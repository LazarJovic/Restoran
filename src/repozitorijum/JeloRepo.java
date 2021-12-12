package repozitorijum;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import baza.BazaPodatakaKonekcija;
import model.JeloCena;
import model.TipJela;

public class JeloRepo {
	
	private TipJelaRepo tipJelaRepo;
	private SlikaJelaRepo slikaJelaRepo;
	private CenaRepo cenaRepo;
	private CenovnikRepo cenovnikRepo;
	
	public JeloRepo() {
		this.tipJelaRepo = new TipJelaRepo();
		this.slikaJelaRepo = new SlikaJelaRepo();
		this.cenaRepo = new CenaRepo();
		this.cenovnikRepo = new CenovnikRepo();
	}
	
	public List<JeloCena> dobaviJelaSaCenama() {
		String dobaviJelaSaCenama = 
				"SELECT jelo.id, jelo.naziv, jelo.opis, cena.vrednost, slika_jela.putanja, tip_jela.naziv\r\n"
				+ "FROM Jelo jelo\r\n"
				+ "LEFT OUTER JOIN Tip_Jela tip_jela ON tip_jela.id = jelo.tip_id\r\n"
				+ "LEFT OUTER JOIN Slika_Jela slika_jela ON slika_jela.id = jelo.id\r\n"
				+ "LEFT OUTER JOIN Cenovnik cenovnik ON cenovnik.jelo_id = jelo.id\r\n"
				+ "LEFT OUTER JOIN Cena cena ON cena.id = cenovnik.cena_id\r\n"
				+ "GROUP BY jelo.id, jelo.naziv, jelo.opis, cena.vrednost, slika_jela.putanja, tip_jela.naziv, cena.kreirana\r\n"
				+ "HAVING cena.kreirana = (SELECT MAX(cena.kreirana) FROM cena LEFT OUTER JOIN cenovnik ON cena.id = cenovnik.cena_id\r\n"
				+ "WHERE jelo.id = cenovnik.jelo_id)";
		PreparedStatement preparedStatement = null;
		List<JeloCena> jela = new ArrayList<>();
		try {
			preparedStatement = BazaPodatakaKonekcija.getInstance().getKonekcija().prepareStatement(dobaviJelaSaCenama);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				jela.add(new JeloCena(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getFloat(4),
						resultSet.getString(5), resultSet.getString(6)));
			}
		} catch (SQLException e) {
			return jela;
		}
		
		return jela;
	}
	
	public JeloCena dodajJelo(String naziv, String nazivTipa, String opis, String recept, float cena, String putanjaSlike) {
		JeloCena jeloCena = null;
		TipJela tipJela = tipJelaRepo.dobaviTipJelaPoNazivu(nazivTipa);
		String dodajJelo = "INSERT INTO Jelo (naziv, opis, recept, uklonjeno, tip_id) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement = null;
		int jeloId = 0;
		try {
			preparedStatement = BazaPodatakaKonekcija.getInstance().getKonekcija().prepareStatement(dodajJelo, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1,  naziv);
			preparedStatement.setString(2, opis);
			preparedStatement.setString(3, recept);
			preparedStatement.setBoolean(4, false);
			preparedStatement.setInt(5, tipJela.getId());
			preparedStatement.execute();
			try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
			      if (generatedKeys.next()) {
			    	  jeloId = generatedKeys.getInt(1);
			      }
			}
			
			slikaJelaRepo.dodajSlikuJela(putanjaSlike, jeloId);
			int cenaId = cenaRepo.dodajCenu(cena);
			cenovnikRepo.dodajCenuJelo(jeloId, cenaId);
		} catch (SQLException e) {
			return jeloCena;
		} catch (Exception e) {
			return jeloCena;
		}
		return new JeloCena(jeloId, naziv, opis, cena, putanjaSlike, nazivTipa);
	}
	
}

package repozitorijum;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import baza.BazaPodatakaKonekcija;
import model.JeloCena;

public class JeloRepo {
	
	public JeloRepo() {}
	
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
	
}

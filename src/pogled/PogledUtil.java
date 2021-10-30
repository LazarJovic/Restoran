package pogled;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class PogledUtil {

	public static Font getRobotoFont(int velicina, boolean isBold) {
		if (isBold) {
			return new Font("roboto", Font.BOLD, velicina);
		} else {
			return new Font("roboto", Font.PLAIN, velicina);
		}
		
	}
	
	public static Color getPrimarnaBoja() {
		return new Color(16, 97, 4);
	}
	
	public static Color getSekundarnaBoja() {
		return new Color(64, 71, 62);
	}
	
	public static Color getTercijarnaBoja() {
		return new Color(190, 196, 188);
	}
	
	public static DateTimeFormatter getFormatDatuma() {
		return DateTimeFormatter.ofPattern("dd.MM.yyyy.");
	}
}

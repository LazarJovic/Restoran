package pogled;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class PadajucaLista extends JComboBox {
	
	public PadajucaLista() {}
	
	@SuppressWarnings("unchecked")
	public PadajucaLista(String[] opcije, Color pozadinaBoja, Color prednjaBoja, Font font, int sirina, int visina) {
		super(opcije);
		this.setBackground(pozadinaBoja);
		this.setForeground(prednjaBoja);
//		this.setBorder(BorderFactory.createCompoundBorder(
//		        BorderFactory.createLineBorder(prednjaBoja, 1), 
//		        BorderFactory.createEmptyBorder(0, 0, 0, 0)));
		this.setFont(font);
		this.setPreferredSize(new Dimension(sirina, visina));
		this.setUI(StrelicaUI.createUI(this));
		this.setRenderer(new PadajucaListaRenderer(this.getRenderer()));
		this.setEditable(true);
	}

}

@SuppressWarnings({"rawtypes", "unchecked"})
class PadajucaListaRenderer extends DefaultListCellRenderer {

	  
	  private ListCellRenderer defaultRenderer;

	  public PadajucaListaRenderer(ListCellRenderer defaultRenderer) {
	    this.defaultRenderer = defaultRenderer;
	  }

	  @Override
	  public Component getListCellRendererComponent(JList list, Object value,
	      int index, boolean isSelected, boolean cellHasFocus) {
		Component c = defaultRenderer.getListCellRendererComponent(list, value,
	        index, isSelected, cellHasFocus);
	    if (c instanceof JLabel) {
	      if (isSelected) {
	        c.setBackground(Color.white);
	      } else {
	        c.setBackground(PogledUtil.getPrimarnaBoja());
	      }
	    } else {
	      c.setBackground(Color.red);
	      c = super.getListCellRendererComponent(list, value, index, isSelected,
	          cellHasFocus);
	    }
	    return c;
	  }
	}

class StrelicaUI extends BasicComboBoxUI {

    public static ComboBoxUI createUI(JComponent c) {
        return new StrelicaUI();
    }

    @Override protected JButton createArrowButton() {
        return new BasicArrowButton(
            BasicArrowButton.SOUTH,
            PogledUtil.getPrimarnaBoja(), PogledUtil.getPrimarnaBoja(),
            Color.WHITE, Color.WHITE);
    }
}
package fr.eseo.poo.projet.artiste.vue.ihm;

import org.junit.Test;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import java.awt.Color;

public class PanneauDessinTest {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new PanneauDessinTest(); 
			}
		});
	}
	
	public PanneauDessinTest() {
		testConstructeurParDefaut();
		testConstructeur();
	}
	
	@Test
	private void testConstructeurParDefaut() {
		JFrame frame = new JFrame("Etre un Artiste");
		
		PanneauDessin panneau = new PanneauDessin();

		frame.add(panneau);

		frame.setSize(panneau.getPreferredSize());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	@Test
	private void testConstructeur() {
		JFrame frame = new JFrame("Blues du Businessman");
		
		PanneauDessin panneau = new PanneauDessin(1000, 600, Color.BLUE);

		frame.add(panneau);

		frame.setSize(panneau.getPreferredSize());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

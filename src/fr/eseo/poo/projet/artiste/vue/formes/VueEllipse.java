package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;

public class VueEllipse extends VueForme {
	public VueEllipse(Ellipse ellipse) {
		super(ellipse);
	}
	
	/**
	 * @since extension
	 * Prend en charge l'épaisseur des traits et une couleur de remplissage différente de la couleur des contours
	 */
	@Override
	public void affiche(Graphics2D g2d) {
		Color couleurCourante = g2d.getColor();
		Ellipse ellipse = (Ellipse)getForme();
		if(ellipse.estRempli()) {
			g2d.setColor(ellipse.getCouleurRemplissage());
			g2d.fillOval((int)Math.round(ellipse.getPosition().getAbscisse()), 
						 (int)Math.round(ellipse.getPosition().getOrdonnee()), 
						 (int)Math.round(ellipse.getLargeur()),
						 (int)Math.round(ellipse.getHauteur()));
		}
		g2d.setColor(ellipse.getCouleur());
		g2d.setStroke(new BasicStroke(ellipse.getEpaisseurContours()));
		g2d.drawOval((int)Math.round(ellipse.getPosition().getAbscisse()), 
					 (int)Math.round(ellipse.getPosition().getOrdonnee()), 
					 (int)Math.round(ellipse.getLargeur()),
					 (int)Math.round(ellipse.getHauteur()));
		g2d.setColor(couleurCourante);
	}
}

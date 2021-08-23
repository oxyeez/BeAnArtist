package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.poo.projet.artiste.modele.formes.Triangle;

/**
 * @since extension
 * @author marcelin
 * 
 * Représentation réelle du Triangle
 */
public class VueTriangle  extends VueForme {
	public VueTriangle(Triangle triangle) {
		super(triangle);
	}

	@Override
	public void affiche(Graphics2D g2d) {
		Color couleurCourante = g2d.getColor();
		Triangle triangle = (Triangle)getForme();
		int xPoints[] = {(int)Math.round(triangle.getBase1().getAbscisse()), 
						 (int)Math.round(triangle.getBase2().getAbscisse()), 
						 (int)Math.round(triangle.getSommet().getAbscisse())};
		int yPoints[] = {(int)Math.round(triangle.getBase1().getOrdonnee()), 
				 		 (int)Math.round(triangle.getBase2().getOrdonnee()), 
				 		 (int)Math.round(triangle.getSommet().getOrdonnee())};
		if(triangle.estRempli()) {
			g2d.setColor(triangle.getCouleurRemplissage());
			g2d.fillPolygon(xPoints, yPoints, 3);
		}
		g2d.setColor(triangle.getCouleur());
		g2d.setStroke(new BasicStroke(getForme().getEpaisseurContours()));
		g2d.drawPolygon(xPoints, yPoints, 3);
		g2d.setColor(couleurCourante);
	}
}
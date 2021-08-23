package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.poo.projet.artiste.modele.formes.Rectangle;

/**
 * @since extension
 * @author marcelin
 * 
 * Représentation réelle du Rectangle
 */
public class VueRectangle extends VueForme {
	public VueRectangle(Rectangle rectangle) {
		super(rectangle);
	}
	
	@Override
	public void affiche(Graphics2D g2d) {
		Color couleurCourante = g2d.getColor();
		Rectangle rectangle = (Rectangle)getForme();
		if(rectangle.estRempli()) {
			g2d.setColor(rectangle.getCouleurRemplissage());
			g2d.fillRect((int)Math.round(rectangle.getPosition().getAbscisse()), 
						 (int)Math.round(rectangle.getPosition().getOrdonnee()), 
						 (int)Math.round(rectangle.getLargeur()),
						 (int)Math.round(rectangle.getHauteur()));
		}
		g2d.setColor(rectangle.getCouleur());
		g2d.setStroke(new BasicStroke(getForme().getEpaisseurContours()));
		g2d.drawRect((int)Math.round(rectangle.getPosition().getAbscisse()), 
					 (int)Math.round(rectangle.getPosition().getOrdonnee()), 
					 (int)Math.round(rectangle.getLargeur()),
					 (int)Math.round(rectangle.getHauteur()));
		g2d.setColor(couleurCourante);
	}
}
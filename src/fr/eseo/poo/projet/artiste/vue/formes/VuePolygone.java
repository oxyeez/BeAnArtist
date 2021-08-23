package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.poo.projet.artiste.modele.formes.Polygone;

/**
 * @since extension
 * @author marcelin
 *
 * Représentation réelle du polygone
 */
public class VuePolygone extends VueForme {
	public VuePolygone(Polygone polygone) {
		super(polygone);
	}

	@Override
	public void affiche(Graphics2D g2d) {
		Color couleurCourante = g2d.getColor();
		Polygone polygone = (Polygone)getForme();
		int xPoints[] = new int[polygone.getCoordonnees().size()];
		int yPoints[] = new int[polygone.getCoordonnees().size()];
		for (int i = 0; i < polygone.getCoordonnees().size(); i++) {
			xPoints[i] = (int)Math.round(polygone.getCoordonnees().get(i).getAbscisse());
			yPoints[i] = (int)Math.round(polygone.getCoordonnees().get(i).getOrdonnee());
		}
		if(polygone.estRempli()) {
			g2d.setColor(polygone.getCouleurRemplissage());
			g2d.fillPolygon(xPoints, yPoints, polygone.getCoordonnees().size());
		}
		g2d.setColor(polygone.getCouleur());
		g2d.setStroke(new BasicStroke(polygone.getEpaisseurContours()));
		g2d.drawPolygon(xPoints, yPoints, polygone.getCoordonnees().size());
		g2d.setColor(couleurCourante);
	}
}

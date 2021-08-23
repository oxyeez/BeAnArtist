package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.poo.projet.artiste.modele.formes.Etoile;

public class VueEtoile extends VueForme {
	public VueEtoile(Etoile etoile) {
		super(etoile);
	}

	/**
	 * @since extension
	 * Prend en charge l'épaisseur des traits et une couleur de remplissage différente de la couleur des contours
	 */
	@Override
	public void affiche(Graphics2D g2d) {
		Color couleurCourante = g2d.getColor();
		Etoile etoile = (Etoile)getForme();
		int xPoints[] = new int[etoile.getCoordonnees().size()];
		int yPoints[] = new int[etoile.getCoordonnees().size()];
		for (int i = 0; i < etoile.getCoordonnees().size(); i++) {
			xPoints[i] = (int)Math.round(etoile.getCoordonnees().get(i).getAbscisse());
			yPoints[i] = (int)Math.round(etoile.getCoordonnees().get(i).getOrdonnee());
		}
		if(etoile.estRempli()) {
			g2d.setColor(etoile.getCouleurRemplissage());
			g2d.fillPolygon(xPoints, yPoints, etoile.getCoordonnees().size());
		}
		g2d.setColor(etoile.getCouleur());
		g2d.setStroke(new BasicStroke(etoile.getEpaisseurContours()));
		g2d.drawPolygon(xPoints, yPoints, etoile.getCoordonnees().size());
		g2d.setColor(couleurCourante);
	}
}

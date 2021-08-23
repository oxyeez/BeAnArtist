package fr.eseo.poo.projet.artiste.vue.formes;

import fr.eseo.poo.projet.artiste.modele.formes.Ligne;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class VueLigne extends VueForme{
	
	public VueLigne(Ligne ligne) {
		super(ligne);
	}
	
	/**
	 * @since extension
	 * Prend en charge l'épaisseur des traits
	 */
	@Override
	public void affiche(Graphics2D g2d) {
		Color couleurCourante = g2d.getColor();
		g2d.setColor(getForme().getCouleur());
		g2d.setStroke(new BasicStroke(getForme().getEpaisseurContours()));
		g2d.drawLine((int)Math.round(getForme().getPosition().getAbscisse()), 
					 (int)Math.round(getForme().getPosition().getOrdonnee()), 
					 (int)Math.round(getForme().getPosition().getAbscisse() + getForme().getLargeur()),
					 (int)Math.round(getForme().getPosition().getOrdonnee() + getForme().getHauteur()));
		g2d.setColor(couleurCourante);
	}
}

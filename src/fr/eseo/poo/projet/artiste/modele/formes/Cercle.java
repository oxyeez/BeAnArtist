package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class Cercle extends Ellipse{
	
	public Cercle() {
		super(LARGEUR_PAR_DEFAUT, LARGEUR_PAR_DEFAUT);
	}
	
	public Cercle(double taille) {
		super(taille, taille);
	}
	
	public Cercle(Coordonnees position) {
		super(position, LARGEUR_PAR_DEFAUT, LARGEUR_PAR_DEFAUT);
	}
	
	public Cercle(Coordonnees position, double taille) {
		super(position, taille, taille);
	}
	
	@Override
	public void setHauteur(double taille) {
		setLargeur(taille);
	}
	
	@Override
	public void setLargeur(double taille) {
		if(taille < 0)
			throw new IllegalArgumentException("La taille est négative");
		else {
			super.setLargeur(taille);
			super.setHauteur(taille);
		}
	}
	
	@Override
	public double perimetre() {
		return 2*Math.PI*getLargeur()/2;
	}
}

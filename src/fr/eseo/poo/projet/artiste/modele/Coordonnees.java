package fr.eseo.poo.projet.artiste.modele;

import java.text.DecimalFormat;

public class Coordonnees {
	public static final double ABSCISSE_PAR_DEFAUT = 50;
	public static final double ORDONNEE_PAR_DEFAUT = 50;

	public double abscisse, ordonnee;

	public Coordonnees() {
		this(ABSCISSE_PAR_DEFAUT, ORDONNEE_PAR_DEFAUT);
	}

	public Coordonnees(double abscisse, double ordonnee) {
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
	}

	public double getAbscisse() {
		return abscisse;
	}

	public double getOrdonnee() {
		return ordonnee;
	}

	public void setAbscisse(double abscisse) {
		this.abscisse = abscisse;
	}

	public void setOrdonnee(double ordonnee) {
		this.ordonnee = ordonnee;
	}

	public void deplacerDe(double deltaX, double deltaY) {
		this.abscisse += deltaX;
		this.ordonnee += deltaY;
	}
	
	/**
	 * @since extension
	 * 
	 * Permet de déplacer un point selon un vecteur
	 */
	public void deplacerDe(Vecteur vect) {
		deplacerDe(vect.getAbscisse(), vect.getOrdonnee());
	}

	public void deplacerVers(double nouvelleAbscisse, double nouvelleOrdonnee) {
		setAbscisse(nouvelleAbscisse);
		setOrdonnee(nouvelleOrdonnee);
	}

	public double distanceVers(Coordonnees autreCoordonnees) {
		double deltaX = this.abscisse - autreCoordonnees.getAbscisse();
		double deltaY = this.ordonnee - autreCoordonnees.getOrdonnee();
		return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
	}
	
	/**
	 * Methode ajoutée permettant de simplifier la vérification de l'égalité entre deux Coordonnees
	 * @param autreCoordonnees
	 */
	public boolean estEgalA(Coordonnees autreCoordonnees) {
		return getAbscisse() == autreCoordonnees.getAbscisse() && getOrdonnee() == autreCoordonnees.getOrdonnee();
	}

	public double angleVers(Coordonnees autreCoordonnees) {
		return Math.atan2(autreCoordonnees.getOrdonnee() - getOrdonnee(),
				autreCoordonnees.getAbscisse() - getAbscisse());
	}

	@Override
	public String toString() {
		return "(" + new DecimalFormat("0.0#").format(getAbscisse()) + " , "
				+ new DecimalFormat("0.0#").format(getOrdonnee()) + ")";
	}
	
	
	/**
	 * @since extension
	 * @param autreCoordonnees
	 * 
	 * Permet de trouver le point au milieu de deux autres
	 */
	public Coordonnees milieu(Coordonnees autreCoordonnees) {
		return new Coordonnees((getAbscisse()+autreCoordonnees.getAbscisse())/2, 
							   (getOrdonnee()+autreCoordonnees.getOrdonnee())/2);
	}

	/**
	 * @since extension
	 * 
	 * Permet de simplifier la duplication de coordonnees
	 */
	public Coordonnees copier() {
		return new Coordonnees(getAbscisse(), getOrdonnee());
	}
	
}

package fr.eseo.poo.projet.artiste.modele;

import java.text.DecimalFormat;

/**
 * @since extension
 * @author marcelin
 *
 * Class qui permet de créer un vecteur de façon abstraite 
 */
public class Vecteur {
	public static final double ABSCISSE_PAR_DEFAUT = 10;
	public static final double ORDONNEE_PAR_DEFAUT = 10;
	
	public double abscisse, ordonnee;

	public Vecteur() {
		this(ABSCISSE_PAR_DEFAUT, ORDONNEE_PAR_DEFAUT);
	}

	public Vecteur(double abscisse, double ordonnee) {
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
	}
	
	public Vecteur(Coordonnees p1, Coordonnees p2) {
		this.abscisse = p2.getAbscisse()-p1.getAbscisse();
		this.ordonnee = p2.getOrdonnee()-p1.getOrdonnee();
	}
	
	public double getAbscisse() {
		return abscisse;
	}

	public double getOrdonnee() {
		return ordonnee;
	}
	
	/**
	 * 
	 * @return	un vecteur normal
	 */
	public Vecteur normal() {
		return new Vecteur(getOrdonnee(), -getAbscisse());
	}
	
	/**
	 * 
	 * @param reel avec lequel on veut multiplier le vecteur
	 */
	public void produitAvecReel(double reel) {
		this.abscisse *= reel;
		this.ordonnee *= reel;
	}
	
	@Override
	public String toString() {
		return "(" + new DecimalFormat("0.0#").format(getAbscisse()) + " , "
				+ new DecimalFormat("0.0#").format(getOrdonnee()) + ")";
	}
}

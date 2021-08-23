package fr.eseo.poo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.util.Locale;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Remplissable;

public class Ellipse extends Forme implements Remplissable {
	
	public boolean modeRemplissage;
	
	public Ellipse() {
		super();
		setRempli(false);
	}
	
	public Ellipse(double largeur, double hauteur) throws IllegalArgumentException {
		super(largeur, hauteur);
		setRempli(false);

	}
	
	public Ellipse(Coordonnees position) {
		super(position);
		setRempli(false);
	}
	
	public Ellipse(Coordonnees position, double largeur, double hauteur) {
		super(position, largeur, hauteur);
		setRempli(false);
	}
	
	@Override
	public void setLargeur(double largeur) {
		if(largeur < 0)
			throw new IllegalArgumentException("La largeur est négative");
		else 
			this.largeur = largeur;
	}
	
	@Override
	public void setHauteur(double hauteur) {
		if(hauteur < 0)
			throw new IllegalArgumentException("La hauteur est négative");
		else 
			this.hauteur = hauteur;
	}
	
	@Override
	public double aire() {
		return getLargeur() / 2 * getHauteur() / 2 * Math.PI;
	}
	
	@Override
	public double perimetre() {
		double r1 = getLargeur()/2;
		double r2 = getHauteur()/2;
		double h = Math.pow((r1-r2)/(r1+r2), 2);
		return Math.PI*(r1 + r2)*(1+(3*h)/(10+Math.sqrt(4-3*h)));
	}
	
	/**
	 * @since extension
	 * Affiche la couleur de remplissage si la forme est remplie et l'épaisseur des contours
	 */
	@Override
	public String toString()  {
		return "[" + this.getClass().getSimpleName()
			 + (estRempli() ? "-Rempli" : "")
			 + "] : pos " + getPosition().toString() 
			 + " dim " + new DecimalFormat("0.0#").format(getLargeur()) 
			 + " x " + new DecimalFormat("0.0#").format(getHauteur())
			 + " périmètre : " + new DecimalFormat("0.0#").format(perimetre()) 
			 + " aire : " + new DecimalFormat("0.0#").format(aire())
			 + "/n couleur = R" + getCouleur().getRed() + "," 
			 + (Locale.getDefault().getLanguage() == Locale.FRENCH.getLanguage() ? "V" : "G")
			 + getCouleur().getGreen() + ",B" + getCouleur().getBlue()
			 + " epaisseur = " + getEpaisseurContours() + "px"
			 + (estRempli() ?  " remplissage = R" + getCouleurRemplissage().getRed() + "," 
					 		   + (Locale.getDefault().getLanguage() == Locale.FRENCH.getLanguage() ? "V" : "G")
					 		   + getCouleurRemplissage().getGreen() + ",B" + getCouleurRemplissage().getBlue() : "");
	}
	
	@Override
   public boolean contient(Coordonnees position) {
    	double xPoint = position.getAbscisse();
    	double yPoint = position.getOrdonnee();
    	double xCentre = getPosition().getAbscisse()+getLargeur()/2;
    	double yCentre = getPosition().getOrdonnee()+getHauteur()/2;
    	double xRayon = getLargeur()/2;
    	double yRayon = getHauteur()/2;
    	return Math.pow((xPoint - xCentre)/xRayon, 2) + Math.pow((yPoint - yCentre)/yRayon, 2) <= 1;
    }

	@Override
	public boolean estRempli() {
		return modeRemplissage;
	}

	@Override
	public void setRempli(boolean remplissage) {
		this.modeRemplissage = remplissage;
	}
}


package fr.eseo.poo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.util.Locale;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Remplissable;

/**
 * @since extension
 * @author marcelin
 *
 * Représentation abstraite du Rectangle, insipré de Ellipse
 */
public class Rectangle extends Forme implements Remplissable {
	
	public boolean modeRemplissage;
	
	public Rectangle() {
		super();
		setRempli(false);
	}
	
	public Rectangle(double largeur, double hauteur) throws IllegalArgumentException {
		super(largeur, hauteur);
		setRempli(false);
	}
	
	public Rectangle(Coordonnees position) {
		super(position);
		setRempli(false);
	}
	
	public Rectangle(Coordonnees position, double largeur, double hauteur) {
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
		return getLargeur() * getHauteur();
	}
	
	@Override
	public double perimetre() {
		return 2*getLargeur() + 2*getHauteur();
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
			 + " couleur = R" + getCouleur().getRed() + "," 
			 + (Locale.getDefault().getLanguage() == Locale.FRENCH.getLanguage() ? "V" : "G")
			 + getCouleur().getGreen() + ",B" + getCouleur().getBlue()
			 + " epaisseur = " + getEpaisseurContours() + "px"
			 + (estRempli() ?  " remplissage = R" + getCouleurRemplissage().getRed() + "," 
			 		   + (Locale.getDefault().getLanguage() == Locale.FRENCH.getLanguage() ? "V" : "G")
			 		   + getCouleurRemplissage().getGreen() + ",B" + getCouleurRemplissage().getBlue() : "");
	}
	
	@Override
    public boolean contient(Coordonnees position) {
    	return position.getAbscisse() >= getPosition().getAbscisse()
    		&& position.getAbscisse() <= getPosition().getAbscisse()+getLargeur()
    		&& position.getOrdonnee() >= getPosition().getOrdonnee()
    		&& position.getOrdonnee() <= getPosition().getOrdonnee()+getHauteur();
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

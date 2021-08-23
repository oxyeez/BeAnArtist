package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

import java.text.DecimalFormat;
import java.util.Locale;

public class Ligne extends Forme {
	public static final double EPSILON = 1e-1;
	
	public Ligne() {
		super();
	}
    
	public Ligne(Coordonnees position) {
		super(position);
	}

	public Ligne(double largeur, double hauteur) {
		super(largeur, hauteur);
    }
    
    public Ligne(Coordonnees position, double largeur, double hauteur) {
		super(position, largeur, hauteur);
	}

	public Coordonnees getC1() {        
        return getPosition();
	}

    public Coordonnees getC2() {
        return new Coordonnees(getC1().getAbscisse()+getLargeur(), getC1().getOrdonnee()+getHauteur());
    }

    public void setC1(Coordonnees newC1) {
        setLargeur(getC2().getAbscisse() - newC1.getAbscisse());
        setHauteur(getC2().getOrdonnee() - newC1.getOrdonnee());
        setPosition(newC1);
    }

    public void setC2(Coordonnees newC2) {
        setLargeur(newC2.getAbscisse() - getC1().getAbscisse());
        setHauteur(newC2.getOrdonnee() - getC1().getOrdonnee());
    }

    /**
     * @since extension
     * Affiche l'épaisseur de la ligne
     */
    @Override
    public String toString() {
        double angle = getC1().angleVers(getC2())*180/Math.PI;
        if(angle < 0) {
        	angle += 360;
        }
    	return "[" + this.getClass().getSimpleName() 
    		+ "] c1 : " + getC1().toString() 
    		+ " c2 : " + getC2().toString() 
            + " longueur : " + new DecimalFormat("0.0#").format(perimetre()) 
            + " angle : " + new DecimalFormat("0.0#").format(angle) + "°"
            + "/n couleur = R" + getCouleur().getRed() + "," 
            + (Locale.getDefault().getLanguage() == Locale.FRENCH.getLanguage() ? "V" : "G")
            + getCouleur().getGreen() + ",B" + getCouleur().getBlue()
    		+ " epaisseur = " + getEpaisseurContours() + "px";
    }

	@Override
    public double aire() {
        return 0;
    }

	@Override
    public double perimetre() {
        return getC1().distanceVers(getC2());
    }
    
	@Override
    public boolean contient(Coordonnees position) {
		return (Math.abs(getC1().distanceVers(position)) + Math.abs(getC2().distanceVers(position)))
				- Math.abs(perimetre()) <= EPSILON;
    }
}
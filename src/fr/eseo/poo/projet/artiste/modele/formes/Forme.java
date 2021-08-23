package fr.eseo.poo.projet.artiste.modele.formes;

import java.awt.Color;

import fr.eseo.poo.projet.artiste.modele.Coloriable;
import fr.eseo.poo.projet.artiste.modele.Coordonnees;

/**
 * @since extension
 *
 * Prend en charge différentes épaisseurs de contours et une couleur de remplissage différente de la couleur des contours
 */
public abstract class Forme implements Coloriable {
    public static final double LARGEUR_PAR_DEFAUT = 100;
    public static final double HAUTEUR_PAR_DEFAUT = 75;
    public static final Color COULEUR_PAR_DEFAUT = javax.swing.UIManager.getColor("Panel.foreground");
    public static final int EPAISSEUR_CONTOURS_PAR_DEFAUT = 1;

    public double largeur, hauteur;
    private Coordonnees position;
    public Color couleur, couleurRemplissage;
    public int epaisseurContours;

    public Forme() {
        this(new Coordonnees(), LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
    }

    public Forme(double largeur, double hauteur) {
        this(new Coordonnees(), largeur, hauteur);
    }

    public Forme(Coordonnees position) {
        this(position, LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
    }

    public Forme(Coordonnees position, double largeur, double hauteur) {
        setPosition(position);
        setLargeur(largeur);
        setHauteur(hauteur);
        setCouleur(COULEUR_PAR_DEFAUT);
        setCouleurRemplissage(COULEUR_PAR_DEFAUT);
        setEpaisseurContours(EPAISSEUR_CONTOURS_PAR_DEFAUT);
    }
    
    public Coordonnees getPosition() {
        return position;
    }

    public double getLargeur() {
        return largeur;
    }

    public double getHauteur() {
        return hauteur;
    }

    public double getCadreMinX() {
        return Math.min(getPosition().getAbscisse(), getPosition().getAbscisse()+getLargeur());
    }

    public double getCadreMinY() {
        return Math.min(getPosition().getOrdonnee(), getPosition().getOrdonnee()+getHauteur());
    }

    public double getCadreMaxX() {
        return Math.max(getPosition().getAbscisse(), getPosition().getAbscisse()+getLargeur());
    }

    public double getCadreMaxY() {
        return Math.max(getPosition().getOrdonnee(), getPosition().getOrdonnee()+getHauteur());
    }
    
	@Override
    public Color getCouleur() {
    	return couleur;
    }
    
	@Override
    public Color getCouleurRemplissage() {
    	return couleurRemplissage;
    }
    
    public int getEpaisseurContours() {
    	return epaisseurContours;
    }
    
    public void setPosition(Coordonnees position) {
        this.position = position;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }
    
	@Override
    public void setCouleur(Color couleur) {
    	this.couleur = couleur;
    }
    
	@Override
    public void setCouleurRemplissage(Color couleurRemplissage) {
    	this.couleurRemplissage = couleurRemplissage;
    }
    
    public void setEpaisseurContours(int epaisseur) {
    	this.epaisseurContours = epaisseur;
    }
    
    public void deplacerDe(double deltaX, double deltaY) {
        getPosition().deplacerDe(deltaX, deltaY);
    }

    public void deplacerVers(double nouvelleAbscisse, double nouvelleOrdonnee) {
        getPosition().deplacerVers(nouvelleAbscisse, nouvelleOrdonnee);
    }

    public abstract double aire();
    
    public abstract double perimetre();
    
    public abstract boolean contient(Coordonnees coordonnees);
}

package fr.eseo.poo.projet.artiste.modele.formes;

import java.awt.geom.Line2D;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Remplissable;

/**
 * @since extension
 * @author marcelin
 *
 * Représentation abstraite d'un polygone régulier pouvant aller de 5 à 12 côtés
 * Inspiré de la classe Etoile
 */
public class Polygone extends Forme implements Remplissable {
	
	public static final int NOMBRE_SOMMET_PAR_DEFAUT = 5;
	public static final double ANGLE_PREMIER_SOMMET_PAR_DEFAUT = -Math.PI/2;
	//liste des noms des polygones réguliers, allant de 5 cotés à 12 cotés
	public static final String[] NOMS_POLYGONES = {"Pentagone", "Hexagone", "Heptagone", 
													"Octogone", "Enneagone", "Decagone", 
													"Hendecagone", "Dodecagone"};
	
	private List<Coordonnees> coordonnees;
	
	public int nombreSommets;
	public double anglePremierSommet;
	public boolean modeRemplissage;
	
	public Polygone() {
		this(new Coordonnees(), LARGEUR_PAR_DEFAUT, NOMBRE_SOMMET_PAR_DEFAUT, 
													ANGLE_PREMIER_SOMMET_PAR_DEFAUT);
	}
	
	public Polygone(int nombreSommet) {
		this(new Coordonnees(), LARGEUR_PAR_DEFAUT, nombreSommet, 
													ANGLE_PREMIER_SOMMET_PAR_DEFAUT);
	}
	
	public Polygone(double taille) {
		this(new Coordonnees(), taille, NOMBRE_SOMMET_PAR_DEFAUT, 
										ANGLE_PREMIER_SOMMET_PAR_DEFAUT);
	}
	
	public Polygone(double taille, int nombreSommet) {
		this(new Coordonnees(), taille, nombreSommet, 
										ANGLE_PREMIER_SOMMET_PAR_DEFAUT);
	}
	
	public Polygone(Coordonnees coordonnees) {
		this(coordonnees, LARGEUR_PAR_DEFAUT, NOMBRE_SOMMET_PAR_DEFAUT, 
											  ANGLE_PREMIER_SOMMET_PAR_DEFAUT);
	}
	
	public Polygone(Coordonnees coordonnees, int nombreSommet) {
		this(coordonnees, LARGEUR_PAR_DEFAUT, nombreSommet, 
											  ANGLE_PREMIER_SOMMET_PAR_DEFAUT);
	}
	
	public Polygone(Coordonnees coordonnees, double taille) {
		this(coordonnees, taille, NOMBRE_SOMMET_PAR_DEFAUT, 
								  ANGLE_PREMIER_SOMMET_PAR_DEFAUT);
	}
	
	public Polygone(Coordonnees coordonnees, double taille, int nombreSommet) {
		this(coordonnees, taille, nombreSommet, ANGLE_PREMIER_SOMMET_PAR_DEFAUT);
	}
	
	public Polygone(Coordonnees coordonnees, double taille, int nombreSommet, 
								double anglePremierSommet) {
		super(coordonnees, taille, taille);
		setNombreSommets(nombreSommet);
		setAnglePremierSommet(anglePremierSommet);
		setCoordonnees();
	}
	
	@Override
	public void setLargeur(double taille) {
		if(taille < 0)
			throw new IllegalArgumentException("La taille est négative");
		else {
			super.setLargeur(taille);
			super.setHauteur(taille);
			setCoordonnees();
		}
	}
	
	@Override
	public void setHauteur(double taille) {
		setLargeur(taille);
	}
	
	public void setNombreSommets(int nombreSommets) {
		if(nombreSommets < 5 || nombreSommets > 12 )
			throw new IllegalArgumentException("Le nombre de sommets n'est pas accepté");
		else {
			this.nombreSommets = nombreSommets;
			setCoordonnees();
		}
	}
	
	public void setAnglePremierSommet(double anglePremierSommet) {
		if(anglePremierSommet < -Math.PI || anglePremierSommet > Math.PI )
			throw new IllegalArgumentException("L'angle du premier sommet n'est pas accepté");
		else {
			this.anglePremierSommet = anglePremierSommet;
			setCoordonnees();
		}
	}
	
	/**
	 * Inspiré de la methode setCoordonnees() de Etoile, mais on ne génère que les sommets
	 */
	public void setCoordonnees() {
		this.coordonnees = new ArrayList<Coordonnees>();
		Coordonnees coordonneesSommet;
		for (int sommet = 0; sommet < getNombreSommets(); sommet++) {
			double angleSommet = getAnglePremierSommet() + sommet * 2 * Math.PI/getNombreSommets();
			double absSommet = getCentrePolygon().getAbscisse()+(getLargeur()/2)*Math.cos(angleSommet);
			double ordSommet = getCentrePolygon().getOrdonnee()+(getLargeur()/2)*Math.sin(angleSommet);
			coordonneesSommet = new Coordonnees(absSommet, ordSommet);
			getCoordonnees().add(coordonneesSommet);
		}
	}
	
	public List<Coordonnees> getCoordonnees() {
		return this.coordonnees;
	}
	
	public int getNombreSommets() {
		return this.nombreSommets;
	}
	
	public double getAnglePremierSommet() {
		return this.anglePremierSommet;
	}
	
	public Coordonnees getCentrePolygon() {
		return new Coordonnees(getPosition().getAbscisse()+getLargeur()/2, getPosition().getOrdonnee()+getLargeur()/2);
	}
	
	/**
	 * @since extension
	 * Affiche la couleur de remplissage si la forme est remplie et l'épaisseur des contours
	 */
	@Override
	public String toString()  {
		return "[" + NOMS_POLYGONES[getNombreSommets()-5]
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
	public double aire() {
		double apotheme = getCoordonnees().get(0).milieu(getCoordonnees().get(1)).distanceVers(getCentrePolygon());
		return apotheme*getNombreSommets()*getCoordonnees().get(0).distanceVers(getCoordonnees().get(1))/2;
	}
	
	@Override
	public double perimetre() {
		return getCoordonnees().get(0).distanceVers(getCoordonnees().get(1))*getNombreSommets();
	}
	
	/**
	 * Principe identique à la methode rayTracing de Etoile
	 */
	public boolean rayTracing(Coordonnees origineRayon, Coordonnees point) {
		int nombreDIntersections = 0;
		if (Line2D.linesIntersect(origineRayon.getAbscisse(), origineRayon.getOrdonnee(), 
								  point.getAbscisse(), point.getOrdonnee(), 
								  getCoordonnees().get(getCoordonnees().size()-1).getAbscisse(), 
								  getCoordonnees().get(getCoordonnees().size()-1).getOrdonnee(), 
								  getCoordonnees().get(0).getAbscisse(), 
								  getCoordonnees().get(0).getOrdonnee())) {
			nombreDIntersections++;
		}

		for (int i = 1; i < getCoordonnees().size(); i++) {
			if (Line2D.linesIntersect(origineRayon.getAbscisse(), origineRayon.getOrdonnee(), 
									  point.getAbscisse(), point.getOrdonnee(), 
									  getCoordonnees().get(i-1).getAbscisse(), 
									  getCoordonnees().get(i-1).getOrdonnee(), 
									  getCoordonnees().get(i).getAbscisse(), 
									  getCoordonnees().get(i).getOrdonnee())) {
				nombreDIntersections++;
			}
		}

		return nombreDIntersections % 2 != 0;
	}
	
	/**
	 * Principe identique à la methode contient de Etoile
	 */
	@Override
	public boolean contient(Coordonnees point) {
		Coordonnees origineRayon1 = new Coordonnees(getPosition().getAbscisse()-20, getPosition().getOrdonnee()-20);
		Coordonnees origineRayon2 = new Coordonnees(getPosition().getAbscisse()+getLargeur()+20, getPosition().getOrdonnee()+getLargeur()/3);
		return rayTracing(origineRayon1, point) || rayTracing(origineRayon2, point);
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

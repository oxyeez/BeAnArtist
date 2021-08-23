package fr.eseo.poo.projet.artiste.modele.formes;

import java.awt.geom.Line2D;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Remplissable;

public class Etoile extends Forme implements Remplissable {
	
	public static final int NOMBRE_BRANCHES_PAR_DEFAUT = 5;
	public static final double ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT = -Math.PI/2;
	public static final double LONGUEUR_BRANCHE_PAR_DEFAUT = 0.5;
	
	private List<Coordonnees> coordonnees;
	
	public int nombreBranches;
	public double longueurBranche, anglePremiereBranche;
	public boolean modeRemplissage;
	
	public Etoile() {
		this(new Coordonnees(), LARGEUR_PAR_DEFAUT, NOMBRE_BRANCHES_PAR_DEFAUT, 
													ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, 
													LONGUEUR_BRANCHE_PAR_DEFAUT);
	}
	
	public Etoile(double taille) {
		this(new Coordonnees(), taille, NOMBRE_BRANCHES_PAR_DEFAUT, 
										ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, 
										LONGUEUR_BRANCHE_PAR_DEFAUT);
	}
	
	public Etoile(Coordonnees coordonnees) {
		this(coordonnees, LARGEUR_PAR_DEFAUT, NOMBRE_BRANCHES_PAR_DEFAUT, 
											  ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, 
											  LONGUEUR_BRANCHE_PAR_DEFAUT);
	}
	
	public Etoile(Coordonnees coordonnees, double taille) {
		this(coordonnees, taille, NOMBRE_BRANCHES_PAR_DEFAUT, 
								  ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, 
								  LONGUEUR_BRANCHE_PAR_DEFAUT);
	}
	
	public Etoile(Coordonnees coordonnees, double taille, int nombreBranches, 
								double anglePremiereBranche, double longueurBranche) {
		super(coordonnees, taille, taille);
		setNombreBranches(nombreBranches);
		setAnglePremiereBranche(anglePremiereBranche);
		setLongueurBranche(longueurBranche);
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
	
	public void setNombreBranches(int nombreBranches) {
		if(nombreBranches < 3 || nombreBranches > 15 )
			throw new IllegalArgumentException("Le nombre de branches n'est pas accepté");
		else {
			this.nombreBranches = nombreBranches;
			setCoordonnees();
		}
	}
	
	public void setLongueurBranche(double longueurBranche) {
		if(longueurBranche < 0 || longueurBranche > 1 )
			throw new IllegalArgumentException("La longueur de branches n'est pas accepté");
		else {
			this.longueurBranche = longueurBranche;
			setCoordonnees();
		}
	}
	
	public void setAnglePremiereBranche(double anglePremiereBranche) {
		if(anglePremiereBranche < -Math.PI || anglePremiereBranche > Math.PI )
			throw new IllegalArgumentException("Le nombre de branches n'est pas accepté");
		else {
			this.anglePremiereBranche = anglePremiereBranche;
			setCoordonnees();
		}
	}
	
	/**
	 * Création de la liste de coordonnees servant à définir le contour de l'étoile
	 * à chaque ittération de la boucle on décale l'angle d'un angle correspondant à 360°/nombre de branche
	 * on ajoute à chaque itération 2 points :
	 * 		un point correspondant au sommet
	 * 		un point décallé de 360°/nombre de branche * 2 par rapport au sommet et ayant pour distance avec le centre 
	 * 				la distance entre le sommet et le centre * la longueur de branche demandée
	 */
	public void setCoordonnees() {
		this.coordonnees = new ArrayList<Coordonnees>();
		Coordonnees coordonneesBranche, coordonneesInter;
		for (int branche = 0; branche < getNombreBranches(); branche++) {
			double angleBranche = getAnglePremiereBranche() + branche * 2 * Math.PI/getNombreBranches();
			double absBranche = getCentreEtoile().getAbscisse()+(getLargeur()/2)*Math.cos(angleBranche);
			double ordBranche = getCentreEtoile().getOrdonnee()+(getLargeur()/2)*Math.sin(angleBranche);
			coordonneesBranche = new Coordonnees(absBranche, ordBranche);
			getCoordonnees().add(coordonneesBranche);
			
			double angleInter = angleBranche + Math.PI/getNombreBranches();
			double absInter = getCentreEtoile().getAbscisse()+(getLargeur()/2)*(1-getLongueurBranche())*Math.cos(angleInter);
			double ordInter = getCentreEtoile().getOrdonnee()+(getLargeur()/2)*(1-getLongueurBranche())*Math.sin(angleInter);
			coordonneesInter = new Coordonnees(absInter, ordInter);
			getCoordonnees().add(coordonneesInter);
		}
	}
	
	public List<Coordonnees> getCoordonnees() {
		return this.coordonnees;
	}
	
	public int getNombreBranches() {
		return this.nombreBranches;
	}
	
	public double getLongueurBranche() {
		return this.longueurBranche;
	}
	
	public double getAnglePremiereBranche() {
		return this.anglePremiereBranche;
	}
	
	/**
	 * Methode ajoutée pour simplifier les autres methodes
	 * @return le centre de l'étoile
	 */
	public Coordonnees getCentreEtoile() {
		return new Coordonnees(getPosition().getAbscisse()+getLargeur()/2, getPosition().getOrdonnee()+getLargeur()/2);
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
	
	/**
	 * Une étoile étant composé de triangle isoceles: 2 par branche, un à l'interieur, l'autre à l'extérieur
	 * En faisant le somme des aires des triangles on obtient l'aire de l'étoile
	 */
	@Override
	public double aire() {
		TriangleIsocele triangleExte = new TriangleIsocele(getCoordonnees().get(1), getCoordonnees().get(3), getCoordonnees().get(2));
		TriangleIsocele triangleInte = new TriangleIsocele(getCoordonnees().get(1), getCoordonnees().get(3), getCentreEtoile());
		return triangleExte.aire() * getNombreBranches() + triangleInte.aire() * getNombreBranches();
	}
	
	@Override
	public double perimetre() {
		return (getCoordonnees().get(0).distanceVers(getCoordonnees().get(1)) 
				+ getCoordonnees().get(1).distanceVers(getCoordonnees().get(2)))*getNombreBranches();
	}
	
	/**
	 * Methode vérifiant en utilisant le ray tracing (ou ray casting) si un point donné est dans l'étoile
	 * le principe est le suivant: 
	 * 		si la ligne qui va de l'origine du rayon au point à tester coupe un nombre paire de lignes formant l'étoile,
	 * 													alors le point est à l'extérieur
	 * 		sinon le point est à l'intérieur
	 * 
	 * @param origineRayon		point défini de façon arbitraire devant obligatoirement se trouver à lextérieur de l'étoile
	 * @param point				point à tester
	 * @return					true si le point est à l'intérieur, false sinon
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
	 * Méthode contient qui appel la methode raytracing plusieurs fois avec différentes origines de rayons
	 * car si on n'utilis qu'un rayon il y a un risque que celui-ci passe par un sommet ou un creux de l'étoile, 
	 * dans ce cas il coupe alors 2 lignes, alors que le point est à l'intérieur
	 * En utilisant 2 rayons différents on diminue drastiquement le nombre de faux négatifs au point de le rendre quasiment nul, 
	 * mais on pourrait utiliser plus de 2 rayons
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





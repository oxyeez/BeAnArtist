package fr.eseo.poo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.util.Locale;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Droite;
import fr.eseo.poo.projet.artiste.modele.Remplissable;
import fr.eseo.poo.projet.artiste.modele.Vecteur;

/**
 * @since extension
 * @author marcelin
 *
 * Représentation abstraite du Triangle
 */
public class Triangle extends Forme implements Remplissable {
	
	
	public static final Coordonnees BASE1_PAR_DEFAUT = new Coordonnees(50, 50);
	public static final Coordonnees BASE2_PAR_DEFAUT = new Coordonnees(70, 30);
	public static final Coordonnees SOMMET_PAR_DEFAUT = new Coordonnees(80, 60);
	
	public boolean modeRemplissage;
	//base1 et base2 sont les deux extrémitées de la base
	public Coordonnees base1, base2, sommet;
	
	public Triangle() {
		this(BASE1_PAR_DEFAUT, BASE2_PAR_DEFAUT, SOMMET_PAR_DEFAUT);
	}
	
	public Triangle(Coordonnees base1) {
		this(base1, calculBase2Defaut(base1), calculSommetDefaut(base1, calculBase2Defaut(base1), 0.5));
	}
	
	public Triangle(Coordonnees base1, Coordonnees base2) {
		this(base1, base2, calculSommetDefaut(base1, base2, 0.5));
	}
	
	public Triangle(Coordonnees base1, Coordonnees base2, Coordonnees sommet) {
		super(calculPosition(base1,  base2,  sommet), calculLargeurForme(base1,  base2,  sommet), calculHauteurForme(base1,  base2,  sommet));
		setBase1(base1);
		setBase2(base2);
		setSommet(sommet);
	}
	
	/**
	 * Permet de décharger les opérations à faire dans les constructeurs auxquels on ne donne pas de position pour la base2
	 * @param base1
	 * @return	les coordonnees de la base2 calculées de façon arbitraire
	 */
	public static Coordonnees calculBase2Defaut(Coordonnees base1) {
		return new Coordonnees(base1.getAbscisse()+100, base1.getOrdonnee()+100);
	}
	
	/**
	 * Permet de décharger les opérations à faire dans les constructeurs auxquels on ne donne pas de position pour le sommet
	 * @param base1
	 * @param base2
	 * @return	les coordonnees du sommet calculées de façon arbitraire
	 */
	public static Coordonnees calculSommetDefaut(Coordonnees base1, Coordonnees base2, double hauteur) {
		return new Coordonnees(base1.milieu(base2).milieu(base2).getAbscisse() 
									+ (new Vecteur(base1, base2)).normal().getAbscisse()*hauteur,
							   base1.milieu(base2).milieu(base2).getOrdonnee() 
							   		+ (new Vecteur(base1, base2)).normal().getOrdonnee()*hauteur);
	}
	
	/**
	 * 
	 * @param base1
	 * @param base2
	 * @param sommet
	 * @return	la position du rectangle le plus petit encadrant le triangle
	 */
	public static Coordonnees calculPosition(Coordonnees base1, Coordonnees base2, Coordonnees sommet) {
		return new Coordonnees(Math.min(sommet.getAbscisse(), Math.min(base1.getAbscisse(), base2.getAbscisse())),
				Math.min(sommet.getOrdonnee(), Math.min(base1.getOrdonnee(), base2.getOrdonnee())));
	}
	
	/**
	 * 
	 * @param base1
	 * @param base2
	 * @param sommet
	 * @return	la largeur du rectanle le plus petit encadrant le triangle
	 */
	public static double calculLargeurForme(Coordonnees base1, Coordonnees base2, Coordonnees sommet) {
		return Math.max(sommet.getAbscisse()-calculPosition(base1,  base2,  sommet).getAbscisse(), 
						Math.max(base1.getAbscisse()-calculPosition(base1,  base2,  sommet).getAbscisse(), 
								 base2.getAbscisse()-calculPosition(base1,  base2,  sommet).getAbscisse()));
	}
	
	/**
	 * 
	 * @param base1
	 * @param base2
	 * @param sommet
	 * @return	la hauteur du triangle le plus petit encadrant le triangle
	 */
	public static double calculHauteurForme(Coordonnees base1, Coordonnees base2, Coordonnees sommet) {
		return Math.max(sommet.getOrdonnee()-calculPosition(base1,  base2,  sommet).getOrdonnee(), 
				Math.max(base1.getOrdonnee()-calculPosition(base1,  base2,  sommet).getOrdonnee(), 
						 base2.getOrdonnee()-calculPosition(base1,  base2,  sommet).getOrdonnee()));
	}
	
	public void setBase1(Coordonnees base1) {
		this.base1 = base1;
	}
	
	public void setBase2(Coordonnees base2) {
		this.base2 = base2;
	}
	
	public void setSommet(Coordonnees sommet) {
		this.sommet = sommet;
	}

	public Coordonnees getBase1() {
		return base1;
	}
	
	public Coordonnees getBase2() {
		return base2;
	}
	
	public Coordonnees getSommet() {
		return sommet;
	}
	
	/**
	 * @since extension
	 * Affiche la couleur de remplissage si la forme est remplie et l'épaisseur des contours
	 */
	@Override
	public String toString() {
		return "[" + this.getClass().getSimpleName()
			 + (estRempli() ? "-Rempli" : "")
			 + "] : base de " + getBase1().toString()
			 + " à " + getBase2().toString()
			 + " sommet " + getSommet().toString()
			 + " hauteur : " + new DecimalFormat("0.0#").format(getHauteurTriangle())
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
	 * 
	 * @return	la hauteur du triangle (plus courte distance entre la base et le sommet)
	 */
	public double getHauteurTriangle() {
		Droite droiteBase = new Droite(getBase1(), getBase2());
		Coordonnees projete = droiteBase.projeteOrthogonal(getSommet());
		return getSommet().distanceVers(projete);
	}
	
	@Override
	public double aire() {
		return getBase1().distanceVers(getBase2())*getHauteurTriangle()/2;
	}
	
	@Override
	public double perimetre() {
		return getBase1().distanceVers(getBase2()) + getBase2().distanceVers(getSommet()) + getSommet().distanceVers(getBase1());
	}
	
	/**
	 * Methode basée sur le principe qu'un point M est dans un triangle ABC si 3 conditions sont vérifiées :
	 * 		(vect(AB) ^ vect(AM)) . (vect(AM) ^ vect(AC)) >= 0
	 * 		(vect(BA) ^ vect(BM)) . (vect(BM) ^ vect(BC)) >= 0
	 * 		(vect(CA) ^ vect(CM)) . (vect(CM) ^ vect(CB)) >= 0
	 * 
	 * après simplification sur papier, on obtient cette methode :
	 * 		- on commence par calculer les vecteurs
	 * 		- puis on calcul les normes de chaque produit vectoriel 
	 * 			(les vecteurs n'étant qu'en 2 dimension, le produit vectoriel n'a qu'une composante Z 
	 * 			qui est donc égale à sa norme
	 * 		- pour finir on vérifie si les produits vectoriels sont supérieurs ou égaux à 0
	 */
	@Override
	public boolean contient(Coordonnees point) {
		Vecteur vectAB = new Vecteur(getBase1(), getBase2());
		Vecteur vectAC = new Vecteur(getBase1(), getSommet());
		Vecteur vectAM = new Vecteur(getBase1(), point);
		Vecteur vectBA = new Vecteur(getBase2(), getBase1());
		Vecteur vectBC = new Vecteur(getBase2(), getSommet());
		Vecteur vectBM = new Vecteur(getBase2(), point);
		Vecteur vectCA = new Vecteur(getSommet(), getBase1());
		Vecteur vectCB = new Vecteur(getSommet(), getBase2());
		Vecteur vectCM = new Vecteur(getSommet(), point);
		
		double normeABvectAM = vectAB.getAbscisse()*vectAM.getOrdonnee() - vectAB.getOrdonnee()*vectAM.getAbscisse();
		double normeAMvectAC = vectAM.getAbscisse()*vectAC.getOrdonnee() - vectAM.getOrdonnee()*vectAC.getAbscisse();
		double normeBAvectBM = vectBA.getAbscisse()*vectBM.getOrdonnee() - vectBA.getOrdonnee()*vectBM.getAbscisse();
		double normeBMvectBC = vectBM.getAbscisse()*vectBC.getOrdonnee() - vectBM.getOrdonnee()*vectBC.getAbscisse();
		double normeCAvectCM = vectCA.getAbscisse()*vectCM.getOrdonnee() - vectCA.getOrdonnee()*vectCM.getAbscisse();
		double normeCMvectCB = vectCM.getAbscisse()*vectCB.getOrdonnee() - vectCM.getOrdonnee()*vectCB.getAbscisse();
				
		boolean condition1 = (Math.pow(normeABvectAM, 2) + Math.pow(normeAMvectAC, 2) - Math.pow(normeABvectAM-normeAMvectAC, 2))/2 >= 0;
		boolean condition2 = (Math.pow(normeBAvectBM, 2) + Math.pow(normeBMvectBC, 2) - Math.pow(normeBAvectBM-normeBMvectBC, 2))/2 >= 0;
		boolean condition3 = (Math.pow(normeCAvectCM, 2) + Math.pow(normeCMvectCB, 2) - Math.pow(normeCAvectCM-normeCMvectCB, 2))/2 >= 0;
		
		return condition1 && condition2 && condition3;
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

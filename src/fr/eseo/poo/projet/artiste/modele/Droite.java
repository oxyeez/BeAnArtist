package fr.eseo.poo.projet.artiste.modele;

/**
 * @since extension
 * @author marcelin
 *
 * Class qui permet de créer une droite de façon abstraite
 */
public class Droite {
	public static final double A_PAR_DEFAUT = 1;
	public static final double B_PAR_DEFAUT = 1;
	public static final double C_PAR_DEFAUT = 1;
	
	
	//valeurs de a, b et c dans l'équation de droite sous la forme ax+by+c=0
	public double a, b, c;
	
	/**
	 * Crée une droite à partir d'un point et d'un vecteur qui peut etre normal ou directeur de la droite
	 * @param vecteur			Vecteur normale ou directeur de la droite
	 * @param point				Point de la droite
	 * @param vecteurNormal		true si le vecteur donné est normal à la droite, false si il est directeur
	 */
	public Droite(Vecteur vecteur, Coordonnees point, boolean vecteurNormal) {
		if(!vecteurNormal)
			setDroiteFromVecteurDirecteur(vecteur, point);
		else
			setDroiteFromVecteurNormal(vecteur, point);
	}
	
	/**
	 * Permet de créer une droite à partir d'un vecteur directeur de la droite et d'un point sans avoir à préciser le type de vecteur
	 * @param vecteur			Vecteur directeur de la droite
	 * @param point				Point de la droite
	 */
	public Droite(Vecteur vecteur, Coordonnees point) {
		this(vecteur, point, false);
	}
	
	/**
	 * Permet de créer une droite à partir de deux points de la droite
	 * @param point1			un point de la droite
	 * @param point2			un autre point de la droite
	 */
	public Droite(Coordonnees point1, Coordonnees point2) {
		this(new Vecteur(point1, point2), point1, false);
	}

	/**
	 * Permet de définir la droite en fonction d'un vecteur directeur et d'un point de la droite
	 * @param vecteur
	 * @param point
	 */
	public void setDroiteFromVecteurDirecteur(Vecteur vecteur, Coordonnees point) {
		setA(vecteur.getOrdonnee());
		setB(-vecteur.getAbscisse());
		setC(-(vecteur.getOrdonnee()*point.getAbscisse()-vecteur.getAbscisse()*point.getOrdonnee()));
	}

	/**
	 * Permet de définir la droite en fonction d'un vecteur normal et d'un point de la droite
	 * @param vecteur
	 * @param point
	 */
	public void setDroiteFromVecteurNormal(Vecteur vecteur, Coordonnees point) {
		setA(vecteur.getAbscisse());
		setB(vecteur.getOrdonnee());
		setC(-(vecteur.getAbscisse()*point.getAbscisse() + vecteur.getOrdonnee()*point.getOrdonnee()));
	}
	
	/**
	 * 
	 * @return		un vecteur directeur de la droite
	 */
	public Vecteur getVecteurDirecteur() {
		return new Vecteur(-getB(), getA());
	}
	
	/**
	 * 
	 * @return		un vecteur normal à la droite
	 */
	public Vecteur getVecteurNormal() {
		return new Vecteur(getA(), getB());
	}
	
	public void setA(double a) {
		this.a = a;
	}
	
	public void setB(double b) {
		this.b = b;
	}
	
	public void setC(double c) {
		this.c = c;
	}
	
	public double getA() {
		return this.a;
	}
	
	public double getB() {
		return this.b;
	}
	
	public double getC() {
		return this.c;
	}
	
	/**
	 * Permet de calculer le projeté orthogonal d'un point donné sur la droite
	 * 
	 * On résoud un système de 2 équations à 2 inconnus afin de définir le point d'intersection 
	 * de la droite sur laquelle on veut projeté et de la droite perpendiculaire à cette dernière 
	 * et passant par le point à projeter
	 * 
	 * @param point		Point à projeter
	 * @return			les coordonnees du projeté
	 */
	public Coordonnees projeteOrthogonal(Coordonnees point) {
		Droite droiteParPoint = new Droite(getVecteurDirecteur(), point, true);
		double abscisseProjete, ordonneeProjete;
		if (getA() == 0) {
			abscisseProjete = -droiteParPoint.getC()/droiteParPoint.getA();
			ordonneeProjete = -getC()/getB();
		}
		else if(getB() == 0) {
			abscisseProjete = -getC()/getA();
			ordonneeProjete = -droiteParPoint.getC()/droiteParPoint.getB();
		}
		else {
			ordonneeProjete = (-((getC()*droiteParPoint.getA())/getA())+droiteParPoint.getC())/
								(((droiteParPoint.getA()*getB())/getA())-droiteParPoint.getB());
			abscisseProjete = -(getB()*ordonneeProjete+getC())/getA();
		}
		return new Coordonnees(abscisseProjete, ordonneeProjete);
	}
}

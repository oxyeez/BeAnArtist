package fr.eseo.poo.projet.artiste.controleur.outils.formes;

import java.awt.event.MouseEvent;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Triangle;
import fr.eseo.poo.projet.artiste.modele.formes.TriangleEquilateral;
import fr.eseo.poo.projet.artiste.modele.formes.TriangleIsocele;
import fr.eseo.poo.projet.artiste.modele.formes.TriangleRectangle;
import fr.eseo.poo.projet.artiste.vue.formes.VueTriangle;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;

/**
 * @since extension
 * @author marcelin
 *
 * Class créant l'outil permettant de dessiner les triangles de tous types
 */
public class OutilTriangle extends OutilForme {

	//liste contenant tous les types de triangles pris en charge
	public static final String[] TYPES_TRIANGLE = {"Libre", "Isocele", "Equilateral", "Rectangle"};
	
	//variable indiquant si la base est déjà tracée ou non
	public boolean baseTracee;
	//variable contenant les coordonnees du sommet
	public Coordonnees sommet;
	
	public OutilTriangle(PanneauBarreOutils panneauBarreOutils) {
		super(panneauBarreOutils);
		this.baseTracee = false;
		this.sommet = null;
	}
	
	/**
	 * Si la base n'est pas tracée, on affecte le point d'appui de la souris aux coordonnees de début
	 */
	@Override
	public void mousePressed(MouseEvent event) {
		if (!getBaseTracee())
			super.mousePressed(event);
	}
	
	/**
	 * Si le triangle est de type equilatéral, deux points suffisent pour tracer le triangle, on trace donc la triangle à ce moment
	 * 
	 * Si le triangle est d'un autre type, et que la base n'est pas tracée, on affecte le point de relache de la souris aux coordonnees de fin,
	 * 		et si le début et différent de la fin, on définie la base comme étant tracée
	 */
	@Override
	public void mouseReleased(MouseEvent event) {
		if (getPanneauBarreOutils().getTypeTriangle().equals("Equilateral")) {
			super.mouseReleased(event);
		}
		else {
			if (!getBaseTracee()) {
				setFin(new Coordonnees(event.getX(), event.getY()));
				if (!getDebut().estEgalA(getFin()))
					setBaseTracee(true);
			}
		}
	}
	
	/**
	 * Si le triangle est de type equilatéral et qu'un double click a été effectué on crée une VueTriangle, 
	 * 			qui sera alors un triangle equilateral par défaut car le début et la fin sont identiques
	 * 
	 * Si le triangle est d'un autre type :
	 * 		s'il s'agit d'un double click, on crée une VueTriangle, 
	 * 			qui sera alors un triangle du type demandé par défaut car le début et la fin sont identiques
	 * 		s'il s'agit d'un simple click et que la base est déjà tracée, 
	 * 			il s'agit alors du click qui défini le sommet, on affecte donc la valeur du point de click aux coordonnees du sommet
	 * 		pour finir si la forme était en construction, on la définie comme n'étant plus en construction 
	 * 			car dans les deux cas elle est complete
	 */
	@Override
	public void mouseClicked(MouseEvent event) {
		if (getPanneauBarreOutils().getTypeTriangle().equals("Equilateral")) {
			if (event.getClickCount() == 2) {
				getPanneauDessin().ajouterVueForme(creerVueForme());
				getPanneauDessin().repaint();
			}
		}
		else {
			if (event.getClickCount() == 2) {
				setSommet(new Coordonnees(event.getX(), event.getY()));
				getPanneauDessin().ajouterVueForme(creerVueForme());
				getPanneauDessin().repaint();
				setBaseTracee(false);
			}
			else if (event.getClickCount() == 1 && getBaseTracee()) {
				setSommet(new Coordonnees(event.getX(), event.getY()));
				getPanneauDessin().remplacerDerniereVueForme(creerVueForme());
				getPanneauDessin().repaint();
				setBaseTracee(false);
			}
			if (getFormeEnConstruction())
				setFormeEnConstruction(false);
		}
	}
	
	/**
	 * Pour gérer le rubberbanding
	 * 
	 * Si le triangle est de type equilatéral, rien ne change par rapport aux autres formes
	 * 
	 * Si le triangle est d'un autre type :
	 * 		on définie l'endroit actuel de la souris comme étant à la fois la fin et le sommet, 
	 * 		s'il s'agit du premier déplacement on définie la forme comme étant en construction et on ajoute une forme à la toile
	 * 		sinon on remplace juste la dernière forme par une nouvelle
	 */
	@Override
	public void mouseDragged(MouseEvent event) {
		if (getPanneauBarreOutils().getTypeTriangle().equals("Equilateral")) {
			super.mouseDragged(event);
		}
		else {
			setFin(new Coordonnees(event.getX(), event.getY()));
			setSommet(getFin());
			if (!getFormeEnConstruction()) {
				setFormeEnConstruction(true);
				getPanneauDessin().ajouterVueForme(creerVueForme());
			}
			else {
				getPanneauDessin().remplacerDerniereVueForme(creerVueForme());
			}
		}
		getPanneauDessin().repaint();
	}
	
	/**
	 * Si la base est tracée et que la forme est toujours en construction, on définie la position de la souris comme étant le sommet du triangle 
	 * et on remplace la dernière forme par une nouvelle
	 */
	@Override
	public void mouseMoved(MouseEvent event) {
		if (getBaseTracee() && getFormeEnConstruction()) {
			setSommet(new Coordonnees(event.getX(), event.getY()));
			getPanneauDessin().remplacerDerniereVueForme(creerVueForme());
			getPanneauDessin().repaint();
		}
	}

	/**
	 * Création de la vue forme en fonction du type de triangle demandé
	 */
	@Override
	protected VueTriangle creerVueForme() {
		Triangle triangle;
		switch (getPanneauBarreOutils().getTypeTriangle()) {
			case "Isocele" :
				if (!getDebut().estEgalA(getFin())) {
					if (getSommet().distanceVers(getFin()) <= 3) {
						triangle = new TriangleIsocele(getDebut(), getFin());
					}
					else {
						triangle = new TriangleIsocele(getDebut(), getFin(), getSommet());
					}
				}
				else {
					triangle = new TriangleIsocele(getDebut());
				}
				break;
			
			case "Equilateral" :
				if (!getDebut().estEgalA(getFin())) {
					triangle = new TriangleEquilateral(getDebut(), getFin());
				}
				else {
					triangle = new TriangleEquilateral(getDebut());
				}
				break;
			
			case "Rectangle" :
				if (!getDebut().estEgalA(getFin())) {
					if (getSommet().distanceVers(getFin()) <= 3) {
						triangle = new TriangleRectangle(getDebut(), getFin());
					}
					else {
						triangle = new TriangleRectangle(getDebut(), getFin(), getSommet());
					}
				}
				else {
					triangle = new TriangleRectangle(getDebut());
				}
				break;
				
			default :	// dans le cas où le type est Libre, ou si un type inconnu est reçu
				if (!getDebut().estEgalA(getFin())) {
					if (!getSommet().estEgalA(getFin())) {
						triangle = new Triangle(getDebut(), getFin(), getSommet());
					}
					else {
						triangle = new Triangle(getDebut(), getFin());
					}
				}
				else {
					triangle = new Triangle(getDebut());
				}
				break;
		}
		triangle.setCouleur(getPanneauDessin().getCouleurCourante());
		triangle.setRempli(getPanneauDessin().getModeRemplissage());
		triangle.setCouleurRemplissage(getPanneauDessin().getCouleurRemplissageCourante());
		triangle.setEpaisseurContours(getPanneauBarreOutils().getEpaisseurContours());
		
		return new VueTriangle(triangle);
	}
	
	public void setSommet(Coordonnees sommet) {
		this.sommet = sommet;
	}
	
	public void setBaseTracee(boolean tracee) {
		this.baseTracee = tracee;
	}
	
	public Coordonnees getSommet() {
		return this.sommet;
	}
	
	public boolean getBaseTracee() {
		return this.baseTracee;
	}
}

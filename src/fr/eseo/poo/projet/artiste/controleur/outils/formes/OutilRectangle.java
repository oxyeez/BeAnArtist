package fr.eseo.poo.projet.artiste.controleur.outils.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Rectangle;
import fr.eseo.poo.projet.artiste.vue.formes.VueRectangle;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;

/**
 * @since extension
 * @author marcelin
 *
 * Class créant l'outil permettant de dessiner les rectangles
 */
public class OutilRectangle  extends OutilForme {

	public OutilRectangle(PanneauBarreOutils panneauBarreOutils) {
		super(panneauBarreOutils);
	}

	@Override
	protected VueRectangle creerVueForme() {
		Rectangle rectangle;
		if (!getDebut().estEgalA(getFin())) {
			Coordonnees position = new Coordonnees(Math.min(getDebut().getAbscisse(), getFin().getAbscisse()),
					Math.min(getDebut().getOrdonnee(), getFin().getOrdonnee()));
			double largeur = Math.abs(getFin().getAbscisse() - getDebut().getAbscisse());
			double hauteur = Math.abs(getFin().getOrdonnee() - getDebut().getOrdonnee());
			rectangle = new Rectangle(position, largeur, hauteur);
		} else {
			rectangle = new Rectangle(getDebut());
		}
		rectangle.setCouleur(getPanneauDessin().getCouleurCourante());
		rectangle.setRempli(getPanneauDessin().getModeRemplissage());
		rectangle.setCouleurRemplissage(getPanneauDessin().getCouleurRemplissageCourante());
		rectangle.setEpaisseurContours(getPanneauBarreOutils().getEpaisseurContours());
		
		return new VueRectangle(rectangle);
	}
}
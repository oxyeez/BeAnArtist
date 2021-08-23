package fr.eseo.poo.projet.artiste.controleur.outils.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.poo.projet.artiste.vue.formes.VueEllipse;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;

public class OutilEllipse extends OutilForme {

	/**
	 * Constructeur qui demande un panneauBarreOutils, car on en a besoin pour récupérer l'épaisseur des traits
	 * 
	 * @param panneauBarreOutils
	 * @since extension
	 */
	public OutilEllipse(PanneauBarreOutils panneauBarreOutils) {
		super(panneauBarreOutils);
	}

	@Override
	protected VueEllipse creerVueForme() {
		Ellipse ellipse;
		if (!getDebut().estEgalA(getFin())) {
			Coordonnees position = new Coordonnees(Math.min(getDebut().getAbscisse(), getFin().getAbscisse()),
					Math.min(getDebut().getOrdonnee(), getFin().getOrdonnee()));
			double largeur = Math.abs(getFin().getAbscisse() - getDebut().getAbscisse());
			double hauteur = Math.abs(getFin().getOrdonnee() - getDebut().getOrdonnee());
			ellipse = new Ellipse(position, largeur, hauteur);
		} else {
			ellipse = new Ellipse(getDebut());
		}
		ellipse.setCouleur(getPanneauDessin().getCouleurCourante());
		ellipse.setRempli(getPanneauDessin().getModeRemplissage());
		ellipse.setCouleurRemplissage(getPanneauDessin().getCouleurRemplissageCourante());
		ellipse.setEpaisseurContours(getPanneauBarreOutils().getEpaisseurContours());
		return new VueEllipse(ellipse);
	}
}

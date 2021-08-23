package fr.eseo.poo.projet.artiste.controleur.outils.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Cercle;
import fr.eseo.poo.projet.artiste.vue.formes.VueCercle;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;

public class OutilCercle extends OutilForme {
	
	/**
	 * Constructeur qui demande un panneauBarreOutils, car on en a besoin pour récupérer l'épaisseur des traits
	 * 
	 * @param panneauBarreOutils
	 * @since extension
	 */
	public OutilCercle(PanneauBarreOutils panneauBarreOutils) {
		super(panneauBarreOutils);
	}

	@Override
	protected VueCercle creerVueForme() {
		Cercle cercle;
		if (!getDebut().estEgalA(getFin())) {
			
			double largeur = Math.max(Math.abs(getFin().getAbscisse() - getDebut().getAbscisse()),
										Math.abs(getFin().getOrdonnee() - getDebut().getOrdonnee()));
			double x;
			double y;
			if (getFin().getAbscisse() - getDebut().getAbscisse() < 0) {
				x = getDebut().getAbscisse()-largeur;
			}
			else {
				x = getDebut().getAbscisse();
			}
			if (getFin().getOrdonnee() - getDebut().getOrdonnee() < 0) {
				y = getDebut().getOrdonnee()-largeur;
			}
			else {
				y = getDebut().getOrdonnee();
			}
			Coordonnees position = new Coordonnees(x, y);
			cercle = new Cercle(position, largeur);
		}
		else {
			cercle = new Cercle(getDebut());
		}
		cercle.setCouleur(getPanneauDessin().getCouleurCourante());
		cercle.setRempli(getPanneauDessin().getModeRemplissage());
		cercle.setCouleurRemplissage(getPanneauDessin().getCouleurRemplissageCourante());
		cercle.setEpaisseurContours(getPanneauBarreOutils().getEpaisseurContours());
		return new VueCercle(cercle);
	}
}

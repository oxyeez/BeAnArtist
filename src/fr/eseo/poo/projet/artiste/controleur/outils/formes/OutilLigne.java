package fr.eseo.poo.projet.artiste.controleur.outils.formes;

import fr.eseo.poo.projet.artiste.modele.formes.Ligne;
import fr.eseo.poo.projet.artiste.vue.formes.VueLigne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;

public class OutilLigne extends OutilForme {
	
	/**
	 * Constructeur qui demande un panneauBarreOutils, car on en a besoin pour récupérer l'épaisseur des traits
	 * 
	 * @param panneauBarreOutils
	 * @since extension
	 */
	public OutilLigne(PanneauBarreOutils panneauBarreOutils) {
		super(panneauBarreOutils);
	}

	@Override
	protected VueLigne creerVueForme() {
		Ligne ligne;
		if (!getDebut().estEgalA(getFin())) {
			double largeur = getFin().getAbscisse() - getDebut().getAbscisse();
			double hauteur = getFin().getOrdonnee() - getDebut().getOrdonnee();
			ligne = new Ligne(getDebut(), largeur, hauteur);
		}
		else {
			ligne = new Ligne(getDebut());
		}
		ligne.setCouleur(getPanneauDessin().getCouleurCourante());
		ligne.setEpaisseurContours(getPanneauBarreOutils().getEpaisseurContours());
		return new VueLigne(ligne);
	}
}

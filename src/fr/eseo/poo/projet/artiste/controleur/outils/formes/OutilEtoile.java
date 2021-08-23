package fr.eseo.poo.projet.artiste.controleur.outils.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;
import fr.eseo.poo.projet.artiste.vue.formes.VueEtoile;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;

public class OutilEtoile extends OutilForme {
	
	public PanneauBarreOutils panneauBarreOutils;
	
	public OutilEtoile(PanneauBarreOutils panneauBarreOutils) {
		super(panneauBarreOutils);
	}
	
	@Override
	protected VueEtoile creerVueForme() {
		Etoile etoile;
		if (!getDebut().estEgalA(getFin())) {
			double taille = getDebut().distanceVers(getFin());
			Coordonnees position = new Coordonnees(getFin().getAbscisse(), getFin().getOrdonnee());
			position.deplacerDe(-taille, -taille);
			etoile = new Etoile(position, taille*2);
			etoile.setAnglePremiereBranche(getDebut().angleVers(getFin()));
		}
		else {
			etoile = new Etoile(getDebut());
			etoile.setAnglePremiereBranche(Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT);
		}
		etoile.setCouleur(getPanneauDessin().getCouleurCourante());
		etoile.setRempli(getPanneauDessin().getModeRemplissage());
		etoile.setCouleurRemplissage(getPanneauDessin().getCouleurRemplissageCourante());
		etoile.setAnglePremiereBranche(getDebut().angleVers(getFin()));
		etoile.setLongueurBranche(getPanneauBarreOutils().getLongueurBranche());
		etoile.setNombreBranches(getPanneauBarreOutils().getNbBranchesCotes());
		etoile.setEpaisseurContours(getPanneauBarreOutils().getEpaisseurContours());

		return new VueEtoile(etoile);
	}
}

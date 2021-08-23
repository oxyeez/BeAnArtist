package fr.eseo.poo.projet.artiste.controleur.outils.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Polygone;
import fr.eseo.poo.projet.artiste.vue.formes.VuePolygone;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;

/**
 * @since extension
 * @author marcelin
 *
 * Classe créant l'outil permettant de dessiner les polygones réguliers
 */
public class OutilPolygone extends OutilForme {
	
	public OutilPolygone(PanneauBarreOutils panneauBarreOutils) {
		super(panneauBarreOutils);
	}
	
	/**
	 * Crée une VuePolygone pour un Polygone prenant le nombre de cotés demandés dans le panneauBarreOutils et l'angleDuPremierSommet
	 */
	@Override
	protected VuePolygone creerVueForme() {
		Polygone polygone;
		if (!getDebut().estEgalA(getFin())) {
			double taille = getDebut().distanceVers(getFin());
			Coordonnees position = new Coordonnees(getFin().getAbscisse(), getFin().getOrdonnee());
			position.deplacerDe(-taille, -taille);
			polygone = new Polygone(position, taille*2);
			polygone.setAnglePremierSommet(getDebut().angleVers(getFin()));
		}
		else {
			polygone = new Polygone(getDebut());
			polygone.setAnglePremierSommet(Polygone.ANGLE_PREMIER_SOMMET_PAR_DEFAUT);
		}
		polygone.setCouleur(getPanneauDessin().getCouleurCourante());
		polygone.setRempli(getPanneauDessin().getModeRemplissage());
		polygone.setCouleurRemplissage(getPanneauDessin().getCouleurRemplissageCourante());
		polygone.setAnglePremierSommet(getDebut().angleVers(getFin()));
		polygone.setNombreSommets(getPanneauBarreOutils().getNbBranchesCotes());
		polygone.setEpaisseurContours(getPanneauBarreOutils().getEpaisseurContours());
		
		return new VuePolygone(polygone);
	}
}

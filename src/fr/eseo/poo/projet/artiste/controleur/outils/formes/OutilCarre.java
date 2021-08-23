package fr.eseo.poo.projet.artiste.controleur.outils.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Carre;
import fr.eseo.poo.projet.artiste.vue.formes.VueCarre;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;

/**
 * Class outil permettant le dessin de Carrés, semblable à OutilCercle
 * 
 * @author marcelin
 * @since extension
 */
public class OutilCarre extends OutilForme {

	public OutilCarre(PanneauBarreOutils panneauBarreOutils) {
		super(panneauBarreOutils);
	}

	@Override
	protected VueCarre creerVueForme() {
		Carre carre;
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
			carre = new Carre(position, largeur);
		}
		else {
			carre = new Carre(getDebut());
		}
		carre.setCouleur(getPanneauDessin().getCouleurCourante());
		carre.setCouleurRemplissage(getPanneauDessin().getCouleurRemplissageCourante());
		carre.setRempli(getPanneauDessin().getModeRemplissage());
		carre.setEpaisseurContours(getPanneauBarreOutils().getEpaisseurContours());
		return new VueCarre(carre);
	}
}
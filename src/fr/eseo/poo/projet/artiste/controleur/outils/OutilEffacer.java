package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Outil permettant d'effacer uniquement la forme sur laquelle on clique lorsqu'il est sélectionné
 * 
 * @author marcelin
 * @since extension
 */
public class OutilEffacer extends Outil {
	
	public PanneauDessin panneauDessin;
	
	public OutilEffacer(PanneauDessin panneauDessin) {
		this.panneauDessin = panneauDessin;
	}
	
	public PanneauDessin getPanneauBarreOutils() {
		return this.panneauDessin;
	}
	
	/**
	 * On passe en revue toutes les formes en commençant pas celle du dessus
	 * Dès qu'une forme contient le poins cliqué on sauvegarde l'état de la toile à ce moment,
	 * on supprime la forme qui a étée clquée, et on rafraichi la toile
	 */
	@Override
	public void mouseClicked(MouseEvent event) {
		for (int i = getPanneauDessin().getVueFormes().size()-1; i >= 0; i--) {
			if (getPanneauDessin().getVueFormes().get(i).getForme().contient(getDebut())) {
				panneauDessin.setVueFormesAncien(panneauDessin.getVueFormes());
				getPanneauDessin().getVueFormes().remove(i);
				getPanneauDessin().repaint();
				break;
			}
		}
	}
}

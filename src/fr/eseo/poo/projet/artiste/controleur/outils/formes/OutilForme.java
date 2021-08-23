package fr.eseo.poo.projet.artiste.controleur.outils.formes;

import java.awt.event.MouseEvent;

import fr.eseo.poo.projet.artiste.controleur.outils.Outil;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;

public abstract class OutilForme extends Outil {
	
	//permet de savoir si la construction d'une forme est en cours ou non
	public boolean formeEnConstruction;
	public PanneauBarreOutils panneauBarreOutils;

	public OutilForme(PanneauBarreOutils panneauBarreOutils) {
		this.panneauBarreOutils = panneauBarreOutils;
		this.formeEnConstruction = false;
	}
	
	public PanneauBarreOutils getPanneauBarreOutils() {
		return this.panneauBarreOutils;
	}
	
	/**
	 * @since extension 	
	 * Lorsque la souris est relachée, la forme est déclarée comme n'étant plus en construction
	 */
	@Override
	public void mouseReleased(MouseEvent event) {
		super.mouseReleased(event);
		if (!getDebut().estEgalA(getFin())) {
			getPanneauDessin().remplacerDerniereVueForme(creerVueForme());
			getPanneauDessin().repaint();
		}
		if (getFormeEnConstruction())
			setFormeEnConstruction(false);
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {
		if (event.getClickCount() == 2) {
			getPanneauDessin().ajouterVueForme(creerVueForme());
			getPanneauDessin().repaint();
		}
	}
	
	/**
	 * @since extension
	 * Pour gérer le rubberbanding
	 * Lorsque la souris est déplacée avec bouton appuyé :
	 * 		s'il s'agit du premier déplacement on crée une nouvelle forme ayant pour position de 
	 * 		fin la position actuelle de la souris qu'on ajoute à la toile et on déclare la forme 
	 * 		comme étant en construction si la forme est déjà en construction, on crée une nouvelle 
	 * 		forme ayant pour position de fin la position actuelle de la souris, qui vient remplacer 
	 * 		la forme précédente
	 */
	@Override
	public void mouseDragged(MouseEvent event) {
		super.mouseDragged(event);
		if (!getFormeEnConstruction()) {
			setFormeEnConstruction(true);
			getPanneauDessin().ajouterVueForme(creerVueForme());
		}
		else
			getPanneauDessin().remplacerDerniereVueForme(creerVueForme());
		getPanneauDessin().repaint();
	}
	
	public void setFormeEnConstruction(boolean enConstruction) {
		this.formeEnConstruction = enConstruction;
	}
	
	public boolean getFormeEnConstruction() {
		return this.formeEnConstruction;
	}

	protected abstract VueForme creerVueForme();
}

package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Class ActionEffacer renommée après les extensions
 * @since extension
 */
public class ActionToutEffacer extends javax.swing.AbstractAction {

	private static final long serialVersionUID = 1L;
	public static final String NOM_ACTION = "Tout effacer";
	public PanneauDessin panneauDessin;
	
	public ActionToutEffacer(PanneauDessin panneau) {
		super(NOM_ACTION);
		this.panneauDessin = panneau;
	}
	
    /**
     * Ouverture d'une fenetre de confirmation
     * 
     * Si il y a confirmation on efface toutes les VueFormes enregistrées et on raffraichie la toile
     */
	@Override
	public void actionPerformed(ActionEvent event) {
		int reponse = JOptionPane.showConfirmDialog(panneauDessin, "Voullez-vous tout effacer?", NOM_ACTION, JOptionPane.YES_NO_OPTION);
		if(reponse == JOptionPane.YES_OPTION) {
			panneauDessin.setVueFormesAncien(panneauDessin.getVueFormes());
			panneauDessin.getVueFormes().clear();
			panneauDessin.repaint();
		}
	}
}
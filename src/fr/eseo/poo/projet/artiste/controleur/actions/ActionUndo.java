package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Class permettant d'annuler la dernière action effectuée
 * 
 * @author marcelin
 * @since extensions
 */
public class ActionUndo extends javax.swing.AbstractAction {

	private static final long serialVersionUID = 1L;
	public static final String NOM_ACTION = "Retour";
	public PanneauDessin panneauDessin;
	
	public ActionUndo(PanneauDessin panneau) {
		super(NOM_ACTION);
		this.panneauDessin = panneau;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		panneauDessin.switchVueFormes();
	}
}

package fr.eseo.poo.projet.artiste.controleur.actions;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilSelectionner;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;
import java.awt.event.ActionEvent;

public class ActionSelectionner extends javax.swing.AbstractAction {
	
	private static final long serialVersionUID = 1L;
	public static final String NOM_ACTION = "Selectionner";
	
	public PanneauDessin panneauDessin;
	
	public ActionSelectionner(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		OutilSelectionner outilSelectionner = new OutilSelectionner();
		panneauDessin.associerOutil(outilSelectionner);
	}
}

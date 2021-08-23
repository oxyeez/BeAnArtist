package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.JCheckBox;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirRemplissage extends javax.swing.AbstractAction {

	private static final long serialVersionUID = 1L;
	public static final String NOM_ACTION = "Remplissage";
    private PanneauDessin panneauDessin;

    public ActionChoisirRemplissage(PanneauDessin panneau) {
		super(NOM_ACTION);
		this.panneauDessin = panneau;
    }

    /**
     * Lorsque l'état de la checkbox change, la mode de remplissage est adapté
     */
    @Override
    public void actionPerformed(ActionEvent event) {
    	panneauDessin.setModeRemplissage(((JCheckBox)event.getSource()).isSelected());
    }
}

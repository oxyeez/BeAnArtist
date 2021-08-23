package fr.eseo.poo.projet.artiste.controleur.actions;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilEffacer;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;
import java.awt.event.ActionEvent;

/**
 * Contrairement à la version de base, cette Class permet de supprimer un seul element
 * La Class qui permet d'effacer tout est maintenant nomée ActionEffacerTout
 * @author marcelin
 * @since extension
 */
public class ActionEffacer extends javax.swing.AbstractAction {

	private static final long serialVersionUID = 1L;
	public static final String NOM_ACTION = "Effacer";
	public PanneauDessin panneauDessin;
	
	public ActionEffacer(PanneauDessin panneau) {
		super(NOM_ACTION);
		this.panneauDessin = panneau;
	}
	
    /**
     * Initialisation de l'outilEffacer
     */
	@Override
	public void actionPerformed(ActionEvent event) {
		OutilEffacer outilEffacer = new OutilEffacer(panneauDessin);
		panneauDessin.associerOutil(outilEffacer);
	}
}

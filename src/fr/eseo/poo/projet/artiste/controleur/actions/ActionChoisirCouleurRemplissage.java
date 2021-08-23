package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JColorChooser;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Extension basée sur la Class ActionChoisirCouleur mais pour la couleur de remplissage es formes uniquement
 * @author marcelin
 *
 */
public class ActionChoisirCouleurRemplissage extends javax.swing.AbstractAction {

	private static final long serialVersionUID = 1L;
	public static final String NOM_ACTION = "Remplissage";
	
	public PanneauDessin panneauDessin;
	
	public ActionChoisirCouleurRemplissage(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}
	
	/**
	 * @since extension
	 * garde la couleur équipé prededemment lorsque l'utilisateur choisi d'annuler, auparavant la couleur était réinitialisée à NOIR dans ce cas
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		Color couleur = JColorChooser.showDialog(panneauDessin, NOM_ACTION, panneauDessin.getCouleurRemplissageCourante());
		if (couleur == null)
			couleur = panneauDessin.getCouleurRemplissageCourante();
		panneauDessin.setCouleurRemplissageCourante(couleur);
	}
}

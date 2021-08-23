package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JOptionPane;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

public class OutilSelectionner extends Outil {
	
	public Forme formeSelectionnee;
	
	@Override
	public void mouseClicked(MouseEvent event) {
		List<VueForme> vueFormes = getPanneauDessin().getVueFormes();
		for (int i = vueFormes.size()-1; i >= 0; i--) {
			if (vueFormes.get(i).getForme().contient(getDebut())) {
				this.formeSelectionnee = vueFormes.get(i).getForme();
				break;
			}
		}
		if (formeSelectionnee != null) {
			JOptionPane.showMessageDialog(getPanneauDessin(), 
										  formeSelectionnee.toString(), 
										  ActionSelectionner.NOM_ACTION,
										  JOptionPane.INFORMATION_MESSAGE);
		}
		formeSelectionnee = null;
	}
}

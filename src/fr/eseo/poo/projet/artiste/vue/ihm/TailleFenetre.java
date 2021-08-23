package fr.eseo.poo.projet.artiste.vue.ihm;

import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class TailleFenetre implements ComponentListener {

	public PanneauDessin panneauDessin;
	public PanneauBarreOutils panneauBarreOutils;

	public TailleFenetre(PanneauDessin panneauDessin, PanneauBarreOutils panneauBarreOutils) {
		this.panneauDessin = panneauDessin;
		this.panneauBarreOutils = panneauBarreOutils;
	}
	
	@Override
	public void componentResized(ComponentEvent e) {
		int largeur = (int) (e.getComponent().getSize().getWidth()-panneauBarreOutils.getSize().getWidth());
		int hauteur = (int) e.getComponent().getSize().getHeight();
		panneauDessin.setSize(new Dimension(largeur, hauteur));
		panneauBarreOutils.setLocation(largeur, 0);
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

}

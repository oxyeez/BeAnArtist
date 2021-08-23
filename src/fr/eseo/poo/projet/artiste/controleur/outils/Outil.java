package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;
import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public abstract class Outil implements javax.swing.event.MouseInputListener {
	
	private PanneauDessin panneauDessin;
	private Coordonnees debut, fin;
	
	public Coordonnees getDebut() {
		return debut;
	}
	
	public Coordonnees getFin() {
		return fin;
	}
	
	public PanneauDessin getPanneauDessin() {
		return panneauDessin;
	}
	
	public void setDebut(Coordonnees debut) {
		this.debut = debut;
	}
	
	public void setFin(Coordonnees fin) {
		this.fin = fin;
	}
	
	public void setPanneauDessin(PanneauDessin panneau) {
		this.panneauDessin = panneau;
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {
		
	}
	
	@Override
	public void mouseDragged(MouseEvent event) {
		setFin(new Coordonnees(event.getX(), event.getY()));
	}
	
	@Override
	public void mouseEntered(MouseEvent event) {
		
	}
	
	@Override
	public void mouseExited(MouseEvent event) {
		
	}
	
	@Override
	public void mouseMoved(MouseEvent event) {
		
	}
	
	@Override
	public void mousePressed(MouseEvent event) {
		setDebut(new Coordonnees(event.getX(), event.getY()));
	}
	
	@Override
	public void mouseReleased(MouseEvent event) {
		setFin(new Coordonnees(event.getX(), event.getY()));
	}
}

package fr.eseo.poo.projet.artiste.vue.ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.Graphics;

import fr.eseo.poo.projet.artiste.vue.formes.VueForme;
import fr.eseo.poo.projet.artiste.controleur.outils.Outil;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;

/**
 * @since extension
 * 
 * Mise en place d'une nouvelle liste de VueForme afin de sauvegarder la liste de VueForme 
 * principale dans l'état où elle était juste avant la dernière modification
 */
public class PanneauDessin extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;
	public static final int LARGEUR_PAR_DEFAUT = 700;
	public static final int HAUTEUR_PAR_DEFAUT = 550;
	public static final Color COULEUR_FOND_PAR_DEFAUT = Color.WHITE;

	public int largeur, hauteur;
	private List<VueForme> vueFormes, vueFormesAncien;
	private Outil outilCourant;
	private Color couleurCourante, couleurRemplissageCourante;

	public boolean modeRemplissage;

	public PanneauDessin() {
		this(LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT, COULEUR_FOND_PAR_DEFAUT);
	}

	public PanneauDessin(int largeur, int hauteur, Color fond) {
		this.largeur = largeur;
		this.hauteur = hauteur;
		setSize(new Dimension(largeur, hauteur));
		setBackground(fond);
		this.couleurCourante = Forme.COULEUR_PAR_DEFAUT;
		this.couleurRemplissageCourante = Forme.COULEUR_PAR_DEFAUT;
		this.modeRemplissage = false;		
		this.vueFormes = new ArrayList<VueForme>();
		this.vueFormesAncien = new ArrayList<VueForme>();
	}

	public List<VueForme> getVueFormes() {
		return this.vueFormes;
	}
	
	public List<VueForme> getVueFormesAncien() {
		return this.vueFormesAncien;
	}
	
	public Outil getOutilCourant() {
		return this.outilCourant;
	}
	
	public Color getCouleurCourante() {
		return this.couleurCourante;
	}

	public Color getCouleurRemplissageCourante() {
		return this.couleurRemplissageCourante;
	}

	public boolean getModeRemplissage() {
		return modeRemplissage;
	}
	
	private void setOutilCourant(Outil outil) {
		this.outilCourant = outil;
	}
	
	public void setCouleurCourante(Color couleur) {
		this.couleurCourante = couleur;
	}

	public void setCouleurRemplissageCourante(Color couleur) {
		this.couleurRemplissageCourante = couleur;
	}

	public void setModeRemplissage(boolean remplissage) {
		this.modeRemplissage = remplissage;
	}
	
	public void setVueFormes(List<VueForme> listeActuelle) {
		this.vueFormes = new ArrayList<VueForme>(listeActuelle);
	}

	public void setVueFormesAncien(List<VueForme> listeActuelle) {
		this.vueFormesAncien = new ArrayList<VueForme>(listeActuelle);
	}

	public void ajouterVueForme(VueForme vueForme) {
		setVueFormesAncien(getVueFormes());
		getVueFormes().add(vueForme);
	}
	
	public void retirerDerniereVueForme() {
		getVueFormes().remove(getVueFormes().size()-1);
	}
	
	/**
	 * @since extension
	 * 
	 * Permet de remplacer la dernière VueForme de la liste par celle donnée en parametre
	 */
	public void remplacerDerniereVueForme(VueForme vueForme) {
		retirerDerniereVueForme();
		ajouterVueForme(vueForme);
	}
	
	/**
	 * @since extension
	 * 
	 * Permet d'intervertir la liste de VueForme actuelle et la liste de VueForme d'avant
	 */
	public void switchVueFormes() {
		List<VueForme> listeActuelle = new ArrayList<VueForme>(getVueFormes());
		setVueFormes(getVueFormesAncien());
		setVueFormesAncien(listeActuelle);
		repaint();
	}
	
	public void associerOutil(Outil outil) {
		if (outil != null) {
			dissocierOutil();
			setOutilCourant(outil);
			outil.setPanneauDessin(this);
			addMouseListener(outil);
			addMouseMotionListener(outil);
		}
	}
	
	private void dissocierOutil() {
		if(getOutilCourant() != null && getOutilCourant().getPanneauDessin() != null) {
			removeMouseListener(getOutilCourant());
			removeMouseMotionListener(getOutilCourant());
			getOutilCourant().setPanneauDessin(null);
			setOutilCourant(null);
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g.create();
		for (VueForme vueForme : getVueFormes()) {
			vueForme.affiche(g2d);
		}
		g2d.dispose();
	}
}

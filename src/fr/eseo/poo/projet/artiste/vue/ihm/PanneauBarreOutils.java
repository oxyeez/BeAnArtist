package fr.eseo.poo.projet.artiste.vue.ihm;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirCouleur;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirCouleurRemplissage;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirRemplissage;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionEffacer;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionToutEffacer;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionUndo;
import fr.eseo.poo.projet.artiste.controleur.outils.formes.OutilTriangle;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JSpinner;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

/**
 * @since extension
 * 
 * Ajout des boutons/sliders/spinner permettant de gérer les nouvelles fonctionnalitées
 */
public class PanneauBarreOutils extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;
	public static final String BRANCHES_SPINNER_NOM = "Branches";
	public static final String COTES_SPINNER_NOM = "Cotés";
	public static final String LONGUEUR_SPINNER_NOM = "Longueur";
	public static final String TYPE_TRIANGLE_SPINNER_NOM = "Type de Triangle";
	public static final String EPAISSEUR_CONTOUR_SLIDER_NOM = "Epaisseur du Contour";

	private PanneauDessin panneauDessin;
	public JSpinner spinnerNombreBranchesCotes;
	public JSpinner spinnerLongueurBranche;
	public JSpinner spinnerTypeTriangle;
	public JSlider sliderEpaisseurContours;
	public JLabel labelLongueurBranche;
	public JLabel labelNombreBrancheCotes;
	
	public PanneauBarreOutils(PanneauDessin panneau) {
		this.panneauDessin = panneau;
		super.setLayout(new GridLayout(12, 2));
		super.setSize(new Dimension(250, 450));
		initComponents();
	}
	
	public void initComponents() {
		ButtonGroup boutonGroup = new ButtonGroup();

		ajouterBouton(new ActionEffacer(this.panneauDessin), ActionEffacer.NOM_ACTION);
		ajouterBouton(new ActionToutEffacer(this.panneauDessin), ActionToutEffacer.NOM_ACTION);
		ajouterBouton(new ActionUndo(this.panneauDessin), ActionUndo.NOM_ACTION);
		add(new JLabel(""));
		ajouterBouton(new ActionSelectionner(this.panneauDessin), boutonGroup, ActionSelectionner.NOM_ACTION);

		ajouterBouton(new ActionChoisirForme(this.panneauDessin, this, ActionChoisirForme.NOM_ACTION_LIGNE),
						boutonGroup, ActionChoisirForme.NOM_ACTION_LIGNE);
		ajouterBouton(new ActionChoisirForme(this.panneauDessin, this, ActionChoisirForme.NOM_ACTION_RECTANGLE), 
				boutonGroup, ActionChoisirForme.NOM_ACTION_RECTANGLE);
		ajouterBouton(new ActionChoisirForme(this.panneauDessin, this, ActionChoisirForme.NOM_ACTION_CARRE), 
				boutonGroup, ActionChoisirForme.NOM_ACTION_CARRE);
		ajouterBouton(new ActionChoisirForme(this.panneauDessin, this, ActionChoisirForme.NOM_ACTION_ELLIPSE), 
						boutonGroup, ActionChoisirForme.NOM_ACTION_ELLIPSE);
		ajouterBouton(new ActionChoisirForme(this.panneauDessin, this, ActionChoisirForme.NOM_ACTION_CERCLE),
						boutonGroup, ActionChoisirForme.NOM_ACTION_CERCLE);
		ajouterBouton(new ActionChoisirForme(this.panneauDessin, this, ActionChoisirForme.NOM_ACTION_TRIANGLE),
						boutonGroup, ActionChoisirForme.NOM_ACTION_TRIANGLE);
		spinnerTypeTriangle = new JSpinner(new SpinnerListModel(OutilTriangle.TYPES_TRIANGLE));
		spinnerTypeTriangle.setName(TYPE_TRIANGLE_SPINNER_NOM);
		add(spinnerTypeTriangle);
		
		ajouterBouton(new ActionChoisirForme(this.panneauDessin, this, ActionChoisirForme.NOM_ACTION_ETOILE), 
						boutonGroup, ActionChoisirForme.NOM_ACTION_ETOILE);
		ajouterBouton(new ActionChoisirForme(this.panneauDessin, this, ActionChoisirForme.NOM_ACTION_POLYGONE), 
				boutonGroup, ActionChoisirForme.NOM_ACTION_POLYGONE);
		labelLongueurBranche = new JLabel(LONGUEUR_SPINNER_NOM);
		add(labelLongueurBranche);
		labelNombreBrancheCotes = new JLabel(BRANCHES_SPINNER_NOM);
		add(labelNombreBrancheCotes);
		
		spinnerLongueurBranche = new JSpinner(new SpinnerNumberModel(Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT, 0, 1, 0.01));
		spinnerLongueurBranche.setName(LONGUEUR_SPINNER_NOM);
		add(spinnerLongueurBranche);
		spinnerNombreBranchesCotes = new JSpinner(new SpinnerNumberModel(Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, 3, 15, 1));
		spinnerNombreBranchesCotes.setName(BRANCHES_SPINNER_NOM);
		add(spinnerNombreBranchesCotes);
		
		ajouterBouton(new ActionChoisirCouleur(this.panneauDessin), ActionChoisirCouleur.NOM_ACTION);
		sliderInitialisation();
		ajouterBouton(new ActionChoisirCouleurRemplissage(this.panneauDessin), ActionChoisirCouleurRemplissage.NOM_ACTION);
		JCheckBox checkboxRemplissage = new JCheckBox(new ActionChoisirRemplissage(this.panneauDessin));
		checkboxRemplissage.setName(ActionChoisirRemplissage.NOM_ACTION);
		add(checkboxRemplissage);
		revalidate();
		repaint();
	}
	
	/**
	 * Methode qui permet de créer un JButton et de l'ajouter au JPanel barreOutils
	 * Créée afin de rendre la methode initComponent plus simple, et évite de répéter des blocs de 4 lignes en boucle
	 * 
	 * @param action	Action du bouton
	 * @param nom		Nom du bouton
	 */
	public void ajouterBouton(AbstractAction action, String nom) {
		JButton bouton = new JButton(action);
		bouton.setName(nom);
		add(bouton);
	}
	
	/**
	 * Methode permettant de créer un JToggleButton, de l'ajouter à un groupe et au JPanel barreOutils
	 * 
	 * @param action	Action du bouton
	 * @param group		Groupe d'appartenance du bouton
	 * @param nom		Nom du bouton
	 */
	public void ajouterBouton(AbstractAction action, ButtonGroup group, String nom) {
		JToggleButton bouton = new JToggleButton(action);
		bouton.setName(nom);
		group.add(bouton);
		add(bouton);
	}
	
	/**
	 * Initialisation du slider permettant de sélectionner l'épaisseur des contours
	 */
	public void sliderInitialisation() {
		sliderEpaisseurContours = new JSlider(1, 7, 1);
		sliderEpaisseurContours.setName(EPAISSEUR_CONTOUR_SLIDER_NOM);
		sliderEpaisseurContours.setPaintTicks(true);
		sliderEpaisseurContours.setSnapToTicks(true);
		sliderEpaisseurContours.setPaintLabels(true);
		
		Dictionary<Integer, Component> labelTable = new Hashtable<Integer, Component>();
		labelTable.put(1, new JLabel("1"));
		labelTable.put(2, new JLabel("2"));
		labelTable.put(3, new JLabel("3"));
		labelTable.put(4, new JLabel("4"));
		labelTable.put(5, new JLabel("5"));
		labelTable.put(6, new JLabel("6"));
		labelTable.put(7, new JLabel("7"));
		
		sliderEpaisseurContours.setLabelTable(labelTable);
		add(sliderEpaisseurContours);
	}
	
	public int getNbBranchesCotes() {
		return (int)this.spinnerNombreBranchesCotes.getValue();
	}
	
	public double getLongueurBranche() {
		return (double)this.spinnerLongueurBranche.getValue();
	}
	
	public String getTypeTriangle() {
		return (String)this.spinnerTypeTriangle.getValue();
	}
	
	public int getEpaisseurContours() {
		return (int)this.sliderEpaisseurContours.getValue();
	}
}
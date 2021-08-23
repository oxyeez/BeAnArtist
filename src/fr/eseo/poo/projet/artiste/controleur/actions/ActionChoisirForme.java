package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.SpinnerNumberModel;

import fr.eseo.poo.projet.artiste.controleur.outils.Outil;
import fr.eseo.poo.projet.artiste.controleur.outils.formes.OutilCarre;
import fr.eseo.poo.projet.artiste.controleur.outils.formes.OutilCercle;
import fr.eseo.poo.projet.artiste.controleur.outils.formes.OutilEllipse;
import fr.eseo.poo.projet.artiste.controleur.outils.formes.OutilEtoile;
import fr.eseo.poo.projet.artiste.controleur.outils.formes.OutilLigne;
import fr.eseo.poo.projet.artiste.controleur.outils.formes.OutilPolygone;
import fr.eseo.poo.projet.artiste.controleur.outils.formes.OutilRectangle;
import fr.eseo.poo.projet.artiste.controleur.outils.formes.OutilTriangle;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;
import fr.eseo.poo.projet.artiste.modele.formes.Polygone;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirForme extends javax.swing.AbstractAction {

	private static final long serialVersionUID = 1L;
	public static final String NOM_ACTION_LIGNE = "Ligne";
	public static final String NOM_ACTION_ELLIPSE = "Ellipse";
	public static final String NOM_ACTION_CERCLE = "Cercle";
	public static final String NOM_ACTION_RECTANGLE = "Rectangle"; 	//Extension
	public static final String NOM_ACTION_CARRE = "Carre";			//Extension
	public static final String NOM_ACTION_ETOILE = "Etoile";
	public static final String NOM_ACTION_POLYGONE = "Polygone";	//Extension
	public static final String NOM_ACTION_TRIANGLE = "Triangle";	//Extension
	
	public PanneauDessin panneauDessin;
	public PanneauBarreOutils panneauOutils;
	public String action;

	public ActionChoisirForme(PanneauDessin panneauDessin, PanneauBarreOutils panneauOutils, String action) {
		super(action);
		this.panneauDessin = panneauDessin;
		this.panneauOutils = panneauOutils;
		this.action = action;
	}

    /**
     * Methode selectionnant l'action demandée en utilisant un switch case
     * Une fois l'outil créé en fonction de l'action demandée, il est associé au panneauDessin
     * 
     * @since extension
     * Le principe est le même pour les formes ajoutées dans les extensions, à l'exception de Etoile et Polygone
     * Pour ces deux formes, si elles sont sélectionnées, on adapte l'affichage de panneauBarreOutils en fonction :
     * 		On désactive le spinner de longueur de branche lorsque le polygone est sélectionné car on ne s'en sert pas dans ce cas,
     * 		On modifie le le model du spinner de nombre de branches/cotes en fonction de la forme sélectionnée
     * 		On modifie le label du spiner de nombre de branche/cotes afin qu'il affiche "Nombre Branches" si étoile est sélectionné 
	 * 			et "Nombre Cotés" si polygone est séléctionné
     */
	@Override
	public void actionPerformed(ActionEvent event) {
		Outil outil;
		switch(action) {
			case NOM_ACTION_LIGNE :
				outil = new OutilLigne(panneauOutils);
				break;
				
			case NOM_ACTION_ELLIPSE :
				outil = new OutilEllipse(panneauOutils);
				break;
				
			case NOM_ACTION_CERCLE :
				outil = new OutilCercle(panneauOutils);
				break;
				
			case NOM_ACTION_RECTANGLE :
				outil = new OutilRectangle(panneauOutils);
				break;
				
			case NOM_ACTION_CARRE :
				outil = new OutilCarre(panneauOutils);
				break;
				
			case NOM_ACTION_TRIANGLE :
				outil = new OutilTriangle(panneauOutils);
				break;
				
			case NOM_ACTION_ETOILE :
				outil = new OutilEtoile(panneauOutils);
				panneauOutils.spinnerNombreBranchesCotes.setModel(
						new SpinnerNumberModel(Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, 3, 15, 1));
				panneauOutils.labelNombreBrancheCotes.setText(PanneauBarreOutils.BRANCHES_SPINNER_NOM);
				panneauOutils.spinnerLongueurBranche.setEnabled(true);
				break;
				
			case NOM_ACTION_POLYGONE :
				outil = new OutilPolygone(panneauOutils);
				panneauOutils.spinnerNombreBranchesCotes.setModel(
						new SpinnerNumberModel(Polygone.NOMBRE_SOMMET_PAR_DEFAUT, 5, 12, 1));
				panneauOutils.labelNombreBrancheCotes.setText(PanneauBarreOutils.COTES_SPINNER_NOM);
				panneauOutils.spinnerLongueurBranche.setEnabled(false);
				break;
				
			default:
				outil = null;
				break;
		}
		panneauDessin.associerOutil(outil);
	}
}

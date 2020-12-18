package test;

import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class Filtres extends Observable{
	public JRadioButton  site = new JRadioButton();
	public JRadioButton photoProfil = new JRadioButton();
	public JRadioButton photoBanniere = new JRadioButton();
	public JRadioButton biographie = new JRadioButton();
	public JRadioButton Like = new JRadioButton();
	public JRadioButton Moments = new JRadioButton();
	public JRadioButton Abonnements = new JRadioButton();
	public JRadioButton Media = new JRadioButton();
	public JRadioButton Reponse = new JRadioButton();
	public JRadioButton Retweets = new JRadioButton();
	public JRadioButton localisation = new JRadioButton();
	public JRadioButton date = new JRadioButton();
	public JRadioButton Selectall = new JRadioButton();
	public int nbselect = 0;
	public boolean selectionner = false;
	public JLabel jLabel5 = new JLabel();
	
	public void incrementerSelection() {
		if (this.nbselect + 1 > 12) {
			nbselect = 12;
		} else {
			nbselect++;
		}
		jLabel5.setText(nbselect + " Filtres choisis");
		notifyObservers();
	}

	public void decrementerSelection() {
		if (this.nbselect - 1 < 0) {
			nbselect = 0;
		} else {
			nbselect--;
		}
		jLabel5.setText(nbselect + " Filtres choisis");
		notifyObservers();
	}
	
}

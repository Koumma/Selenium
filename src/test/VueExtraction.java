package test;

import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle;

public class VueExtraction extends JPanel implements Observer {

	private JTextField TempsMax = new JTextField();
	private JToggleButton BoutonExtraire = new JToggleButton();
	private JComboBox Pronfondeur = new JComboBox();
	private JLabel PronfondeurText = new JLabel();
	private JLabel TempsMaxText = new JLabel();
	private JLabel duCompteText = new JLabel();
	private JLabel Temps = new JLabel();

	public VueExtraction() {
		this.initialiserComposants();

	}

	public void initialiserComposants() {
		
		GroupLayout layout = new GroupLayout(this);
		JTextField jTextField1 = new JTextField();
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(26, 26, 26).addComponent(duCompteText)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
						.addGap(103, 103, 103).addComponent(Temps)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(TempsMaxText, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
						.addComponent(PronfondeurText).addGap(18, 18, 18)
						.addComponent(Pronfondeur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(170, 170, 170))
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(176, 176, 176).addComponent(
										BoutonExtraire, GroupLayout.PREFERRED_SIZE, 471, GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addGap(376, 376, 376).addComponent(Temps)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(29, 29, 29)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(TempsMaxText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(Pronfondeur, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(PronfondeurText).addComponent(duCompteText).addComponent(Temps))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
						.addComponent(Temps).addGap(29, 29, 29)
						.addComponent(BoutonExtraire, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
						.addGap(99, 99, 99)));

		this.getPronfondeur().setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));

		this.getBoutonExtraire().setText("Extraire");

		this.getTempsMaxText().setText("2H10");

		this.getPronfondeurText().setText("Pronfondeur");

		this.getTemps().setText("Temps Max :");

		this.getDuCompteText().setText("@duCompte");

		this.getTemps().setText("Temps XXHXX");
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	public JTextField getTempsMax() {
		return TempsMax;
	}

	public void setTempsMax(JTextField tempsMax) {
		TempsMax = tempsMax;
	}

	public JComboBox getPronfondeur() {
		return Pronfondeur;
	}

	public void setPronfondeur(JComboBox pronfondeur) {
		Pronfondeur = pronfondeur;
	}

	public JToggleButton getBoutonExtraire() {
		return BoutonExtraire;
	}

	public void setBoutonExtraire(JToggleButton boutonExtraire) {
		BoutonExtraire = boutonExtraire;
	}

	public JLabel getPronfondeurText() {
		return PronfondeurText;
	}

	public void setPronfondeurText(JLabel pronfondeurText) {
		PronfondeurText = pronfondeurText;
	}

	public JLabel getTempsMaxText() {
		return TempsMaxText;
	}

	public void setTempsMaxText(JLabel tempsMaxText) {
		TempsMaxText = tempsMaxText;
	}

	public JLabel getDuCompteText() {
		return duCompteText;
	}

	public void setDuCompteText(JLabel duCompteText) {
		this.duCompteText = duCompteText;
	}

	public JLabel getTemps() {
		return Temps;
	}

	public void setTemps(JLabel temps) {
		Temps = temps;
	}

}

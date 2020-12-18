package test;

import javax.swing.*;


import java.awt.Dimension;


@SuppressWarnings("serial")
public class Ihm2 extends JFrame {
	private JTabbedPane jTabbedPane1;

	public Ihm2() {
		this.initComponents();

	}

	private void initComponents() {

		jTabbedPane1 = new JTabbedPane();

		jTabbedPane1.addTab("Extraction", new VueExtraction());
		jTabbedPane1.addTab("Recherche", new VueRecherche());
		jTabbedPane1.addTab("Filtres", new VueFiltres());
		this.resize(new Dimension(900,600));
		this.add(jTabbedPane1);
	}

	public static void main(String args[]) {

		new Ihm2().setVisible(true);

	}

}

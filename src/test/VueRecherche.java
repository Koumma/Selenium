package test;

import java.util.Observable;
import java.util.Observer;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class VueRecherche extends JPanel implements Observer {
	private JTextField recherche = new  JTextField();
	private JToggleButton rechercher = new JToggleButton();
	private JTable table = new JTable();
	private JScrollPane jsp = new JScrollPane();
	
	public VueRecherche() {
		this.initialiserComposants();

	}

	public void initialiserComposants() {

		recherche.setText("recherche");

		rechercher.setText("Recherche");
		table.setModel(
				new javax.swing.table.DefaultTableModel(
						new Object[][] { },
						new String[] { "Tweet", "Nom du compte", "Nb Reponses", "Nb RT","Nb Like"}));
		
		jsp.setViewportView(table);
		
		recherche.setText("recherche");
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGroup(layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(45, 45, 45).addComponent(jsp,
								GroupLayout.PREFERRED_SIZE, 758, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup().addGap(110, 110, 110)
								.addComponent(recherche, GroupLayout.PREFERRED_SIZE, 473, GroupLayout.PREFERRED_SIZE)
								.addGap(54, 54, 54).addComponent(rechercher)))
						.addContainerGap(66, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(recherche, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(rechercher))
						.addGap(32, 32, 32)
						.addComponent(jsp, GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(65, Short.MAX_VALUE)));
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

}

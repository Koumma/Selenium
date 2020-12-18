package test;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;


@SuppressWarnings("serial")
public class IhmTest extends JFrame {
	boolean  selectionner= false;
	int nbselect = 0;
	
	private JComboBox jComboBox1;
	private JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5;
	private JPanel jPanel1, jPanel2, jPanel3, jPanel4;
	private JRadioButton site, photoProfil, photoBanniere, biographie, like, moments,
	abonnements, media, reponse, retweets, localisation, date, selectAll;
	private JScrollPane jScrollPane1;
	private JTabbedPane jTabbedPane1;
	private JTable jTable1;
	private JTextField jTextField1, jTextField2, jTextField3;
	
	private JButton jToggleButton1, jToggleButton2;

	
	
	public IhmTest() {
		initComponents();
		gestionBouton();
	}
	
	
	/**
	 * Creates new form essai
	 */
	public void incrementerSelection()
	{
		if(this.nbselect +1 > 12)
		{
			nbselect = 12;
		}
		else
		{
			nbselect++;
		}
		jLabel5.setText(nbselect+ " Filtres choisis");
	}
	public   void decrementerSelection()
	{
		if(this.nbselect -1 <0)
		{
			nbselect = 0;
		}
		else
		{
			nbselect--;
		}
		jLabel5.setText(nbselect+ " Filtres choisis");
	}

	private void initComponents() {
		
		jPanel1 = new JPanel();
		jTabbedPane1 = new JTabbedPane();
		jPanel2 = new JPanel();
		jTextField1 = new JTextField();
		jTextField2 = new JTextField();
		jComboBox1 = new JComboBox();
		jToggleButton1 = new JButton();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jPanel3 = new JPanel();
		jScrollPane1 = new JScrollPane();
		jTable1 = new JTable();
		jTextField3 = new JTextField();
		jToggleButton2 = new JButton();
		jPanel4 = new JPanel();
		site = new JRadioButton();
		photoProfil = new JRadioButton();
		photoBanniere = new JRadioButton();
		biographie = new JRadioButton();
		like = new JRadioButton();
		moments = new JRadioButton();
		abonnements = new JRadioButton();
		media = new JRadioButton();
		reponse = new JRadioButton();
		retweets = new JRadioButton();
		localisation = new JRadioButton();
		date = new JRadioButton();
		jLabel5 = new JLabel();
		selectAll = new JRadioButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		

		jTextField2.setText("2H10");
		jTextField2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField2ActionPerformed(evt);
			}
		});

		jComboBox1.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));
		jComboBox1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jComboBox1ActionPerformed(evt);
			}
		});

		jToggleButton1.setText("Extraire");
		jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jToggleButton1ActionPerformed(evt);
			}
		});

		jLabel1.setText("Profondeur");

		jLabel2.setText("Temps Max :");

		jLabel3.setText("@duCompte");
		
		jLabel4.setText("Temps XXHXX");

		GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(26, 26, 26).addComponent(jLabel3)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
						.addGap(103, 103, 103).addComponent(jLabel2)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
						.addComponent(jLabel1).addGap(18, 18, 18)
						.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(170, 170, 170))
				.addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(jPanel2Layout.createSequentialGroup().addGap(176, 176, 176).addComponent(
								jToggleButton1, GroupLayout.PREFERRED_SIZE, 471, GroupLayout.PREFERRED_SIZE))
						.addGroup(jPanel2Layout.createSequentialGroup().addGap(376, 376, 376).addComponent(jLabel4)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(jPanel2Layout.createSequentialGroup().addGap(29, 29, 29)
								.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel1).addComponent(jLabel3).addComponent(jLabel2))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
								.addComponent(jLabel4).addGap(29, 29, 29).addComponent(jToggleButton1,
										GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
								.addGap(99, 99, 99)));

		jTabbedPane1.addTab("Extraction", jPanel2);

		jTable1.setModel(
				new javax.swing.table.DefaultTableModel(
						new Object[][] {},
						new String[] { "Tweet", "Nom du compte", "Nb Reponses", "Nb RT","Nb Like" }));
		jScrollPane1.setViewportView(jTable1);

		jTextField3.setText("recherche");

		jToggleButton2.setText("Recherche");
		
		jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jToggleButton2ActionPerformed(evt);
			}
		});

		GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(jPanel3Layout.createSequentialGroup().addGap(45, 45, 45).addComponent(jScrollPane1,
								GroupLayout.PREFERRED_SIZE, 758, GroupLayout.PREFERRED_SIZE))
						.addGroup(jPanel3Layout.createSequentialGroup().addGap(110, 110, 110)
								.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 473, GroupLayout.PREFERRED_SIZE)
								.addGap(54, 54, 54).addComponent(jToggleButton2)))
						.addContainerGap(66, Short.MAX_VALUE)));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jToggleButton2))
						.addGap(32, 32, 32)
						.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(65, Short.MAX_VALUE)));

		jTabbedPane1.addTab("Recherche", jPanel3);

		site.setText("site");

		photoProfil.setText("photo de profil");
		photoProfil.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton2ActionPerformed(evt);
			}
		});

		photoBanniere.setText("photo de banni�re");
		photoBanniere.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton3ActionPerformed(evt);
			}
		});

		biographie.setText("biographie");
		biographie.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton4ActionPerformed(evt);
			}
		});

		like.setText("Like");

		moments.setText("Moments");

		abonnements.setText("Abonnements");
		abonnements.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton7ActionPerformed(evt);
			}
		});

		media.setText("M�dia");

		reponse.setText("R�ponse");

		retweets.setText("Retweets");

		localisation.setText("localisation");
		localisation.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton11ActionPerformed(evt);
			}
		});

		date.setText("date de naissance");
		date.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton12ActionPerformed(evt);
			}
		});

		jLabel5.setText(nbselect+ " Filtres choisis");

		selectAll.setText("Tout s�l�ctionner");

		GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addGap(174, 174, 174).addGroup(jPanel4Layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
								.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(date).addComponent(localisation)
										.addComponent(site))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
								.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(like).addComponent(media)
										.addComponent(abonnements).addComponent(moments))
								.addGap(253, 253, 253))
						.addGroup(GroupLayout.Alignment.TRAILING,
								jPanel4Layout.createSequentialGroup().addComponent(photoBanniere)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(reponse).addGap(277, 277, 277))
						.addGroup(GroupLayout.Alignment.TRAILING,
								jPanel4Layout.createSequentialGroup()
										.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
												.addComponent(biographie, GroupLayout.Alignment.LEADING)
												.addComponent(photoProfil, GroupLayout.Alignment.LEADING))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(retweets).addGap(273, 273, 273))
						.addGroup(
								jPanel4Layout.createSequentialGroup().addComponent(jLabel5)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(selectAll).addGap(217, 217, 217)))));
		jPanel4Layout
				.setVerticalGroup(
						jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel4Layout.createSequentialGroup().addGap(28, 28, 28)
										.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel5).addComponent(selectAll))
										.addGap(34, 34, 34)
										.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(date).addComponent(abonnements))
										.addGap(18, 18, 18)
										.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(site).addComponent(like))
										.addGap(18, 18, 18)
										.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(photoProfil).addComponent(moments))
										.addGap(18, 18, 18)
										.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(photoBanniere).addComponent(reponse))
										.addGap(18, 18, 18)
										.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(biographie).addComponent(retweets))
										.addGap(18, 18, 18)
										.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(localisation).addComponent(media))
										.addContainerGap(171, Short.MAX_VALUE)));

		jTabbedPane1.addTab("Filtres", jPanel4);

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jTabbedPane1));
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jTabbedPane1));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jPanel1,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jPanel1,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}
	public void gestionBouton() {
		site.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if(site.isSelected())
	        	{
	        		incrementerSelection();
	        	}else
	        	{
	        		decrementerSelection();
	        		}
	        }
	        	
	        });
		photoProfil.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if(photoProfil.isSelected())
	        	{
	        		incrementerSelection();
	        	}else
	        	{
	        		decrementerSelection();
	        	}
	        }
	        	
	        });
		photoBanniere.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if(photoBanniere.isSelected())
	        	{
	        		incrementerSelection();
	        	}else
	        	{
	        		decrementerSelection();
	        	}
	        }
	        	
	        });
		biographie.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if(biographie.isSelected())
	        	{
	        		incrementerSelection();
	        	}else
	        	{
	        		decrementerSelection();
	        	}
	        }
	        	
	        });
		like.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if(like.isSelected())
	        	{
	        		incrementerSelection();
	        	}else
	        	{
	        		nbselect--;
		    		jLabel5.setText(nbselect+ " Filtres choisis");
	        	}
	        }
	        	
	        });
		abonnements.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if(abonnements.isSelected())
	        	{
	        		incrementerSelection();
	        	}else
	        	{
	        		decrementerSelection();
	        	}
	        }
	        	
	        });
		media.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if(media.isSelected())
	        	{
	        		incrementerSelection();
	        	}else
	        	{
	        		decrementerSelection();
	        	}
	        }
	        	
	        });
		reponse.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if(reponse.isSelected())
	        	{
	        		incrementerSelection();
	        	}else
	        	{
	        		decrementerSelection();
	        	}
	        }
	        	
	        });
		
		retweets.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if(retweets.isSelected())
	        	{
	        		incrementerSelection();
	        	}else
	        	{
	        		decrementerSelection();
	        	}
	        }
	        	
	        });
		
		date.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if(date.isSelected())
	        	{
	        		incrementerSelection();
	        	}else
	        	{
	        		decrementerSelection();
	        	}
	        }
	        	
	        });
		
		
		selectAll.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if(!selectionner) {
	        	site.setSelected(true) ;
	    		photoProfil.setSelected(true);
	    		photoBanniere.setSelected(true);
	    		biographie	.setSelected(true);
	    		like.setSelected(true);
	    		moments	.setSelected(true);
	    		abonnements	.setSelected(true);
	    		media.setSelected(true);
	    		reponse	.setSelected(true);
	    		retweets.setSelected(true);
	    		localisation.setSelected(true);
	    		date.setSelected(true);
	    		selectionner = true;
	    		nbselect=12;
	    		jLabel5.setText(nbselect+ " Filtres choisis");
	        	}else {
	        		site.setSelected(false) ;
		    		photoProfil.setSelected(false);
		    		photoBanniere.setSelected(false);
		    		biographie	.setSelected(false);
		    		like.setSelected(false);
		    		moments	.setSelected(false);
		    		abonnements	.setSelected(false);
		    		media.setSelected(false);
		    		reponse	.setSelected(false);
		    		retweets.setSelected(false);
		    		localisation.setSelected(false);
		    		date.setSelected(false);
		    		selectionner = false;
		    		nbselect=0;
		    		jLabel5.setText(nbselect+ " Filtres choisis");
	        	}

	        }
	    });
	
	    
	        	

	
	}// </editor-fold>
	
	
	public String getNomDeCompte() {
		return this.jTextField1.getText();
	}

	private void jToggleButton1ActionPerformed(ActionEvent evt) {
		try {
			Main.executer();
		} catch (SQLException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void jToggleButton2ActionPerformed(ActionEvent evt) {
		try {
			String r=jTextField3.getText();
			Main.rechercher(r);
		} catch (SQLException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void jComboBox1ActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
	}
	

	private void jTextField2ActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jRadioButton12ActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jRadioButton2ActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jRadioButton3ActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
	}

	public void remplirJTable(ArrayList<Tweet> tweets) {
		DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
		Object rowData[]=new Object[5];
	    for (int i = 0; i < tweets.size(); i++) {
	    	rowData[0]=tweets.get(i).contenutextuel;
	    	rowData[1]=tweets.get(i).nomducompte;
	    	rowData[2]=tweets.get(i).nbRep;
	    	rowData[3]=tweets.get(i).nbRT;
	    	rowData[4]=tweets.get(i).nbLike;
	    	model.addRow(rowData);
	    }
	}

		
		
	
	
	private void jRadioButton4ActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jRadioButton11ActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jRadioButton7ActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
	}

	


}

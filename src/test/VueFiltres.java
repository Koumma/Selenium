package test;

import java.util.Observable;
import java.util.Observer;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;


public class VueFiltres extends JPanel implements Observer {

	Filtres f = new Filtres();

	public VueFiltres() {
		initialiserFiltres();
	}

	public void initialiserFiltres() {

		f.site.setText("site");

		f.photoProfil.setText("photo de profil");

		f.photoBanniere.setText("photo de banni�re");

		f.biographie.setText("biographie");

		f.Like.setText("Like");

		f.Moments.setText("Moments");

		f.Abonnements.setText("Abonnements");

		f.Media.setText("M�dia");

		f.Reponse.setText("R�ponse");

		f.Retweets.setText("Retweets");

		f.localisation.setText("localisation");

		f.date.setText("date de naissance");

		f.jLabel5.setText(f.nbselect + " Filtres choisis");

		f.Selectall.setText("Tout séléctionner");
		GroupLayout jPanel4Layout = new GroupLayout(this);
		this.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addGap(277, 277, 277)
						.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
										.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(f.date).addComponent(f.localisation).addComponent(f.site))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 277, Short.MAX_VALUE)
										.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(f.Like).addComponent(f.Media).addComponent(f.Abonnements)
												.addComponent(f.Moments))
										.addGap(277, 277, 277))
								.addGroup(GroupLayout.Alignment.TRAILING,
										jPanel4Layout.createSequentialGroup().addComponent(f.photoBanniere)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(f.Reponse).addGap(277, 277, 277))
								.addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
										.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
												.addComponent(f.biographie, GroupLayout.Alignment.LEADING)
												.addComponent(f.photoProfil, GroupLayout.Alignment.LEADING))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(f.Retweets).addGap(277, 277, 277))
								.addGroup(jPanel4Layout.createSequentialGroup().addComponent(f.jLabel5)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(f.Selectall).addGap(277, 277, 277)))));
		jPanel4Layout
				.setVerticalGroup(
						jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanel4Layout.createSequentialGroup().addGap(18, 18, 18)
										.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(f.jLabel5).addComponent(f.Selectall))
										.addGap(18, 18, 18)
										.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(f.date).addComponent(f.Abonnements))
										.addGap(18, 18, 18)
										.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(f.site).addComponent(f.Like))
										.addGap(18, 18, 18)
										.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(f.photoProfil).addComponent(f.Moments))
										.addGap(18, 18, 18)
										.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(f.photoBanniere).addComponent(f.Reponse))
										.addGap(18, 18, 18)
										.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(f.biographie).addComponent(f.Retweets))
										.addGap(18, 18, 18)
										.addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(f.localisation).addComponent(f.Media))
										.addContainerGap(171, Short.MAX_VALUE)));
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("update");
		f = (Filtres) arg0;
		f.jLabel5.setText(f.nbselect + " Filtres choisis");
		repaint();

	}
}

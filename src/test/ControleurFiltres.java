package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleurFiltres {
	
	Filtres f;
	
	public ControleurFiltres(Filtres e)
	{
		this.f=e;
	}

	public void gestionBouton() {
		f.site.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if(f.site.isSelected())
	        	{
	        		f.incrementerSelection();
	        	}else
	        	{
	        		f.decrementerSelection();
	        		}
	        }
	        	
	        });
		f.photoProfil.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if(f.photoProfil.isSelected())
	        	{
	        		f.incrementerSelection();
	        	}else
	        	{
	        		f.decrementerSelection();
	        	}
	        }
	        	
	        });
		f.photoBanniere.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if(f.photoBanniere.isSelected())
	        	{
	        		f.incrementerSelection();
	        	}else
	        	{
	        		f.decrementerSelection();
	        	}
	        }
	        	
	        });
		f.biographie.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if(f.biographie.isSelected())
	        	{
	        		f.incrementerSelection();
	        	}else
	        	{
	        		f.decrementerSelection();
	        	}
	        }
	        	
	        });
		f.Like.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if(f.Like.isSelected())
	        	{
	        		f.incrementerSelection();
	        	}else
	        	{
	        		f.decrementerSelection();
	        	}
	        }
	        	
	        });
		f.Abonnements.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if(f.Abonnements.isSelected())
	        	{
	        		f.incrementerSelection();
	        	}else
	        	{
	        		f.decrementerSelection();
	        	}
	        }
	        	
	        });
		f.Media.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if(f.Media.isSelected())
	        	{
	        		f.incrementerSelection();
	        	}else
	        	{
	        		f.decrementerSelection();
	        	}
	        }
	        	
	        });
		f.Reponse.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if(f.Reponse.isSelected())
	        	{
	        		f.incrementerSelection();
	        	}else
	        	{
	        		f.decrementerSelection();
	        	}
	        }
	        	
	        });
		
		f.Retweets.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if(f.Retweets.isSelected())
	        	{
	        		f.incrementerSelection();
	        	}else
	        	{
	        		f.decrementerSelection();
	        	}
	        }
	        	
	        });
		
		f.date.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if(f.date.isSelected())
	        	{
	        		f.incrementerSelection();
	        	}else
	        	{
	        		f.decrementerSelection();
	        	}
	        }
	        	
	        });
		
		
		f.Selectall.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if(!f.selectionner) {
	        	f.site.setSelected(true) ;
	    		f.photoProfil.setSelected(true);
	    		f.photoBanniere.setSelected(true);
	    		f.biographie	.setSelected(true);
	    		f.Like.setSelected(true);
	    		f.Moments	.setSelected(true);
	    		f.Abonnements	.setSelected(true);
	    		f.Media.setSelected(true);
	    		f.Reponse	.setSelected(true);
	    		f.Retweets.setSelected(true);
	    		f.localisation.setSelected(true);
	    		f.date.setSelected(true);
	    		f.selectionner = true;
	    		f.nbselect=12;
	    		f.jLabel5.setText(f.nbselect+ " Filtres choisis");
	        	}else {
	        		f.site.setSelected(false) ;
		    		f.photoProfil.setSelected(false);
		    		f.photoBanniere.setSelected(false);
		    		f.biographie	.setSelected(false);
		    		f.Like.setSelected(false);
		    		f.Moments	.setSelected(false);
		    		f.Abonnements	.setSelected(false);
		    		f.Media.setSelected(false);
		    		f.Reponse	.setSelected(false);
		    		f.Retweets.setSelected(false);
		    		f.localisation.setSelected(false);
		    		f.date.setSelected(false);
		    		f.selectionner = false;
		    		f.nbselect=0;
		    		f.jLabel5.setText(f.nbselect+ " Filtres choisis");
	        	}

	        }
	    });
	}
	    
	        	



}

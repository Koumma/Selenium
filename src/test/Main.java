package test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class Main {

	static Connection c;

	static IhmTest ihm;

	public static void main(String[] args) throws SQLException {

		ihm = new IhmTest();
		ihm.setVisible(true);

	}

	public static void executer() throws SQLException, InterruptedException {

		try {
			c = DBConnexion.getConnexion();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Benjamin\\eclipse-workspace\\s3b_s4_digniel_farruggia_nopre_vancoille\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String site = "https://twitter.com/login";
		driver.get(site);

		Properties props = new Properties();

		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\Benjamin\\eclipse-workspace\\s3b_s4_digniel_farruggia_nopre_vancoille\\connexion.ini");
			props.load(fis);
			fis.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		String user = props.getProperty("user");
		String pass = props.getProperty("pass");

		WebElement inputEmail = driver.findElement(By.xpath(Element.INPUTEMAIL.getNomClass()));
		inputEmail.click();
		inputEmail.sendKeys(user);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement inputMDP = driver.findElement(By.xpath(Element.INPUTMDP.getNomClass()));

		inputMDP.click();
		inputMDP.sendKeys(pass);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath(Element.SECONNECTER.getNomClass())).click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		/**
		 * traitement
		 */

		// tweeter(driver);

		accederAuProfil(driver, ihm.getNomDeCompte());
		extraireInfosProfil(driver);
		extraireTweets(driver);
		
		
		accederAuProfil(driver, ihm.getNomDeCompte());
		accederAuxAbonnements(driver);
		extraireInfosAbonnements(driver);
		
		
		accederAuProfil(driver, ihm.getNomDeCompte());
		accederAuxAbonnes(driver);
		extraireInfosAbonnes(driver);
		
		

	}

	private static void extraireInfosProfil(WebDriver driver) throws SQLException {

		System.out.println("/!\\ EXTRACTION DES DONNEES DU PROFIL");
		System.out.println("attente de 10 secondes pour le chargement de la page");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		try {

			String pseudo = driver.findElement(By.cssSelector(Element.PSEUDO.getNomClass())).getText();
			String id = driver.findElement(By.cssSelector(Element.ID.getNomClass())).getText();
			String bio = driver.findElement(By.cssSelector(Element.BIO.getNomClass())).getText();
			String localisation = driver.findElement(By.cssSelector(Element.LOCALISATION.getNomClass())).getText();
			int nbAbonnements = Integer
					.parseInt(driver.findElement(By.cssSelector(Element.NBABONNEMENTS.getNomClass())).getText().replace(".", "").replace(",", "").replace("K", "000").replace("M", "000000"));

			String nbAbonnesString = driver.findElement(By.cssSelector(Element.NBABONNES.getNomClass())).getText().replace(".", "").replace(",", "").replace("K", "000").replace("M", "000000");
			int nbAbonnes = Integer.parseInt(nbAbonnesString);
			

			Date dateNaiss = null;
			Date dateInscription = null;

			/**
			 * try { dateNaiss = new Date(new SimpleDateFormat("MMMM d, yyyy",
			 * Locale.ENGLISH).parse(driver.findElement(By.cssSelector(Element.DATENAISSANCE.getNomClass())).getText().substring(5)).getTime());
			 * dateInscription = new Date(new SimpleDateFormat("MMMM d, yyyy",
			 * Locale.ENGLISH).parse(driver.findElement(By.xpath(Element.DATEINSCRIPTION.getNomClass())).getText().substring(7)).getTime());
			 * } catch (ParseException e) { e.printStackTrace(); }
			 */

			System.out.println("Voici les informations relatives ï¿½ ce compte :");

			System.out.println("	- " + pseudo + " " + id + " " + bio + " " + localisation + " " + nbAbonnements + " " + nbAbonnes);

			/**
			try {
				dateNaiss = new Date(new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(
						driver.findElement(By.cssSelector(Element.DATENAISSANCE.getNomClass())).getText().substring(5))
						.getTime());
				dateInscription = new Date(new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(
						driver.findElement(By.xpath(Element.DATEINSCRIPTION.getNomClass())).getText().substring(7))
						.getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}

			*/
			
			System.out.println("/!\\ SAUVEGARDE DE " + id);

			Profil profil = new Profil(id, pseudo, bio, localisation, dateNaiss, dateInscription, nbAbonnements,
					nbAbonnes);
			profil.save();

		} catch (NoSuchElementException e) {
		}
	}

	private static void extraireTweets(WebDriver driver) throws SQLException, InterruptedException {
		
		System.out.println("/!\\ EXTRACTION DES TWEETS ET RETWEETS");
		System.out.println("attente de 10 secondes pour le chargement de la page");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		ArrayList<Tweet> tweets = new ArrayList<>();
		ArrayList<Retweet> retweets = new ArrayList<>();
		ArrayList<Aime> aimes = new ArrayList<>();
		ArrayList<Media> medias = new ArrayList<>();

		WebElement tweetsConteneur = driver.findElement(By.xpath(Element.TOUSLESTWEETS.getNomClass()));

		List<WebElement> tweetsElement = tweetsConteneur.findElements(By.tagName("li"));

		System.out.println("Voici la liste des tweets et retweets de ce compte :");
		for (WebElement tweet : tweetsElement) {
			if (tweet != null) {
				if (tweet.getAttribute("data-item-id") != null) {
					if (!tweet.getAttribute("data-item-id").equals("null")) {

						int nbReponse = 0;
						int nbRT = 0;
						int nbLike = 0;
						

						String id = tweet.findElement(By.cssSelector("span.username.u-dir.u-textTruncate")).getText()
								.substring(1);
						String contenuTextuel = tweet.findElement(By.cssSelector("div.js-tweet-text-container"))
								.getText();

						String nbReponseString = tweet
								.findElement(By.cssSelector(
										"div.ProfileTweet-action.ProfileTweet-action--reply > button > span > span"))
								.getText();
						if (!nbReponseString.equals("")) {
							nbReponse = Integer.parseInt(nbReponseString);
						}
						String nbRTString = tweet.findElement(By.cssSelector(
								"button.ProfileTweet-actionButtonUndo.js-actionButton.js-actionRetweet > span > span"))
								.getText();
						if (!nbRTString.equals("")) {
							nbRT = Integer.parseInt(nbRTString);
						}
						String nbLikeString = tweet.findElement(By.cssSelector(
								"button.ProfileTweet-actionButtonUndo.ProfileTweet-action--unfavorite.u-linkClean.js-actionButton.js-actionFavorite > span > span"))
								.getText();
						if (!nbLikeString.equals("")) {
							nbLike = Integer.parseInt(nbLikeString);
						}
						
						
						if (tweet.findElement(By.cssSelector("div")).getAttribute("class").contains("retweeted")) {
							System.out.println("	(c'est un retweet)");

							String nomDuCompteQuiARetweeter = tweet.findElement(By.cssSelector("div"))
									.getAttribute("data-retweeter");

							Retweet retweet = new Retweet(nomDuCompteQuiARetweeter, contenuTextuel);
							retweets.add(retweet);

						}
						
						//System.out.println(tweet.findElement(By.cssSelector("div")).getAttribute("class"));
						
						if (tweet.findElement(By.cssSelector("div")).getAttribute("class").contains("favorited")) {
							System.out.println("	(l\'utilisateur a aimé ce tweet)");
							
							String idCompteQuiAAime = driver.findElement(By.cssSelector(Element.ID.getNomClass())).getText();
							
							Aime aime = new Aime(idCompteQuiAAime, contenuTextuel);
							aimes.add(aime);
						}
						
						
						
						if (tweet.findElement(By.cssSelector("div")).getAttribute("class").contains("has-content")) {
							
							System.out.println("	(ce tweet contient un média)");
							
							
							Media media = null;
							
							WebElement mediaContainer = tweet.findElement(By.cssSelector("div > div.content > div.AdaptiveMediaOuterContainer > div > div > div"));
							
							String url = "";
							
							if (mediaContainer.getAttribute("class").contains("AdaptiveMedia-singlePhoto")) {
								url = mediaContainer.findElement(By.cssSelector("img")).getAttribute("src");
								media = new Media(url, contenuTextuel, "photo_seule");
							}
							
							if (mediaContainer.getAttribute("class").contains("AdaptiveMedia-video")) {
								url = mediaContainer.findElement(By.cssSelector("video")).getAttribute("src");
								media = new Media(url, contenuTextuel, "video");
							}
							
							medias.add(media);
							
							
							
							
						}

						System.out.println("	-" + contenuTextuel + " " + id + " " + nbReponse + " " + nbRT + " " + nbLike);

						Tweet nouveauTweet = new Tweet(contenuTextuel, id, nbReponse, nbRT, nbLike);
						tweets.add(nouveauTweet);

					}
				}
			}
		}

		for (Tweet tweet : tweets) {
			String id = tweet.getNomducompte();
			if (Profil.findByNomDuCompte(id).isEmpty()) {
				accederAuProfil(driver, id);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				extraireInfosProfil(driver);
			}
		}

		for (Tweet tweet : tweets) {
			tweet.save();
		}

		for (Retweet retweet : retweets) {
			retweet.save();
		}
		
		for (Aime aime : aimes) {
			aime.save();
		}
		
		for (Media media : medias) {
			media.save();
		}

	}
	
	
	private static void extraireInfosAbonnements(WebDriver driver) {
		
		System.out.println("/!\\ EXTRACTION DES INFOS DES ABONNEMENTS");
		System.out.println("attente de 10 secondes pour le chargement de la page");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String id = driver.findElement(By.cssSelector(Element.ID.getNomClass())).getText();
		
		ArrayList<String> idAExtraire = new ArrayList<String>();
		
		List<WebElement> profils = driver.findElement(By.cssSelector("div.GridTimeline > div.GridTimeline-items.has-items > div")).findElements(By.cssSelector("div.ProfileCard.js-actionable-user"));
		
		for (WebElement profil : profils) {
			
			idAExtraire.add(profil.getAttribute("data-screen-name"));
			
		}
		
		
		for (String idProfil : idAExtraire) {
			if (Profil.findByNomDuCompte(idProfil).isEmpty()) {
				try {
					accederAuProfil(driver, idProfil);
					Thread.sleep(5000);
					extraireInfosProfil(driver);
					
					
				} catch (InterruptedException | SQLException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println("/!\\ SAUVEGARDE DE " + id + " abonne ï¿½ " + idProfil);
			
			Abonnement abonnement = new Abonnement(id, idProfil);
			abonnement.save();
		}
		
		//les images doivent etre visibles a partie de l ihm
	}
	
	
	private static void extraireInfosAbonnes(WebDriver driver) {
		
		System.out.println("/!\\ EXTRACTION DES INFOS DES ABONNES");
		System.out.println("attente de 10 secondes pour le chargement de la page");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String id = driver.findElement(By.cssSelector(Element.ID.getNomClass())).getText();
		
		ArrayList<String> idAExtraire = new ArrayList<String>();
		
		List<WebElement> profils = driver.findElement(By.cssSelector("div.GridTimeline > div.GridTimeline-items.has-items > div")).findElements(By.cssSelector("div.ProfileCard.js-actionable-user"));

		
		for (WebElement profil : profils) {
			idAExtraire.add(profil.getAttribute("data-screen-name"));
		}
		
		
		for (String idProfil : idAExtraire) {
			if (Profil.findByNomDuCompte(idProfil).isEmpty()) {
				try {
					accederAuProfil(driver, idProfil);
					Thread.sleep(5000);
					extraireInfosProfil(driver);
					
					
				} catch (InterruptedException | SQLException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println("/!\\ SAUVEGARDE DE " + idProfil + " abonne à " + id);
			
			Abonnement abonnement = new Abonnement(idProfil, id);
			abonnement.save();
		}
		
		//les images doivent etre visibles a partie de l ihm
	}
	
	 
	
	

	private static void accederAuProfil(WebDriver driver, String idProfil) throws InterruptedException {
		
		System.out.println("ACCES AU PROFIL " + idProfil);
		System.out.println("attente de 5 secondes pour le chargement de la page");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement barreDeRecherche = driver.findElement(By.xpath("//*[@id=\"search-query\"]"));
		barreDeRecherche.click();
		Thread.sleep(2000);
		barreDeRecherche.sendKeys(idProfil);
		WebElement profil = driver.findElement(By.cssSelector("span.typeahead-user-item-info.account-group"));
		profil.click();

	}
	
	
	
	private static void accederAuxAbonnements(WebDriver driver) throws InterruptedException {
		
		System.out.println("ACCES AUX ABONNEMENTS DU PROFIL " + ihm.getNomDeCompte());
		System.out.println("attente de 5 secondes pour le chargement de la page");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.cssSelector("li.ProfileNav-item.ProfileNav-item--following > a")).click();
		Thread.sleep(2000);
	}
	
	private static void accederAuxAbonnes(WebDriver driver) throws InterruptedException {
		
		System.out.println("ACCES AUX ABONNES DU PROFIL " + ihm.getNomDeCompte());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.cssSelector("li.ProfileNav-item.ProfileNav-item--followers > a")).click();
		Thread.sleep(2000);
	}
	
	

	/**
	 * permet de tweeter
	 * 
	 * @param 
	 */
	private static void tweeter(WebDriver driver) {
		WebElement tweetBox = driver.findElement(By.xpath("tweet-box-home-timeline"));
		tweetBox.click();
		tweetBox.sendKeys("Ceci est un message automatisÃ© dans le cadre de notre projet tutorÃ© sur Twitter");
		driver.findElement(By.xpath(Element.TWEETBUTTON.getNomClass())).click();
	}

	public static void rechercher(String r) throws SQLException, InterruptedException {

		if (r == null || r == "") {
			System.out.println(Profil.findAll());
		} else {
			
			System.out.println(Tweet.findByNomDuCompte(r));
			ihm.remplirJTable(Tweet.findByNomDuCompte(r));
		}
	}

}

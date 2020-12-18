package test;

public enum Element {

	INPUTEMAIL("//*[@id=\"page-container\"]/div/div[1]/form/fieldset/div[1]/input"),
	INPUTMDP("//*[@id=\"page-container\"]/div/div[1]/form/fieldset/div[2]/input"),
	SECONNECTER("//*[@id=\"page-container\"]/div/div[1]/form/div[2]/button"),
	SEDECO("//*[@id=\"signout-button\"]/button"),
	TWEETBOX("//*[@id=\"tweet-box-home-timeline\"]"),
	PROFIL("//*[@id=\"page-container\"]/div[1]/div[1]/div/div[1]/span/a/span/b"),
	TWEETBUTTON("//*[@id=\"timeline\"]/div[2]/div/form/div[3]/div[2]/button/span[1]"),
	ID ("div.ProfileHeaderCard > h2 > a > span > b"),
	BIO("div.ProfileHeaderCard > p"),
	LOCALISATION("span.ProfileHeaderCard-locationText.u-dir"),
	DATEINSCRIPTION("span.ProfileHeaderCard-joinDateText.js-tooltip.u-dir"),
	DATENAISSANCE("span.ProfileHeaderCard-birthdateText.u-dir > span"),
	PHOTOPROFIL("//*[@id=\"page-container\"]/div[3]/div/div[1]/div[4]/div[1]/div[1]/a[2]/img"),
	PSEUDO ("div.ProfileHeaderCard > h1 > a"),
	TOUSLESTWEETS("//*[@id=\"stream-items-id\"]"),
	NBABONNEMENTS("li.ProfileNav-item.ProfileNav-item--following > a > span.ProfileNav-value"),
	NBABONNES("li.ProfileNav-item.ProfileNav-item--followers > a > span.ProfileNav-value");
	
	private String nomClass;
	
	private Element(String nomClass) {
		this.nomClass = nomClass;
	}
	
	public String getNomClass() {
		return nomClass;
	}
	
}

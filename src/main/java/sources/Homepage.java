package sources;

public interface Homepage {
	//Menu
	public String navigationmenu = "//*[@id='d-navigationTop']";
	//Logo
	public String logo = "//*[@alt='WebMath - Solve your math problem today']";
	//Homebutton
	public String homebutton = "//*[@title='WebMath Home Page']";
	public String homeurl = "https://www.webmath.com/index.html";
	//Contact us
	public String contactuslink = "//*[@title='Contact WebMath']";
	public String contactusttl = "Contact Information - WebMath";
	public String contactinfo = "//*[text()='webmathadmin@gmail.com']";
	//About Webmath
	public String aboutus = "//*[@title='About WebMath']";
	public String aboutusttl = "What is WebMath? - WebMath";
	public String aboutusinfo = "(//*[@class='d-mainContainerRow'])[3]";
	//Why Webmath
	public String why = "//*[@title='Why WebMath']";
	public String whyttl = "Why Webmath? - WebMath";
	public String whywebmath = "//*[@id='d-childMainContLeft']";
	//Sitemap
	public String sitemaplink = "//*[@title='Website Map Index']";
	public String sitemapttl = "Site Map - WebMath";
	public String sitemapinfo = "//*[@id='d-childMainContLeft']";
	//PP
	public String pplink ="//*[@title='Privacy Policy']";
	public String ppttl = "Privacy Policy | Discovery Education";
	public String ppinfo = "//*[@class='horizontal-cta-button comet-button comet-button--primary comet-button--small btn shadow-100']";
	
	

}

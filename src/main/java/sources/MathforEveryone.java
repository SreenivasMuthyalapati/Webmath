package sources;

public interface MathforEveryone {
	// Page
	public String link = "//*[@title='Math for Everyone']";
	public String ttl = "Math for Everyone - WebMath";
	public int linkcount = 36;
	// Links under Everyday Math
	public String tip = "//a[text()='Figuring a tip']";
	public String saleprice = "//a[text()='Sale price']";
	public String windchill = "//a[text()='Wind Chill']";
	public String coincount = "//a[text()='Count Coins']";
	public String lottods = "//a[text()='Lottery Odds']";
	// Units Conversion
	public String Length = "//a[text()='Length']";
	public String mass = "//a[text()='mass']";
	public String area = "//a[text()='area']";
	public String volume = "//a[text()='volume']";
	public String speed = "//a[text()='speed']";
	public String power = "//a[text()='power']";
	public String temp = "//a[text()='Temps.']";
	//$$ Personal Finance $$
	public String sampleinterest = "//a[text()='Simple Interest']";
	public String compoundinterest = "//a[text()='Compound Interest']";
	public String retirement = "//a[text()='Retirement']";
	public String loan = "//a[text()='A loan']";
	//Math @ Home
	public String costofelectricity = "//a[text()='Cost of electricity']";
	//Math & Beyond
	public String weightonplanet = "//a[text()='Weight on Another Planet?']";
	//Instructions
	public String instructionlink = "//a[@title='Help typing in your problem']";
	public String instructionsttl = "Typing Math Problems into this Site - WebMath";
	public String instructionslist = "//*[@id='d-childMainContLeft']";

}

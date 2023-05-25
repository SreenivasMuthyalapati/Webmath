package com.PageObjectClasses;

import org.openqa.selenium.By;

public class HomePage {

	//Menu
	public static By navigationmenu = By.xpath("//*[@id='d-navigationTop']");
	
	//Logo
	public static By logo = By.xpath("//*[@alt='WebMath - Solve your math problem today']");
	
	//HomePage
	public static By homebutton = By.xpath("//*[@title='WebMath Home Page']");
	
	//Contact Us
	public static By contactuslink = By.xpath("//*[@title='Contact WebMath']");
	public static By contactinfo = By.xpath("//*[text()='webmathadmin@gmail.com']");
	
	//About Us
	public static By aboutus = By.xpath("//*[@title='About WebMath']");
	public static By aboutusinfo = By.xpath("(//*[@class='d-mainContainerRow'])[3]");
	
	//Why WebMath
	public static By why = By.xpath("//*[@title='Why WebMath']");
	public static By whywebmath = By.xpath("//*[@id='d-childMainContLeft']");
	
	//Site map
	public static By sitemaplink = By.xpath("//*[@title='Website Map Index']");
	public static By sitemapinfo = By.xpath("//*[@id='d-childMainContLeft']");
	
	//Privacy Policy
	public static By pplink = By.xpath("//*[@title='Privacy Policy']");
	public static By ppinfo = By.xpath("//*[@class='horizontal-cta-button comet-button comet-button--primary comet-button--small btn shadow-100']");
	
}

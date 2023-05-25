package com.PageObjectClasses;

import org.openqa.selenium.By;

public class MathfrEvryone {

	// Math for everyone link
	public static By link = By.xpath("//*[@title='Math for Everyone']");

	// Links under everyday math
	public static By tip = By.xpath("//a[text()='Figuring a tip']");
	public static By saleprice = By.xpath("//a[text()='Sale price']");
	public static By windchill = By.xpath("//a[text()='Wind Chill']");
	public static By coincount = By.xpath("//a[text()='Count Coins']");
	public static By lottods = By.xpath("//a[text()='Lottery Odds']");

	// Links under Unit Convertions
	public static By Length = By.xpath("//a[text()='Length']");
	public static By mass = By.xpath("//a[text()='mass']");
	public static By area = By.xpath("//a[text()='area']");
	public static By volume = By.xpath("//a[text()='volume']");
	public static By speed = By.xpath("//a[text()='speed']");
	public static By power = By.xpath("//a[text()='power']");
	public static By temp = By.xpath("//a[text()='Temps.']");

	// Links under $$ Personal Finance $$
	public static By sampleinterest = By.xpath("//a[text()='Simple Interest']");
	public static By compoundinterest = By.xpath("//a[text()='Compound Interest']");
	public static By retirement = By.xpath("//a[text()='Retirement']");
	public static By loan = By.xpath("//a[text()='A loan']");

	// Links under Math @ Home
	public static By costofelectricity = By.xpath("//a[text()='Cost of electricity']");

	// Links under Math & Beyond
	public static By weightonplanet = By.xpath("//a[text()='Weight on Another Planet?']");

	// Instructions to write problem
	public static By instructionlink = By.xpath("//a[@title='Help typing in your problem']");
	public static By instructionslist = By.xpath("//*[@id='d-childMainContLeft']");

}

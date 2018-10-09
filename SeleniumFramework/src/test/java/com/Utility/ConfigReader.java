package com.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	Properties prop = new Properties();
	
	public ConfigReader() {
		try {
			File src = new File("./src/test/java/ConfigFiles/OR.property");
			FileInputStream fis = new FileInputStream(src);
			prop.load(fis);
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
	public String HotelSearchTextBox(){
			return prop.getProperty("HotelNameTextBox");
		
		}
	
	public String HotelNameEnterValue(){
		return prop.getProperty("HotelNameInput");
	
	}

	public String HotelNameSelectValue(){
		return prop.getProperty("HotelNameSelectValue");
	
	}

	public String HotelChkInDate(){
		return prop.getProperty("HotelChkInDt");
	
	}
	
	
	public String HotelChkOutDate(){
		return prop.getProperty("HotelChkOutDt");
	
	}
	
	public String HotelGuestField(){
		return prop.getProperty("HotelTravellers");
	
	}
	
	public String HotelAdultGuest(){
		return prop.getProperty("HotelAdultGuest");
	}
	
	public String HotelChildGuest() {
		return prop.getProperty("HotelChildGuest");
	}
	
	public String HotelSearchBtn() {
		return prop.getProperty("HotelSearchBtn");
	}
	
	public String HotelNameLabel() {
		return prop.getProperty("HotelNameTxt");
	}
	
	//-----------------Flights Screen ----------------
	
	public String FlightLink(){
		return prop.getProperty("FlightsLink");
	
	}
	
	
	public String FlightRoundTripRdBtn(){
		return prop.getProperty("FlightRoundTripRdBtn");
	
	}
	
	public String FlightFrom(){
		return prop.getProperty("FlightFrom");
	
	}
	
	public String FlightFromInput(){
		return prop.getProperty("FlightFromInput");
	}
	
	public String FlightFromResult() {
		return prop.getProperty("FlightFromResult");
	}
	
	public String FlightTo() {
		return prop.getProperty("FlightTo");
	}
	
	public String FlightToInput() {
		return prop.getProperty("FlightToInput");
	}
	

	public String FlightToResult() {
		return prop.getProperty("FlightToResult");
	}
	
	public String FlightDepDate() {
		return prop.getProperty("FlightDepDt");
	}
	
	public String FlightArrivalDt() {
		return prop.getProperty("FlightArrDt");
	}
	
	public String FlightTravellers() {
		return prop.getProperty("FlightTravellers");
	}
	
	public String FlightSearchBtn() {
		return prop.getProperty("FlightSearchBtn");
	}
	
	public String FlightAvailableLabel() {
		return prop.getProperty("FlightAvailableLabel");
	}
	
	public String FlightBookBtn() {
		return prop.getProperty("FlightBookBtn");
	}
	
	public String FlightCost() {
		return prop.getProperty("FlightBookingAmnt");
	}
	
	public String FlightBookingCost() {
		return prop.getProperty("FlightBookingPageAmount");
	}
	
	//--------------Personal Details---------------------
	
	public String FirstName() {
		return prop.getProperty("FirstName");
	}
	
	public String LastName() {
		return prop.getProperty("LastName");
	}
	
	public String Email() {
		return prop.getProperty("Email");
	}
	
	public String ConfirmEmail() {
		return prop.getProperty("ConfirmEmail");
	}
	
	public String Mobile() {
		return prop.getProperty("Mobile");
	}
	
	public String Address() {
		return prop.getProperty("Address");
	}
	
	public String Country() {
		return prop.getProperty("Country");
	}
	
	public String CountryInput() {
		return prop.getProperty("CountryInput");
	}
	
	public String CountrySearchResult() {
		return prop.getProperty("CountrySearchResult");
	}
	
	public String BookingConfBtn() {
		return prop.getProperty("BookingConfirmationBtn");
	}
	
	//--------------Payment Details Page----------------------
	
	public String PayNowBtn() {
		return prop.getProperty("PayNowBtn");
	}
}



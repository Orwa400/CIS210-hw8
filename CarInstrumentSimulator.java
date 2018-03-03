package hw8_perry_leah;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CarInstrumentSimulator {
	/*PROGRAM: CarInstrumentSimulator / Assignment 8 
	 * AUTHOR: Leah Perry
	 * Due Date: November 5, 2015
	 * SUMMARY: Uses Odometer and FuelGauge classes to simulate a car
	 */
	public static void main(String[]args) throws IOException, FileNotFoundException{
		Scanner keyboard = new Scanner(System.in);
		
		
		Odometer odo = new Odometer();//odometer to use
		FuelGauge fuel = new FuelGauge();//gas tank to use
		
		fuel.SetFuel(keyboard);//fill the tank as desired

		SimulateOdometer(odo, fuel);//simulates odometer
	
	}//end main
	 
	public static void SimulateOdometer(Odometer meter, FuelGauge gas){
		/* FUNCTION: SimulateOdometer
		 * PURPOSE: Uses gas as car moves
		 * @Parameter	GetMileage		returns current mileage
		 * 				GetFuel			returns fuel remaining
		 * 				gas				fuel gauge to use
		 * 				meter			odometer to use
		 */
		
		while (gas.GetFuel() > 0) {//while there is fuel
			meter.Run(gas);//run the car
			
			System.out.println("The current mileage is " + meter.GetMileage());//prints mileage
			System.out.println("The amount of fuel left in tank is " + gas.GetFuel()//prints remaining fuel
				+ "\n*******************************************************");
			
		}//end while
		System.out.println("Out of gas. Goodbye.");
	}//end SimulateOdometer

}//end CarInstrumentSimulator

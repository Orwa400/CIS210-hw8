package hw8_perry_leah;

import java.util.Scanner;

public class FuelGauge {
	
	private int fuel;//number of gallons
	private boolean full;//is tank full
	private boolean empty;//is tank empty
	final private int maxFuel;//tank limit
	final private int minFuel;//minimum gallons of gas
	
	public FuelGauge() {
		maxFuel = 15;
		minFuel = 0;
		fuel = minFuel;
		full = false;
		empty = true;
	}//end FuelGauge constructor
	
	public FuelGauge(int inputFuel, int inputMax, int inputMin) {
		maxFuel = inputMax;
		minFuel = inputMin;
		if (inputFuel <= maxFuel && inputFuel >= minFuel){//if input fuel is within range
			fuel = inputFuel;//set fuel
		}//end if
		else {
			fuel = minFuel;//else default to min fuel
		}//end else
		
		if (fuel == maxFuel) {
			full = true;//if fuel is max, tank is full
		}//end if
		else {
			full = false;//otherwise it is not full
		}//end else
		
		if (fuel == minFuel) {
			empty = true;//if fuel is min, tank is empty
		}//end if
		else {
			empty = false;//otherwise it is not empty
		}//end else
	}//end FuelGauge custom constructor

	public int GetFuel() {
		return fuel;
	}//end GetFuel
	
	public int GetMinFuel() {
		return minFuel;
	}//end GetFuel
	
	public int GetMaxFuel() {
		return maxFuel;
	}//end GetFuel
	
	public boolean IsFull(){
		return full;//true if full, false if not
	}//end IsFull
	
	public boolean IsEmpty() {
		return empty;//true is empty, false if not
	}//end IsEmpty

	public void SetFuel(Scanner input) {
		/* FUNCTION: SetFuel
		 * PURPOSE: Used to Initialize and change fuel
		 * @Parameter	inputFuel		User inputted fuel value
		 * 				fuel			final fuel value inputted
		 * 				minFuel			minimum allowed
		 * 				maxFuel			maximum allowed
		 *				full			is tank full? boolean
		 *				empty			is tank empty? boolean
		 */
		int inputFuel = minFuel - 1;//inputted fuel, default as min - 1 so do-while works and loops if there are errors
		do {
			System.out.println("Please enter the amount of fuel. Must be greater than or equal to " + GetMinFuel() +
					" and less than or equal to " + GetMaxFuel() + " You may enter 'fill' to fill the tank.");
			if (input.hasNextInt()){//if input is an int
				inputFuel = input.nextInt();//scans in fuel	
				fuel = inputFuel;//sets input as fuel
			}//end if
			else if (input.next().equals("fill")){//if input is 'fill'
				inputFuel = GetMaxFuel();//sets input as max to escape while
				FillTank();//fills tank
				break;
			}//end else if
		} while (inputFuel < minFuel || inputFuel > maxFuel); //while input is not in range//end while
		
		if (fuel > minFuel) {//if not empty, then not empty
			empty = false;
			if (fuel == maxFuel) {//if full then full 
				full = true;
			}//end if
		}//end if
		else {
			empty = true;//if empty, tank is empty and not full
			full = false;
		}//end else
	}//end SetFuel
	
	public void SetFuel(int inputFuel) {//no scanner allows for change from within the class
		fuel = inputFuel;//sets input as fuel	
		if (fuel > minFuel) {//if not empty, then not empty
			empty = false;
			if (fuel == maxFuel) {//if full then full 
				full = true;
			}//end if
		}
		else {
			empty = true;//if empty, tank is empty and not full
			full = false;
		}//end else
	}//end SetFuel

	public void AddGas() {
	/* FUNCTION: AddGas
	 * PURPOSE: Adds a gallon of gas to tank
	 * @Parameter	fuel		number of gallons in tank
	 * 				empty		boolean-is tank empty
	 * 				full		boolean-is tank full
	 */
		if (GetFuel() < maxFuel){
			SetFuel(fuel + 1);//increase fuel by one
			empty = false;//tank is no longer empty if it was before
		}//end if
		else {
			full = true;//tank is full
		}//end else
	}//end AddGas
	
	public void FillTank(){
		while (!IsFull()){//until tank is full
			AddGas();//add gas
		}//end while
	}//end FillTank

	public void UseGas() {
	/* FUNCTION: UseGas
	 * PURPOSE: Removes a gallon of gas to tank
	 * @Parameter	fuel		number of gallons in tank
	 * 				empty		boolean-is tank empty
	 * 				full		boolean-is tank full
	 */
		if (GetFuel() > minFuel) {//if the tank isn't already empty...
			SetFuel(fuel- 1);//a gallon is used
			full = false;//tank is no longer full, if it was before
		}//end if
		else {
			empty = true;//tank is empty
		}//end else
	}//end UseGas

}//end class

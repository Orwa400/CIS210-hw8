package hw8_perry_leah;

public class Odometer {
	
	private int mileage;//current mileage	
	private int fuelEconomy;//fuel economy of the car
	final private int maxMileage = 999999;//maximum allowed mileage
	
	public Odometer(){//default constructor
		mileage = 0;//sets mileage to 0
		fuelEconomy = 24;//sets fiel economy to 24
	}//end Odometer constructor
	
	public Odometer(int inputMileage, int inputFuelEconomy) {//custom constructor
		if (inputMileage >= 0 && inputMileage <= maxMileage){//if input is in range
			mileage = inputMileage;//set mileage
		}//end if
		if (inputFuelEconomy > 0) {//fuel economy cannot be 0 or negative
			fuelEconomy = inputFuelEconomy;
		}//end if
	}//end Odometer constructor
	
	public int GetMileage(){
		return mileage;
	}//end GetMileage
	
	public void SetMileage(int inputMileage) {
		if (inputMileage >= 0 && inputMileage <= maxMileage) {
			mileage = inputMileage;//scans in mileage if in range
		}//end if
		else {
			System.out.println("Invalid input. Mileage must be 0 or higher, but no higher than " + maxMileage);
		}//end else		
	}//end SetFuel
	
	public void Run(FuelGauge gas){
		/* FUNCTION: Run
		 * PURPOSE: Increases mileage and uses gas
		 * @Parameter	mileage			current mileage
		 * 				fuelEconomy		how many miles a gallon is used	
		 * 				gas				fuel gauge to use
		 */
		if (mileage < maxMileage){//as long as we don't hit the max
			SetMileage(mileage + 1);//mileage increases
			if (mileage % fuelEconomy == 0 && !gas.IsEmpty()) {//uses a gallon of gas every fuelEconomy miles
				gas.UseGas();
			}//end if
		}//end if
		else {
			mileage = maxMileage % fuelEconomy;
			/*resets mileage as the remainder so the division still works
			*ensures that leftover mileage gets counted when using gas 
			*(i.e. a fuelEconomy of 24 would have 15 miles unaccounted for if this was not considered)*/
		}//end else
	}//end Run
	
}//end class

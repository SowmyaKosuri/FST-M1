package activities;

public class Car {
	// Variables
	String color;
	String transmisison;
	int make;
	int tyres = 4;
	int doors = 4;

	public Car(String color, String transmisison, int make) {
		this.color = color;
		this.transmisison = transmisison;
		this.make = make;
	}

	public void displayCharacteristics() {
		System.out.println("Color of the car is: " + this.color);
		System.out.println("Transmisison type is: " + this.transmisison);
		System.out.println("Car is made in the year: " + this.make);
		System.out.println("No. of tyres in the car is: " + this.tyres);
		System.out.println("No. of doors in the car is: " + this.doors);
	}

	public void accelarate() {
		System.out.println("Car moves Forward");
	}

	public void brake() {
		System.out.println("Car stops");
	}

}

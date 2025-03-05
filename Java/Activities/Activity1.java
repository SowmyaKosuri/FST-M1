package activities;

	/* Write a program to return properties of car */

public class Activity1 {

	public static void main(String[] args) {
		Car carObj1 = new Car("Black", "Automatic", 2020);
		Car carObj2 = new Car("Blue", "Manual", 2024);
		
		carObj2.displayCharacteristics();
		carObj2.accelarate();
		carObj1.brake();

	}

}

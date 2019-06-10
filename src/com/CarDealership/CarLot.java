package com.CarDealership;

import java.io.*;
import java.util.*;


public class CarLot {
	
	private static Scanner carlot = new Scanner(System.in);
	
	public static void main (String[] args) throws Exception {
		
		ArrayList<TotalCars> cars = new ArrayList<>();
		TotalCars newCar = new TotalCars("JSH0529", "Mazda", "3", 2014, 50000, 9000);
		cars.add(newCar);
		cars.add(new TotalCars("AMH0847", "Chevrolet", "Impala", 2008, 70000, 6000));
		cars.add(new TotalCars("AFJ0847", "BWM", "4Series", 2015, 60000, 12500));
		cars.add(new TotalCars("AJN9909", "Ford", "Focus", 2009, 90000, 3000));
		
		new FileOutputStream("TotalCars.txt", true).close();
		int choices = 0;
		System.out.println("Welcome. Choose Option 1-5. Press 0 for menu");
		displayMenu();
		
		do {
			choices = carlot.nextInt();
			while (choices < 0 || choices > 4) {
				System.out.println("Please enter valid option");
				choices = carlot.nextInt();				
			}
			doChoices(choices,cars);
			} while (choices != 6);

        FileOutputStream fos = new FileOutputStream("allCars.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (TotalCars car : cars) {
            oos.writeObject(car);
        }
        fos.close(); }
		
		public static void displayCars(ArrayList<TotalCars> cars) {
	        String formatter = "| %-2d | %-6s | %-15s | %-15s | %-5d | %-8d | $%.2f   |%n";
	        System.out.format("+----+--------+-----------------+-----------------+-------+----------+------------+%n");
	        System.out.printf("| #  | VIN    | Make            | Model           | Year  | Mileage  | Price      |%n");
	        System.out.format("+----+--------+-----------------+-----------------+-------+----------+------------+%n");
	        int i = 0;
	        for (TotalCars car : cars) {
	            System.out.format(formatter,++i,car.getVIN(),car.getMake(),car.getModel(),car.getYear(),car.getMileage(),car.getPrice());
	        }
	        System.out.format("+----+--------+-----------------+-----------------+-------+----------+------------+%n");
	    }	
	
	public static void displayMenu() {
		System.out.println("Welcome. Choose Options. Press 0 for menu");
		System.out.println("1. List all cars");
		System.out.println("2. Add a new car to the list");
		System.out.println("3. Remove a car from the list");
		System.out.println("4. Exit");		
}
	public static void doChoices(int choice, ArrayList<TotalCars> cars)	throws Exception {
		String newCar, VIN, make, model;
		int carNumber = 0, year = 0, mileage = 0, price = 0;
		
		switch(choice) {
		case 0: 
			System.out.println("Main Menu: ");
			displayMenu();
			break;
		case 1:
			System.out.println("List all cars");
			displayCars(cars);
			break;
		case 2:
			System.out.println("Add a new car to the list");
			newCars(cars);
			break;
		case 3:
			System.out.println("Remove car from the list");
			removeCar(cars);
			break;
		case 4:
			break;
		default:
			break;
		}
			
	
		
	}
	
	public static void newCars(ArrayList<TotalCars> cars) {
        
        boolean carInput;
        String VIN, make, model;
        int mileage = 0, year = 0, price = 0;
        
        System.out.println("Enter a new car in format:");
        System.out.println("VIN MAKE MODEL YEAR MILEAGE PRICE");
        System.out.println("EX: KRJ0285 Honda Accord 2015 9500 20000");
        do {
            carInput = true;
            VIN = carlot.next();
            make = carlot.next();
            model = carlot.next();
            if(carlot.hasNextInt()) 
                year = carlot.nextInt();
            else carInput = false;
            if(carlot.hasNextInt())
                mileage = carlot.nextInt();
            else carInput = false;
            if(carlot.hasNextInt())
                price = carlot.nextInt();
            else carInput = false;
            if(!carInput)
            {
                System.out.println("\nIncorrect Format.");
            }
        } while(carInput == false);
        cars.add(new TotalCars(VIN,make,model,year,mileage,price));
        
    }
	
	public static void removeCar(ArrayList<TotalCars> cars)
    {
        int carNo;
        
        if(cars.size()>0) {
            System.out.println("Please select the car you want to remove from the list");
            displayCars(cars);
            do {
                System.out.print("Remove car #: ");
                while(!carlot.hasNextInt())
                {
                    System.out.println("Invalid input");
                    carlot.next();
                }
                carNo = carlot.nextInt();

            } while (carNo < 1 || carNo > cars.size());
            cars.remove(carNo-1);
        } else System.out.println("No cars to remove.");
    }


	
}


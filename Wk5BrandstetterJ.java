import java.util.Scanner;

//Johnathan Brandstetter CMIS 242 Intermediate Programming
//06/17/2022 Discussion Week 5 Parent Child class

	public class Wk5BrandstetterJ {

		public static class Vehicle{
			int gears;
			double speed;
			public Vehicle(int gears) {
				this.gears=gears;
				this.speed=0;
			}

			public int getGears() {
				return gears;
			}
			
			public void setGears(int gears) {
				this.gears=gears;
			}
			
			public double getSpeed() {
				return speed;
			}
			
			public void setSpeed(double speed) {
				this.speed=speed;
			}
			
			public void increaseSpeed() {
				speed=speed+10;
			}
			
			public void decreaseSpeed() {
				speed=speed-10;
			}
			
		}
		
		public static class Car extends Vehicle{
			int passengerCapacity;
			public Car(int gears,int passengerCapacity) {
				super(gears);
				this.passengerCapacity=passengerCapacity;
			}
			
			public int getPassengerCapacity() {
				return passengerCapacity;
			}	
				
				//example of overriding.Here we are overriding the increaseSpeed() from the super class
				//and providing a new implementation in the child class
			@Override
			public void increaseSpeed() {
				this.speed = this.speed + 20;
			}
			
				//overloading
			public void increaseSpeed(double i) {
				this.speed = this.speed + i;
				}
			}
		
			public static class Truck extends Vehicle{
				double maximumLoad;
				public Truck(int gears, double maximumLoad) {
					super(gears);
					this.maximumLoad = maximumLoad;
				}
				
				public double getMaximumLoad() {
					return maximumLoad;
				}
					
				@Override
				public void increaseSpeed() {
					this.speed = this.speed + 5;
				}
			}
			
			public static void main(String[] args) {
			// TODO Auto-generated method stub
				Scanner sc = new Scanner(System.in);
				
				System.out.println("Please enter the car speed:");
				int a = sc.nextInt();
				
				System.out.println("Please enter the truck speed:");
				int b = sc.nextInt();

				Car car = new Car(6,4);
				Truck truck = new Truck(4,580.45);
				
				car.setSpeed(a);
				truck.setSpeed(b);
				
				car.increaseSpeed(5); //overriden method.Speed of car will increase by 20
				truck.increaseSpeed(); //overriden method.Speed of truck will increase by 5
				
				System.out.println("Car with passenger capacity of " + car.getPassengerCapacity() + " has the current speed of " + car.getSpeed());
				System.out.println("Truck with maximum load of " + truck.getMaximumLoad() + " has the current speed of " + truck.getSpeed());
				System.out.println("increasing the speed of the car again: ");
				
				car.increaseSpeed(30); //overloading method
				System.out.println("New car speed: " + car.getSpeed());
				System.out.println("New truck speed: " + truck.getSpeed());

				sc.close();
			}  
		}
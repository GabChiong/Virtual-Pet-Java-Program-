/*day
time
Energy

Action 
Sleep
Fetch
Walk
Ball 
bathe 	
cuddle 
*/
import java.util.Scanner;
import java.util.Random;
public class Dog{
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();
	int day = 1;
	int time;
	int energy = 100;
	int food = 1;
	


public void Menu(){
	System.out.println("Day " + day);
	System.out.println("Energy :" + energy);
	System.out.println("1. Sleep");
	System.out.println("2. Fetch");
	System.out.println("3. Walk");
	System.out.println("4. Run");
	System.out.println("5. Play with ball");
	System.out.println("6. Feed");
	int option = sc.nextInt();
	
	
	switch(option){
			case 1:
				Sleep();
				break;
			case 2:
				Activity(40, "playing fetch");
			case 3:
				Activity(30, "walking in the park");
			case 4:
				Activity(50, "running together");
			case 5:
				Activity(30, "playing with ball");
			case 6:
				Activity(0, "Feed");
			default:
				System.out.println("Invalid selection");
				Menu();
		}//end of switch
	
	}//end of Menu	
	
public void Sleep(){
		System.out.println("The dog is sleeping");
		energy += 20 + ran.nextInt(30);//this will randomize the number of energy the dog will receive per sleep
		day++;// the day adds every time 
		food = 1;
		if(energy > 100){
		energy = 100;
	}//end of else if
		Menu();
	}//end of sleep
public void Activity(int damage, String action){
		int heal = 0;
		if(action == "Feed"){
				if(food <= 0){
					System.out.println("You may only feed your dog once per day");
				}//end of if
				else{
					food--;
					System.out.println("You are feeding your dog");
					heal = 5+ ran.nextInt(10);
					energy += heal;
					if(energy > 100){
						energy = 100;
							}//end of if
					System.out.println("You received " + heal + " energy");
				}//end of else
			}//end of if
		else{
		System.out.println("You are " + action + " with your dog");
		int result = 0+ran.nextInt(9);
		
		if(result == 9){
			System.out.println("An Accident has occured while " + action);
			System.out.println("Your dog's energy has been deducted by " + damage);
			energy -= damage;
		}//an accident has occured
		else{
			System.out.println("Your dog is done " + action);
			damage = 10 + ran.nextInt(20);
			System.out.println("Energy has been deducted by " + damage);
			energy -= damage;
		}//
		
		}//end of else
		if(energy <= 0){
		System.out.println("Game over!");
		System.out.println("Your dog has died!");
		System.out.println("You lasted " + day + " days");
		System.exit(0);
	}//
		Menu();
	}//end of activity
}


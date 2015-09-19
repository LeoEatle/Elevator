package main;
import java.util.*;


public class User {
	int direction;
	int Aim_floor;
	int floor;
	
	User( int f){
		this.floor = f;
		
	}
	void InputDirection(){
		System.out.println("Please input 1 for up or 2 for down");
		Scanner input = new Scanner(System.in);
		this.direction = input.nextInt();
		
		
	}
	
	void InputFloor(){
		System.out.println("Please input the number of the floor you go to");
		Scanner input = new Scanner(System.in);
		this.Aim_floor  = input.nextInt();
		
		
	}

}

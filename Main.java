package com.qualityoflifegames;

import com.qualityoflifegames.Google;
import com.qualityoflifegames.Landscape;


/**
 * Main class of the Java program.
 * This code allows you to represent a character to be used in a simple game. We
 * will learn better ways to do this when we have learned how to create objects.
 * 
 */

 public class qualityoflifegamesMain {

    /* variables to describe the character */
	static String name;
	//to do: create a new String variable description
	static int health;
	static int secretWeapon;
	
	/*Other methods*/
   	public static void printInfo(){
	 String result =  
	            "*************************************"+ "\n" +  
	            "Name: " + name + "\n" +
				//to do: include your code for printing the description
				"Secret weapon: " + secretWeapon + "\n" +
				"Health: " + health + "\n" +
				"*************************************";
		System.out.println(result);
	}


	public static void main(String[] args){
	    System.out.println("Setting up the character");
	    //todo: Change the values below to represent different characters
	    name = "John";
	    //to do: assign value to the description variable
	    secretWeapon = 5;
	    health = 10;
	    printInfo();
	}
}


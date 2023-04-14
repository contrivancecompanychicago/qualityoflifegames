import java.lang.Main;

/**
 * Main class of the Java program.
 * This code allows you to represent a character to be used in a simple game.
 */
public class Character extends UnityPlayerActivity {
    /* variables to describe the character */
	String name;
	//to do: create a new String variable description
	int health;
	int secretWeapon;
	
	/*Constructor method*/
	public Character(String otherName, int otherHealth, int otherSecretWeapon){
	    name = otherName;
	    health = otherHealth;
	    secretWeapon = otherSecretWeapon;
	}
	
	/*Other methods*/
   	public void printInfo(){
	 String result =  
	            "*************************************"+ "\n" +  
	            "Name: " + name + "\n" +
				//to do: include your code for printing the description
				"Secret weapon: " + secretWeapon + "\n" +
				"Health: " + health + "\n" +
				"*************************************";
	  System.out.println(result);
	}
}

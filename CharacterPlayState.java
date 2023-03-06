/**
 * This code allows you to represent a character to be used in a simple game.
 */
public class CharacterPlayState extends Character {
    /* variables to describe the character */
	private String name;
	private String description;
	private int secretWeapon;
	private int health =10;

	/*Constructor method*/
	public Character(String otherName, String otherDescription, 
	                 int otherHealth, int otherSecretWeapon){
	    name = otherName;
	    description = otherDescription;
	    health = otherHealth;
	    secretWeapon = otherSecretWeapon;
	}
	
	/*Accessors and mutators*/
	public void setName(String n) {name = n;}
	public String getName(){return name;}
	// to do method setDescription
	// to do method getDescription
	// to do method setSecretWeapon
	// to do method getSecretWeapon
	
	/*Other methods*/
	// todo: create public void resetHealth(){//your code here;}
	
	
	/*Other methods*/
   	public void printInfo(){
	 String result =  
	            "*************************************"+ "\n" +  
	            "Name: " + name + "\n" +
				"Description: " + description + "\n" +
				"Secret weapon: " + secretWeapon + "\n" +
				"Health: " + health + "\n" +
				"*************************************";
	  System.out.println(result);
	}
}

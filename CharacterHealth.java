/**
 * This code allows you to represent a character to be used in a simple game.
 */
public class CharacterHealth extends CharacterPlayState { 
 /* Constant to define the maximum health value */
	public static final int MAX_HEALTH = 10;
	
	/* constants to describe possible values of secret Weapon */
	public static final int CLEVERNESS = 5; // cleverness-5 mainly used by heros 
	public static final int SPELL = 4; // spell-4 mainly used by wizards and witches
	public static final int SWORD = 3; // sword-3 mainly used by warriors
	public static final int TEETH = 2;  // teeth-2 mainly used by vampires
	public static final int CHAINS = 1; // chains-1 mainly used by ghosts
	public static final int UNDEFINED = -1; // default value for weapon
	
    /* variables to describe the character */
	private String name;
	private String description;
	private int secretWeapon;
	private int health = MAX_HEALTH;
	
	/*Constructor method*/
	public Character(String otherName, String otherDescription, 
	                 int otherHealth, int otherSecretWeapon){
	    name = otherName;
	    description = otherDescription;
	    health = otherHealth;
	    setSecretWeapon(otherSecretWeapon);
	}
	
	
	/*Accessors and mutators*/
	public void setName(String n) {name = n;}
	public String getName(){return name;}
	public void setDescription(String d){description = d;}
	public String getDescription(){return description;}
	//to do: observe how to restrict the allowed values for secretWeapon
	public void setSecretWeapon(int sw){
	    if(sw == CLEVERNESS || sw == SPELL || sw == SWORD ||
	       sw == TEETH || sw == CHAINS){
	       secretWeapon = sw;
	    }else{
	       secretWeapon = UNDEFINED;
	    }
	}
	public int getSecretWeapon(){return secretWeapon;}
	
	/*Other methods*/
	//to do: Change 10 by MAX_HEALTH
	public void resetHealth(){
	    health = 10;
	}
	
	
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

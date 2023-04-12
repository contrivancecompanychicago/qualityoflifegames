import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A generic superclass for all Actors that will use a Controller.
 * 
 * @author Joseph Lenton
 */
public abstract class ControllerActor  extends Actor
{
    private final GamePad controller;
    
    /**
     * Creates the actor storing the given game pad.
     * @param controller The gamepad to store.
     */
    public ControllerActor(GamePad controller)
    {
        this.controller = controller;
    }
    
    /**
     * @return The GamePad that is stored inside of this Actor.
     */
    public GamePad getGamePad()
    {
        return controller;
    }
}

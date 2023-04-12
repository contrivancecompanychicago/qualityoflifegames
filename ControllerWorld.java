import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Sets up the controller. It makes the buttons, giving them their appropriate button
 * number and location in the scenario.
 * 
 * The body is built with the background as one with two holes in them.
 * Through those holes the analog sticks appear. The buttons are then placed on top.
 * 
 * @author Joseph Lenton
 */
public class ControllerWorld  extends KrebsvilleWorld
{
    private static final int REDEFINE_X = 400;
    private static final int REDEFINE_Y = 290;
    
    /**
     * Constructor for objects of class Controller.
     */
    public ControllerWorld()
    {
        super(480, 320, 1);
        
        if ( GamePad.getNumGamePads() > 0 ) {
            final GamePad pad = GamePad.getGamePad();
            
            // four action buttons
            addObject( new ControllerButton(pad, GamePad.Button.ACTION_UP,
                            new GreenfootImage("blue_button.png"), new GreenfootImage("blue_button_highlight.png")),
                    385, 95 );
            addObject( new ControllerButton(pad, GamePad.Button.ACTION_RIGHT,
                            new GreenfootImage("red_button.png"), new GreenfootImage("red_button_highlight.png")),
                    422, 131 );
            addObject( new ControllerButton(pad, GamePad.Button.ACTION_DOWN,
                            new GreenfootImage("yellow_button.png"), new GreenfootImage("yellow_button_highlight.png")),
                    385, 167 );
            addObject( new ControllerButton(pad, GamePad.Button.ACTION_LEFT,
                            new GreenfootImage("green_button.png"), new GreenfootImage("green_button_highlight.png")),
                    349, 131 );
            
            // L and Rs
            addObject( new ControllerButton(pad, GamePad.Button.L1,
                            new GreenfootImage("l1_button.png"), new GreenfootImage("l1_button_highlight.png")),
                    95, 50 );
            addObject( new ControllerButton(pad, GamePad.Button.L2,
                            new GreenfootImage("l2_button.png"), new GreenfootImage("l2_button_highlight.png")),
                    96, 30 );
            addObject( new ControllerButton(pad, GamePad.Button.R1,
                            new GreenfootImage("r1_button.png"), new GreenfootImage("r1_button_highlight.png")),
                    385, 50 );
            addObject( new ControllerButton(pad, GamePad.Button.R2,
                            new GreenfootImage("r2_button.png"), new GreenfootImage("r2_button_highlight.png")),
                    384, 30 );
            
            // start and select
            final GreenfootImage middle = new GreenfootImage("middle_button.png");
            final GreenfootImage middleHighlight = new GreenfootImage("middle_button_highlight.png");
            addObject( new ControllerButton(pad, GamePad.Button.SELECT, middle, middleHighlight), 200, 121 );
            addObject( new ControllerButton(pad, GamePad.Button.START, middle, middleHighlight), 280, 121 );
            
            // L3 and R3
            final GreenfootImage noImage = new GreenfootImage(1, 1);
            final GreenfootImage analogHighlightImage = new GreenfootImage("analog_button_highlight.png");
            addObject( new ControllerButton(pad, GamePad.Button.L3, noImage, analogHighlightImage),
                    150, 209 );
            addObject( new ControllerButton(pad, GamePad.Button.R3, noImage, analogHighlightImage),
                    330, 209 );
            
            // d-pad
            addObject( new ControllerDirection(pad, 0, new GreenfootImage("right_button.png"), new GreenfootImage("right_button_highlight.png")), 123, 131);
            addObject( new ControllerDirection(pad, 90, new GreenfootImage("down_button.png"), new GreenfootImage("down_button_highlight.png")), 95, 160);
            addObject( new ControllerDirection(pad, 180, new GreenfootImage("left_button.png"), new GreenfootImage("left_button_highlight.png")), 66, 131);
            addObject( new ControllerDirection(pad, 270, new GreenfootImage("up_button.png"), new GreenfootImage("up_button_highlight.png")), 95, 103);
            
            // analog sticks
            addObject( new ControllerAnalog(pad, GamePad.Axis.LEFT) , 150, 209 );
            addObject( new ControllerAnalog(pad, GamePad.Axis.RIGHT), 330, 209 );
    //        addObject( new ControllerAnalog(pad, GamePad.Axis.POV), 0, 0 );
            
            addObject( new ControllerBody(), getWidth()/2, getHeight()/2 );
            
            addObject( new RedefineButton(pad), REDEFINE_X, REDEFINE_Y );
            
            setPaintOrder( RedefineButton.class, ControllerDirection.class, ControllerButton.class, ControllerBody.class, ControllerAnalog.class );
        } else {
            System.err.println( "No GamePad found, please ensure one is plugged in!" );
        }
    }
}

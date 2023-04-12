import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This listens to a particular direction on the d-pad.
 * The directions also wrap around and take into account of diagonals.
 * 
 * The direction is from 0 to 1, where both 0 and 1 point to the left
 * and move around the d-pad in a clockwise fashion. However the number
 * 0 itself represents no input.
 * 
 * @author Joseph Lenton
 */
public class ControllerDirection  extends ControllerActor
{
    private static final int DIRECTION_DIST = 45;
    private static final int MAX_DIRECTION = 360;
    
    private final GreenfootImage image;
    private final GreenfootImage highlight;
    private final int minDirection;
    private final int maxDirection;
    private final int maxDirectionWrap;
    private final boolean wraps;
    
    /**
     * @param pad The GamePad to listen too.
     * @param direction The d-pad direction this will be listening for.
     * @param image The image to display when the d-pad is not pressed in it's direction.
     * @param image The image to display when the d-pad is pressed in the particular direction.
     */
    public ControllerDirection(GamePad pad, int direction, GreenfootImage image, GreenfootImage highlight)
    {
        super( pad );
        
        minDirection = direction-DIRECTION_DIST;
        maxDirection = direction+DIRECTION_DIST;
        maxDirectionWrap = (direction+DIRECTION_DIST) % MAX_DIRECTION;
        wraps = (direction+DIRECTION_DIST) > MAX_DIRECTION;
        
        this.image = image;
        this.highlight = highlight;
        
        setImage( image );
    }
    
    /**
     * If the d-pad is pressed in the direction given in the constructor,
     * then this will appear highlighted. Otherwise non-highlighted.
     */
    public void act()
    {
        final Direction dpadDir = getGamePad().getAxis( GamePad.Axis.DPAD );
        
        if ( dpadDir.getStrength() > 0 ) {
            final int d = dpadDir.getAngle();
            
            if (
                    (d >= minDirection && d <= maxDirection) ||
                    (wraps && d < maxDirectionWrap)
            ) {
                setImage( highlight );
            } else {
                setImage( image );
            }
        } else {
            setImage( image );
        }
    }
}

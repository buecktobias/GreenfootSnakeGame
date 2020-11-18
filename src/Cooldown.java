import greenfoot.World;

/**
 * Write a description of class Cooldown here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cooldown extends Countdown
{
    /**
     * Constructor for objects of class Cooldown
     */
    protected Cooldown(int cooldownTime, World w)
    {
        super(cooldownTime, w);
    }

    private void resetCooldown(){
        this.setCurrentCount(this.getSTART_COUNT());
    }

    protected boolean isCooledDown(){
        return this.isDown();
    }

    public boolean activate(){
        if(isCooledDown()){
            this.resetCooldown();
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void act() {
        super.act();
    }
}

package game.countdown;

import game.helper.Settings;
import greenfoot.World;

/**
 * Write a description of class game.countdown.Cooldown here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cooldown extends Countdown
{
    /**
     * Constructor for objects of class game.countdown.Cooldown
     */
    public Cooldown(int cooldownTime, World w)
    {
        super(cooldownTime, w);
        this.setImage(Settings.getFilePath("Transparent.png"));
    }

    private void resetCooldown(){
        this.setCurrentCount(this.getSTART_COUNT());
    }

    public boolean isCooledDown(){
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

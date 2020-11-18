import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Countdown here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Countdown extends Actor {
    private final int START_COUNT;

    public int getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    private int currentCount;

    protected Countdown(int START_COUNT, World w) {
        this.START_COUNT = START_COUNT;
        this.currentCount = START_COUNT;
        w.addObject(this, 0, 0);
        this.getImage().setTransparency(0);
    }

    /**
     * Act - do whatever the Countdown wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        this.decreaseCount();
    }

    protected boolean isDown() {
        return this.currentCount < 0;
    }

    protected void decreaseCount() {
        this.currentCount--;
    }

    public int getSTART_COUNT() {
        return START_COUNT;
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LifeBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LifeBar extends Entity
{
    private LivingActor forActor;
    private int xOffset;
    private int yOffset;
    public LifeBar(LivingActor forA){
        super();
        this.forActor = forA;
        int x = forA.getX();
        int y = forA.getY();
        int height = forA.getImage().getHeight();
        this.xOffset = 0;
        this.yOffset = - (height / 2) - 5;
        forA.getWorld().addObject(this, x + this.xOffset, y + this.yOffset);
    }
    /**
     * Act - do whatever the LifeBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!this.forActor.isInWorld()){
            this.destroySelf();
            return;
        }
        int x = this.forActor.getX();
        int y = this.forActor.getY();
        this.setLocation(x + this.xOffset, y + this.yOffset);
        this.draw();

    }
    private void draw(){
        this.setImage(new GreenfootImage(this.getDefaultImage()));
        this.getImage().setColor(new Color(255,0,0));
        this.getImage().fillRect(0, 0,this.forActor.getLife(), 10);
    }
}

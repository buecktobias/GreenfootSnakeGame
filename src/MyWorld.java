import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class src.worlds.MyWorld here.
 *
 * @author Tobias Bück
 * @version 1
 */
public class MyWorld extends World
{
    @Override
    public void removeObject(Actor object) {
        super.removeObject(object);
        if(object instanceof Entity){
            Entity entity = (Entity) object;
            entity.removedFromWorld(this);
        }
    }

    /**
     * Constructor for objects of class src.worlds.MyWorld
     *
     */
    public MyWorld()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        Snake s = new Snake();
        this.addObject(s, 100, 100);
        Rabbit r = new Rabbit();
        this.addObject(r, 400, 400);
        Player p = new Player(r);
        this.addObject(p,0,0);
        Teleporter t1 = new Teleporter(new Vector2D(100, 200), new Vector2D(400, 100));
        this.addObject(t1,0,0);
        this.setPaintOrder(Rabbit.class, MovingActor.class);
    }
}

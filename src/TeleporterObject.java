import java.util.List;

/**
 * Write a description of class TeleporterObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TeleporterObject extends Entity
{
    public TeleporterObject getOther() {
        return other;
    }

    public void setOther(TeleporterObject other) {
        this.other = other;
    }

    private TeleporterObject other;
    protected TeleporterObject(){

    }

    private List<Teleportable> getTeleportableIntersecting(){
        return this.getIntersectingObjects(Teleportable.class);
    }

    private void teleport(Teleportable t){
        t.setLocation(this.other.getX(), this.other.getY());
    }

    protected boolean hasTeleportableIntersecting(){
        return this.getTeleportableIntersecting().size() > 0;
    }

    protected void teleport(){
        this.teleport(this.getTeleportableIntersecting().get(0));
    }

    /**
     * Act - do whatever the TeleporterObject wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }    
}

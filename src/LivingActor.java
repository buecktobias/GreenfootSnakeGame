/**
 * Write a description of class LivingActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
interface LivingActor extends IActor
{
    int getLife();
    void setLife(int newLife);
    default void createLifeBar(){
        new LifeBar(this);
    }
    boolean isInWorld();
}

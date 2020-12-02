package game.entity.movingactor;

import game.countdown.Cooldown;
import game.countdown.Countdown;
import game.entity.interfaces.CanBeHit;
import game.entity.interfaces.LivingActor;
import game.entity.teleporter.Teleportable;
import game.helper.Settings;
import greenfoot.GreenfootImage;
import greenfoot.World;

import java.util.List;

/**
 * Write a description of class game.entity.movingactor.Snake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
final public class Snake extends MovingActor implements CanBeHit, LivingActor, Teleportable
{
    private boolean animationStarted = false;
    private Countdown animationCountdown;
    private int life;
    private Cooldown attackCooldown;
    public Snake(){
        super(1, new GreenfootImage(Settings.getFilePath("snake2.png")));
        this.setLife(50);
    }

    @Override
    protected void addedToWorld(World world) {
        super.addedToWorld(world);
        this.createLifeBar();
        this.attackCooldown = this.createCooldown(30);
        this.animationCountdown = this.createCountdown(1_000_000_000);
    }

    @Override
    public void hit() {
        this.setLife(this.getLife() - 10);
    }

    /**
     * Act - do whatever the game.entity.movingactor.Snake wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        this.doRandomMovement(0.01, 0.5);
        if (this.getAttackableObjects().size() > 0 && this.attackCooldown.activate()){
            this.startAnimation();
        }
        if(!this.animationCountdown.isDown() && animationStarted){
            this.animate();
        }
        if(this.animationCountdown.isDown()){
            if (this.getAttackableObjects().size() > 0) {
                this.attack(this.getAttackableObjects());
            }
            this.setImage(new GreenfootImage(this.getDefaultImage()));
            this.animationCountdown = this.createCountdown(1000000000);
            this.animationStarted = false;
        }
    }
    private void startAnimation(){
        this.animationStarted = true;
        this.animationCountdown = this.createCountdown(10);
    }

    private void animate(){
        this.getImage().rotate(10);
    }

    private void attack(List<LivingActor> attackable){
        LivingActor la = attackable.get(0);
        la.setLife(la.getLife() - 10);
    }

    private List<LivingActor> getAttackableObjects(){
        List<LivingActor> livingActorList = this.getObjectsInRange(100, LivingActor.class);
        if(livingActorList.contains(this)){
            livingActorList.remove(this);
        }
        return livingActorList;
    }

    @Override
    public int getLife() {
        return life;
    }

    @Override
    public void setLife(int life) {
        if(life < 0 ){
            this.destroySelf();
        }

        this.life = life;
    }

    @Override
    public boolean isInWorld() {
        return super.isInWorld();
    }
}

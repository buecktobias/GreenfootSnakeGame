package game.entity;

import game.countdown.Cooldown;
import game.entity.movingactor.Snake;
import game.helper.Settings;
import greenfoot.GreenfootImage;
import greenfoot.World;

import java.util.Random;

public class SnakeSpawner extends Entity {
    private Cooldown spawnCooldown;
    public SnakeSpawner(){
        super(new GreenfootImage(Settings.getFilePath("Transparent.png")));
    }

    @Override
    protected void addedToWorld(World world) {
        super.addedToWorld(world);
        this.spawnCooldown = this.createCooldown(100);
    }

    @Override
    public void act() {
        super.act();
        if(this.spawnCooldown.activate()){
            this.spawn();
        }
    }

    private int getRandomX(){
        int maxX = this.getWorld().getWidth();
        int minX = 0;
        Random r = new Random();
        return r.nextInt(maxX);
    }
    private int getRandomY(){
        int maxY = this.getWorld().getHeight();
        int minY = 0;
        Random r = new Random();
        return r.nextInt(maxY);
    }

    private void spawn(){
        Snake snake = new Snake();
        this.getWorld().addObject(snake, this.getRandomX(), this.getRandomY());
    }
}

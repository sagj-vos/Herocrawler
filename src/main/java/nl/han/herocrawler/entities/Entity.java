package nl.han.herocrawler.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public abstract class Entity extends DynamicSpriteEntity implements Collider, Collided {
    protected int numberOfHearts;
    protected int power;
    protected double speed;


    protected Entity(String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size);
    }

    public abstract void playSound();

    public int getPower() {
        return this.power;
    }
}

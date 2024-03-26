package nl.han.herocrawler.entities.monsters;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;

import java.util.List;

public class Wizard extends Monster {
    protected Wizard(String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size);
    }

    @Override
    public void onCollision(List<Collider> list) {

    }

    @Override
    public void playSound() {
        System.out.println("I'm a wizard Gandalf!");
    }
}

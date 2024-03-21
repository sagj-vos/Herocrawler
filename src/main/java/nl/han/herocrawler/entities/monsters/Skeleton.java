package nl.han.herocrawler.entities.monsters;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;

import java.util.List;

public class Skeleton extends Monster {

    protected Skeleton(String resource, Coordinate2D initialLocation, Size size, int rows, int columns) {
        super(resource, initialLocation, size, rows, columns);
    }

    @Override
    public void onCollision(List<Collider> list) {

    }
}

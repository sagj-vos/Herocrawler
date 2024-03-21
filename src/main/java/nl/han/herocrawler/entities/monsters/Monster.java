package nl.han.herocrawler.entities.monsters;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import nl.han.herocrawler.entities.Entity;

public abstract class Monster extends Entity {

    protected Monster(String resource, Coordinate2D initialLocation, Size size, int rows, int columns) {
        super(resource, initialLocation, size, rows, columns);
    }
}

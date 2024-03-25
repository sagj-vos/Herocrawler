package nl.han.herocrawler.entities.tiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public abstract class Tile extends SpriteEntity implements Collider {
    protected Tile(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }
}

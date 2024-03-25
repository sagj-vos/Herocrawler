package nl.han.herocrawler.entities.tiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public final class UnWalkableTile extends Tile {
    public UnWalkableTile(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }
}
package nl.han.herocrawler.entities.tiles;

import com.github.hanyaeger.api.Coordinate2D;

public final class WalkableTile extends Tile {
    public WalkableTile(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }
}

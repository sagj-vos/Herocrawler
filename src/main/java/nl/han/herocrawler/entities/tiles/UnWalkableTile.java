package nl.han.herocrawler.entities.tiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public final class UnWalkableTile extends Tile {

    public UnWalkableTile(Coordinate2D initialLocation, Size size, String resource) {
        super(initialLocation, size, resource);
    }


}

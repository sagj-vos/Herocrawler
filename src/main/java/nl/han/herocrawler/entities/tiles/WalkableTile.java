package nl.han.herocrawler.entities.tiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public final class WalkableTile extends SpriteEntity {
    public WalkableTile(String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size);
    }
}

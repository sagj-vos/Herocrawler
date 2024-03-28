package nl.han.herocrawler.entities.tiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public final class WalkableTile extends SpriteEntity {
    public WalkableTile(Coordinate2D initialLocation, Size size, String resource) {
        super(resource, initialLocation, size);
    }
}

package nl.han.herocrawler.entities.tiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public final class UnWalkableTile extends SpriteEntity implements Collider {

    public UnWalkableTile(String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size);
    }
}

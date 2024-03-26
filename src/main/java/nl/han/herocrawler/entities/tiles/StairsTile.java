package nl.han.herocrawler.entities.tiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class StairsTile extends SpriteEntity implements Collider {
    public StairsTile(Coordinate2D initialLocation, Size size, String resource) {
        super(resource, initialLocation, size);
    }
}

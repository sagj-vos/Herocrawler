package nl.han.herocrawler.entities.objects;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import nl.han.herocrawler.entities.GameSound;

public abstract class PickupObject extends SpriteEntity implements Collider, GameSound {
    protected PickupObject(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation, new Size(16, 16));
    }
}

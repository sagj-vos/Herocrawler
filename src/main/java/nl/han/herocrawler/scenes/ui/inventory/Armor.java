package nl.han.herocrawler.scenes.ui.inventory;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Armor extends SpriteEntity {
    public Armor(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation, new Size(96, 96));
    }
}

package nl.han.herocrawler.scenes.ui.heartdisplay;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Heart extends SpriteEntity {
    protected Heart(Coordinate2D initialLocation) {
        super("ui/heart.png", initialLocation);
    }
}

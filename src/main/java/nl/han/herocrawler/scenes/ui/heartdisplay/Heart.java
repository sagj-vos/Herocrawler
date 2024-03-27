package nl.han.herocrawler.scenes.ui.heartdisplay;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import nl.han.herocrawler.Herocrawler;

public class Heart extends SpriteEntity {
    public Heart(Coordinate2D initialLocation) {
        super("ui/heart.png", initialLocation);
    }
}

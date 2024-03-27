package nl.han.herocrawler.scenes.ui.hp;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public abstract class Hp extends SpriteEntity {

    public Hp(String recourse, Coordinate2D initialLocation) {
        super(recourse, initialLocation, new Size(96, 96));
    }
}
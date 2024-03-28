package nl.han.herocrawler.scenes.ui.inventory.spells;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class CooldownBar extends RectangleEntity {

    protected CooldownBar(Coordinate2D initialPosition, Size size) {
        super(initialPosition, size);

        this.setFill(Color.RED);
        this.setStrokeColor(Color.RED);
        setStrokeWidth(1);
    }
}

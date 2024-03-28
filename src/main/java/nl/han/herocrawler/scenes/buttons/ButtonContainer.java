package nl.han.herocrawler.scenes.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class ButtonContainer extends RectangleEntity {
    protected ButtonContainer(Coordinate2D initialLocation, double width, double height) {
        super(initialLocation, new Size(width, height));
        super.setStrokeColor(Color.WHITE);
        super.setStrokeWidth(8);
    }
}

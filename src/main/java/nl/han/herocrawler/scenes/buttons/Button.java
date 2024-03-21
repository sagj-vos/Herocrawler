package nl.han.herocrawler.scenes.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;

public abstract class Button extends RectangleEntity implements MouseButtonPressedListener {
    protected Button(Coordinate2D initialLocation) {
        super(initialLocation);
    }
}

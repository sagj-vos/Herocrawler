package nl.han.herocrawler.scenes.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.paint.Color;

public abstract class Button extends CompositeEntity implements MouseButtonPressedListener {

    private String text;
    protected Button(Coordinate2D initialLocation, String text) {
        super(initialLocation);
        this.text = text;
    }

    @Override
    protected void setupEntities() {
        //var buttonText = new TextEntity((getWidth() / 2, y), text);
    }
}

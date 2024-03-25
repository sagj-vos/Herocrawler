package nl.han.herocrawler.scenes.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;

public class ReplayButton extends Button{
    public ReplayButton(Coordinate2D initialLocation) {
        super(initialLocation, "Start");
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {

    }
}

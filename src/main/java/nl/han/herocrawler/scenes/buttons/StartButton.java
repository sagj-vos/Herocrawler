package nl.han.herocrawler.scenes.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import nl.han.herocrawler.Herocrawler;

public class StartButton extends Button{
    public StartButton(Coordinate2D initialLocation, Herocrawler herocrawler) {
        super(initialLocation, "START", herocrawler);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        this.herocrawler.setActiveScene(2);
    }
}

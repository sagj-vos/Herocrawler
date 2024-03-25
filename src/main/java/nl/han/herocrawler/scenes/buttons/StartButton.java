package nl.han.herocrawler.scenes.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import nl.han.herocrawler.Herocrawler;

public class StartButton extends Button{
    private Herocrawler herocrawler;
    public StartButton(Coordinate2D initialLocation, Herocrawler herocrawler) {
        super(initialLocation, "Start");
        this.herocrawler = herocrawler;
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        this.herocrawler.setActiveScene(1);
    }
}

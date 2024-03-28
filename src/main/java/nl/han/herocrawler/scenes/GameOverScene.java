package nl.han.herocrawler.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.han.herocrawler.Herocrawler;
import nl.han.herocrawler.scenes.buttons.ExitButton;
import nl.han.herocrawler.scenes.buttons.ReplayButton;

public class GameOverScene extends StaticScene {

    private final Herocrawler herocrawler;
    public GameOverScene(Herocrawler herocrawler) {
        this.herocrawler = herocrawler;
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.BLACK);
    }

    @Override
    public void setupEntities() {
        var gameOverSceneText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 4),
                "GAME OVER"
        );
        gameOverSceneText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        gameOverSceneText.setFill(Color.WHITE);
        gameOverSceneText.setFont(Font.font("Roboto", FontWeight.BOLD, 60));
        addEntity(gameOverSceneText);

        addEntity(new ReplayButton(new Coordinate2D(getWidth() / 2, getHeight() / 2), this.herocrawler));
        addEntity(new ExitButton(new Coordinate2D(getWidth() / 2, getHeight() / 4 * 3), this.herocrawler));
    }
}

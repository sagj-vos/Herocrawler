package nl.han.herocrawler.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.han.herocrawler.scenes.buttons.StartButton;

public class TitleScene extends StaticScene {
    @Override
    public void setupScene() {
        setBackgroundColor(Color.BLACK);
    }

    @Override
    public void setupEntities() {
        var titleSceneText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 4),
                    "Herocrawler"
        );
        titleSceneText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        titleSceneText.setFill(Color.WHITE);
        titleSceneText.setFont(Font.font("Roboto", FontWeight.BOLD, 60));
        addEntity(titleSceneText);
        //addEntity(new StartButton(new Coordinate2D(getWidth() / 2, getHeight() / 2)));
    }
}

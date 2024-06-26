package nl.han.herocrawler;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import nl.han.herocrawler.entities.Player;
import nl.han.herocrawler.scenes.GameOverScene;
import nl.han.herocrawler.scenes.TitleScene;
import nl.han.herocrawler.scenes.levels.LevelOneScene;
import nl.han.herocrawler.scenes.levels.LevelScene;
import nl.han.herocrawler.scenes.levels.LevelTwoScene;
import nl.han.herocrawler.scenes.ui.HealthUI;
import nl.han.herocrawler.scenes.ui.hp.Health;

public class Herocrawler extends YaegerGame {

    private static final double WIDTH = 1000;
    private static final double HEIGHT = 600;
    public static void main( String[] args ) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Herocrawler");
        setSize(new Size(WIDTH, HEIGHT));
    }

    @Override
    public void setupScenes() {
        var healthUI = new HealthUI(new Coordinate2D(0, 0));
        var player = new Player(this, new Coordinate2D(WIDTH / 15.75, HEIGHT / 2), healthUI);

        addScene(0, new TitleScene(this));
        addScene(1, new LevelOneScene(this, player));
        addScene(2, new LevelTwoScene(this, player));
        addScene(3, new GameOverScene(this));
    }
}

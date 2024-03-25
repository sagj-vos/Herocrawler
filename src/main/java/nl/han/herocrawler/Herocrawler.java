package nl.han.herocrawler;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import nl.han.herocrawler.scenes.levels.LevelOneScene;

/**
 * Hello world!
 *
 */
public class Herocrawler extends YaegerGame {
    public static void main( String[] args ) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setSize(new Size(800, 800));
    }

    @Override
    public void setupScenes() {
        addScene(0, new LevelOneScene());
    }
}

package nl.han.herocrawler;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import nl.han.herocrawler.scenes.Level1;
import nl.han.herocrawler.scenes.TitleScene;

public class Herocrawler extends YaegerGame {
    public static void main( String[] args ) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Herocrawler");
        setSize(new Size(1000, 600));
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitleScene(this));
        addScene(1, new Level1());
    }
}

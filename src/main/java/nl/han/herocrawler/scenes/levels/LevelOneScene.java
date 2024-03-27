package nl.han.herocrawler.scenes.levels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import nl.han.herocrawler.Herocrawler;
import nl.han.herocrawler.entities.Player;
import nl.han.herocrawler.scenes.tilemaps.TileMapLevelOne;
import nl.han.herocrawler.scenes.ui.hp.Heart;
import nl.han.herocrawler.scenes.ui.hp.Shield;

public class LevelOneScene extends DynamicScene implements TileMapContainer {
    private final Herocrawler herocrawler;
    private final Player player;

    public LevelOneScene(Herocrawler herocrawler, Player player) {
        this.herocrawler = herocrawler;
        this.player = player;
    }
    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/level-background.png");
    }

    @Override
    public void setupEntities() {
        addEntity(new Player(this.herocrawler,new Coordinate2D(getWidth() / 16 + 1, getHeight() / 2)));
        for (int i = 0; i < 5; i++) {
            addEntity(new Heart(new Coordinate2D(i * 64, 0)));
        }
        addEntity(new Shield(new Coordinate2D(320, 0)));
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new TileMapLevelOne());
    }
}
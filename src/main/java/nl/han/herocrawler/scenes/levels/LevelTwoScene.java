package nl.han.herocrawler.scenes.levels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import nl.han.herocrawler.entities.Player;
import nl.han.herocrawler.scenes.tilemaps.TileMapLevelTwo;

public class LevelTwoScene extends DynamicScene implements TileMapContainer {
    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/level-background.png");
    }

    @Override
    public void setupEntities() {
        addEntity(new Player(new Coordinate2D(getWidth() / 16 * 1.5, getHeight() / 2)));
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new TileMapLevelTwo());
    }
}
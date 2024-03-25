package nl.han.herocrawler.scenes.levels;

import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import nl.han.herocrawler.scenes.tilemaps.TileMapLevelOne;

public class LevelOneScene extends DynamicScene implements TileMapContainer {
    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/level-background.png");
    }

    @Override
    public void setupEntities() {

    }

    @Override
    public void setupTileMaps() {
        addTileMap(new TileMapLevelOne());
    }
}

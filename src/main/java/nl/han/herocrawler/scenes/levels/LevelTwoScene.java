package nl.han.herocrawler.scenes.levels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import nl.han.herocrawler.Herocrawler;
import nl.han.herocrawler.entities.Player;
import nl.han.herocrawler.scenes.tilemaps.TileMapLevelTwo;

public class LevelTwoScene extends DynamicScene implements TileMapContainer {
    private final Herocrawler herocrawler;
    private final Player player;

    public LevelTwoScene(Herocrawler herocrawler, Player player) {
        this.herocrawler = herocrawler;
        this.player = player;
    }
    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/level-background.png");
    }

    @Override
    public void setupEntities() {
        addEntity(this.player);
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new TileMapLevelTwo());
    }
}
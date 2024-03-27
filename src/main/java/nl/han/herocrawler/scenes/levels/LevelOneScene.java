package nl.han.herocrawler.scenes.levels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import nl.han.herocrawler.Herocrawler;
import nl.han.herocrawler.entities.Player;
import nl.han.herocrawler.scenes.tilemaps.TileMapLevelOne;
import nl.han.herocrawler.scenes.ui.heartdisplay.Heart;

public class LevelOneScene extends DynamicScene implements TileMapContainer {
    private final Herocrawler herocrawler;

    public LevelOneScene(Herocrawler herocrawler) {
        this.herocrawler = herocrawler;
    }
    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/level-background.png");
    }

    @Override
    public void setupEntities() {
        addEntity(new Player(this.herocrawler,new Coordinate2D(400, 400)));
        addEntity(new Heart(new Coordinate2D(0, 0)));
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new TileMapLevelOne());
    }
}
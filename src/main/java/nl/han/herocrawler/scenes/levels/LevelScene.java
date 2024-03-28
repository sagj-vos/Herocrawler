package nl.han.herocrawler.scenes.levels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import nl.han.herocrawler.Herocrawler;
import nl.han.herocrawler.entities.Player;
import nl.han.herocrawler.scenes.buttons.ExitButton;
import nl.han.herocrawler.scenes.tilemaps.LevelTileMap;
import nl.han.herocrawler.scenes.ui.InventoryUi;

public abstract class LevelScene extends DynamicScene implements TileMapContainer {
    protected static final  double TILE_CENTER_OFFSET = 0.25;

    protected final Herocrawler herocrawler;
    protected final Player player;
    protected double tileWidth;
    protected double tileHeight;


    protected LevelScene(Herocrawler herocrawler, Player player) {
        this.herocrawler = herocrawler;
        this.player = player;
    }

    @Override
    public  void setupEntities() {
        this.tileWidth = getWidth() / LevelTileMap.TILE_MAP_WIDTH;
        this.tileHeight = getHeight() / LevelTileMap.TILE_MAP_HEIGHT;

        addEntity(this.player);
        addEntity(this.player.getHealthUI());
        addEntity(new InventoryUi(new Coordinate2D(0, (getHeight() / 12 * 10))));
        addEntity(new ExitButton(new Coordinate2D(getWidth() / 5 * 4, getHeight() / 12), this.herocrawler));
    }
}

package nl.han.herocrawler.scenes.levels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import nl.han.herocrawler.Herocrawler;
import nl.han.herocrawler.entities.Player;
import nl.han.herocrawler.scenes.buttons.ExitButton;
import nl.han.herocrawler.scenes.tilemaps.TileMapLevelOne;
import nl.han.herocrawler.scenes.ui.HpUi;
import nl.han.herocrawler.scenes.ui.InventoryUi;

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
        addEntity(this.player);
        addEntity(new HpUi(new Coordinate2D(0, 0)));
        addEntity(new InventoryUi(new Coordinate2D(0, (getHeight() / 12 * 10))));
        addEntity(new ExitButton(new Coordinate2D(getWidth() / 5 * 4, getHeight() / 12), this.herocrawler));
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new TileMapLevelOne());
    }
}
package nl.han.herocrawler.scenes.levels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import nl.han.herocrawler.Herocrawler;
import nl.han.herocrawler.entities.Player;
import nl.han.herocrawler.entities.monsters.Skeleton;
import nl.han.herocrawler.entities.monsters.Wizard;
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
        addEntity(new Skeleton(new Coordinate2D(getWidth() / 16 * 2 , getHeight()/ 12 * 8)));
        addEntity(new Skeleton(new Coordinate2D(getWidth() / 16 * 3 , getHeight()/ 12 * 3)));
        addEntity(new Skeleton(new Coordinate2D(getWidth() / 16 * 7 , getHeight()/ 12 * 4)));
        addEntity(new Skeleton(new Coordinate2D(getWidth() / 16 * 6 , getHeight()/ 12 * 7)));
        addEntity(new Skeleton(new Coordinate2D(getWidth() / 16 * 13 , getHeight()/ 12 * 9)));
        addEntity(new Wizard(new Coordinate2D(getWidth() / 16 * 5 , getHeight()/ 12 * 5)));
        addEntity(new Wizard(new Coordinate2D(getWidth() / 16 * 9 , getHeight()/ 12 * 7)));
        addEntity(new Wizard(new Coordinate2D(getWidth() / 16 * 12 , getHeight()/ 12 * 7)));
        addEntity(new Wizard(new Coordinate2D(getWidth() / 16 * 13 , getHeight()/ 12 * 3)));
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new TileMapLevelOne());
    }
}
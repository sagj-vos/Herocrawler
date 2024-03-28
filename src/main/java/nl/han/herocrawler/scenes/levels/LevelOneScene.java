package nl.han.herocrawler.scenes.levels;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import nl.han.herocrawler.Herocrawler;
import nl.han.herocrawler.entities.Player;
import nl.han.herocrawler.entities.monsters.Skeleton;
import nl.han.herocrawler.entities.monsters.Wizard;
import nl.han.herocrawler.entities.objects.Food;
import nl.han.herocrawler.entities.objects.potions.BluePotion;
import nl.han.herocrawler.scenes.buttons.ExitButton;
import nl.han.herocrawler.scenes.tilemaps.TileMapLevelOne;
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
        addEntity(this.player.getHealthUI());
        addEntity(new InventoryUi(new Coordinate2D(0, (getHeight() / 12 * 10))));
        addEntity(new ExitButton(new Coordinate2D(getWidth() / 5 * 4, getHeight() / 12), this.herocrawler));

        addEntity(new Skeleton(new Coordinate2D(getWidth() / 16 * 2 , getHeight()/ 12 * 8)));
        addEntity(new Skeleton(new Coordinate2D(getWidth() / 16 * 3 , getHeight()/ 12 * 3)));

        addEntity(new Wizard(new Coordinate2D(getWidth() / 16 * 7 , getHeight()/ 12 * 7)));
        addEntity(new Wizard(new Coordinate2D(getWidth() / 16 * 7 , getHeight()/ 12 * 2)));
        addEntity(new Wizard(new Coordinate2D(getWidth() / 16 * 11 , getHeight()/ 12 * 7)));
        addEntity(new Wizard(new Coordinate2D(getWidth() / 16 * 12 , getHeight()/ 12 * 3)));

        addEntity(new Food("objects/banana.png", new Coordinate2D(getWidth()/ 16 * 3.25, getHeight() / 12 * 7.25)));
        addEntity(new Food("objects/grape.png", new Coordinate2D(getWidth()/ 16 * 4.25, getHeight() / 12 * 9.25)));
        addEntity(new Food("objects/lemon.png", new Coordinate2D(getWidth()/ 16 * 12.25, getHeight() / 12 * 9.25)));
        addEntity(new Food("objects/orange.png", new Coordinate2D(getWidth()/ 16 * 9.25, getHeight() / 12 * 2.25)));
        addEntity(new Food("objects/pear.png", new Coordinate2D(getWidth()/ 16 * 14.25, getHeight() / 12 * 3.25)));

        addEntity(new BluePotion(new Coordinate2D(getWidth()/ 16 * 4.25, getHeight() / 12 * 2.25)));
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new TileMapLevelOne());
    }
}
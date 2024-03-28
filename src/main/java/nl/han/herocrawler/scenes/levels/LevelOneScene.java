package nl.han.herocrawler.scenes.levels;

import com.github.hanyaeger.api.Coordinate2D;
import nl.han.herocrawler.Herocrawler;
import nl.han.herocrawler.entities.Player;
import nl.han.herocrawler.entities.monsters.Skeleton;
import nl.han.herocrawler.entities.monsters.Wizard;
import nl.han.herocrawler.entities.objects.Food;
import nl.han.herocrawler.entities.objects.potions.BluePotion;
import nl.han.herocrawler.scenes.tilemaps.TileMapLevelOne;

public class LevelOneScene extends LevelScene {
    public LevelOneScene(Herocrawler herocrawler, Player player) {
        super(herocrawler, player);
    }
    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/level-background.png");
    }

    @Override
    public void setupEntities() {
        super.setupEntities();

        addEntity(new Skeleton(new Coordinate2D(
                this.tileWidth * (2 + TILE_CENTER_OFFSET),
                this.tileHeight * (8 + TILE_CENTER_OFFSET)
        )));
        addEntity(new Skeleton(new Coordinate2D(
                this.tileWidth * (3 + TILE_CENTER_OFFSET),
                this.tileHeight * (3 + TILE_CENTER_OFFSET)
        )));

        addEntity(new Wizard(new Coordinate2D(
                this.tileWidth * (7 + TILE_CENTER_OFFSET),
                this.tileHeight * (7 + TILE_CENTER_OFFSET)
        )));
        addEntity(new Wizard(new Coordinate2D(
                this.tileWidth * (7 + TILE_CENTER_OFFSET),
                this.tileHeight * (2 + TILE_CENTER_OFFSET)
        )));
        addEntity(new Wizard(new Coordinate2D(
                this.tileWidth * (11 + TILE_CENTER_OFFSET),
                this.tileHeight * (7 + TILE_CENTER_OFFSET)
        )));
        addEntity(new Wizard(new Coordinate2D(
                this.tileWidth * (12 + TILE_CENTER_OFFSET),
                this.tileHeight * (3 + TILE_CENTER_OFFSET)
        )));

        addEntity(new Food("objects/banana.png", new Coordinate2D(
                this.tileWidth * (3 + TILE_CENTER_OFFSET),
                this.tileHeight * (7 + TILE_CENTER_OFFSET)
        )));
        addEntity(new Food("objects/grape.png", new Coordinate2D(
                this.tileWidth * (4 + TILE_CENTER_OFFSET),
                this.tileHeight * (9 + TILE_CENTER_OFFSET)
        )));
        addEntity(new Food("objects/lemon.png", new Coordinate2D(
                this.tileWidth * (12 + TILE_CENTER_OFFSET),
                this.tileWidth * (9 + TILE_CENTER_OFFSET)
        )));
        addEntity(new Food("objects/orange.png", new Coordinate2D(
                this.tileWidth * (9 + TILE_CENTER_OFFSET),
                this.tileHeight * (2 + TILE_CENTER_OFFSET)
        )));
        addEntity(new Food("objects/pear.png", new Coordinate2D(
                this.tileWidth * (14 + TILE_CENTER_OFFSET),
                this.tileHeight * (3 + TILE_CENTER_OFFSET)
        )));

        addEntity(new BluePotion(new Coordinate2D(
                this.tileWidth * (6 + TILE_CENTER_OFFSET),
                this.tileHeight * (2 + TILE_CENTER_OFFSET)
        )));
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new TileMapLevelOne());
    }
}
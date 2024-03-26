package nl.han.herocrawler.scenes.tilemaps;

import com.github.hanyaeger.api.scenes.TileMap;
import nl.han.herocrawler.entities.tiles.StairsTile;
import nl.han.herocrawler.entities.tiles.UnWalkableTile;
import nl.han.herocrawler.entities.tiles.WalkableTile;

public abstract class LevelTileMap extends TileMap {

    @Override
    public void setupEntities() {
        addEntity(1, UnWalkableTile.class, "tiles/tile-void.png");
        addEntity(2, WalkableTile.class, "tiles/tile-bottom.png");
        addEntity(3, UnWalkableTile.class, "tiles/tile-bottom-bottom.png");
        addEntity(4, WalkableTile.class, "tiles/tile-bottom-left.png");
        addEntity(5, WalkableTile.class, "tiles/tile-bottom-right.png");
        addEntity(6, WalkableTile.class, "tiles/tile-left.png");
        addEntity(7, WalkableTile.class, "tiles/tile-middle.png");
        addEntity(8, WalkableTile.class, "tiles/tile-right.png");
        addEntity(9, WalkableTile.class, "tiles/tile-top.png");
        addEntity(10, WalkableTile.class, "tiles/tile-top-left.png");
        addEntity(11, WalkableTile.class, "tiles/tile-top-right.png");
        addEntity(12, StairsTile.class, "tiles/tile-stairs.png");
    }
}

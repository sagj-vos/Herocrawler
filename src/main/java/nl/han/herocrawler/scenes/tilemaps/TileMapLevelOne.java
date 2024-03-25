package nl.han.herocrawler.scenes.tilemaps;

public class TileMapLevelOne extends LevelTileMap{
    @Override
    public int[][] defineMap() {
        return new int[][] {
                {1, 1, 1, 1,  1},
                {1, 9, 8, 10, 1},
                {1, 5, 6, 7,  1},
                {1, 3, 2, 4,  1},
                {1, 1, 1, 1,  1},
        };
    }
}

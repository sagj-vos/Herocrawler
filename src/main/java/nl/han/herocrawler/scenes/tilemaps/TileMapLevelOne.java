package nl.han.herocrawler.scenes.tilemaps;

public class TileMapLevelOne extends LevelTileMap{
    @Override
    public int[][] defineMap() {
        return new int[][] {
                {1, 1, 1, 1,  1},
                {1, 10, 9, 11, 1},
                {1, 6, 7, 8,  1},
                {1, 4, 2, 5,  1},
                {1, 3, 3, 3,  1},
        };
    }
}

package nl.han.herocrawler.scenes.tilemaps;

public class TileMapLevelOne extends LevelTileMap{
    @Override
    public int[][] defineMap() {
        return new int[][] {
                {0, 0, 0, 0, 0},
                {0, 8, 7, 9, 0},
                {0, 4, 5, 6, 0},
                {0, 2, 1, 3, 0},
                {0, 0, 0, 0, 0},
        };
    }
}

module Herocrawler {
    requires hanyaeger;

    exports nl.han.herocrawler;
    exports nl.han.herocrawler.entities.tiles;
    exports nl.han.herocrawler.scenes.tilemaps;

    opens backgrounds;
    opens tiles;
}
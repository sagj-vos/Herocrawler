package nl.han.herocrawler.entities.monsters;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import nl.han.herocrawler.entities.Entity;
import nl.han.herocrawler.entities.Player;

public abstract class Monster extends Entity {
    protected int accuracy;
    protected Monster(String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size);
    }

    protected void isHit(Player player) {
        this.numberOfHearts -= player.getPower();
    }

    public int getAccuracy() {
        return this.accuracy;
    }
}

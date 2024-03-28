package nl.han.herocrawler.scenes.ui.inventory.spells;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Spell extends SpriteEntity {
    protected long cooldown;
    protected Spell(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation, new Size(96, 96));
    }

    public long getCooldown() {
        return this.cooldown;
    }
}

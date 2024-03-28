package nl.han.herocrawler.scenes.ui.inventory.spells;

import com.github.hanyaeger.api.Coordinate2D;

public class TeleportSpell extends Spell {
    public TeleportSpell(Coordinate2D initialLocation) {
        super("ui/teleport-spell.png", initialLocation);
        this.cooldown = 30000;
    }
}

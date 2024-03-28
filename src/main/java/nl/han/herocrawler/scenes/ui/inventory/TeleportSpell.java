package nl.han.herocrawler.scenes.ui.inventory;

import com.github.hanyaeger.api.Coordinate2D;

public class TeleportSpell extends Spell {
    public TeleportSpell(Coordinate2D initialLocation) {
        super("ui/teleport-spell.png", initialLocation);
    }
}

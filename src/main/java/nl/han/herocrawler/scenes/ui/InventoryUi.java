package nl.han.herocrawler.scenes.ui;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.CompositeEntity;
import nl.han.herocrawler.scenes.ui.inventory.Armor;
import nl.han.herocrawler.scenes.ui.inventory.Helmet;
import nl.han.herocrawler.scenes.ui.inventory.Sword;
import nl.han.herocrawler.scenes.ui.inventory.spells.Spell;
import nl.han.herocrawler.scenes.ui.inventory.spells.SpellSlot;
import nl.han.herocrawler.scenes.ui.inventory.spells.TeleportSpell;

public class InventoryUi extends CompositeEntity {
    private Spell spell;

    public InventoryUi(Coordinate2D initialLocation, Spell spell) {
        super(initialLocation);
        this.spell = spell;
    }

    @Override
    protected void setupEntities() {
        addEntity(new SpellSlot(new Coordinate2D(0, 0), this.spell));
        addEntity(new Armor("ui/armor-lvl-1.png", new Coordinate2D(96, 0)));
        addEntity(new Helmet("ui/helmet-lvl-1.png", new Coordinate2D(192, 0)));
        addEntity(new Sword("ui/sword-lvl-1.png", new Coordinate2D(288, 0)));
    }
}

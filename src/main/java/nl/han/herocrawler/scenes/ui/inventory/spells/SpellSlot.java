package nl.han.herocrawler.scenes.ui.inventory.spells;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.CompositeEntity;
import nl.han.herocrawler.timers.SpellTimer;

public class SpellSlot extends CompositeEntity implements TimerContainer {
    private static final int COOLDOWN_STEPS = 10;
    private final Coordinate2D initialLocation;
    private final Spell spell;
    private final int timerUpdateInterval;
    private CooldownBar cooldownBar;
    public SpellSlot(Coordinate2D initialLocation, Spell spell) {
        super(initialLocation);

        this.initialLocation = initialLocation;
        this.spell = spell;
        this.timerUpdateInterval = (int) (spell.getCooldown() / COOLDOWN_STEPS);
        System.out.println(this.timerUpdateInterval);
    }

    @Override
    protected void setupEntities() {
        addEntity(spell);

        this.cooldownBar = new CooldownBar(this.initialLocation, new Size(15, 150));
        addEntity(this.cooldownBar);
    }

    @Override
    public void setupTimers() {
        var timer = new SpellTimer(this.cooldownBar, this.timerUpdateInterval, this.spell.getCooldown());
        addTimer(timer);
    }
}
package nl.han.herocrawler.timers;

import com.github.hanyaeger.api.Timer;
import nl.han.herocrawler.scenes.ui.inventory.spells.CooldownBar;
import nl.han.herocrawler.scenes.ui.inventory.spells.SpellSlot;

public class SpellTimer extends Timer {
    private final CooldownBar cooldownBar;
    private final int chipSize;
    public SpellTimer(CooldownBar cooldownBar, long intervalInMs, long totalCooldownInMs) {
        super(intervalInMs);
        this.cooldownBar = cooldownBar;
        this.chipSize = (int) (intervalInMs / totalCooldownInMs);
    }

    @Override
    public void onAnimationUpdate(long l) {
        System.out.println("hit");
        this.cooldownBar.setHeight(this.cooldownBar.getHeight() - chipSize);
    }
}

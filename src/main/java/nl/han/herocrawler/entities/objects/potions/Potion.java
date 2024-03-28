package nl.han.herocrawler.entities.objects.potions;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.media.SoundClip;
import nl.han.herocrawler.entities.objects.PickupObject;

public class Potion extends PickupObject {
    protected Potion(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }

    @Override
    public void playSound() {
        var potionDrinking = new SoundClip("audio/potion-drinking.mp3");
        potionDrinking.play();
    }
}

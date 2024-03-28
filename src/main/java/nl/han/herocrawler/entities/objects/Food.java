package nl.han.herocrawler.entities.objects;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.media.SoundClip;

public class Food extends PickupObject {
    public Food(Coordinate2D initialLocation) {
        super("", initialLocation);
    }

    @Override
    public void playSound() {
        var eatingFood = new SoundClip("audio/eating.mp3");
        eatingFood.play();
    }
}

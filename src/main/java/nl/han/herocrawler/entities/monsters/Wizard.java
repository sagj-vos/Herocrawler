package nl.han.herocrawler.entities.monsters;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.media.SoundClip;

import java.util.List;

public class Wizard extends Monster {
    public Wizard(String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size);
    }

    @Override
    public void onCollision(List<Collider> list) {

    }

    @Override
    public void playSound() {
        var attackSound = new SoundClip("audio/wizard-attack.mp3");
        attackSound.play();
    }
}

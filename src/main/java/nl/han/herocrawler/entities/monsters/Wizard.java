package nl.han.herocrawler.entities.monsters;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.media.SoundClip;

import java.util.List;

public class Wizard extends Monster {
    public Wizard(Coordinate2D initialLocation) {
        super("sprites/wizard.png", initialLocation, new Size(32, 32));

        this.power = 1;
        this.numberOfHearts = 3;
        this.speed = 0.85;
        this.accuracy = 40;
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

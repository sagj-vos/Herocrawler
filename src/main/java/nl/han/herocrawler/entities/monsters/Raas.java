package nl.han.herocrawler.entities.monsters;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.media.SoundClip;
import nl.han.herocrawler.Herocrawler;
import nl.han.herocrawler.entities.Player;

import java.util.List;

public class Raas extends Monster{
    private final Herocrawler herocrawler;
    public Raas(Herocrawler herocrawler, Coordinate2D initialLocation) {
        super("sprites/raas.png", initialLocation, new Size(48, 48));

        this.herocrawler = herocrawler;
        this.numberOfHearts = 10;
        this.power = 2;
        this.accuracy = 80;
    }

    @Override
    public void onCollision(List<Collider> colliders) {
        for (Collider collider : colliders) {
            if (collider instanceof Player) {
                this.isHit(((Player)collider));
            }
        }
    }

    @Override
    protected void isHit(Player player) {
        super.isHit(player);

        if (this.numberOfHearts < 1) {
            this.herocrawler.setActiveScene(3);
        }
    }

    @Override
    public void playSound() {
        var attackSound = new SoundClip("audio/raafattack.mp3");
        attackSound.play();
    }
}

package nl.han.herocrawler.entities.monsters;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.media.SoundClip;
import nl.han.herocrawler.entities.tiles.UnWalkableTile;

import java.util.List;

public class Skeleton extends Monster {

    public Skeleton(Coordinate2D initialLocation) {
        super("sprites/skeleton.png", initialLocation, new Size(32, 32));
        this.power = 1;
        this.accuracy = 80;
        this.speed = 0.75;
        this.walkingDirection = 180;

        setMotion(this.speed, this.walkingDirection);
    }

    @Override
    public void onCollision(List<Collider> colliders) {
        for (Collider collider : colliders) {
            if (collider instanceof UnWalkableTile) {
                this.walkingDirection = (this.walkingDirection + 180) % 360;
                setMotion(this.speed, this.walkingDirection);
            }
        }
    }

    @Override
    public void playSound() {
        var attackSound = new SoundClip("audio/skeleton-attack.mp3");
        attackSound.play();
    }
}

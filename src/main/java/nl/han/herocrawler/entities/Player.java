package nl.han.herocrawler.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import nl.han.herocrawler.Herocrawler;
import nl.han.herocrawler.entities.monsters.Monster;
import nl.han.herocrawler.entities.objects.Food;
import nl.han.herocrawler.entities.objects.potions.BluePotion;
import nl.han.herocrawler.entities.objects.potions.GreenPotion;
import nl.han.herocrawler.entities.objects.potions.Potion;
import nl.han.herocrawler.entities.objects.potions.RedPotion;
import nl.han.herocrawler.entities.tiles.StairsTile;
import nl.han.herocrawler.entities.tiles.UnWalkableTile;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class Player extends Entity implements KeyListener {
    private static final int HIT_CHANCE = 100;
    private static final int ARMOR_PROTECTION_VALUE = 13;

    private final Herocrawler herocrawler;
    private final Coordinate2D initialLocation;
    private int numberOfShields;
    private int level;


    public Player(Herocrawler herocrawler, Coordinate2D initialLocation) {
        super("sprites/player.png", initialLocation, new Size(32, 32));

        this.herocrawler = herocrawler;
        this.initialLocation = initialLocation;
        this.level = 1;
        this.power = 1;
        this.speed = 3.0;
        this.numberOfHearts = 5;
        this.numberOfShields = 1;
    }


    @Override
    public void onCollision(List<Collider> colliders) {
        for (Collider collider : colliders) {
            if (collider instanceof Entity) {
                ((Entity)collider).playSound();
            }

            if (collider instanceof UnWalkableTile) {
                this.stopMovement();
                continue;
            }

            if (collider instanceof StairsTile) {
                this.levelUp();
                continue;
            }

            if (collider instanceof Food) {
                if (this.numberOfHearts >= 5) continue;

                this.numberOfHearts += 1;

                ((Food)collider).remove();
                continue;
            }

            if (collider instanceof Potion) {
                if (collider instanceof RedPotion) {
                    if (this.numberOfHearts >= 5) continue;
                    if (this.numberOfHearts == 4) {
                        this.numberOfHearts += 1;
                    } else {
                        this.numberOfHearts += 2;
                    }

                    continue;
                }

                if (collider instanceof BluePotion) {
                    if (this.numberOfShields >= 3) continue;

                    this.numberOfShields += 1;

                    continue;
                }

                if (collider instanceof GreenPotion) {
                    this.speed *= 1.25;
                    continue;
                }

                ((Potion)collider).remove();
            }

            if (collider instanceof Monster) {
                this.monsterHit((Monster) collider);
                setAnchorLocation(this.initialLocation);
            }
        }
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> keyCodes) {
        if (keyCodes.isEmpty()) {
            setSpeed(0);
            return;
        }

        for (KeyCode keyCode : keyCodes) {
            switch (keyCode) {
                case KeyCode.SPACE:
                    break;
                case KeyCode.DIGIT1:
                    break;
                case KeyCode.W:
                case KeyCode.UP:
                    setMotion(this.speed, 180d);
                    break;
                case KeyCode.A:
                case KeyCode.LEFT:
                    setMotion(this.speed, 270d);
                    break;
                case KeyCode.S:
                case KeyCode.DOWN:
                    setMotion(this.speed, 0d);
                    break;
                case KeyCode.D:
                case KeyCode.RIGHT:
                    setMotion(this.speed, 90d);
                    break;
            }
        }
    }

    private void stopMovement() {
        final int direction = ((int)getDirection());
        setSpeed(0);

        switch (direction) {
            case 180:
                setAnchorLocationY(getAnchorLocation().getY() + this.speed);
                break;
            case 270:
                setAnchorLocationX(getAnchorLocation().getX() + this.speed);
                break;
            case 0:
                setAnchorLocationY(getAnchorLocation().getY() - this.speed);
                break;
            case 90:
                setAnchorLocationX(getAnchorLocation().getX() - this.speed);
                break;
        }
    }

    private void levelUp() {
        this.level += 1;
        this.herocrawler.setActiveScene(this.level);
    }

    private void monsterHit(Monster collider) {
        Random rand = new Random();

        // Calculate the chance bounds for lousing life
        final int chance = HIT_CHANCE + (ARMOR_PROTECTION_VALUE * this.level);
        final int result = rand.nextInt(chance);

        // Do nothing if the monster missed
        if (collider.getAccuracy() < result) return;

        // First remove shields before starting with the hearts
        if (this.numberOfShields > 0) {
            this.numberOfShields -= collider.getPower();

            // If too many shields are taken away, subtract from hearts
            if (this.numberOfShields < 0) {
                this.numberOfHearts += this.numberOfShields;
                this.numberOfShields = 0;
            }
        } else {
            this.numberOfHearts -= collider.getPower();
        }

        this.playSound();
    }

    @Override
    public void playSound() {
        var attackSound = new SoundClip("audio/human-attack.mp3");
        attackSound.play();
    }

    @Override
    public int getPower() {
        return this.power * this.level;
    }
}

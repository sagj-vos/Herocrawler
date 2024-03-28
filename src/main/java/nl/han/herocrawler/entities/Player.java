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
import nl.han.herocrawler.scenes.ui.HealthUI;
import nl.han.herocrawler.scenes.ui.hp.Health;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class Player extends Entity implements KeyListener {
    private static final int HIT_CHANCE = 100;
    private static final int ARMOR_PROTECTION_VALUE = 13;

    private final Herocrawler herocrawler;
    private final Coordinate2D initialLocation;
    private final HealthUI healthUI;
    private int numberOfShields;
    private int level;


    public Player(Herocrawler herocrawler, Coordinate2D initialLocation, HealthUI healthUI) {
        super("sprites/player.png", initialLocation, new Size(32, 32));

        this.herocrawler = herocrawler;
        this.initialLocation = initialLocation;
        this.healthUI = healthUI;
        this.level = 1;
        this.power = 1;
        this.speed = 1.0;
        this.numberOfHearts = 5;
        this.numberOfShields = 1;
    }

    public void resetPlayer() {
        this.level = 1;
        this.speed = 1.0;
        this.numberOfShields = 1;
        this.numberOfHearts = 5;

        setAnchorLocation(this.initialLocation);

        this.healthUI.updateHealth(this.numberOfHearts);
        this.healthUI.updateShield(this.numberOfShields);
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
                this.eatFood(((Food)collider));
                continue;
            }

            if (collider instanceof Potion) {
                this.drinkPotion(((Potion)collider));
            }

            if (collider instanceof Monster) {
                this.monsterHit((Monster) collider);
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
                    // code to attack monsters
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

    private void eatFood(Food food) {
        food.remove();

        if (this.numberOfHearts >= 5) return;

        this.numberOfHearts += 1;

        this.healthUI.updateHealth(this.numberOfHearts);
    }

    private void drinkPotion(Potion potion) {
        potion.remove();

        if (potion instanceof RedPotion) {
            if (this.numberOfHearts >= 5) return;
            if (this.numberOfHearts == 4) {
                this.numberOfHearts += 1;
            } else {
                this.numberOfHearts += 2;
            }

            this.healthUI.updateHealth(this.numberOfHearts);

            return;
        }

        if (potion instanceof BluePotion) {
            if (this.numberOfShields >= 3) return;

            this.numberOfShields += 1;

            this.healthUI.updateShield(this.numberOfShields);

            return;
        }

        if (potion instanceof GreenPotion) {
            this.speed *= 1.25;
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

        setAnchorLocation(this.initialLocation);

        this.herocrawler.setActiveScene(this.level);
    }

    private void monsterHit(Monster collider) {
        setAnchorLocation(this.initialLocation);

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

            this.healthUI.updateShield(this.numberOfShields);
        } else {
            this.numberOfHearts -= collider.getPower();
        }

        this.healthUI.updateHealth(this.numberOfHearts);

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
    public HealthUI getHealthUI() { return this.healthUI; }
}

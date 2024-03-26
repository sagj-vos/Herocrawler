package nl.han.herocrawler.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import nl.han.herocrawler.entities.monsters.Monster;
import nl.han.herocrawler.entities.tiles.UnWalkableTile;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class Player extends Entity implements KeyListener {
    private static final int HIT_CHANCE = 100;
    private static final int ARMOR_PROTECTION_VALUE = 13;
    private int numberOfShields;
    private int level;

    protected Player(Coordinate2D initialLocation) {
        super("sprites/player.png", initialLocation, new Size(32, 32), 1, 1);

        this.level = 1;
        this.power = 1;
        this.numberOfHearts = 5;
        this.numberOfShields = 1;
    }


    @Override
    public void onCollision(List<Collider> list) {
        for (Collider collider : list) {
            if (collider instanceof UnWalkableTile) {
                final int direction = ((int)getDirection());
                setSpeed(0);

                switch (direction) {
                    case 180:
                        setAnchorLocationY(getAnchorLocation().getY() + 1);
                        break;
                    case 270:
                        setAnchorLocationX(getAnchorLocation().getX() + 1);
                        break;
                    case 0:
                        setAnchorLocationY(getAnchorLocation().getY() - 1);
                        break;
                    case 90:
                        setAnchorLocationX(getAnchorLocation().getX() - 1);
                        break;
                }
                continue;
            }

            if (collider instanceof Monster) {
                this.monsterHit((Monster) collider);
                continue;
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
                    setMotion(1, 180d);
                    break;
                case KeyCode.A:
                case KeyCode.LEFT:
                    setMotion(1, 270d);
                    break;
                case KeyCode.S:
                case KeyCode.DOWN:
                    setMotion(1, 0d);
                    break;
                case KeyCode.D:
                case KeyCode.RIGHT:
                    setMotion(1, 90d);
                    break;
            }
        }
    }

    private void monsterHit(Monster collider) {
        Random rand = new Random();

        // Calculate the chance bounds for lousing life
        final int chance = HIT_CHANCE + (ARMOR_PROTECTION_VALUE * this.level);
        final int result = rand.nextInt(chance);

        // Do nothing if the monster missed
        if (collider.getAccuracy() > result) return;

        // First remove shields before starting with the hearts
        if (this.numberOfShields > 0) {
            this.numberOfShields -= collider.getPower();

            //
            if (this.numberOfShields < 0) {
                this.numberOfHearts += this.numberOfShields;
                this.numberOfShields = 0;
            }
        } else {
            this.numberOfHearts -= collider.getPower();
        }
    }
}

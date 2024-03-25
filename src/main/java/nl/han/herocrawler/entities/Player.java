package nl.han.herocrawler.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import nl.han.herocrawler.entities.monsters.Monster;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class Player extends Entity implements KeyListener {
    private static final int HIT_CHANCE = 100;
    private static final int ARMOR_PROTECTION_VALUE = 13;
    private int numberOfShields;
    private int level;

    protected Player(String resource, Coordinate2D initialLocation, Size size, int rows, int columns) {
        super(resource, initialLocation, size, rows, columns);

        this.level = 1;
        this.power = 1;
        this.numberOfHearts = 5;
        this.numberOfShields = 1;
    }


    @Override
    public void onCollision(List<Collider> list) {
        for (Collider collider : list) {
            if (collider instanceof Monster) {
                this.monsterHit((Monster) collider);
                continue;
            }
        }
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> set) {
        if (set.contains(KeyCode.SPACE)) {

        } else if (set.contains(KeyCode.DIGIT1)) {

        } else if (set.contains(KeyCode.W) || set.contains(KeyCode.UP)) {

        } else if (set.contains(KeyCode.A) || set.contains(KeyCode.LEFT)) {

        } else if (set.contains(KeyCode.S) || set.contains(KeyCode.DOWN)) {

        } else if (set.contains(KeyCode.D) || set.contains(KeyCode.RIGHT)) {

        } else if (set.isEmpty()) {

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

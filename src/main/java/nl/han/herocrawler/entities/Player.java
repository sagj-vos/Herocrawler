package nl.han.herocrawler.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Set;

public class Player extends Entity implements KeyListener {
    private int numberOfShields;
    private int armorProtectionValue;

    protected Player(String resource, Coordinate2D initialLocation, Size size, int rows, int columns) {
        super(resource, initialLocation, size, rows, columns);
    }


    @Override
    public void onCollision(List<Collider> list) {

    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> set) {

    }
}

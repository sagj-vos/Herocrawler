package nl.han.herocrawler.entities.objects;

import com.github.hanyaeger.api.Coordinate2D;

public class SecretButton extends PickupObject {
    public SecretButton(Coordinate2D initialLocation) {
        super("objects/secret-button.png", initialLocation);
    }

    @Override
    public void playSound() {

    }
}
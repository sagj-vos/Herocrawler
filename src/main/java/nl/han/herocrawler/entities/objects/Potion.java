package nl.han.herocrawler.entities.objects;

import com.github.hanyaeger.api.Coordinate2D;

public class Potion extends PickupObject {
    protected Potion(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }
}

package nl.han.herocrawler.entities.objects;

import com.github.hanyaeger.api.Coordinate2D;

public class Food extends PickupObject {
    public Food(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }
}

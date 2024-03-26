package nl.han.herocrawler.entities.objects.potions;

import com.github.hanyaeger.api.Coordinate2D;
import nl.han.herocrawler.entities.objects.PickupObject;

public class Potion extends PickupObject {
    protected Potion(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }
}

package nl.han.herocrawler.scenes.ui;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.CompositeEntity;
import nl.han.herocrawler.scenes.ui.hp.Health;
import nl.han.herocrawler.scenes.ui.hp.Heart;
import nl.han.herocrawler.scenes.ui.hp.Shield;

public class HealthUI extends CompositeEntity {
    private static final int ICON_SIZE = 64;
    private static final int HEART_INITIAL_LOCATION_X = 0;
    private static final int SHIELD_INITIAL_LOCATION_X = 320;
    private static final int ICONS_INITIAL_LOCATION_Y = 0;

    private final Heart[] heartEntities;
    private final Shield[] shieldEntities;

    public HealthUI(Coordinate2D initialLocation) {
        super(initialLocation);
        this.heartEntities = new Heart[5];
        this.shieldEntities = new Shield[3];
    }

    @Override
    protected void setupEntities() {
        for (int heart = 0; heart < 5; heart++) {
            var heartEntity = new Heart(new Coordinate2D(
                    HEART_INITIAL_LOCATION_X + (heart * ICON_SIZE),
                    ICONS_INITIAL_LOCATION_Y
            ));

            this.heartEntities[heart] = heartEntity;
            addEntity(heartEntity);
        }

        for (int shield = 0; shield < 3; shield++) {
            var shieldEntity = new Shield(new Coordinate2D(
                    SHIELD_INITIAL_LOCATION_X + (shield * ICON_SIZE),
                    ICONS_INITIAL_LOCATION_Y
            ));

            this.shieldEntities[shield] = shieldEntity;
        }
        addEntity(this.shieldEntities[0]);

    }

    public void updateHealth(int hearts) {
        this.updateUI(this.heartEntities, hearts);
    }

    public void updateShield(int shields) {
        this.updateUI(this.shieldEntities, shields);
    }

    private void updateUI(Health[] healthEntities, int amount) {
        for (int health = 0; health < healthEntities.length; health++) {
            if (health < amount) {
                healthEntities[health].setOpacity(1);
            } else {
                healthEntities[health].setOpacity(0);
            }
        }
    }
}

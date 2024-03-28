package nl.han.herocrawler.scenes.ui;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.CompositeEntity;
import nl.han.herocrawler.scenes.ui.hp.Heart;
import nl.han.herocrawler.scenes.ui.hp.Shield;

public class HpUi extends CompositeEntity {
    public HpUi(Coordinate2D initialLocation) {
        super(initialLocation);
    }

    @Override
    protected void setupEntities() {
        for (int i = 0; i < 5; i++) {
            addEntity(new Heart(new Coordinate2D(i * 64, 0)));
        }
        addEntity(new Shield(new Coordinate2D(320, 0)));
    }

    public void updateHpUi(int hearts, int shields) {

    }
}

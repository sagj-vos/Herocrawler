package nl.han.herocrawler.scenes.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.han.herocrawler.Herocrawler;

public abstract class Button extends CompositeEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

    private static final double BUTTON_WIDTH = 300;
    private static final double BUTTON_HEIGHT = 80;
    protected String text;

    protected Herocrawler herocrawler;
    protected Button(Coordinate2D initialLocation, String text, Herocrawler herocrawler) {
        super(initialLocation);
        this.text = text;
        this.herocrawler = herocrawler;
    }

    @Override
    protected void setupEntities() {
        var container = new ButtonContainer(new Coordinate2D(getHeight() / 2 - (BUTTON_WIDTH / 2),
                getHeight() / 2 - (BUTTON_HEIGHT / 2)),
                BUTTON_WIDTH, BUTTON_HEIGHT);
        addEntity(container);
        var buttonText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 4),
                this.text
        );
        buttonText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        buttonText.setFill(Color.WHITE);
        buttonText.setFont(Font.font("Roboto", FontWeight.NORMAL, 60));
        addEntity(buttonText);
    }
    @Override
    public void onMouseEntered(){
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited(){
        setCursor(Cursor.DEFAULT);
    }
}

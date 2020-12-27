package ui.movable_drawables;

import model.game_building.Configuration;
import model.game_building.GameConstants;
import model.game_entities.Powerup;
import utils.Coordinates;
import utils.MathUtils;

import java.awt.*;


/**
 * This class is responsible for drawing a Powerup given a Powerup entity in the constructor
 */
public class PowerupDrawer implements Drawable {

    private final Powerup powerup;
    private final int radius;
    private final Image powerupImage;

    public PowerupDrawer(Powerup powerup) {
        this.powerup = powerup;
        this.radius = (int) (Configuration.getInstance().getUnitL() * GameConstants.POWERUP_RADIUS);
        this.powerupImage = ImageResources.get(powerup.getType(), powerup.getSuperType(),null, 2 * radius, 2 * radius);
    }

    @Override
    public void draw(Graphics g) {
        Coordinates drawingCoord = MathUtils.drawingCoordinates(powerup.getCoordinates(), radius);
        g.drawImage(powerupImage, drawingCoord.getPoint().x, drawingCoord.getPoint().y, null);
    }
}

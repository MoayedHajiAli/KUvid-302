package ui.movable_drawables;

import model.game_building.Configuration;
import model.game_entities.Blocker;
import model.game_running.GameConstants;
import utils.Coordinates;
import utils.MathUtils;

import java.awt.*;

public class BlockerDrawer implements Drawable {

    private final Blocker blocker;
    private final int radius;
    private Image blockerImage;

    public BlockerDrawer(Blocker blocker) {
        this.blocker = blocker;
        this.radius = (int) (Configuration.getInstance().getUnitL() * GameConstants.BLOCKER_DIAMETER);
        this.blockerImage = ImageResources.get(blocker.getType(), blocker.getSuperType(), radius, radius);
    }

    @Override
    public void draw(Graphics g) {

        Coordinates drawingCoord = MathUtils.drawingCoordinates(blocker.getCoordinates(), radius);
        g.drawImage(blockerImage, drawingCoord.getPoint().x, drawingCoord.getPoint().y, null);
    }
}

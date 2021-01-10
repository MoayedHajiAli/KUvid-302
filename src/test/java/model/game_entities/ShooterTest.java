package model.game_entities;

import model.game_entities.enums.EntityType;
import model.game_entities.enums.SuperType;
import model.game_running.ProjectileContainer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShooterTest {

    @Test
    void switchAtom() {

        ProjectileContainer container = new ProjectileContainer(null, 10, 10, 10, 10, 1, 1, 1, 1);
        Shooter shooter = new Shooter(container);

        // testing when the current projectile is powerup. in this case , when we call switchAtom(), the current projectile set to atom.
        shooter.setCurrentProjectile(container.getPowerUp(shooter.getCoordinates(), EntityType.ALPHA));

        Projectile current = shooter.getCurrentProjectile();
        shooter.switchAtom();
        Projectile switched = shooter.getCurrentProjectile();

        assertEquals(switched.getSuperType(), SuperType.ATOM);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////

        // testing when the projectile container is empty. in this case , when we call switchAtom(), the current projectile is null.
        // this is unreachable case since we end the game if the container is empty, but we assure that it gives null values.
        container = new ProjectileContainer(null, 0, 0, 0, 0, 1, 0, 0, 0);
        shooter = new Shooter(container);


        current = shooter.getCurrentProjectile();
        shooter.switchAtom();
        switched = shooter.getCurrentProjectile();

        assertEquals(current, null);
        assertEquals(switched, null);


    }
}
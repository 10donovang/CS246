package prove02;

import java.awt.*;

/**
 * Created by darkwarriordono on 4/29/17.
 */

    public class ManEater extends Creature implements Aggressor{

        /**
         * Creates a plant with 1 health point.
         */
        public ManEater() {
            _health = 1;
        }

        // No javadocs are necessary for these methods because they will inherit the
        // documentation from the superclass. We only need to add docs here if we are
        // doing something non-obvious in our overridden version.

        public void attack(Creature target) {
            // Animals only eat plants. Give the plant 1 damage
            // and increase our health by one.
            if (target instanceof Zombie || target instanceof Man) {
                target.takeDamage(1);
                _health++;
            }
        }

        public Shape getShape() {
            return Shape.Circle;
        }

        public Color getColor() {
            return new Color(0, 0, 0);
        }

        public Boolean isAlive() {
            return _health > 0;
        }
    }


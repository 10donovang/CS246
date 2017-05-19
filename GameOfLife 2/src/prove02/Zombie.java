package prove02;


import java.awt.Color;



/**
 * Created by darkwarriordono on 4/28/17.
 */
public class Zombie extends Creature implements Movable, Aggressor{

    public Zombie() {
        _health = 1;

    }
    public void move() {
        _location.x++;
    }
    public void attack(Creature target) {
        // Animals only eat plants. Give the plant 1 damage
        // and increase our health by one.
        if (target instanceof Animal || target instanceof Wolf || target instanceof Man) {
            target.takeDamage(10);
            _health++;
        }
    }
    public Shape getShape() {
        return Shape.Square;
    }

    public Color getColor() {
        return new Color(0, 0, 135);
    }

    public Boolean isAlive() {
        return _health > 0;
    }
}


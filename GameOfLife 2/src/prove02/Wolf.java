package prove02;

import java.awt.*;
import java.util.Random;

/**
 * Created by darkwarriordono on 4/28/17.
 */
public class Wolf extends Creature implements Movable, Aggressor, Aware, Spawner{
    Random _rand = new Random();
    int loc;

    public Wolf() {
        _health = 1;
        loc = _rand.nextInt(4);



    }

    public void move() {
        switch(loc) {
            case 0:
                _location.x++;
                break;
            case 1:
                _location.x--;
                break;
            case 2:
                _location.y++;
                break;
            case 3:
                _location.y--;
                break;
            default:
                break;
        }
    }

    public void senseNeighbors(Creature above, Creature below, Creature left, Creature right){
        boolean r = false;
        boolean l = false;
        boolean a = false;
        boolean b = false;

        if(right instanceof Animal || right instanceof Man) {
            r = right.isAlive();
        }
        if (left instanceof Animal || left instanceof Man) {
            l = left.isAlive();
        }
        if (above instanceof Animal || above instanceof Man) {
            a = above.isAlive();
        }
        if (below instanceof Animal || below instanceof Man) {
            b = below.isAlive();
        }

        switch(loc){
            case 0:
                if(r){
                    loc = 0;
                    break;
                }
                else if(a){
                    loc = 3;
                    break;
                }
                else if(b) {
                    loc = 2;
                    break;
                }
                else if(l) {
                    loc = 1;
                    break;
                }

            case 1:
                if(l){
                    loc = 1;
                    break;
                }
                else if(a){
                    loc = 3;
                    break;
                }
                else if(r) {
                    loc = 0;
                    break;
                }
                else if(b) {
                    loc = 2;
                    break;
                }
            case 2:
                if(b){
                    loc = 2;
                    break;
                }
                else if(a){
                    loc = 3;
                    break;
                }
                else if(r) {
                    loc = 0;
                    break;
                }
                else if(l) {
                    loc = 1;
                    break;
                }
            case 3:
                if(a){
                    loc = 3;
                    break;
                }
                else if(r){
                    loc = 0;
                    break;
                }
                else if(b) {
                    loc = 2;
                    break;
                }
                else if(l) {
                    loc = 1;
                    break;
                }
            default:
                if(!(r) && !(l) && !(a) && !(b)){
                    break;
                }
                else{
                    loc = 0;
                }
        }


    }

    public void attack(Creature target) {

        if (target instanceof Animal || target instanceof Man) {
            target.takeDamage(5);
            _health++;
        }
    }
    public Shape getShape() {
        return Shape.Square;
    }

    public Color getColor() {
        return new Color(128, 128, 128);
    }

    public Boolean isAlive() {
        return _health > 0;
    }



    public Creature spawnNewCreature() {
        return new Wolf();
    }
}
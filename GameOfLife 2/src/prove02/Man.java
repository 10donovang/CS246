package prove02;

import java.awt.*;
import java.util.Random;

/**
 * Created by darkwarriordono on 4/29/17.
 */
public class Man extends Creature implements Movable, Aware {
    Random _rand = new Random();
    int loc;
    public Man() {
        _health = 10;
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

        if(right instanceof Animal || right instanceof Wolf || right instanceof Zombie) {
            r = right.isAlive();
        }
        if (left instanceof Animal || left instanceof Wolf || left instanceof Zombie) {
            l = left.isAlive();
        }
        if (above instanceof Animal || above instanceof Wolf || above instanceof Zombie) {
            a = above.isAlive();
        }
        if (below instanceof Animal || below instanceof Wolf || below instanceof Zombie) {
            b = below.isAlive();
        }

        switch(loc){
            case 0:
                if(r){
                    loc = 1;
                    break;
                }
                else if(a){
                    loc = 2;
                    break;
                }
                else if(b) {
                    loc = 3;
                    break;
                }
                else if(l) {
                    loc = 0;
                    break;
                }

            case 1:
                if(l){
                    loc = 0;
                    break;
                }
                else if(a){
                    loc = 2;
                    break;
                }
                else if(r) {
                    loc = 1;
                    break;
                }
                else if(b) {
                    loc = 3;
                    break;
                }
            case 2:
                if(b){
                    loc = 3;
                    break;
                }
                else if(a){
                    loc = 2;
                    break;
                }
                else if(r) {
                    loc = 1;
                    break;
                }
                else if(l) {
                    loc = 0;
                    break;
                }
            case 3:
                if(a){
                    loc = 2;
                    break;
                }
                else if(r){
                    loc = 1;
                    break;
                }
                else if(b) {
                    loc = 3;
                    break;
                }
                else if(l) {
                    loc = 0;
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

    public Shape getShape() {
        return Shape.Square;
    }

    public Color getColor() {
        return new Color(0, 0, 0);
    }

    public Boolean isAlive() {
        return _health > 0;
    }
}

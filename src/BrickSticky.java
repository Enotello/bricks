//package bricks;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.concurrent.TimeUnit;

class BrickSticky extends Brick {
    public BrickSticky(
            PlayField pf,
            BrickPile bp,
            Rectangle p,
            Image img){
        super(pf, bp, img, p);
        _bp = bp;
    }
    public void hitBy(Puck p) {
        _isDead = false;
        p.getVelocity().sticky();
        p._isMoving = false;
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        p._isMoving = true;
                    }
                },
                2000
        );
        if (_bp.unbrokenCount() == 10) {
            _pf.getMatch().win();
        }
    }
}

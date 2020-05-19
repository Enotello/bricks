//package bricks;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

public class BrickPile extends ArrayList{
	private PlayField _pf;
	private ArrayList _bricks;
	private final int _rows = 4;
	private final int _cols = 10;

	public BrickPile(PlayField pf, Image img1, Image img2, Image img3) {
		_pf = pf;
		_bricks = new ArrayList<>();
		int startx = 80;
		int x = startx, y = 10;

		for (int r = 0; r < _rows; r++) {
			for (int c = 0; c < _cols; c++) {
				Rectangle pos = new Rectangle(x, y, img1.getWidth(null), img1.getHeight(null));
				if (r == 1){
					Brick s = new HardBrick(_pf, this, pos, img2, img1);
					pf.addSprite(s);
					_bricks.add(s);
					x += img2.getWidth(null);
				}
				else if (r == 0){
					Brick h = new BrickSticky(_pf, this, pos, img3);
					pf.addSprite(h);
					_bricks.add(h);
					x += img3.getWidth(null);
				}
				else {
					Brick b = new Brick(_pf, this, img1, pos);
					pf.addSprite(b);
					_bricks.add(b);
					x += img1.getWidth(null);
				}
			}
			y += img1.getHeight(null) + 2;
			x = startx;
		}
	}


	public int unbrokenCount() {
		int result = 0;

		for (int i = 0; i < _bricks.size(); i++) {
			if ( !((Brick) _bricks.get(i)).isDead() )
				result++;
		}

		return result;
	}

	public int brokenCount() {
		return _bricks.size() - unbrokenCount();
	}
}

//package bricks;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

public class BrickPile {
    private PlayField _pf;
    private ArrayList _bricks;
    private final int _rows = 4; //строки
    private final int _cols = 10; //столбики

    public BrickPile(PlayField pf,Image img, Image img1) {
        _pf = pf;
        _bricks = new ArrayList();
        //_bricks1 = new ArrayList();
        int startx = 80;
        int x = startx, y = 10;

        for (int r = 0; r < _rows; r++) {
            for (int c = 0; c < _cols; c++) {
                Rectangle pos = new Rectangle(x, y, img.getWidth(null), img.getHeight(null));


                Brick b = new Brick(_pf, this, img, pos);
                pf.addSprite(b);
                _bricks.add(b);

                x += img.getWidth(null);
            }

            y += img.getHeight(null) + 2;
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

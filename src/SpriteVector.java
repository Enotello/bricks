//package bricks;

import java.awt.Graphics;
import java.util.ArrayList;

/* Множество всех спрайтов находящихся на игровом поле.
 * Выделен в отдельный класс для "разгрузки" 
 * игрового поля.
 */

class SpriteVector extends ArrayList {
	public void draw(Graphics g) {
		for (int i = 0; i < size(); i++)
			((Sprite) get(i)).draw(g);
	}
	
	/* Проверка коллизии */
	public Sprite testCollision(Sprite test) {
		for (int i = 0; i < size(); i++) {
			Sprite s = (Sprite) get(i);
		
			if (test == s)
				continue;
		
			if (test.testCollision(s))
				return s;
		}
		
		return null;
	}
	
	/* Обновить состояние всех спрайтов */ 
	public void update() {
		for (int i = 0; i < size(); i++) {
			Sprite s = (Sprite) get(i);
      
			s.update();

			if (s.isDead()) {
				remove(i);
				continue;
			}
		}
	}
}

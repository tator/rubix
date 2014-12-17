package rubix;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class gui extends JPanel implements MouseListener, MouseMotionListener,
		KeyListener {
	int v;
	cube cube;
	int x1, x2, y1, y2;

	public gui() {
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		setFocusable(true);
		requestFocusInWindow();
		cube = new cube();
		// cube.mix();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		v = Math.min(getSize().height, getSize().width);

		setBackground(Color.gray);
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		for (int w = 0; w < 3; w++) {
			for (int e = 0; e < 3; e++) {
				g.setColor(cube.cube[2][e][2 - w].back);
				g.fillRect(v / 12 * e + v / 4, v / 12 * w + v / 4, v / 12,
						v / 12);
			}
		}

		for (int w = 0; w < 3; w++) {
			for (int e = 0; e <= 3; e++) {
				for (int q = 0; q < 3; q++) {
					switch (e) {
					case 0:
						g.setColor(cube.cube[2 - w][0][2 - q].left);
						g.fillRect(v / 12 * q, v / 12 * w + 2 * v / 4, v / 12,
								v / 12);
						break;
					case 1:
						g.setColor(cube.cube[2 - w][q][0].top);
						g.fillRect(v / 12 * q + v / 4, v / 12 * w + 2 * v / 4,
								v / 12, v / 12);
						break;
					case 2:
						g.setColor(cube.cube[2 - w][2][q].right);
						g.fillRect(v / 12 * q + 2 * v / 4, v / 12 * w + 2 * v
								/ 4, v / 12, v / 12);
						break;
					case 3:
						g.setColor(cube.cube[2 - w][2 - q][2].under);
						g.fillRect(v / 12 * q + 3 * v / 4, v / 12 * w + 2 * v
								/ 4, v / 12, v / 12);
						break;
					}
				}
			}
		}
		for (int w = 0; w < 3; w++) {
			for (int e = 0; e < 3; e++) {
				g.setColor(cube.cube[0][e][w].front);
				g.fillRect(v / 12 * e + v / 4, v / 12 * w + 3 * v / 4, v / 12,
						v / 12);
			}
		}
	}

	private void move() {
		if ((v / 2 <= y1 && y1 <= (v / 2 + v / 12))
				&& (v / 2 <= y2 && y2 <= (v / 2 + v / 12))) {
			if (x1 > x2) {
				cube.backRotateClock();
			} else if (x1 < x2) {
				cube.backRotateCounter();
			}
		} else if (((3 * v / 4 - v / 12) <= y1 && y1 <= 3 * v / 4)
				&& ((3 * v / 4 - v / 12) <= y2 && y2 <= 3 * v / 4)) {
			if (x1 > x2) {
				cube.frontRotateCounter();
			} else if (x1 < x2) {
				cube.frontRotateClock();
			}
		} else if ((v / 4 <= x1 && x1 <= (v / 4 + v / 12))
				&& (v / 4 <= x2 && x2 <= (v / 4 + v / 12))
				|| (v - v / 12 <= x1 && x1 <= (v))
				&& (v - v / 12 <= x2 && x2 <= (v))) {
			if ((v - v / 12 <= x1 && x1 <= (v))
					&& (v - v / 12 <= x2 && x2 <= (v))) {
				int t = y1;
				y1 = y2;
				y2 = t;
			}
			if (y1 > y2) {
				cube.leftRotateCounter();
			} else if (y1 < y2) {
				cube.leftRotateClock();
			}
		} else if (((v / 2 - v / 12) <= x1 && x1 <= v / 2)
				&& ((v / 2 - v / 12) <= x2 && x2 <= v / 2)
				|| (3 * v / 4 <= x1 && x1 <= (3 * v / 4 + v / 12))
				&& (3 * v / 4 <= x2 && x2 <= (3 * v / 4 + v / 12))) {
			if ((3 * v / 4 <= x1 && x1 <= (3 * v / 4 + v / 12))
					&& (3 * v / 4 <= x2 && x2 <= (3 * v / 4 + v / 12))) {
				int t = y1;
				y1 = y2;
				y2 = t;
			}
			if (y1 > y2) {
				cube.rightRotateClock();
			} else if (y1 < y2) {
				cube.rightRotateCounter();
			}
		} else if (((v / 4 - v / 12) <= x1 && x1 <= v / 4)
				&& ((v / 4 - v / 12) <= x2 && x2 <= v / 4)
				|| (v / 2 <= x1 && x1 <= (v / 2 + v / 12))
				&& (v / 2 <= x2 && x2 <= (v / 2 + v / 12))) {
			if ((v / 2 <= x1 && x1 <= (v / 2 + v / 12))
					&& (v / 2 <= x2 && x2 <= (v / 2 + v / 12))) {
				int t = y1;
				y1 = y2;
				y2 = t;
			}
			if (y1 > y2) {
				cube.topRotateClock();
			} else if (y1 < y2) {
				cube.topRotateCounter();
			}
		} else if (((v / 2 - v / 12) <= y1 && y1 <= v / 2)
				&& ((v / 2 - v / 12) <= y2 && y2 <= v / 2)
				|| (3 * v / 4 <= y1 && y1 <= (3 * v / 4 + v / 12))
				&& (3 * v / 4 <= y2 && y2 <= (3 * v / 4 + v / 12))) {
			if ((3 * v / 4 <= y1 && y1 <= (3 * v / 4 + v / 12))
					&& (3 * v / 4 <= y2 && y2 <= (3 * v / 4 + v / 12))) {
				int t = x1;
				x1 = x2;
				x2 = t;
			}
			if (x1 > x2) {
				cube.topRotateCounter();
			} else if (x1 < x2) {
				cube.topRotateClock();
			}
		} else if ((0 <= x1 && x1 <= v / 12) && (0 <= x2 && x2 <= v / 12)
				|| (3 * v / 4-v/12 <= x1 && x1 <= 3 * v / 4 )
				&& (3 * v / 4-v/12 <= x2 && x2 <= 3 * v / 4 )) {
			if ((3 * v / 4-v/12 <= x1 && x1 <= 3 * v / 4 )
					&& (3 * v / 4-v/12 <= x2 && x2 <= 3 * v / 4 )) {
				int t = y1;
				y1 = y2;
				y2 = t;
			}
			if (y1 > y2) {
				cube.underRotateCounter();
			} else if (y1 < y2) {
				cube.underRotateClock();
			}
		} else if (((v / 4 ) <= y1 && y1 <= v / 4+v/12)
				&& ((v / 4) <= y2 && y2 <= v / 4+v/12)
				|| (v-v/12 <= y1 && y1 <= v)
				&& (v-v/12 <= y2 && y2 <= v )) {
			if ((v-v/12 <= y1 && y1 <= v)
					&& (v-v/12 <= y2 && y2 <= v )) {
				int t = x1;
				x1 = x2;
				x2 = t;
			}
			if (x1 > x2) {
				cube.underRotateClock();
			} else if (x1 < x2) {
				cube.underRotateCounter();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		cube.mix();
		repaint();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();
		move();
		repaint();
	}

}

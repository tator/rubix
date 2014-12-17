package rubix;

import java.awt.Color;

public class cube {
	piece[][][] cube;

	public cube() {
		cube = new piece[3][3][3];
		set();
	}

	public void set() {
		// z x y back,left,top ,righ,unde,fron
		cube[0][0][0] = new piece(null, Color.BLUE, Color.white, null, null,
				Color.RED);
		cube[1][0][0] = new piece(null, Color.BLUE, Color.white, null, null,
				null);
		cube[2][0][0] = new piece(Color.ORANGE.darker(), Color.BLUE, Color.white, null,
				null, null);
		cube[0][1][0] = new piece(null, null, Color.white, null, null,
				Color.red);
		cube[1][1][0] = new piece(null, null, Color.white, null, null, null);
		cube[2][1][0] = new piece(Color.ORANGE.darker(), null, Color.white, null, null,
				null);
		cube[0][2][0] = new piece(null, null, Color.white, Color.GREEN, null,
				Color.red);
		cube[1][2][0] = new piece(null, null, Color.white, Color.GREEN, null,
				null);
		cube[2][2][0] = new piece(Color.ORANGE.darker(), null, Color.white, Color.GREEN,
				null, null);
		cube[0][0][1] = new piece(null, Color.blue, null, null, null, Color.red);
		cube[1][0][1] = new piece(null, Color.blue, null, null, null, null);
		cube[2][0][1] = new piece(Color.ORANGE.darker(), Color.blue, null, null, null,
				null);
		cube[0][1][1] = new piece(null, null, null, null, null, Color.red);
		cube[1][1][1] = new piece(null, null, null, null, null, null);
		cube[2][1][1] = new piece(Color.ORANGE.darker(), null, null, null, null, null);
		cube[0][2][1] = new piece(null, null, null, Color.GREEN, null,
				Color.RED);
		cube[1][2][1] = new piece(null, null, null, Color.GREEN, null, null);
		cube[2][2][1] = new piece(Color.ORANGE.darker(), null, null, Color.green, null,
				null);
		cube[0][0][2] = new piece(null, Color.blue, null, null, Color.yellow,
				Color.red);
		cube[1][0][2] = new piece(null, Color.blue, null, null, Color.yellow,
				null);
		cube[2][0][2] = new piece(Color.ORANGE.darker(), Color.blue, null, null,
				Color.yellow, null);
		cube[0][1][2] = new piece(null, null, null, null, Color.yellow,
				Color.red);
		cube[1][1][2] = new piece(null, null, null, null, Color.yellow, null);
		cube[2][1][2] = new piece(Color.ORANGE.darker(), null, null, null, Color.yellow,
				null);
		cube[0][2][2] = new piece(null, null, null, Color.GREEN, Color.yellow,
				Color.RED);
		cube[1][2][2] = new piece(null, null, null, Color.green, Color.yellow,
				null);
		cube[2][2][2] = new piece(Color.ORANGE.darker(), null, null, Color.green,
				Color.yellow, null);
	}

	public void print() {
		for (int w = 0; w < 3; w++) {
			System.out.print("\t\t\t");
			for (int e = 0; e < 3; e++) {
				System.out.print("2" + e + (2 - w) + ""
						+ cube[2][e][2 - w].sback + "\t");
			}
			System.out.println();
		}

		for (int w = 0; w < 3; w++) {
			for (int e = 0; e <= 3; e++) {
				for (int q = 0; q < 3; q++) {
					switch (e) {
					case 0:
						System.out.print("" + (2 - w) + 0 + (2 - q) + ""
								+ cube[2 - w][0][2 - q].sleft + "\t");
						break;
					case 1:
						System.out.print("" + (2 - w) + q + 0 + ""
								+ cube[2 - w][q][0].stop + "\t");
						break;
					case 2:
						System.out.print("" + (2 - w) + 2 + (q) + ""
								+ cube[2 - w][2][q].sright + "\t");
						break;
					case 3:
						System.out.print("" + (2 - w) + (2 - q) + (2) + ""
								+ cube[2 - w][2 - q][2].sunder + "\t");
						break;
					}
				}
			}
			System.out.println();
		}
		for (int w = 0; w < 3; w++) {
			System.out.print("\t\t\t");
			for (int e = 0; e < 3; e++) {
				System.out.print("" + (0) + e + (w) + "" + cube[0][e][w].sfront
						+ "\t");
			}
			System.out.println();
		}

	}

	public void mix() {
		for (int a = 0; a < 1000; a++) {
			switch ((int) (Math.random() * 12)) {
			case 0:
				//good
				this.backRotateClock();
				break;
			case 1:
				//good
				this.underRotateClock();
				break;
			case 2:
				//good
				this.underRotateCounter();
				break;
			case 3:
				//good
				this.backRotateCounter();
				break;
			case 4:
				//good
				this.leftRotateClock();
				break;
			case 5:
				//good
				this.leftRotateCounter();
				break;
			case 6:
				//good
				this.topRotateClock();
				break;
			case 7:
				// good
				this.topRotateCounter();
				break;
			case 8:
				//good
				this.rightRotateClock();
				break;
			case 9:
				///good
				this.rightRotateCounter();
				break;
			case 10:
				//good
				this.frontRotateClock();
				break;
			case 11:
				//good
				this.frontRotateCounter();
				break;
			}
		}
	}

	public void backRotateCounter() {
		piece temp = cube[2][0][0];
		cube[2][0][0].rollRight();
		cube[2][0][0] = cube[2][0][2];
		cube[2][0][2].rollRight();
		cube[2][0][2] = cube[2][2][2];
		cube[2][2][2].rollRight();
		cube[2][2][2] = cube[2][2][0];
		cube[2][2][0].rollRight();
		cube[2][2][0] = temp;
		temp = cube[2][1][0];
		cube[2][1][0].rollRight();
		cube[2][1][0] = cube[2][0][1];
		cube[2][0][1].rollRight();
		cube[2][0][1] = cube[2][1][2];
		cube[2][1][2].rollRight();
		cube[2][1][2] = cube[2][2][1];
		cube[2][2][1].rollRight();
		cube[2][2][1] = temp;
	}

	public void backRotateClock() {
		piece temp = cube[2][0][0];
		cube[2][0][0].rollLeft();
		cube[2][0][0] = cube[2][2][0];
		cube[2][2][0].rollLeft();
		cube[2][2][0] = cube[2][2][2];
		cube[2][2][2].rollLeft();
		cube[2][2][2] = cube[2][0][2];
		cube[2][0][2].rollLeft();
		cube[2][0][2] = temp;
		temp = cube[2][1][0];
		cube[2][1][0].rollLeft();
		cube[2][1][0] = cube[2][2][1];
		cube[2][2][1].rollLeft();
		cube[2][2][1] = cube[2][1][2];
		cube[2][1][2].rollLeft();
		cube[2][1][2] = cube[2][0][1];
		cube[2][0][1].rollLeft();
		cube[2][0][1] = temp;
	}

	public void leftRotateCounter() {
		piece temp = cube[0][0][0];
		cube[0][0][0].rotateUp();
		cube[0][0][0] = cube[0][0][2];
		cube[0][0][2].rotateUp();
		cube[0][0][2] = cube[2][0][2];
		cube[2][0][2].rotateUp();
		cube[2][0][2] = cube[2][0][0];
		cube[2][0][0].rotateUp();
		cube[2][0][0] = temp;
		temp = cube[1][0][0];
		cube[1][0][0].rotateUp();
		cube[1][0][0] = cube[0][0][1];
		cube[0][0][1].rotateUp();
		cube[0][0][1] = cube[1][0][2];
		cube[1][0][2].rotateUp();
		cube[1][0][2] = cube[2][0][1];
		cube[2][0][1].rotateUp();
		cube[2][0][1] = temp;
	}

	public void leftRotateClock() {
		piece temp = cube[0][0][0];
		cube[0][0][0].rotateDown();
		cube[0][0][0] = cube[2][0][0];
		cube[2][0][0].rotateDown();
		cube[2][0][0] = cube[2][0][2];
		cube[2][0][2].rotateDown();
		cube[2][0][2] = cube[0][0][2];
		cube[0][0][2].rotateDown();
		cube[0][0][2] = temp;
		temp = cube[1][0][0];
		cube[1][0][0].rotateDown();
		cube[1][0][0] = cube[2][0][1];
		cube[2][0][1].rotateDown();
		cube[2][0][1] = cube[1][0][2];
		cube[1][0][2].rotateDown();
		cube[1][0][2] = cube[0][0][1];
		cube[0][0][1].rotateDown();
		cube[0][0][1] = temp;
	}

	public void topRotateCounter() {
		piece temp = cube[0][0][0];
		cube[0][0][0].rotateRight();
		cube[0][0][0] = cube[2][0][0];
		cube[2][0][0].rotateRight();
		cube[2][0][0] = cube[2][2][0];
		cube[2][2][0].rotateRight();
		cube[2][2][0] = cube[0][2][0];
		cube[0][2][0].rotateRight();
		cube[0][2][0] = temp;
		temp = cube[1][0][0];
		cube[1][0][0].rotateRight();
		cube[1][0][0] = cube[2][1][0];
		cube[2][1][0].rotateRight();
		cube[2][1][0] = cube[1][2][0];
		cube[1][2][0].rotateRight();
		cube[1][2][0] = cube[0][1][0];
		cube[0][1][0].rotateRight();
		cube[0][1][0] = temp;
	}

	public void topRotateClock() {
		piece temp = cube[0][0][0];
		cube[0][0][0].rotateLeft();
		cube[0][0][0] = cube[0][2][0];
		cube[0][2][0].rotateLeft();
		cube[0][2][0] = cube[2][2][0];
		cube[2][2][0].rotateLeft();
		cube[2][2][0] = cube[2][0][0];
		cube[2][0][0].rotateLeft();
		cube[2][0][0] = temp;
		temp = cube[1][0][0];
		cube[1][0][0].rotateLeft();
		cube[1][0][0] = cube[0][1][0];
		cube[0][1][0].rotateLeft();
		cube[0][1][0] = cube[1][2][0];
		cube[1][2][0].rotateLeft();
		cube[1][2][0] = cube[2][1][0];
		cube[2][1][0].rotateLeft();
		cube[2][1][0] = temp;
	}

	public void rightRotateCounter() {
		piece temp = cube[0][2][0];
		cube[0][2][0].rotateDown();
		cube[0][2][0] = cube[2][2][0];
		cube[2][2][0].rotateDown();
		cube[2][2][0] = cube[2][2][2];
		cube[2][2][2].rotateDown();
		cube[2][2][2] = cube[0][2][2];
		cube[0][2][2].rotateDown();
		cube[0][2][2] = temp;
		temp = cube[1][2][0];
		cube[1][2][0].rotateDown();
		cube[1][2][0] = cube[2][2][1];
		cube[2][2][1].rotateDown();
		cube[2][2][1] = cube[1][2][2];
		cube[1][2][2].rotateDown();
		cube[1][2][2] = cube[0][2][1];
		cube[0][2][1].rotateDown();
		cube[0][2][1] = temp;
	}

	public void rightRotateClock() {
		piece temp = cube[0][2][0];
		cube[0][2][0].rotateUp();
		cube[0][2][0] = cube[0][2][2];
		cube[0][2][2].rotateUp();
		cube[0][2][2] = cube[2][2][2];
		cube[2][2][2].rotateUp();
		cube[2][2][2] = cube[2][2][0];
		cube[2][2][0].rotateUp();
		cube[2][2][0] = temp;
		temp = cube[1][2][0];
		cube[1][2][0].rotateUp();
		cube[1][2][0] = cube[0][2][1];
		cube[0][2][1].rotateUp();
		cube[0][2][1] = cube[1][2][2];
		cube[1][2][2].rotateUp();
		cube[1][2][2] = cube[2][2][1];
		cube[2][2][1].rotateUp();
		cube[2][2][1] = temp;
	}

	public void underRotateCounter() {
		piece temp = cube[0][0][2];
		cube[0][0][2].rotateLeft();
		cube[0][0][2] = cube[0][2][2];
		cube[0][2][2].rotateLeft();
		cube[0][2][2] = cube[2][2][2];
		cube[2][2][2].rotateLeft();
		cube[2][2][2] = cube[2][0][2];
		cube[2][0][2].rotateLeft();
		cube[2][0][2] = temp;
		temp = cube[1][0][2];
		cube[1][0][2].rotateLeft();
		cube[1][0][2] = cube[0][1][2];
		cube[0][1][2].rotateLeft();
		cube[0][1][2] = cube[1][2][2];
		cube[1][2][2].rotateLeft();
		cube[1][2][2] = cube[2][1][2];
		cube[2][1][2].rotateLeft();
		cube[2][1][2] = temp;
	}

	public void underRotateClock() {
		piece temp = cube[0][0][2];
		cube[0][0][2].rotateRight();
		cube[0][0][2] = cube[2][0][2];
		cube[2][0][2].rotateRight();
		cube[2][0][2] = cube[2][2][2];
		cube[2][2][2].rotateRight();
		cube[2][2][2] = cube[0][2][2];
		cube[0][2][2].rotateRight();
		cube[0][2][2] = temp;
		temp = cube[1][0][2];
		cube[1][0][2].rotateRight();
		cube[1][0][2] = cube[2][1][2];
		cube[2][1][2].rotateRight();
		cube[2][1][2] = cube[1][2][2];
		cube[1][2][2].rotateRight();
		cube[1][2][2] = cube[0][1][2];
		cube[0][1][2].rotateRight();
		cube[0][1][2] = temp;
	}

	public void frontRotateCounter() {
		piece temp = cube[0][0][0];
		cube[0][0][0].rollLeft();
		cube[0][0][0] = cube[0][2][0];
		cube[0][2][0].rollLeft();
		cube[0][2][0] = cube[0][2][2];
		cube[0][2][2].rollLeft();
		cube[0][2][2] = cube[0][0][2];
		cube[0][0][2].rollLeft();
		cube[0][0][2] = temp;
		temp = cube[0][1][0];
		cube[0][1][0].rollLeft();
		cube[0][1][0] = cube[0][2][1];
		cube[0][2][1].rollLeft();
		cube[0][2][1] = cube[0][1][2];
		cube[0][1][2].rollLeft();
		cube[0][1][2] = cube[0][0][1];
		cube[0][0][1].rollLeft();
		cube[0][0][1] = temp;
	}

	public void frontRotateClock() {
		piece temp = cube[0][0][0];
		cube[0][0][0].rollRight();
		cube[0][0][0] = cube[0][0][2];
		cube[0][0][2].rollRight();
		cube[0][0][2] = cube[0][2][2];
		cube[0][2][2].rollRight();
		cube[0][2][2] = cube[0][2][0];
		cube[0][2][0].rollRight();
		cube[0][2][0] = temp;
		temp = cube[0][1][0];
		cube[0][1][0].rollRight();
		cube[0][1][0] = cube[0][0][1];
		cube[0][0][1].rollRight();
		cube[0][0][1] = cube[0][1][2];
		cube[0][1][2].rollRight();
		cube[0][1][2] = cube[0][2][1];
		cube[0][2][1].rollRight();
		cube[0][2][1] = temp;
	}
}

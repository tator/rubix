package rubix;

import java.awt.Color;

public class piece {
	Color back, left, top, right, under, front;
	String sback = "white", sleft = "blue", stop = "red", sright = "green",
			sunder = "yellow", sfront = "orange";

	public piece(Color back, Color left, Color top, Color right, Color under,
			Color front) {
		this.back = back;
		this.left = left;
		this.top = top;
		this.right = right;
		this.under = under;
		this.front = front;
		str();
	}

	public void str() {
		sback = setString(back);
		sleft = setString(left);
		stop = setString(top);
		sright = setString(right);
		sunder = setString(under);
		sfront = setString(front);
	}

	public String setString(Color a) {
		if (a == null) {
			return "null";
		} else if (a.equals(Color.WHITE)) {
			return "Whit";
		} else if (a.equals(Color.blue)) {
			return "Blue";
		} else if (a.equals(Color.RED)) {
			return "Red ";
		} else if (a.equals(Color.GREEN)) {
			return "Gree";
		} else if (a.equals(Color.YELLOW)) {
			return "Yell";
		} else if (a.equals(Color.orange.darker())) {
			return "Oran";
		}
		return "error";
	}

	public String toString() {
		return "\t" + sback + "\n" + sleft + "\t" + stop + "\t" + sright + "\t"
				+ sunder + "\n\t" + sfront;
	}

	public void rotateUp() {
		Color temp = front;
		front = under;
		under = back;
		back = top;
		top = temp;
		str();
	}

	public void rotateDown() {
		Color temp = front;
		front = top;
		top = back;
		back = under;
		under = temp;
		str();
	}

	public void rotateLeft() {
		Color temp = front;
		front = right;
		right = back;
		back = left;
		left = temp;
		str();
	}

	public void rotateRight() {
		Color temp = front;
		front = left;
		left = back;
		back = right;
		right = temp;
		str();
	}

	public void rollLeft() {
		Color temp = top;
		top = right;
		right = under;
		under = left;
		left = temp;
		str();
	}

	public void rollRight() {
		Color temp = top;
		top = left;
		left = under;
		under = right;
		right = temp;
		str();

	}
}
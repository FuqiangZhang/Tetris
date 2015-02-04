package model;

import java.awt.Graphics;

public class ShapAll extends Component {

	private int[][] components = new int[28][30];

	public ShapAll() {
		for (int i = 0; i < 30; i++) {
			components[0][i] = 2;
			components[27][i] = 2;
		}
		for (int i = 0; i < 27; i++) {
			components[i][29] = 2;
		}
	}

	@Override
	public void drawShap(Graphics g) {
		for (int i = 0; i < 28; i++) {
			for (int j = 0; j < 30; j++) {
				if (components[i][j] == 2) {
					g.drawRect(10 * i, 10 * j, 10, 10);
				}
				if (components[i][j] == 1) {
					g.fillRect(10 * i, 10 * j, 10, 10);
				}
			}
		}
	}

	public int getValue(int i, int x, int y) {
		if (components[i % 4 + x / 10][i / 4 + y / 10 + 1] != 0) // down
			return 1;
		if (components[i % 4 + x / 10 + 1][i / 4 + y / 10] != 0) // right
			return 2;
		if (components[i % 4 + x / 10 - 1][i / 4 + y / 10] != 0) // left
			return 3;
		return 0;
	}

	public void addOne(Component comp) {
		for (int i = 0; i < 16; i++) {
			if (comp.getValue(i)) {
				components[i % 4 + comp.getX() / 10][i / 4 + comp.getY() / 10] = 1;
				removeLine();
			}
		}
		for (int i = 0; i < 28; i++) {
			for (int j = 0; j < 30; j++) {
				System.out.print(components[i][j]);
			}
			System.out.println();
		}

		System.out.println();
		removeLine();
	}

	public void removeLine() {
		int result = 1;
		for (int i = 0; i < 29; i++) {
			for (int j = 1; j < 27; j++) {
				result = result * components[j][i];
			}
			if (result == 1) {
				// 消除后 所有行下移 预留
				
				for(int l=i;l>=1;l--){
					for (int k = 26; k > 0; k--) {
						components[k][l] = components[k][l-1];
					}
				}
				for (int x = 0; x < 28; x++) {
					for (int z= 0; z < 30; z++) {
						System.out.print(components[x][z]);
					}
					System.out.println();
				}
			}
			result = 1;
		}
	}

}

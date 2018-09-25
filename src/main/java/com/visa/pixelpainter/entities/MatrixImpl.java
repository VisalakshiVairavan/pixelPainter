package com.visa.pixelpainter.entities;

import org.springframework.stereotype.Component;

@Component
public class MatrixImpl implements Matrix {

	char[][] matrix = null;
	Integer currentX;
	Integer currentY;

	public void setPixel(Integer x, Integer y, char value) throws IndexOutOfBoundsException{
		matrix[x][y] = value;

	}

	public char getPixel(Integer x, Integer y) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return matrix[x][y];
	}

	public char[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(char[][] matrix) {
		this.matrix = matrix;
	}

	public void defineMatrix(int width, int height) {
		// Add two to exclude the boundaries from the input size
		// Remove two to make it inclusive
		matrix = new char[height + 2][width + 2];
		for (int i = 0; i < height + 2; i++) {
			for (int j = 0; j < width + 2; j++) {
				matrix[i][j] = ' ';
			}
		}
	}
	
	
	
//	x1 y---------------- x2 y
	
//		| x y1
//		|
//		| x y2

	public void drawLine(Integer x1, Integer y1, Integer x2, Integer y2) throws Exception {
		int startPos, endPos;
		if (x1 == x2) {
			startPos = y1;
			endPos = y2;
			if (startPos > endPos) {
				startPos = y2;
				endPos = y1;
			}
			for (int i = startPos; i <= endPos; i++) {
				setPixel(i, x1, 'X');
			}
		} else if (y1 == y2) {
			startPos = x1;
			endPos = x2;
			if (startPos > endPos) {
				startPos = x2;
				endPos = x1;
			}
			for (int i = startPos; i <= endPos; i++) {
				setPixel(y1, i, 'X');
			}
		} else {
			throw new Exception("Only Vertical and Horizontal lines are supported!");
		}
	}
	
	

	public void printMatrix() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i == 0 || i == matrix.length - 1) {
					System.out.print("-");
					continue;
				}
				if (j == 0 || j == matrix[i].length - 1) {
					System.out.print("|");
				} else {
					System.out.print(matrix[i][j]);
				}
			}
			System.out.print("\n");
		}

	}

	public Integer getCurrentX() {
		return currentX;
	}

	public void setCurrentX(Integer currentX) {
		this.currentX = currentX;
	}

	public Integer getCurrentY() {
		return currentY;
	}

	public void setCurrentY(Integer currentY) {
		this.currentY = currentY;
	}

}

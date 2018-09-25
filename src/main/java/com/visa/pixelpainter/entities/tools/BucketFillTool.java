package com.visa.pixelpainter.entities.tools;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.visa.pixelpainter.entities.MatrixImpl;

@Component
public class BucketFillTool implements Tool {

	String name = "Bucket Fill Tool";
	String Description = "Fills the area enclosing the inputs x1 y1 with color input c";
	Integer maxInput = 3;
	char colorFound = ' ';
	char charToFill = 'o';
	@Autowired
	MatrixImpl matrix;


	public void action(List<Integer> args) throws Exception {
		if (args.size() != maxInput) {
			throw new Exception("Required Args is : " + maxInput);
		}

		Integer x = args.get(0);
		Integer y = args.get(1);
		charToFill = (char) (int) args.get(2);
		colorFound = matrix.getPixel(y, x);
		recursiveFill(x, y);
		matrix.printMatrix();
	}

	public void recursiveFill(int x, int y) {

		if (x < 1 || y < 1 || y > matrix.getMatrix().length - 1 || x > matrix.getMatrix()[0].length - 1) {
			return;
		}
		// change only the color found at the input point - Could be a line or a blank
		// space
		if (matrix.getPixel(y, x) == colorFound) {
			
			matrix.setPixel(y, x, charToFill);
			
			recursiveFill(x + 1, y);
			recursiveFill(x - 1, y);
			recursiveFill(x, y + 1);
			recursiveFill(x, y - 1);

		}
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return Description;
	}

	public Integer getMaxInput() {
		return maxInput;
	}

	public MatrixImpl getMatrix() {
		return matrix;
	}

	public void setMatrix(MatrixImpl matrix) {
		this.matrix = matrix;
	}

}

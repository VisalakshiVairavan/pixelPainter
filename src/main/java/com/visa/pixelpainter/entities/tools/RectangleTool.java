package com.visa.pixelpainter.entities.tools;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.visa.pixelpainter.entities.MatrixImpl;

@Component
public class RectangleTool implements Tool {

	String name = "Line Tool";
	String Description = "Draws a line from input x1 y1 to x2 y2";
	Integer maxInput = 4;
	@Autowired
	MatrixImpl matrix;

	public void action(List<Integer> args) throws Exception {
		if (args.size() != maxInput) {
			throw new Exception("Required Args is : " + maxInput);
		}

		Integer x1 = args.get(0);
		Integer y1 = args.get(1);
		Integer x2 = args.get(2);
		Integer y2 = args.get(3);
		
//			x1 y1 ----------------- x2 y1
//			      |               |
//			      |               |
//         x1 y2  ----------------- x2 y2 
		
		matrix.drawLine(x1, y1, x1, y2);
		matrix.drawLine(x1, y1, x2, y1);
		matrix.drawLine(x2, y1, x2, y2);
		matrix.drawLine(x1, y2, x2, y2);
		matrix.printMatrix();
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

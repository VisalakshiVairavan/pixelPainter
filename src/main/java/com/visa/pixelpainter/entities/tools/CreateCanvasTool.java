package com.visa.pixelpainter.entities.tools;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.visa.pixelpainter.entities.MatrixImpl;

@Component
public class CreateCanvasTool implements Tool {

	String name = "Create Canvas";
	String Description = "Creates an canvas of input width and height";
	Integer maxInput = 2;
	@Autowired
	MatrixImpl matrix;

	public void action(List<Integer> args) throws Exception {
		if (args.size() != maxInput) {
			throw new Exception("Required Args is : " + maxInput);
		}
		matrix.defineMatrix(args.get(0), args.get(1));
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

package com.visa.pixelpainter.entities;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class MatrixImplTest {
	
	MatrixImpl matrixImpl = new MatrixImpl();

	@Test
	public void defineMatrixTest() {
		matrixImpl.defineMatrix(2, 2);
		matrixImpl.setPixel(1, 1, 'c');
		assertEquals('c',matrixImpl.getPixel(1, 1));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void setPixelFailTest() {
		matrixImpl.defineMatrix(2, 2);
		matrixImpl.setPixel(1, 4, 'c');
	}
	@Test
	public void drawLineTest() {
		try {
		matrixImpl.defineMatrix(4, 4);
		matrixImpl.drawLine(1, 1, 1,3);
		assertEquals('X',matrixImpl.getPixel(1, 1));
		assertEquals('X',matrixImpl.getPixel(2, 1));
		}catch(Exception e) {
			
		}
	}
	@Test(expected = Exception.class)
	public void drawLineTestFails() throws Exception {
		matrixImpl.defineMatrix(4, 4);
		matrixImpl.drawLine(2, 1, 1,3);
	}
	
	

}

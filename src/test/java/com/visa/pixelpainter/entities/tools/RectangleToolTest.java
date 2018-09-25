package com.visa.pixelpainter.entities.tools;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.test.context.junit4.SpringRunner;

import com.visa.pixelpainter.entities.MatrixImpl;

@RunWith(SpringRunner.class)
public class RectangleToolTest {

	@Mock
	 MatrixImpl matrix;
	@InjectMocks
	RectangleTool rectTool = new RectangleTool();
	Answer<Integer> answer = new Answer<Integer>() {
	     public Integer answer(InvocationOnMock invocation) {
	         return 1;
	     }
	 };
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		doAnswer(answer).when(matrix).drawLine(anyInt(),anyInt(),anyInt(),anyInt());
		doAnswer(answer).when(matrix).printMatrix();
	}

	@Test
	public void action() {
		List<Integer> argsList = Arrays.asList(4,4,4,4);
		try {
			rectTool.action(argsList);
			verify(matrix, times(4)).drawLine(4,4,4,4);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(expected = Exception.class)
	public void actionFail() throws Exception {
		List<Integer> argsList = Arrays.asList(4);
		rectTool.action(argsList);
	}

}

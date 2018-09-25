package com.visa.pixelpainter.entities.tools;

import static org.mockito.Mockito.*;

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
public class LineToolTest {
	
	@Mock
	 MatrixImpl matrix;
	@InjectMocks
	LineTool lineTool = new LineTool();
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
			lineTool.action(argsList);
			verify(matrix, times(1)).drawLine(4,4,4,4);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(expected = Exception.class)
	public void actionFail() throws Exception {
		List<Integer> argsList = Arrays.asList(4);
		lineTool.action(argsList);
	}

}

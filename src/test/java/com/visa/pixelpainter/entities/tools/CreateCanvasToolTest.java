package com.visa.pixelpainter.entities.tools;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.BDDMockito.*;
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
public class CreateCanvasToolTest {
	@Mock
	 MatrixImpl matrix;
	@InjectMocks
	CreateCanvasTool createCanvasTool = new CreateCanvasTool();
	Answer<Integer> answer = new Answer<Integer>() {
	     public Integer answer(InvocationOnMock invocation) {
	         return 1;
	     }
	 };
	 @Before
	    public  void createMock() {
		    MockitoAnnotations.initMocks(this);
			doAnswer(answer).when(matrix).defineMatrix(4,4);
			doAnswer(answer).when(matrix).printMatrix();
			
	    }
	 
	@Test
	public void action() {
		List<Integer> argsList = Arrays.asList(4,4);
		try {
			createCanvasTool.action(argsList);
			verify(matrix, times(1)).defineMatrix(4,4);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test(expected = Exception.class)
	public void actionFail() throws Exception {
		List<Integer> argsList = Arrays.asList(4);
		createCanvasTool.action(argsList);
	}

}

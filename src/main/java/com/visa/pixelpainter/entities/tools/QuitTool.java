package com.visa.pixelpainter.entities.tools;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class QuitTool implements Tool {

	String name = "Create Canvas";
	String Description = "Creates an canvas of input width and height";
	Integer maxInput = 0;

	public void action(List<Integer> args) throws Exception {
	  System.out.println("**********************************");
	  System.exit(0);
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

}

package com.visa.pixelpainter;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.visa.pixelpainter.entities.tools.BucketFillTool;
import com.visa.pixelpainter.entities.tools.CreateCanvasTool;
import com.visa.pixelpainter.entities.tools.LineTool;
import com.visa.pixelpainter.entities.tools.QuitTool;
import com.visa.pixelpainter.entities.tools.RectangleTool;
import com.visa.pixelpainter.entities.tools.Tool;

@Configuration
public class PixelPainterConfig {

	@Autowired
	CreateCanvasTool canvasTool;
	@Autowired
	LineTool lineTool;
	@Autowired
	RectangleTool rectTool;
	@Autowired
	BucketFillTool bucketfillTool;
	@Autowired 
	QuitTool quit;

	@Bean
	public Map<String, Tool> toolMap() {
		Map<String, Tool> tools = new HashMap<String, Tool>();

		tools.put("C", canvasTool);
		tools.put("L", lineTool);
		tools.put("R", rectTool);
		tools.put("B", bucketfillTool);
		tools.put("Q", quit);
		return tools;
	}

}

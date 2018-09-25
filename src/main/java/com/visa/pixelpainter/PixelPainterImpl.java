package com.visa.pixelpainter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.visa.pixelpainter.entities.tools.Tool;

import org.springframework.boot.Banner;

@SpringBootApplication
public class PixelPainterImpl implements PixelPainter, CommandLineRunner {

	@Resource(name = "toolMap")
	private Map<String, Tool> toolMap;

	public void run(String... args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s;

		System.out.println("\n\n\nWelcome to Pixel Printer!");
		while (true) {
			try {
				System.out.print("Enter Command: ");
				
				if ((s = reader.readLine()) != null) {
					String[] arguments = s.split(" ");
					List<Integer> argslist = Arrays.asList(arguments)
							.subList(1, arguments.length).stream()
							.map(string -> {
								if (Character.isLetter(string.charAt(0)))
									return (int) string.charAt(0);
								return  Integer.parseInt(string);
							})
							.collect(Collectors.toList());
					

					
					Tool t = toolMap.get(arguments[0].toUpperCase());
					
					if (t != null) {
						t.action(argslist);
					} else {
						throw new Exception("Invalid Action specified!");
					}
				}

			} catch (Exception e) {
				System.out.println(e);
			}

		}

	}

	public static void main(String args[]) {

		SpringApplication painter = new SpringApplication(PixelPainterImpl.class);
		painter.setBannerMode(Banner.Mode.OFF);
		painter.run(args);

	}

}

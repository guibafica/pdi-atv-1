package br.com.pdi.vision;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GrayScaleConverte {
	BufferedImage image;
	int width, height, red, green, blue, gray;
	
	public void run() throws IOException {
		File input = new File("/home/guibafica/Desktop/Aulas/PDI/01-09/image1.jpeg");
		
		image = ImageIO.read(input);
		width = image.getWidth();
		height = image.getHeight();
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				Color pixel = new Color(image.getRGB(j, i));
				
				red = pixel.getRed();
				green = pixel.getGreen();
				blue = pixel.getBlue();
				
				gray = (red + green + blue)/3;
				
				Color newPixel = new Color(gray, gray, gray);
				
				image.setRGB(j, i, newPixel.getRGB());				
			}			
		}
		
		File output = new File("/home/guibafica/Desktop/Aulas/PDI/01-09/image1_gray.jpg");
		
		ImageIO.write(image, "jpg", output);
		
		System.out.println("Done!");
	}
	
	public static void main(String[] args) {
		try {
			new GrayScaleConverte().run();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

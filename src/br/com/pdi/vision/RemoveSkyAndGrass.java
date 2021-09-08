package br.com.pdi.vision;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class RemoveSkyAndGrass {
	BufferedImage image;
	
	int width, height, red, green, blue, blueIndex, greenIndex, gray;
	int blueThreshold = 160;
	int greenThreshold = 0;
	
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
				
				greenIndex = (blue - red - green * -1);
				blueIndex = (green - red - blue) * -1;
				gray = (red + green + blue)/3;
				
				Color newPixel = new Color(gray, gray, gray);
				
				if (blueIndex > blueThreshold || greenIndex > greenThreshold) {
//					image.setRGB(j, i, Color.BLACK.getRGB());
					
					image.setRGB(j, i, newPixel.getRGB());	
				} else {
					image.setRGB(j, i, Color.RED.getRGB());
				}
			}			
		}
		
		File output = new File("/home/guibafica/Desktop/Aulas/PDI/01-09/removeSkyAndGrass3.jpg");
		
		ImageIO.write(image, "jpg", output);
		
		System.out.println("Done!");
	}
	
	public static void main(String[] args) {
		try {
			new RemoveSkyAndGrass().run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

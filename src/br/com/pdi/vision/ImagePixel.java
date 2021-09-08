// Método que printa o RGB por pixel 

package br.com.pdi.vision;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.*;

public class ImagePixel {
	BufferedImage image;
	int width, height;
	
	public void run() throws IOException {
		File input = new File("/home/guibafica/Desktop/Aulas/PDI/01-09/image1.jpeg");
		
		image = ImageIO.read(input);
		width = image.getWidth();
		height = image.getHeight();
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				Color pixel = new Color(image.getRGB(j, i));

				System.out.println("["+i+"]["+j+"]  rgb("+pixel.getRed()+", "+pixel.getGreen()+", "+pixel.getBlue()+")");
			}			
		}		
	}

	public static void main(String[] args) {
		try {
			new ImagePixel().run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

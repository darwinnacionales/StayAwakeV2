package util;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

import main.SASystemTray;

public class ImageLoader {
	public static Image createImage(String path, String description) {
    	URL imageURL = SASystemTray.class.getResource(path);

        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }
}

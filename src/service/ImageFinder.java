/**
 * path of images
 */
package service;

import model.Card;

/**
 * @author Mia Gudelj
 * @since 25-06-2020
 * @version 1.0
 *
 */
public class ImageFinder {

	// variables
	private String imgFolder;
	//

	/**
	 * constructor
	 * 
	 * root is set
	 */
	public ImageFinder() {
		imgFolder = "./Pictures/Cards/";
	}

	/**
	 * set the root/folder of the image 
	 * 
	 * @param dir
	 */
	public ImageFinder(String dir) {
		imgFolder = dir;
	}

	/**
	 * get the image
	 * 
	 * @param card
	 * @return image
	 */
	public String getImage(Card card) {
		return imgFolder + card.getSymbol() + "-" + card.getValue().getValue() + ".png";
	}
}

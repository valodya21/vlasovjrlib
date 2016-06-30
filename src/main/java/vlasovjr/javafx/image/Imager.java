package vlasovjr.javafx.image;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 */
public class Imager{
    private Image image;

    public Imager(){
    }

    public Imager(String path) {
        loadImage(path);
    }

    public void setImage(Image image){
        this.image = image;
    }

    public void loadImage(String path){
        this.image = new Image(String.valueOf(getClass().getResource(path)));
    }

    public Image getImage(){
        return this.image;
    }

    public ImageView getImageView(double fitHeight, double fitWidth){
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(fitHeight);
        imageView.setFitWidth(fitWidth);
        return imageView;
    }

    public ImageView getImageView(){
        return new ImageView(image);
    }

}
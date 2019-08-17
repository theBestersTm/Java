package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;

public class BckMap {

    Class<?> clazz = this.getClass();
    InputStream input;
    ImageView background;
    BckMap(){

        input = clazz.getResourceAsStream("img/background.jpg");
        background = new ImageView(new Image(input));
        background.setFitWidth(1000);
        background.setFitHeight(1000);
    }

    ImageView getBackground(){
        return background;
    }
}

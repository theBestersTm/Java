package sample;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;
import java.util.ArrayList;

public class City {
    int hp;
    String team;
    Class<?> clazz = this.getClass();
    Image i;
    ImageView iv;
    InputStream input;
    String name;
    boolean clicked;
    ArrayList<Units> chmp;
    ArrayList<Secondlvl> che;
    ArrayList<Thirdlvl> chee;

    City(String t, double x, double y, String n){
        clicked = false;
        team = t;
        name = n;
        if (this.team == "Red")
        {
            this.input = clazz.getResourceAsStream("img/city_r.png");
        }
        else
        {
            this.input = clazz.getResourceAsStream("img/city_g.png");
        }
        this.i = new Image(input);
        this.iv = new ImageView(i);
        this.iv.setFitHeight(130);
        this.iv.setFitWidth(140);
        this.iv.setX(x);
        this.iv.setY(y);
    }

    ImageView getIv(){
        return iv;
    }

    public void MouseClick(double x, double y) {

        Point2D m = new Point2D(x,y);

        if( iv.contains(m) )
        {
            clicked = true;
        }
        else
            clicked = false;
    }
}

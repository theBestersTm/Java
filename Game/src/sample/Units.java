package sample;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;
import java.util.Random;

public class Units {

    Class<?> clazz = this.getClass();
    String warierOf;
    String team, nick;
    int maxhp;
    int damage;
    double range;
    String weapontype;
    int hp;
    boolean isActive, delete;
    Image i;
    ImageView iv;
    InputStream input;
    String url;
    String tower;

    Units()
    {
        Random rand = new Random();
        this.nick = "Artem";
        this.warierOf = "Spartan";
        this.team = "Green";
        this.isActive = false;
        this.url = "img/spartan_b";
        this.input = clazz.getResourceAsStream(this.url + ".png");
        this.weapontype = "Shotgun";
        this.damage = 50;
        this.maxhp = 150;
        this.hp = 115;
        this.range = 300.75;
        this.i = new Image(input);
        this.iv = new ImageView(i);
        this.iv.setFitHeight(60);
        this.iv.setFitWidth(60);
        this.iv.setY(100 + rand.nextInt(700));
        this.iv.setX(100 + rand.nextInt(700));
    }

    Units(String cc, String te, String nc, double x, double y) {

        this.nick = nc;
        this.warierOf = cc;
        this.team = te;
        this.isActive = false;
        this.delete = false;
        this.tower = "";
        switch (cc)
        {
            case "Spartan": {
                if (this.team == "Red")
                {
                    this.url = "img/spartan_r";
                }
                else
                {
                    this.url = "img/spartan_b";
                }
                this.input = clazz.getResourceAsStream(this.url + ".png");
                this.weapontype = "Shotgun";
                this.damage = 50;
                this.maxhp = 1000;
                this.hp = 1000;
                this.range = 100.75;
                break;
            }
            case "Natiz": {
                if (this.team == "Red")
                {
                    this.url = "img/natiz_r";
                }
                else
                {
                    this.url = "img/natiz_b";
                }
                this.input = clazz.getResourceAsStream(this.url + ".png");
                this.weapontype = "Machine gun";
                this.damage = 200;
                this.maxhp = 700;
                this.hp = 700;
                this.range = 400.25;
                break;
            }
            case "Soviet": {
                if (this.team == "Red")
                {
                    this.url = "img/soviet_r";
                }
                else
                {
                    this.url = "img/soviet_b";
                }
                this.input = clazz.getResourceAsStream(this.url + ".png");
                this.weapontype = "Automaton";
                this.damage = 150;
                this.hp = 600;
                this.maxhp = 600;
                this.range = 500.5;
                break;
            }
            case "Neutral": {
                if (this.team == "Red")
                {
                    this.url = "img/neutral_r";
                }
                else
                {
                    this.url = "img/neutral_b";
                }
                this.input = clazz.getResourceAsStream(this.url + ".png");
                this.weapontype = "Pistol";
                this.damage = 100;
                this.maxhp = 800;
                this.hp = 800;
                this.range = 105.5;
                break;
            }
        }

        this.i = new Image(input);
        this.iv = new ImageView(i);
        this.iv.setFitHeight(60);
        this.iv.setFitWidth(45);
        this.iv.setX(x);
        this.iv.setY(y);

    }
    public void MouseClick(double x, double y) {

        Point2D m = new Point2D(x,y);

        if( iv.contains(m) )
        {
            isActive= !isActive;

            if (isActive) {
                this.input = clazz.getResourceAsStream(this.url + "_a.png");
                iv.setImage(new Image(this.input));
            }
            else{
                this.input = clazz.getResourceAsStream(this.url + ".png");
                iv.setImage(new Image(this.input));
            }
        }

    }
    public void ChangePos(int x1, int x2, int y1, int y2){

        Random rn = new Random();
        int answerx = rn.nextInt(x1) + x2;
        int answery = rn.nextInt(y1) + y2;



    double x = answerx ;

            iv.setX(x);
        double y = answery ;
        iv.setY(y);

    }
    public void Left() {
        if(!isActive)return;

        double x = iv.getX()-5;
        iv.setX(x);
    }
    public void Up() {
        if(!isActive)return;

        double y = iv.getY()-5;
        iv.setY(y);
    }
    public void Right() {
        if(!isActive)return;

        double x = iv.getX()+5;
        iv.setX(x);
    }
    public void Down() {
        if(!isActive)return;

        double y = iv.getY()+5;
        iv.setY(y);
    }
    public ImageView getIv() {
        return  iv;
    }
    public void check (City t){

        if(!isActive)return;

        if ((this.getIv().getX() > t.getIv().getX()) && ((this.getIv().getX() < t.getIv().getX() + t.getIv().getFitWidth()))
                && (this.getIv().getY() > t.getIv().getY()) && ((this.getIv().getY() < t.getIv().getY() + t.getIv().getFitHeight()))
                )
            {
                if (t.team != this.team)
                {
                    delete = true;
                }

                if (t.team == this.team)
                {
                    this.tower = t.name;
                    this.iv.setVisible(false);
                    this.isActive = false;
                    this.input = clazz.getResourceAsStream(this.url + ".png");
                    iv.setImage(new Image(this.input));
                }
            }

    }

}

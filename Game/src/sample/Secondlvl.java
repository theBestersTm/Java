package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Secondlvl extends Units {

    Secondlvl()
    {
        Random rand = new Random();
        this.iv.setFitHeight(80);
        this.iv.setFitWidth(60);
        this.iv.setY(100 + rand.nextInt(700));
        this.iv.setX(100 + rand.nextInt(700));
    }

    Secondlvl ( String cc, String te, String nc, double x, double y)
    {
        this.nick = nc;
        this.warierOf = cc;
        this.team = te;
        this.isActive = false;
        this.delete = false;

        switch (cc)
        {
            case "Spartan": {
                if (this.team == "Red")
                {
                    this.url = "img/spartan_b";
                }
                else
                {
                    this.url = "img/spartan_r";
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
                    this.url = "img/soviet_b";
                }
                else
                {
                    this.url = "img/soviet_r";
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
        this.iv.setFitHeight(80);
        this.iv.setFitWidth(60);
        this.iv.setX(x);
        this.iv.setY(y);
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
    public void LeftUp() {
        if(!isActive)return;

        double x = iv.getX()-5;
        iv.setX(x);
        double y = iv.getY()-5;
        iv.setY(y);
    }

    public void LeftDown() {
        if(!isActive)return;

        double x = iv.getX()-5;
        iv.setX(x);
        double y = iv.getY()+5;
        iv.setY(y);
    }

    public void RightUp() {
        if(!isActive)return;

        double x = iv.getX()+5;
        iv.setX(x);
        double y = iv.getY()-5;
        iv.setY(y);
    }

    public void RightDown() {
        if(!isActive)return;

        double x = iv.getX()+5;
        iv.setX(x);
        double y = iv.getY()+5;
        iv.setY(y);
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

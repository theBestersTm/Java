package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.Arrays;

public class Main extends Application {

    static Units[] units;
    static Secondlvl [] Secondlvls;
    static Thirdlvl [] Thirdlvls;
    static City[] city;

    public static Units r;
    Group grp;
    Scene scene;

    void checkDel(Units c)
    {
        if ( c.delete == true)
        {
            c.getIv().setVisible(false);
        }

    }

    void checkce (Secondlvl c)
    {
        if ( c.delete == true)
        {
            c.getIv().setVisible(false);
        }
    }

    void checkcee (Thirdlvl c)
    {
        if ( c.delete == true)
        {
            c.getIv().setVisible(false);
        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception{

        units = new Units[3];
        Secondlvls = new Secondlvl[1];
        Thirdlvls = new Thirdlvl[1];
        city = new City[6];

        grp = new Group();
        BckMap map = new BckMap();
        grp.getChildren().add( map.getBackground() );

        city[0] = new City("Green", 140, 270, "b1");
        grp.getChildren().add( city[0].getIv() );
        city[1] = new City("Red", 350, 180, "r1");
        grp.getChildren().add( city[1].getIv() );
        city[2] = new City("Green", 720, 800, "b2");
        grp.getChildren().add( city[2].getIv() );
        city[3] = new City("Green", 210, 520, "b3");
        grp.getChildren().add( city[3].getIv() );
        city[4] = new City("Red", 450, 160, "r2");
        grp.getChildren().add( city[4].getIv() );
        city[5] = new City("Red", 233, 610, "r3");
        grp.getChildren().add( city[5].getIv() );


        units[0] = new Units("Spartan", "Red", "фыв", 150, 50);
        grp.getChildren().add( units[0].getIv() );
        units[1] = new Units("Natiz", "Green", "", 250, 150);
        grp.getChildren().add( units[1].getIv() );
        units[2] = new Units("Soviet", "Red", "", 450, 250);
        grp.getChildren().add( units[2].getIv() );
        Secondlvls[0] = new Secondlvl();
        Thirdlvls[0] = new Thirdlvl();
        grp.getChildren().add(Secondlvls[0].getIv() );
        grp.getChildren().add(Thirdlvls[0].getIv() );

        scene = new Scene(grp, 1500, 1500);

        scene.setOnKeyPressed(new KeyPressedHandler());

        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                for( Units mr:units )
                    mr.MouseClick(event.getX(),event.getY());

                for ( Secondlvl mc:Secondlvls )
                    mc.MouseClick(event.getX(),event.getY());

                for ( Thirdlvl md:Thirdlvls )
                    md.MouseClick(event.getX(),event.getY());

                for ( City t:city){
                    t.MouseClick(event.getX(), event.getY());
                    if (t.clicked == true)
                    {
                        for ( Units c: units)
                        {
                            if (c.tower == t.name)
                            {
                                c.getIv().setVisible(true);
                                c.getIv().setX(t.getIv().getX() + 100 );
                                c.getIv().setY(t.getIv().getY());
                                c.tower = "";
                            }
                        }
                        for ( Secondlvl c: Secondlvls)
                        {
                            if (c.tower == t.name)
                            {
                                c.getIv().setVisible(true);
                                c.getIv().setX(c.getIv().getX() + 100 );
                                c.getIv().setY(c.getIv().getY() + 50);
                                c.tower = "";
                            }
                        }
                        for ( Thirdlvl c: Thirdlvls)
                        {
                            if (c.tower == t.name)
                            {
                                c.getIv().setVisible(true);
                                c.getIv().setX(c.getIv().getX() + 100 );
                                c.getIv().setY(c.getIv().getY() + 100);
                                c.tower = "";
                            }
                        }
                    }
                }

            }
        });

        primaryStage.setScene(scene);
        primaryStage.setMaxHeight(1000);
        primaryStage.setMaxWidth(1000);
        primaryStage.show();

    }


    private class KeyPressedHandler implements EventHandler<KeyEvent> {

        @Override
        public void handle(KeyEvent event) {

            if (event.getCode().equals(KeyCode.INSERT))
            {
                if( NewCharacter.display("New Players","Введіть дані"))
                {

                    switch (NewCharacter.level)
                    {
                        case "1 - рівень": {
                            units= Arrays.copyOf(units, units.length+1);


                            units[units.length-1]=
                                    new Units(NewCharacter.UnitClass, NewCharacter.team, NewCharacter.nick, NewCharacter.x, NewCharacter.y);
                            System.out.println("Insert lenght - " + units.length);


                            grp.getChildren().add(units[units.length - 1].getIv());
                            break;
                        }
                        case "2 - рівень": {
                            Secondlvls= Arrays.copyOf(Secondlvls, Secondlvls.length+1);


                            Secondlvls[Secondlvls.length-1]=
                                    new Secondlvl(NewCharacter.UnitClass, NewCharacter.team, NewCharacter.nick, NewCharacter.x, NewCharacter.y);
                            System.out.println("Insert lenght - " + Secondlvls.length);


                            grp.getChildren().add(Secondlvls[Secondlvls.length - 1].getIv());
                            break;
                        }
                        case "3 - рівень": {
                            Thirdlvls= Arrays.copyOf(Thirdlvls, Thirdlvls.length+1);


                            Thirdlvls[Thirdlvls.length-1]=
                                    new Thirdlvl(NewCharacter.UnitClass, NewCharacter.team, NewCharacter.nick, NewCharacter.x, NewCharacter.y);
                            System.out.println("Insert lenght - " + Thirdlvls.length);


                            grp.getChildren().add(Thirdlvls[Thirdlvls.length - 1].getIv());
                            break;
                        }
                    }


                }

            }
            if (event.getCode().equals(KeyCode.DIGIT1))
            {


                if( ChngCoord.display("Lvl Sort","Введіть дані"))
                {
                    if (ChngCoord.firstlvl==1){
                        for(int i =0 ; units.length>i; i++){
                            units[i].ChangePos(370, 30,  370, 50);
                        }

                    }
                    else if(ChngCoord.firstlvl==2){
                        for(int i =0 ; units.length>i; i++){
                            units[i].ChangePos(720, 470,  370, 50);
                        }
                    }
                    else if(ChngCoord.firstlvl==3) {
                        for(int i =0 ; units.length>i; i++){
                            units[i].ChangePos(370, 30,  760, 370);
                        }
                    }
                    else if(ChngCoord.firstlvl==4){
                        for(int i =0 ; units.length>i; i++){
                            units[i].ChangePos(720, 470,  720, 500);
                        }
                    }
                    if (ChngCoord.secondlvl==1){
                        for(int i =0 ; Secondlvls.length>i; i++){
                            Secondlvls[i].ChangePos(370, 30,  370, 50);
                        }

                    }
                    else if(ChngCoord.secondlvl==2){
                        for(int i =0 ; Secondlvls.length>i; i++){
                            Secondlvls[i].ChangePos(720, 470,  370, 50);
                        }
                    }
                    else if(ChngCoord.secondlvl==3) {
                        for(int i =0 ; Secondlvls.length>i; i++){
                            Secondlvls[i].ChangePos(370, 30,  760, 370);
                        }
                    }
                    else if(ChngCoord.secondlvl==4){
                        for(int i =0 ; Secondlvls.length>i; i++){
                            Secondlvls[i].ChangePos(720, 470,  720, 500);
                        }
                    } if (ChngCoord.thirdlvl==1){
                    for(int i =0 ; Thirdlvls.length>i; i++){
                        Thirdlvls[i].ChangePos(370, 30,  370, 50);
                    }

                }
                else if(ChngCoord.thirdlvl==2){
                    for(int i =0 ; Thirdlvls.length>i; i++){
                        Thirdlvls[i].ChangePos(720, 470,  370, 50);
                    }
                }
                else if(ChngCoord.thirdlvl==3) {
                    for(int i =0 ; Thirdlvls.length>i; i++){
                        Thirdlvls[i].ChangePos(370, 30,  760, 370);
                    }
                }
                else if(ChngCoord.thirdlvl==4){
                    for(int i =0 ; Thirdlvls.length>i; i++){
                        Thirdlvls[i].ChangePos(720, 470,  720, 500);
                    }
                }

                    }




//               for (int i =0 ; Secondlvls.length>i; i++) {
//                   Secondlvls[i].ChangePos();
//
//               }
//                for (int i =0 ; Thirdlvls.length>i; i++) {
//                    Thirdlvls[i].ChangePos();
//
//                }
            }
            if (event.getCode().equals(KeyCode.UP)) {
                for( Units r :units)
                {
                    r.Up();
                    for (City t: city)
                    {
                        r.check(t);
                        checkDel(r);
                    }
                }

                for( Secondlvl c :Secondlvls)
                {
                    c.Up();
                    for (City t: city)
                    {
                        c.check(t);
                        checkDel(c);
                    }
                }

                for( Thirdlvl d :Thirdlvls)
                {
                    d.Up();
                    for (City t: city)
                    {
                        d.check(t);
                        checkDel(d);
                    }
                }

            }

            if (event.getCode().equals(KeyCode.RIGHT)) {
                for( Units r :units)
                {
                    r.Right();
                    for (City t: city)
                    {
                        r.check(t);
                        checkDel(r);
                    }
                }

                for( Secondlvl c :Secondlvls)
                {
                    c.Right();
                    for (City t: city)
                    {
                        c.check(t);
                        checkDel(c);
                    }
                }

                for( Thirdlvl d :Thirdlvls)
                {
                    d.Right();
                    for (City t: city)
                    {
                        d.check(t);
                        checkDel(d);
                    }
                }
            }

            if (event.getCode().equals(KeyCode.H)) {
                for( Thirdlvl r :Thirdlvls)
                    r.Dial(true);
            }

            if (event.getCode().equals(KeyCode.J)) {
                for( Thirdlvl r :Thirdlvls)
                    r.Dial(false);
            }

            if (event.getCode().equals(KeyCode.DOWN)) {
                for( Units r :units)
                {
                    r.Down();
                    for (City t: city)
                    {
                        r.check(t);
                        checkDel(r);
                    }
                }

                for( Secondlvl c :Secondlvls)
                {
                    c.Down();
                    for (City t: city)
                    {
                        c.check(t);
                        checkDel(c);
                    }
                }

                for( Thirdlvl d :Thirdlvls)
                {
                    d.Down();
                    for (City t: city)
                    {
                        d.check(t);
                        checkDel(d);
                    }
                }
            }

            if (event.getCode().equals(KeyCode.LEFT)) {
                for( Units r :units)
                {
                    r.Left();
                    for (City t: city)
                    {
                        r.check(t);
                        checkDel(r);
                    }
                }

                for( Secondlvl c :Secondlvls)
                {
                    c.Left();
                    for (City t: city)
                    {
                        c.check(t);
                        checkDel(c);
                    }
                }

                for( Thirdlvl d :Thirdlvls)
                {
                    d.Left();
                    for (City t: city)
                    {
                        d.check(t);
                        checkDel(d);
                    }
                }
            }


            if (event.getCode().equals(KeyCode.DELETE)) {

                int count=0;
                for( Units r :units)
                {
                    if(r.isActive) {
                        r.getIv().setVisible(false);
                        count++;
                    }

                }

                Units[] tmp=new Units[units.length-count];

                count=0;
                for( Units r :units)
                {
                    if(!r.isActive) {
                        tmp[count]=r;
                        count++;
                    }

                }
                units= tmp;

                int count2=0;
                for( Secondlvl r :Secondlvls)
                {
                    if(r.isActive) {
                        r.getIv().setVisible(false);
                        count2++;
                    }

                }

                Secondlvl [] tmp2=new Secondlvl[Secondlvls.length - count2];

                count2=0;
                for( Secondlvl r :Secondlvls)
                {
                    if(!r.isActive) {
                        tmp2[count2]=r;
                        count2++;
                    }
                }
                Secondlvls= tmp2;

                int count3=0;
                for( Thirdlvl r :Thirdlvls)
                {
                    if(r.isActive) {
                        r.getIv().setVisible(false);
                        count3++;
                    }

                }

                Thirdlvl [] tmp3=new Thirdlvl[Thirdlvls.length - count3];

                count3=0;
                for( Thirdlvl r :Thirdlvls)
                {
                    if(!r.isActive) {
                        tmp3[count3]=r;
                        count3++;
                    }

                }
                Thirdlvls= tmp3;

                System.out.println("Delete lenght - " + units.length);

            }

            if (event.getCode().equals(KeyCode.ESCAPE)) {
                for (Units r:units)
                {
                    r.isActive = false;
                    r.input = r.clazz.getResourceAsStream(r.url + ".png");
                    r.iv.setImage(new Image(r.input));
                }

                for (Secondlvl c:Secondlvls)
                {
                    c.isActive = false;
                    c.input = c.clazz.getResourceAsStream(c.url + ".png");
                    c.iv.setImage(new Image(c.input));
                }

                for (Thirdlvl d:Thirdlvls)
                {
                    d.isActive = false;
                    d.input = d.clazz.getResourceAsStream(d.url + ".png");
                    d.iv.setImage(new Image(d.input));
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

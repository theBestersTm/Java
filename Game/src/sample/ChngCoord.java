package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class ChngCoord {

    static boolean answer =false;
    public static double x=0;
    public static double y=0;
    public static double firstlvl=0;
    public static double secondlvl=0;
    public static double thirdlvl=0;
    public static String UnitClass = "";
    public static String nick = "";
    public static String team = "";
    public static String level = "";

    public static boolean display(String title, String message)
    {
        ToggleGroup group = new ToggleGroup();
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);



        Label label1=new Label("Перший рівень:");
        label1.setFont(new Font(16));
        TextField textField1 = new TextField();
        textField1.setFont(new Font(16));

        Label label2=new Label("Другий рівень:");
        label1.setFont(new Font(16));
        TextField textField2 = new TextField();
        textField2.setFont(new Font(16));

        Label label3=new Label("Третій рівень:");
        label3.setFont(new Font(16));
        TextField textField3 = new TextField();
        textField3.setFont(new Font(16));



        Label label0=new Label(message);
        label0.setFont(new Font(16));





        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
                // Has selection.
                if (group.getSelectedToggle() != null) {
                    RadioButton button = (RadioButton) group.getSelectedToggle();
                    team = button.getText();
                }
            }
        });





        Button yesButton = new Button("Yes");
        yesButton.setFont(new Font(16));
        yesButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                answer=true;

                firstlvl=Integer.parseInt(textField1.getText());
                secondlvl=Integer.parseInt(textField2.getText());
                thirdlvl=Integer.parseInt(textField3.getText());
                /*wx=Integer.parseInt(textField3.getText());
                wy=Integer.parseInt(textField4.getText());*/


                window.close();
            }
        });


        VBox layout = new VBox(5);
        layout.getChildren().addAll
                (

                        label0,
                        label1,textField1,
                        label2,textField2,
                        label3,textField3,


                        yesButton
                );

        Scene scene = new Scene(layout, 700,700);
        window.setScene(scene);

        window.showAndWait();

        return answer;
    }

}

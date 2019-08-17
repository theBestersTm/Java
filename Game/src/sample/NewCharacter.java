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


public class NewCharacter {

    static boolean answer =false;
    public static double x=0;
    public static double y=0;
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



        Label label1=new Label("Координата X:");
        label1.setFont(new Font(16));
        TextField textField1 = new TextField();
        textField1.setFont(new Font(16));

        Label label2=new Label("Координата Y:");
        label2.setFont(new Font(16));
        TextField textField2 = new TextField();
        textField2.setFont(new Font(16));

        Label label6=new Label("Виберіть рівень персонажу:");
        label6.setFont(new Font(16));
        ObservableList<String> langs2 = FXCollections.observableArrayList("1 - рівень", "2 - рівень", "3 - рівень");
        ComboBox<String> comboBox2 = new ComboBox<String>(langs2);
        comboBox2.setValue("1 - рівень");
        comboBox2.setStyle("-fx-font: 16px \"Tahoma\";");

        Label label0=new Label(message);
        label0.setFont(new Font(16));



        Label label3=new Label("Виберіть фракцію:");
        label3.setFont(new Font(16));
        ObservableList<String> langs = FXCollections.observableArrayList("Spartan", "Neutral", "Soviet", "Natiz");
        ComboBox<String> comboBox1 = new ComboBox<String>(langs);
        comboBox1.setValue("Spartan");
        comboBox1.setStyle("-fx-font: 16px \"Tahoma\";");// устанавливаем выбранный элемент по умолчанию
        /*TextField textField3 = new TextField();
        textField3.setFont(new Font(24));*/

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

        Label label4=new Label("Введіть назву персонажу:");
        label4.setFont(new Font(16));
        TextField textField4 = new TextField();
        textField4.setFont(new Font(16));

        Label label5=new Label("Виберіть команду:");
        label5.setFont(new Font(16));
        RadioButton button1 = new RadioButton("Green");
        button1.setToggleGroup(group);
        button1.setSelected(true);
        RadioButton button2 = new RadioButton("Red");
        button2.setToggleGroup(group);
        button1.setFont(new Font(16));
        button2.setFont(new Font(16));



        Button yesButton = new Button("Yes");
        yesButton.setFont(new Font(16));
        yesButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                answer=true;

                x=Integer.parseInt(textField1.getText());
                y=Integer.parseInt(textField2.getText());
                UnitClass = comboBox1.getValue();
                nick = textField4.getText();
                level = comboBox2.getValue();
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
                        label6,
                        comboBox2,
                        label3,//textField3,
                        comboBox1,
                        label4,textField4,
                        label5, button1, button2,
                        yesButton
                );

        Scene scene = new Scene(layout, 700,700);
        window.setScene(scene);

        window.showAndWait();

        return answer;
    }

}

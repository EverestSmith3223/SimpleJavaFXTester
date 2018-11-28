package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;

    //first screen
    Scene scene1;
    Label lable1;
    Button button1;
    Button button1_2;
    Button button1_3;

    //second screen
    Scene scene2;
    Label lable2;
    Label label2_1;
    TextField textField;
    Button button2;
    Button button2_1;

    //Third screen
    Scene scene3;
    Label lable3;
    Label Lable3_1;
    Button button3;






    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;

        //first screen
        lable1 = new Label("Main Menu");
        button1 = new Button("Screen 2");
        button1_2 = new Button("Screen 3");
        button1_3 = new Button("Screen 4");

        //set actions for buttons for first screen
        button1.setOnAction(e -> window.setScene(scene2));
        button1_2.setOnAction(e -> window.setScene(scene3));
       

        //layout for first screen
        VBox layoutScene1 = new VBox(20);
        layoutScene1.setAlignment(Pos.CENTER);
        layoutScene1.getChildren().addAll(lable1, button1, button1_2, button1_3);
        scene1 = new Scene(layoutScene1, 200, 600);


        //second screen
        lable2 = new Label("Simple Interactive Window");
        textField = new TextField();
        textField.setPromptText("Type your message here");
        label2_1 = new Label("Message will appear here");
        button2 = new Button("Print Message");
        button2_1 = new Button("Main Menu");

        //set actions for buttons for second screen
        button2.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    label2_1.setText(textField.getText());
                                    System.out.print(textField.getText());
                                }
                            }

        );
        button2_1.setOnAction(e ->window.setScene(scene1));

        //layout for second screen
        GridPane layoutScene2 = new GridPane();
        layoutScene2.setAlignment(Pos.CENTER);
        layoutScene2.setVgap(20);
        layoutScene2.add(lable2,0,0);
        layoutScene2.add(textField,0,1,2,1);
        layoutScene2.add(label2_1,0,3);
        layoutScene2.add(button2,0,4);
        layoutScene2.add(button2_1,1,4);
        scene2 = new Scene(layoutScene2, 400,400);



        //third screen
        lable3 = new Label("Click on one of the Squares");
        Lable3_1 = new Label();
        Rectangle rect1 = new Rectangle(50,50,50,50);
        rect1.setFill(Color.RED);
        Rectangle rect2 = new Rectangle(50,150, 50,50);
        rect2.setFill(Color.BLUE);
        Rectangle rect3 = new Rectangle(50,250, 50, 50);
        rect3.setFill(Color.GREEN);
        button3 = new Button("MainMenu");

        //set actions for buttons on third screen
        button3.setOnAction(e -> window.setScene(scene1));


        //layout for third screen

        Group layoutScene3 = new Group();

        lable3.relocate(150,50);
        Lable3_1.relocate(150,150);
        button3.relocate(150,250);

        layoutScene3.getChildren().addAll(lable3,rect1,rect2,rect3,Lable3_1,button3);

        scene3 = new Scene(layoutScene3, 600,600);
        scene3.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(rect1.contains(event.getX(),event.getY())){
                    Lable3_1.setText("You clicked on the RED square");
                    System.out.println(rect1.contains(event.getX(),event.getY()));
                }
                else if(rect2.contains(event.getX(),event.getY())){
                    Lable3_1.setText("You clicked on the BLUE square");
                }
                else if(rect3.contains(event.getX(),event.getY())){
                    Lable3_1.setText("You clicked on the GREEN square");
                }
                else{
                    Lable3_1.setText("You clicked point: ("+event.getX()+", "+ event.getY()+")" );
                }
            }
        });















        //set the initial scene when the program starts
        window.setScene(scene1);
        window.setTitle("Welcome to the GunShow");
        window.show();



    }
}

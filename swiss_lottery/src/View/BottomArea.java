package View;


import Model.LotteryModel;
import javafx.animation.*;
import javafx.scene.control.Button;


import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Stack;

public class BottomArea extends VBox {

    public Ball ball;

    public Button btnPlay = new Button("Play");
    //public Circle ball = new Circle(30, Color.BLACK);


    LotteryView view;
    LotteryModel model;


    public BottomArea(){
        super();
        //spacer.getStyleClass().add("spacerBottomArea");

        this.getChildren().addAll(btnPlay);
        this.getStyleClass().add("bottomArea");

    }

    public void animation(ArrayList<Integer> numbers, ArrayList<Integer> lucky){

        StackPane stackPane = new StackPane();
        for(int i = 0; i < numbers.size();i++){
            ball = new Ball(numbers.get(i));
            PathElement path1 = new MoveTo((800+(i*60)), 35);
            PathElement path2 = new LineTo(100+(i*60), 35);
            Path path = new Path();
            path.getElements().add(path1);
            path.getElements().add(path2);
            RotateTransition rt = new RotateTransition(Duration.millis(500), ball);
            rt.setByAngle(-360);
            rt.setCycleCount(8);
            rt.setAutoReverse(false);

            PathTransition move = new PathTransition(Duration.millis(4000), path, ball);

            move.setAutoReverse(false);
            move.setCycleCount(1);
            rt.play();
            move.play();
            stackPane.getChildren().add(ball);

        }
        getChildren().add(stackPane);


        /*
        PathElement path1 = new MoveTo(800, 35);
        PathElement path2 = new LineTo(100, 35);

        Path path = new Path();
        path.getElements().add(path1);
        path.getElements().add(path2);

        RotateTransition rt = new RotateTransition(Duration.millis(500), ball);
        rt.setByAngle(-360);
        rt.setCycleCount(8);
        rt.setAutoReverse(false);

        PathTransition move = new PathTransition(Duration.millis(4000), path, ball);

        move.setAutoReverse(false);
        move.setCycleCount(1);
        rt.play();
        move.play();
        */





    }
}

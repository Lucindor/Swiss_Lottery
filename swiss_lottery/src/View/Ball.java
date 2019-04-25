package View;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class Ball extends StackPane {
    Text text;
    Circle circle = new Circle(20,30,30);


    public Ball(){

        super();
        text = new Text("Test");
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        this.getChildren().addAll(circle, text);

    }
    public Ball(int i){
        super();
        text = new Text(Integer.toString(i));
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        this.getChildren().addAll(circle, text);
    }
}

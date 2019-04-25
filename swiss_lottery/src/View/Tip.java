package View;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class Tip extends HBox {


    public HBox hBoxNumbers = new HBox();
    public Label lblLuckyNumber = new Label("y");
    public Label lblNumber;
    public Button btnDelete = new Button("Delete");


    public Tip(){

    }


    public Tip(ArrayList<Integer> n, ArrayList<Integer> l){
        super();

        //lblNr = new Label(counter + ". "); //needs to be increased after each tip
        for(int i = 0; i<n.size();i++){
            lblNumber = new Label(n.get(i).toString());
            lblNumber.setAlignment(Pos.CENTER);
            lblNumber.getStyleClass().add("tipLabel");
            hBoxNumbers.getChildren().add(lblNumber);
        }
        lblLuckyNumber = new Label(l.get(0).toString());
        lblLuckyNumber.setAlignment(Pos.CENTER);
        lblLuckyNumber.getStyleClass().add("tipLuckyNumber");
         //doesnt work properly
        getChildren().addAll(hBoxNumbers, lblLuckyNumber, btnDelete);
    }



    public Button getBtnDelete(){return btnDelete;}
}

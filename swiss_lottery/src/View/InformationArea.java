package View;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class InformationArea extends VBox {

    public Label lblTicketsUsed = new Label("Tickets used: ");


    public InformationArea(){
        super();

        this.getChildren().addAll(lblTicketsUsed);


    }
}

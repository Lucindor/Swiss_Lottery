package View;


import Controller.LotteryController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;



public class TicketListArea extends VBox {

    private Label lblInfo = new Label("Your tips:");


       public TicketListArea(){
        super();


        getChildren().addAll(lblInfo);


    this.getStyleClass().add("ticketListArea");



    }


}

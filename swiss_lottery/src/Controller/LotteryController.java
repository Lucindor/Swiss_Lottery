package Controller;

import Model.LotteryModel;
import View.LotteryView;
import View.Tip;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;


import java.util.Collections;



public class LotteryController implements EventHandler<ActionEvent> {

    private LotteryModel model;
    private LotteryView view;

    String standardBtn = "-fx-background-color: pink";
    String clickedBtn = "-fx-background-color: orange";
    String standardLuckyBtn = "-fx-background-color: yellow";

    public LotteryController(LotteryModel model, LotteryView view){
        this.view= view;
        this.model = model;

    view.getBtnDarkMode().setOnAction(e-> darkmode());
    view.getBtnLottoMode().setOnAction(e-> lottomode());
    view.getBtnExit().setOnAction(e-> shutDown());
    view.getBtnOdds().setOnAction(e-> odds());
    view.getBtnReset().setOnAction(e-> resetGame());
    view.getBtnSaveTip().setOnAction(e-> addTip());
    view.getBtnDelete().setOnAction(this::deleteTip);
    view.getBtnGenerateRandom().setOnAction( e -> generateRandom());

    view.getBtnPlay().setOnAction(e-> play());

    /** getting for all 42 buttons a setOnAction */
    for(Button button: view.getButtons()){
        button.setOnAction(this::handle);
    }

    /** getting for all 6 lucky numbers a setOnAction */
    for(Button luckyNumbers : view.getLuckyNumbers()){
            luckyNumbers.setOnAction(this::clickedLuckyNumber);
        }

    /*
    for(Button delete : view.getBtnDelete()){
        delete.setOnAction(this::deleteTip);
    }
    */



    }

    private void play() {
        view.bottomArea.animation(model.generateRandomNumbers(), model.generateRandomLuckyNumber());
    }

    private void addTip() {

        Collections.sort(model.getChosenNumbers());

        if(model.isTipPossible()){
            view.getTicketListArea().getChildren().add(new Tip(model.getChosenNumbers(),model.getChosenLuckyNumber()));
            model.getTips().add(new Tip(model.getChosenNumbers(), model.getChosenLuckyNumber()));
            model.addTip();
        }
        clearAfterSave();

    }

    private void deleteTip(ActionEvent event) {
        Button btn = (Button) event.getSource();
        System.out.println(btn.getParent());
        model.getTips().remove(btn.getParent());
        view.getTicketListArea().getChildren().remove(btn.getParent());
        model.removeTip();
    }



    /** generates 6 unique numbers and 1 lucky number */
    private void generateRandom() {
        clearButtons();

        model.generateRandomNumbers();
        model.generateRandomLuckyNumber();

        /**     marks the btns which have been generated */

            for(int i = 0; i<model.getChosenNumbers().size();i++){
                for(Button button:view.getButtons()){
                if(button.getText().equals(model.getChosenNumbers().get(i).toString())){
                    model.addNr();
                    button.setStyle(clickedBtn);
                }
            }
        }
            for(int j = 0; j < model.getChosenLuckyNumber().size();j++){
                for(Button lucky : view.getLuckyNumbers()){
                    if(lucky.getText().equals(model.getChosenLuckyNumber().get(j).toString())){
                        model.addLuckyNr();
                        lucky.setStyle(clickedBtn);
                    }
                }
            }
        System.out.println(model.getChosenNumbers());
            System.out.println(model.getChosenLuckyNumber());
        checkAll();

    }

    public void handle(ActionEvent event){
        Button btn = (Button) event.getSource();
        Integer clickedButton = Integer.parseInt(btn.getText());

        if(model.getChosenNumbers().contains(clickedButton)){
            btn.setStyle(standardBtn);
            model.getChosenNumbers().remove(clickedButton);
            model.deleteNr();

            System.out.println(model.getChosenNumbers());
        }else{
            if(model.isPossible()){
                btn.setStyle(clickedBtn);
                model.getChosenNumbers().add(clickedButton);
                model.addNr();
                view.getBtnSaveTip().setDisable(!model.isComplete());
            }

        }

       checkAll();
        view.getBtnSaveTip().setDisable(!model.isComplete());

        System.out.println(model.getChosenNumbers());

    }



    private void clickedLuckyNumber(ActionEvent event) {

        Button btn = (Button) event.getSource();
        Integer clickedButton = Integer.parseInt(btn.getText());

        if(model.getChosenLuckyNumber().contains(clickedButton)){
            btn.setStyle(standardLuckyBtn);
            model.getChosenLuckyNumber().remove(clickedButton);
            model.deleteLuckyNr();
        }else{
            if(model.isPossibleLucky()){
                btn.setStyle(clickedBtn);
                model.addLuckyNr();
                model.getChosenLuckyNumber().add(clickedButton);
            }
        }
      checkAll();
       view.getBtnSaveTip().setDisable(!model.isComplete());

    }


    private void darkmode() { /** to be done in the end*/
    }

    private void lottomode(){ /** to be done in the end*/

    }

    private void shutDown(){
       System.exit(0);
    }

    private void odds(){ /** to be done in the end*/

    }
    private void resetGame(){ /** to be done in the end*/

    }

    /** making sure that everything is ready for the next tip */
    private void clearAfterSave() {
        model.getChosenNumbers().clear();
        model.getChosenLuckyNumber().clear();
        clearButtons();
        view.getBtnSaveTip().setDisable(true);
        model.setCounterNumbers(0);
        model.setCounterLuckyNumbers(0);
    }

    private void clearButtons() {
        for(Button btn : view.getButtons()){
            btn.setStyle(standardBtn);
        }
        for(Button lucky: view.getLuckyNumbers()){
            lucky.setStyle(standardLuckyBtn);
        }
    }

    private void checkAll() {
        if(model.isComplete() && model.isTipPossible()){
            view.getBtnSaveTip().setDisable(!model.isComplete());
        }
    }
}

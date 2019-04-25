package Model;

import View.Tip;

import java.util.ArrayList;
import java.util.Random;

public class LotteryModel {

    public int counterNumbers =0;
    public int tipCounter =0;
    public int counterLuckyNumbers = 0;
    public static final int MAX_NUMBERS = 6;
    public static final int MAX_LUCKYNUMBERS = 1;
    public static final int MAX_TIPS = 10;

    public ArrayList<Integer> getChosenNumbers() {
        return chosenNumbers;
    }

    public ArrayList<Integer> getChosenLuckyNumber() {
        return chosenLuckyNumber;
    }

    public ArrayList<Integer> chosenNumbers = new ArrayList<>();
    public ArrayList<Integer> chosenLuckyNumber = new ArrayList<>();
    public ArrayList<Tip> tips = new ArrayList<>();

    private Random generator = new Random();


    public LotteryModel(){

    }

    public boolean isPossible() {

        /** checks if the user can choose another one or not */
        if (getCounterNumbers() >= MAX_NUMBERS){
            return false;
        }else{
            return true;
        }
    }

    public boolean isPossibleLucky(){

        /** checks if the user can choose another one or not */
        if (getCounterLuckyNumbers() >= MAX_LUCKYNUMBERS){
            return false;
        }else{
            return true;
        }
    }

    public boolean isComplete(){
        if ((!isPossible()) && (!isPossibleLucky())){
            return true;
        }else{
            return  false;
        }
    }

    public ArrayList<Integer> generateRandomNumbers() {

        int generatedNumber;
        boolean finished = false;

        /** making sure the arraylist is empty */
        chosenNumbers.clear();


        while (!finished) {
            generatedNumber = generator.nextInt((42))+1;


            if (chosenNumbers.isEmpty() || !isDuplicate(generatedNumber)) {
                chosenNumbers.add(generatedNumber);
                if (chosenNumbers.size() == MAX_NUMBERS) {
                    finished = true;
                }
            }
        }
        System.out.println(chosenNumbers);

        return chosenNumbers;

    }

    public ArrayList<Integer> generateRandomLuckyNumber() {
        chosenLuckyNumber.clear();
        chosenLuckyNumber.add(generator.nextInt(6)+1);

        System.out.println(chosenLuckyNumber);
        return chosenLuckyNumber;
    }

    private boolean isDuplicate(int n){
        boolean isTwice = false;
        for (int i = 0; i < chosenNumbers.size(); i++){
            if(chosenNumbers.get(i)== n){
                isTwice = true;
                break;
            }
        }
        return isTwice;
    }

    public boolean isTipPossible(){
        if(tipCounter < MAX_TIPS){

            System.out.println(tipCounter);
            return true;
        }else{
            return false;
        }

    }

    public void deleteNr() {
        counterNumbers--;
    }

    public void addNr(){
        counterNumbers++;
    }

    private int getCounterNumbers(){return counterNumbers;}

    public int getCounterLuckyNumbers() {
        return counterLuckyNumbers;
    }

    public void addLuckyNr() {
        counterLuckyNumbers++;
    }

    public void deleteLuckyNr(){
        counterLuckyNumbers--;
    }
    public void setCounterNumbers(int counterNumbers) {
        this.counterNumbers = counterNumbers;
    }

    public void setCounterLuckyNumbers(int counterLuckyNumbers) {
        this.counterLuckyNumbers = counterLuckyNumbers;
    }
    public void addTip(){
        tipCounter++;
    }

    public ArrayList<Tip> getTips() {
        return tips;
    }

    public void removeTip() {
        tipCounter--;
    }
}


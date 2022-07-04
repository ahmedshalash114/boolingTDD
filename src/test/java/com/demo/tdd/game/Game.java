package com.demo.tdd.game;

public class Game {

    int [] rolled = new int[22];

    private int currentBall = 0 ;
    public void roll(int pins) {
        rolled[currentBall] = pins;
        currentBall++;
    }

    public int score() {
        int score = 0;
        int thisBall = 0 ;
        for (int i = 0 ; i < 10 ; i++){

            if(isStrike(rolled[thisBall])){ // strike
                score+=  10 + rolled[thisBall+1] + rolled[thisBall+2];
                thisBall ++ ;
            }
            else if(isSpare(rolled[thisBall] + rolled[thisBall + 1])){ // spare
                score+=10 +rolled[thisBall+2];
                thisBall+=2;
            }
        else {
                score += rolled[thisBall] + rolled[thisBall + 1];
                thisBall+=2;
            }
        }
        return score;
    }

    private boolean isSpare(int rolled) {
        return rolled == 10;
    }

    private boolean isStrike(int rolled) {
        return rolled == 10;
    }
}

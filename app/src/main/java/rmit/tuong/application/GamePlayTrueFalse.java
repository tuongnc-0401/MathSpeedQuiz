package rmit.tuong.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
// Generate the game for game 2
public class GamePlayTrueFalse {

    private List<ExpressionTrueFalse> expressionList;
    private int numOfCorrect;
    private int numOfIncorrect;
    private int total;
    private int score;
    private int limit;
    private ExpressionTrueFalse current;

    // constructor for new game
    public GamePlayTrueFalse(){
        numOfCorrect = 0;
        total = 0;
        score = 0;
        current = new ExpressionTrueFalse( 50);
        expressionList = new ArrayList<ExpressionTrueFalse>();
    }

    // create a new question and add to list
    public void createNewExpression() {
        current = new ExpressionTrueFalse(generateLimit());
        total++;
        expressionList.add(current);
    }

    // generate a max num for a question ( more true answers, question will be more difficult)
    public int generateLimit(){
        return (numOfCorrect /3) * 15 +50;
    }


    // get the answer of user and check true or false
    public boolean checkAns (int answer){
        boolean flag;
        if(current.getAnswer() == answer){
            flag =true;
            numOfCorrect++;
            score = numOfCorrect* 10;

        } else {
            return false;
        }
        return flag;
    }



    // getter and setter
    public List<ExpressionTrueFalse> getExpressionList() {
        return expressionList;
    }

    public void setExpressionList(List<ExpressionTrueFalse> expressionList) {
        this.expressionList = expressionList;
    }

    public int getNumOfCorrect() {
        return numOfCorrect;
    }

    public void setNumOfCorrect(int numOfCorrect) {
        this.numOfCorrect = numOfCorrect;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public ExpressionTrueFalse getCurrent() {
        return current;
    }

    public void setCurrent(ExpressionTrueFalse current) {
        this.current = current;
    }
}

package rmit.tuong.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GamePlayTrueFalse {

    private List<ExpressionTrueFalse> expressionList;
    private int numOfCorrect;
    private int numOfIncorrect;
    private int total;
    private int score;

    private int limit;
    private ExpressionTrueFalse current;

    public GamePlayTrueFalse(){
        numOfCorrect = 0;
        total = 0;
        score = 0;
        current = new ExpressionTrueFalse( 50);
        expressionList = new ArrayList<ExpressionTrueFalse>();
    }
    public void createNewExpression() {
        current = new ExpressionTrueFalse(generateLimit());
        total++;
        expressionList.add(current);
    }

    public int generateLimit(){
        return (numOfCorrect /3) * 15 +50;
    }

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

package rmit.tuong.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// generate one game for game 1
public class GamePlay {
    private List<Expression> expressionList;
    private int numOfCorrect;
    private int numOfIncorrect;
    private int total;
    private int score;
    private ArrayList<String> signsList = new ArrayList<String>() {
        {
            add("+");
            add("-");
            add("x");
            add(":");
        }
    };
    private String sign;
    private int limit;
    private Expression current;

    // constructor for one game.
    public GamePlay(){
        numOfCorrect = 0;
        total = 0;
        score = 0;
        Random rand = new Random();
        int int_random = rand.nextInt(4);
        this.sign = signsList.get(int_random);
        current = new Expression(this.sign, 10);
        expressionList = new ArrayList<Expression>();
    }

    // create a new question and add to list
    public void createNewExpression() {
        Random rand = new Random();
        int int_random = rand.nextInt(4);
        this.sign = signsList.get(int_random);
        current = new Expression(this.sign, generateLimit());
        total++;
        expressionList.add(current);
    }

    // generate a max num of one question
    public int generateLimit(){
        return (numOfCorrect /3) * 15 +10;
    }

    // get the ans of user and check true or false
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
    public List<Expression> getExpressionList() {
        return expressionList;
    }

    public void setExpressionList(List<Expression> expressionList) {
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

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Expression getCurrent() {
        return current;
    }

    public void setCurrent(Expression current) {
        this.current = current;
    }
}

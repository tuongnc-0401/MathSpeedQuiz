package rmit.tuong.application;

import java.util.ArrayList;
import java.util.Random;

public class ExpressionTrueFalse {
    private int firstNum;
    private int secondNum;

    // question and answer of expression
    private String question;
    private int answer;

    // sign of expression
    private String sign;
    private ArrayList<String> signsList = new ArrayList<String>() {
        {
            add("+");
            add("-");
            add("x");
            add(":");
        }
    };

    // constructor
    public ExpressionTrueFalse(int limit) {
        // random
        Random maker = new Random();

        //set sign
        this.sign = signsList.get(maker.nextInt(4));
        boolean flag = maker.nextBoolean();

        // Sign is +
        if (this.sign.equals("+")) {
            this.firstNum = maker.nextInt(limit);
            this.secondNum = maker.nextInt(limit);
            int res = this.firstNum + this.secondNum;

            if (flag == true) {

                this.question = firstNum + " " + sign + " " + secondNum + " = " + res;
                this.answer = 1;
            } else {
                int resWrong = generateWrongRes(res) + res;
                this.question = firstNum + " " + sign + " " + secondNum + " = " + resWrong;
                this.answer = 0;
            }


        }

        // Sign is -
        if (this.sign.equals("-")) {
            int tmp1 = maker.nextInt(limit);
            int tmp2 = maker.nextInt(limit);
            if (tmp1 > tmp2) {
                this.firstNum = tmp1;
                this.secondNum = tmp2;
            } else {
                this.firstNum = tmp2;
                this.secondNum = tmp1;
            }
            int res = this.firstNum - this.secondNum;
            if (flag == true) {
                this.question = firstNum + " " + sign + " " + secondNum + " = " + res;
                this.answer = 1;
            } else {
                int resWrong = res - generateWrongRes(res);
                this.question = firstNum + " " + sign + " " + secondNum + " = " + resWrong;
                this.answer = 0;
            }

        }

        // Sign is x
        if (this.sign.equals("x")) {
            this.firstNum = maker.nextInt(limit / 2);
            this.secondNum = maker.nextInt(limit / 2);
            int res = this.firstNum * this.secondNum;
            if (flag == true) {

                this.question = firstNum + " " + sign + " " + secondNum + " = " + res;
                this.answer = 1;
            } else {
                int resWrong = generateWrongRes(res) + res;
                this.question = firstNum + " " + sign + " " + secondNum + " = " + resWrong;
                this.answer = 0;
            }
        }

        // sign is :
        if (this.sign.equals(":")) {
            int tmp1 = maker.nextInt(limit / 2);
            int tmp2 = maker.nextInt(limit / 2);
            if (tmp1 == 0) {
                tmp1 += 1;
            }
            if (tmp2 == 0) {
                tmp2 += 1;
            }


            this.firstNum = tmp1 * tmp2;
            this.secondNum = tmp1;
            int res = tmp2;

            if (flag == true) {
                this.question = firstNum + " " + sign + " " + secondNum + " = " + res;
                this.answer = 1;
            } else {
                int resWrong = res - generateWrongRes(res);
                this.question = firstNum + " " + sign + " " + secondNum + " = " + resWrong;
                this.answer = 0;
            }

        }


    }

    // getter and setter for all attributes
    public int getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(int firstNum) {
        this.firstNum = firstNum;
    }

    public int getSecondNum() {
        return secondNum;
    }

    public void setSecondNum(int secondNum) {
        this.secondNum = secondNum;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }


    private int generateWrongRes(int trueRes) {
        Random maker = new Random();
        int res = maker.nextInt(10);
        return res;
    }
}

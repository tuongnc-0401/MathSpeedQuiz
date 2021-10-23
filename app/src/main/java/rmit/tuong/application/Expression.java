package rmit.tuong.application;

import java.util.Random;

public class Expression {
    private int firstNum;
    private int secondNum;

    // question and answer of expression
    private String question;
    private int answer;

    // sign of expression
    private String sign;

    public Expression(String s, int limit) {

        //set sign
        this.sign = s;
        // random 2 nums
        Random maker = new Random();



        if(this.sign.equals("+")){
            this.firstNum = maker.nextInt(limit);
            this.secondNum = maker.nextInt(limit);
            this.question = firstNum + " " +sign+ " " +secondNum;
            this.answer = this.firstNum + this.secondNum;
        }
        if(this.sign.equals("-")){
            int tmp1 = maker.nextInt(limit);
            int tmp2 = maker.nextInt(limit);
           if(tmp1>tmp2){
               this.firstNum = tmp1;
               this.secondNum = tmp2;
           } else {
               this.firstNum = tmp2;
               this.secondNum = tmp1;
           }
            this.question = firstNum + " " +sign+ " " +secondNum;
            this.answer = this.firstNum - this.secondNum;
        }

        if(this.sign.equals("x")){
            this.firstNum = maker.nextInt(limit/2);
            this.secondNum = maker.nextInt(limit/2);
            this.question = firstNum + " " +sign+ " " +secondNum;
            this.answer = this.firstNum * this.secondNum;
        }

        if(this.sign.equals(":")){
            int tmp1 = maker.nextInt(limit/2);
            int tmp2 = maker.nextInt(limit/2);
            if (tmp1 == 0){
                tmp1+=1;
            }
            if (tmp2 == 0){
                tmp2+=1;
            }


            this.firstNum = tmp1 * tmp2;
            this.secondNum = tmp1;
            this.question = firstNum + " " +sign+ " " +secondNum;
            this.answer =tmp2;
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
}

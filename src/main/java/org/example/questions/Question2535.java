package org.example.questions;

public class Question2535 {
    public static void main(String[] args){
        Question2535 question2535=new Question2535();
        int [] nums={1,15,6,3};
        question2535.differenceOfSum(nums);
    }
    public int differenceOfSum(int[] nums) {
        int sum1=0;
        int sum2=0;
        for (int num : nums) {
            sum1+=num;
            while(num>0){
                int i=num%10;
                num/=10;
                sum2+=i;
            }
        }
        return sum2-sum1>0?sum2:sum1-sum2;
    }
}

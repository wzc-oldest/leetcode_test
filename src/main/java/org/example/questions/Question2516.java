package org.example.questions;

import org.example.Main;

public class Question2516 {
    public static void main(String[] args){
        String s="ababaacaacaabc";
        Question2516 question2516=new Question2516();
        int num=question2516.takeCharacters(s,2);
        System.out.println(num);
    }
    public int takeCharacters(String s, int k) {
        if(k==0){
            return 0;
        }
        int[] sign={k,k,k};
        for (char c : s.toCharArray()) {
            sign[c-'a']-=1;
        }
        int left=-1;
        int max=-1;
        for(int right=0;right<s.length();right++){
            sign[s.charAt(right)-'a']+=1;
            if(sign[s.charAt(right)-'a']>0){
                while(left<right && sign[s.charAt(right)-'a']>0){
                    left+=1;
                    sign[s.charAt(left)-'a']-=1;
                }
            }
            if(sign[0]<=0&&sign[1]<=0&&sign[2]<=0){
                int num=right-left;
                if(max<=num){
                    max=num;
                }
            }
        }
        return max==-1?max:s.length()-max;
    }
}

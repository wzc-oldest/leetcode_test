package org.example.questions;

/*
给你一个下标从 0 开始的字符串 text 和另一个下标从 0 开始且长度为 2 的字符串 pattern ，两者都只包含小写英文字母。

你可以在 text 中任意位置插入 一个 字符，这个插入的字符必须是 pattern[0] 或者 pattern[1] 。注意，这个字符可以插入在 text 开头或者结尾的位置。

请你返回插入一个字符后，text 中最多包含多少个等于 pattern 的 子序列 。

子序列 指的是将一个字符串删除若干个字符后（也可以不删除），剩余字符保持原本顺序得到的字符串。

实际上只需要考虑在开头插入下标0和在结尾插入下标1的数据 然后从左到右遍历注意考虑重复的情况 最后统计即可
 */

public class Question2207 {
    public static void main(String[] args) {
        //TIP 当文本光标位于高亮显示的文本处时按 <shortcut actionId="ShowIntentionActions"/>
        // 查看 IntelliJ IDEA 建议如何修正。
    }
    public long maximumSubsequenceCount(String text, String pattern) {
        long sum=0;
        String newText=pattern.charAt(0)+text;
        sum=max(sum,getSum(newText,pattern.charAt(0),pattern.charAt(1)));
        newText=text+pattern.charAt(1);
        sum=max(sum,getSum(newText,pattern.charAt(0),pattern.charAt(1)));
        return sum;
    }
    private long getSum(String text, char start,char end){
        long leftCount=0;
        long sum=0;
        long count=0;
        for (int i = 0; i < text.length(); i++) {
            char c=text.charAt(i);
            if(c==start){
                leftCount+=1;
            }
            if(c==end){
                count+=1;
                sum+=leftCount;
            }
        }
        if(start==end){
            return sum-count-2;
        }
        return sum;
    }
    private long max(long i,long j){
        return i>=j?i:j;
    }
}

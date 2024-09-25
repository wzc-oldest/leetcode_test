package org.example.questions;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Question2306 {
    public static void main(String[] args){
        Question2306 question2306=new Question2306();
        //String[] array={"coffee","donuts","time","toffee"};
        String[] array={"sfuzder","spklurny","kvdolme","kbbdklkpgk","za","mdbsmnjiu","pzydbfwiw","lvvyshmd","ow","ssipb","jucpsquexm","ffuzder","uftruik","ringlxh","jz","sjlxouiv","csdbtsvg","openygbaix","dcn","r","hwql","ok","y","sze","ttptd","atxp","ejfpsea","vjfpsea","lj","drmvufbt","zxambug","ozpxq","qzydbfwiw","lqxik","bjo","rrmvufbt","jvl","rzxaaa","nmfydhawa","shlwkf","rcl","hhn","yrmcsc","yieuzizaeh","nrmvufbt","rinsldgdpp","wqg","tyhkgqcu","rsdbtsvg","zvehtqiqxa","jtz","mjaguebiy","fztbpozhf","zzpxq","ue","foktqxiqe","ztf","dn","lxambug","kinsldgdpp","jhn","k","i","qxtava","roktqxiqe","hr","bwzw","mot","cadj","x","bcep","u","kzydbfwiw","ahku","ijo"};
        long result=question2306.distinctNames(array);
        System.out.println(result);
    }
    private Set<Character> getSet(){
        Set<Character> set=new HashSet<>();
        for(char a='a';a<='z';a++){
            set.add(a);
        }
        return set;
    }
    public long distinctNames(String[] ideas) {
        Map<Character,Set<String>> leftToRight=new HashMap<>();
        int count=0;
        for (String idea : ideas) {
            char left=idea.charAt(0);
            String right=idea.substring(1);
            leftToRight.computeIfAbsent(left,key->new HashSet<>()).add(idea.length()==1?"-1":right);
        }
        long result=0;
        for (Map.Entry<Character, Set<String>> characterSetEntry : leftToRight.entrySet()) {
            for (Map.Entry<Character, Set<String>> setEntry : leftToRight.entrySet()) {
                if(characterSetEntry==setEntry){
                    continue;
                }
                long temp=get(characterSetEntry.getValue(),setEntry.getValue());
                result+= (long) (characterSetEntry.getValue().size() - temp) *(setEntry.getValue().size()-temp);
            }
        }
        return result;
        }

        private long get(Set<String> a,Set<String> b){
        long count=0;
        for (String s : a) {
            if(b.contains(s)){
                count+=1;
            }
            }
        return count;
        }
}

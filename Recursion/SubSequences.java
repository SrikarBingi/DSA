package Recursion;

import java.util.ArrayList;

public class SubSequences {
    public static void main(String[] args) {
        // subSequences("","abc");
        System.out.println(subSequences1("", "abc"));
    }
    public static void subSequences(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return ;
        }
        subSequences(p+up.charAt(0), up.substring(1));
        subSequences(p, up.substring(1));
    }
    public static ArrayList<String> subSequences1(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> left = subSequences1(p+up.charAt(0), up.substring(1));
        ArrayList<String> right = subSequences1(p, up.substring(1));
        left.addAll(right);
        return left;
    }
}

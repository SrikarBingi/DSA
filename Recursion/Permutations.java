package Recursion;

import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        permutations("","abc");
        System.out.println(permutations2("", "abc"));
    }
    public static void permutations(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String first = p.substring(0, i);
            String second = p.substring(i,p.length());
            permutations(first+ch+second, up.substring(1));
        }
    }
    public static ArrayList<String> permutations2(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        char ch=up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String first = p.substring(0, i);
            String second = p.substring(i,p.length());
            list.addAll(permutations2(first+ch+second, up.substring(1)));
        }
        return list;
    }
}

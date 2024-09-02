package Recursion;

import java.util.ArrayList;

public class PhonePad {
    public static void main(String[] args) {
        phonePad("","12");
        System.out.println(phonePad2("", "12"));
    }
    static void phonePad(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        int n=up.charAt(0)-'0';
        for(int i=(n-1)*3;i<n*3;i++){
            char ch=(char)('a'+i);
            phonePad(p+ch, up.substring(1));
        }
    }
    static ArrayList<String> phonePad2(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        int n = up.charAt(0)-'0';
        for(int i=(n-1)*3;i<n*3;i++){
            char ch = (char)('a'+i);
            list.addAll(phonePad2(p+ch, up.substring(1)));
        }
        return list;
    }
}

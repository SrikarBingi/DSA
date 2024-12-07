import java.util.*;

public class a {
    public static void helper(String[] words, String target, List<String> valid){
        for(String word : words){
            if(target.contains(word) || word.contains(target)){
                if(!valid.contains(word)){
                    valid.add(word);

                }
            }
        }
    }
    public static int minValidStrings(String[] words, String target) {
        List<String> valid = new ArrayList<>();
        for(int i=0;i<target.length();i++){
            helper(words,target.substring(0,i),valid);
        }
        return valid.size()==0?-1:valid.size();
    }
    public static void main(String[] args) {
        // String[] arr = {"abcdef"};
        // int ans = minValidStrings(arr, "xyz");
        // System.out.println(ans);
        String a = "abc";
        System.out.println(a.substring(0,0));
    }
}

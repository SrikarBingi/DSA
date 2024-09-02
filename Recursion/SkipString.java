package Recursion;

//remove all a's from a string
public class SkipString {
    public static void main(String[] args) {
        System.out.println(skip( "abcaxcaadab"));
    }
    public static String skip(String p, String up){
        if(up.isEmpty()){
            return p;
        }
        char c=up.charAt(0);
        if(c=='a'){
            return skip(p, up.substring(1));
        }
        return skip(p+c, up.substring(1));
    }

    //without taking empty string

    public static String skip(String up){
        if(up.isEmpty()){
            return "";
        }
        char ch = up.charAt(0);
        if(ch=='a'){
            return skip(up.substring(1));
        }
        return ch+skip(up.substring(1));
    }
}

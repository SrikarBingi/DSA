package Recursion;

public class SkipApple {
    public static void main(String[] args) {
        System.out.println(skipApp("abcdappleefappgh"));
    }
    public static String skipApple(String up){
        if(up.isEmpty()){
            return "";
        }
        if(up.startsWith("apple")){
            return skipApple(up.substring(5));
        }
        return up.charAt(0)+skipApple(up.substring(1));
    }

    //remove app if it doesnot start with apple

    public static String skipApp(String up){
        if(up.isEmpty()){
            return "";
        }
        if(up.startsWith("app") && !up.startsWith("apple")){
            return skipApp(up.substring(3));
        }
        return up.charAt(0)+skipApp(up.substring(1));
    }
}

import java.util.*;

public class removeSpace {
    public static String remove(String s) {
        String[] str = s.split("\\s+");
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            newStr.append(str[i] + ' ');
        }
        return newStr.toString();
    }
    
    public static void main(String[] args){
        String s = "I love   this game !  ";
        System.out.println(remove(s));
    }
}
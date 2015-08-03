import java.util.*;

public class CapitalFirst {
    public String Capital (String s)  {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                res.append(Character.toUpperCase(s.charAt(i)));
            }else{
                if (s.charAt(i - 1) == ' ') {
                    res.append(Character.toUpperCase(s.charAt(i)));
                }else{
                    res.append(s.charAt(i));
                }
            }
        }
        return res.toString();
    }
    
    public static void main(String[] args) {
        String input = "this is a test sentence.";
        CapitalFirst test = new CapitalFirst();
        System.out.println(test.Capital(input));
    }
}
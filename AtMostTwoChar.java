import java.util.*;

public class AtMostTwoChar {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int walker = 0;
        int runner = 0;
        int max = 1;
        while (runner < s.length()) {
            if (map.size() < 2) {
                map.put(s.charAt(runner), runner);
                runner++;
                max = Math.max(max, runner - walker);
            }else if(map.size() >= 2) {
                if (map.containsKey(s.charAt(runner))) {
                    map.put(s.charAt(runner), runner);
                    runner++;
                    max = Math.max(max, runner - walker);
                }else{
                    walker = Integer.MAX_VALUE;
                    for (int index : map.values()) {
                        walker = Math.min(index, walker);
                    }
                    walker = map.remove(s.charAt(walker));
                    walker++;
                    map.put(s.charAt(runner), runner);
                    runner++;
                    max = Math.max(max, runner - walker);
                }
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        String s  = "abaffzzz";
        AtMostTwoChar test = new AtMostTwoChar();
        System.out.println(test.lengthOfLongestSubstringTwoDistinct(s));
    }
}
public class matching {
    public boolean isMatch(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        if (lenP == 0) {
            return lenS == 0;
        }
        int indexS = 0;
        int indexP = 0;
        int preS = -1;
        int preP = -1;
        
        while (indexS < lenS) {
            if (indexP < lenP && (s.charAt(indexS) == p.charAt(indexP) || p.charAt(indexP) == '?')) {
                indexS++;
                indexP++;
            }else if(indexP < lenP && p.charAt(indexP) == '*') {
                preS = indexS;
                preP = indexP;
                indexP++;
            }else if(preP != -1) {
                indexP = preP;
                indexP++;
                //pre for p not move, pre for s move;
                preS++;
                indexS = preS;
            }else{
                return false;
            }
        }
        
        while (indexP < lenP) {
            if (p.charAt(indexP) != '*') {
                return false;
            }
            indexP++;
        }
        return true;
    }
    
    public static void main(String[] args) {
        String 
    }
}
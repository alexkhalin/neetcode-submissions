class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        int countPrevPrev = 1;
        int countPrev = 1;
        char prev = '9';
        for (int i = 0; i < len && (countPrev != 0 || countPrevPrev != 0); i++) {
            char curr = s.charAt(i);
            int countCurr = 0;

            // if can be a single digit code
            if (curr != '0') countCurr += countPrev;
            
            // if can be a double digit code
            if ((prev == '1' || prev == '2' && curr <= '6')) countCurr += countPrevPrev;

            prev = curr;
            countPrevPrev = countPrev;
            countPrev = countCurr;
        }
        return countPrev;
    }
}

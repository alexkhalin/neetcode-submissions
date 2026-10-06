class Solution {

    public int characterReplacement(String s, int k) {
        int[] charCounters = new int[26];
        char[] chars = s.toCharArray();
        int maxLen = 0;
        int maxCharCounter = 0;
        int left = -1;
        
        for (int right = 0; right < s.length(); right++) {
            int charIdx = chars[right] - 'A'; 
            charCounters[charIdx]++;
            maxCharCounter = Math.max(maxCharCounter, charCounters[charIdx]);
            int leftLimit = right - maxCharCounter - k;
            while (left < leftLimit) {
                left++;
                charCounters[chars[left] - 'A']--;
            }
            int len = right - left;
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}

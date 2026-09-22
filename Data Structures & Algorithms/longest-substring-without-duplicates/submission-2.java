class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastIdx = new int[128];
        int bestLen = 0;
        int lastBegin = 0;
        for (int i = 0; i != s.length(); i++) {
            char c = s.charAt(i);
            int curBegin = Math.max(lastIdx[c], lastBegin);
            int curLen = i - curBegin + 1;
            lastBegin = curBegin;
            lastIdx[c] = i + 1;
            bestLen = Math.max(bestLen, curLen);
        }
        return bestLen;
    }
}

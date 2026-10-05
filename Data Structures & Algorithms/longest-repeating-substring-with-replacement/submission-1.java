class Solution {
    class Counters {
        int[] charCounters = new int[26];
        int maxCharCounter = 0; 
        Map<Integer, Integer> lengths = new HashMap<>();

        public void add(char c) {
            int idx = c - 'A';
            int charCounter = charCounters[idx];
            lengths.compute(charCounter, (k, v) -> v == null || v == 1 ? null : v - 1);
            charCounter++;
            lengths.compute(charCounter, (k, v) -> v == null ? 1 : v + 1);
            charCounters[idx] = charCounter;
            maxCharCounter = Math.max(maxCharCounter, charCounter);
        }

        public void remove(char c) {
            int idx = c - 'A';
            int charCounter = charCounters[idx];
            lengths.compute(charCounter, (k, v) -> v == 1 ? null : v - 1);
            if (maxCharCounter == charCounter && !lengths.containsKey(charCounter)) maxCharCounter--;
            charCounter--;
            lengths.compute(charCounter, (k, v) -> v == null ? 1 : v + 1);
            charCounters[idx] = charCounter; 
        }

        public int getMaxCharCount() { return maxCharCounter; }
    }

    public int characterReplacement(String s, int k) {
        Counters counters = new Counters();
        int maxLen = 0;
        int left = -1;
        int right = 0;
        while (right < s.length()){
            
            counters.add(s.charAt(right));
            while (counters.getMaxCharCount() + k < right - left) {
                left++;
                counters.remove(s.charAt(left));
            }
            int len = right - left;
            maxLen = Math.max(maxLen, len);

            right++;
        }
        return maxLen;
    }
}

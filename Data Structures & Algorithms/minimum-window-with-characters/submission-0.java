class Solution {
    public String minWindow(String s, String t) {
        int[] tCounters = new int['z' - 'A' + 1];

        long flags = 0;
        for (char c : t.toCharArray()) {
            int idx = c - 'A';
            tCounters[idx]++;
            flags |= 1L << idx;
        }
        
        int[] sCounters = new int['z' - 'A' + 1];
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int left = -1;
        for (int right = 0; right < s.length(); right++) {
            int idx = s.charAt(right) - 'A';
            sCounters[idx]++;
            while ((flags = (sCounters[idx] < tCounters[idx] ? flags | 1L << idx : (flags & (~(1L << idx))))) == 0 && left < right) {
                if (right - left < minLen) {
                    minLen = right - left;
                    minStart = left + 1;
                }
                left++;
                idx = s.charAt(left) - 'A';
                sCounters[idx]--;
            }
        }
        return minLen != Integer.MAX_VALUE ? s.substring(minStart, minStart + minLen): "";
    }
}

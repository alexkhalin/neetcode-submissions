class Solution {
    public String minWindow(String s, String t) {
        int[] tCounters = new int['z' - 'A' + 1];

        for (int i = 0; i < t.length(); i++) {
            tCounters[t.charAt(i) - 'A']++;
        }
        
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int toFind = t.length();
        int left = -1;
        for (int right = 0; right < s.length(); right++) {
            int idx = s.charAt(right) - 'A';
            tCounters[idx]--;
            if (tCounters[idx] >= 0) toFind--;

            while (toFind == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    minStart = left + 1;
                }
                left++;
                idx = s.charAt(left) - 'A';
                tCounters[idx]++;
                if (tCounters[idx] >0 ) toFind = 1;
            }
        }
        return minLen != Integer.MAX_VALUE ? s.substring(minStart, minStart + minLen): "";    }
}

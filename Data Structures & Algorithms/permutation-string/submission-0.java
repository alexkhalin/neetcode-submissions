class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] counters = new int[26];
        for (char c : s1.toCharArray()) {
            counters[c - 'a']++;
        }
        
        int leftIdx = 0;
        char[] arr2 = s2.toCharArray();
        for (int rightIdx = 0; rightIdx < s2.length(); rightIdx++) {
            if (rightIdx - leftIdx == s1.length()) return true; 
            int counterIdx = arr2[rightIdx] - 'a';
            --counters[counterIdx];
            while (counters[counterIdx] < 0) {
                counters[arr2[leftIdx++] - 'a']++;
            }
        }

        return s2.length() - leftIdx == s1.length();
    }
}

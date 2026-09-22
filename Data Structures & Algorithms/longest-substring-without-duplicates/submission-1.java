class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> found = new HashMap<>();

        char[] chars = s.toCharArray();
        int begin = 0;
        int longest = 0;
    
        for (int i = 0; i != chars.length; ++i) {
            char ch = chars[i];
            Integer prev = found.put(ch, i);
            if (prev != null && prev >= begin) {
                begin = prev + 1;
            } else {
                longest = Math.max(longest, i - begin + 1);
            }
        }

        return longest;
    }
}

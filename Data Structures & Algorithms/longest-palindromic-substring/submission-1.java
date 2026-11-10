class Solution {
    private int findPalindrome(char[] arr, int left, int right) {
        while (left >= 0 && right < arr.length && arr[left] == arr[right]){
            left--;
            right++;
        }
        return right - left - 1;
    }

    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length; 
        int longest = 1;
        int start = 0;
        for (int i = 1; i < len; i++) {
            int evenLen = findPalindrome(arr, i - 1, i);
            if (evenLen > longest) {
                longest = evenLen;
                start = i - evenLen / 2;
            }
            int oddLen = findPalindrome(arr, i - 1, i + 1);
            if (oddLen > longest) {
                longest = oddLen;
                start = i - oddLen / 2;
            }
        }
        return s.substring(start, start + longest);
    }
}

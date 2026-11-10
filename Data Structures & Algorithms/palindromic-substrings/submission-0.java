class Solution {

    private int countPalindromes(char[] arr, int left, int right) {
        while (left >= 0 && right < arr.length && arr[left] == arr[right]) {
            left--;
            right++;
        }
        return (right - left) / 2;
    }

    public int countSubstrings(String s) {

        char[] arr = s.toCharArray();
        int count = 1; // for first symbol
        for (int i = 1; i < arr.length; i++) {
            count += countPalindromes(arr, i - 1, i);
            count += countPalindromes(arr, i - 1, i + 1);
        }
        return count;
    }
}

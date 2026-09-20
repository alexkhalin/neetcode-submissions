class Solution {
    public boolean isPalindrome(String s) {

        int leftIdx = 0;
        int rightIdx = s.length() - 1;
        while (leftIdx < rightIdx) {
            char leftChar = s.charAt(leftIdx);
            char rightChar = s.charAt(rightIdx); 
            if (!Character.isLetterOrDigit(rightChar)) {
                rightIdx--;
            } else if (!Character.isLetterOrDigit(leftChar)) {
                leftIdx++;
            } else if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)){
                return false;
            } else {
                leftIdx++;
                rightIdx--;
            }
        }
        return true;
    }
}

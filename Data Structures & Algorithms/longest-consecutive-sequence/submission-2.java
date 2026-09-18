class Solution {

    public int longestConsecutive(int[] nums) {
        var numSet = new HashSet<Integer>((int)(nums.length * 1.334 + 0.5));
        for (int n : nums ) {
            numSet.add(n);
        }

        int maxLen = 0;

        for (var n: numSet) {
            if (!numSet.contains(n - 1)) {
                int m = n + 1;
                while (numSet.contains(m++));
                maxLen = Math.max(maxLen, m - n -1);
            }
        }
        return maxLen;
    }
}

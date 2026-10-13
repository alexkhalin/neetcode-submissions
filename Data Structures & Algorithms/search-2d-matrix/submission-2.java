class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int len = m * n;

        int left = 0;
        int right = len;
        while (right - left > 1) {
            int i = (left + right) / 2;
            int curr = matrix[i / n][i % n];
            if (curr > target) {
                right = i;
            } else if (curr < target) {
                left = i;
            } else {
                return true;
            }
        }
        return matrix[left / n][left % n] == target;
    }
}

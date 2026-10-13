class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowRes = Arrays.binarySearch(matrix, new int[] {target}, (int[] a, int[] b) -> a[0] - b[0]);
        if (rowRes >= 0) return true;
        if (rowRes == -1) return false;

        int rowIdx = -rowRes - 2;
        
        return Arrays.binarySearch(matrix[rowIdx], target) >= 0;        
    }
}

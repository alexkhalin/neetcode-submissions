class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {
            heap.add(nums[i]);
        }
        int[] res = new int[nums.length - k + 1];
        res[0] = heap.peek();
        
        for (int i = k; i < nums.length; i++) {
            heap.remove(nums[i - k]);
            heap.add(nums[i]);
            res[i - k + 1] = heap.peek();
        }

        return res;
    }
}

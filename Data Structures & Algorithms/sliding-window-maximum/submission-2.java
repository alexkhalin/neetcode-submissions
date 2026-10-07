class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

List<Integer> numList = Arrays.stream(nums)
        .limit(k)
        .map(n -> -n)
        .boxed()
        .toList();
        PriorityQueue<Integer> heap = new PriorityQueue<>(numList);
        
        int[] res = new int[nums.length - k + 1];
        res[0] = -heap.peek();
        
        for (int i = k; i < nums.length; i++) {
            heap.remove(-nums[i - k]);
            heap.add(-nums[i]);
            res[i - k + 1] = -heap.peek();
        }

        return res;
    }
}

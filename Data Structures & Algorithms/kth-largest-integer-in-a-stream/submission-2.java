class KthLargest {

    private int k;
    private PriorityQueue<Integer> queue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>(k + 1);
        int toOffer = Math.min(k, nums.length);
        for (int i = 0; i < toOffer; i++) {
            queue.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            queue.offer(nums[i]);
            queue.poll();
        }
    }

    public int add(int val) {
        queue.offer(val);
        if (queue.size() > k) queue.poll();
        return queue.peek();
    }
}

class KthLargest {

    private int k;
    private int size;
    private int[] queue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        if (k <= nums.length) {
            queue = nums;
        } else {
            queue = Arrays.copyOf(nums, k);
            Arrays.fill(queue, nums.length, k, Integer.MIN_VALUE);
        }

        buildHeap();
        for (int i = k; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    private void buildHeap() {
        for (int i = (k - 1) / 2; i >= 0; i--) {
            heapifyDown(i);
        }
    }
    
    private void heapifyDown(int idx) {
        while (true) {
            int left = idx * 2  + 1;
            int right = left + 1;
            int smallest = idx;
            if (left < k && queue[left] < queue[smallest]) smallest = left;
            if (right < k && queue[right] < queue[smallest]) smallest = right;

            if (smallest == idx) {
                return;
            }
            int temp = queue[smallest];
            queue[smallest] = queue[idx];
            queue[idx] = temp;

            idx = smallest;
        }
    }

    public int add(int val) {
        if (val > queue[0]) {
            queue[0] = val;
            heapifyDown(0);
        }
        return queue[0];
    }
}

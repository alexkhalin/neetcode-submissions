class Solution {

    private static class MonotonicQueue {
        int size;
        int start;
        int end;
        int[] queue;
        int[] nums;
        public MonotonicQueue(int size, int[] nums) {
            this.size = size;
            queue = new int[size];
            this.nums = nums;          
        }

        public void addLast(int index) {
            int num = nums[index];
            if (index - queue[start % size] >= size) start++;
            while (end > start && nums[queue[(end - 1) % size]] <= num) {
                end--;
            }
            queue[end % size] = index;

            end++;
        }

        public int getFirst() {
            return nums[queue[start % size]];
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] res = new int[nums.length - k + 1];
        MonotonicQueue queue = new MonotonicQueue(k, nums);
        for (int i = 0; i < k; i++) {
            queue.addLast(i);
        }
    
        for (int i = k; i < nums.length; i++) {
            res[i - k] = queue.getFirst();
            queue.addLast(i);
        }
        res[res.length - 1] = queue.getFirst();

        return res;
    }
}

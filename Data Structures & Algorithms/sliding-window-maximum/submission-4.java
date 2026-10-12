class Solution {

    private static class MonotonicQueue {
        int size;
        int[] queue;
        int pointer;
        public MonotonicQueue(int size) {
            this.size = size;
            queue = new int[size];
            pointer = size;            
        }

        public void addLast(int num) {
            queue[pointer % size] = num;

            for (int i = 1; i < size && queue[(pointer - i) % size] < num; i++) {
                queue[(pointer - i) % size] = num;
            }
            pointer++;
        }

        public int getFirst() {
            return queue[pointer % size];
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] res = new int[nums.length - k + 1];
        MonotonicQueue queue = new MonotonicQueue(k);
        for (int i = 0; i < k; i++) {
            queue.addLast(nums[i]);
        }
    
        for (int i = k; i < nums.length; i++) {
            res[i - k] = queue.getFirst();
            queue.addLast(nums[i]);
        }
        res[res.length - 1] = queue.getFirst();

        return res;
    }
}

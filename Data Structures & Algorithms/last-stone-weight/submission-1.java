class Solution {

    void pushDown(int[] queue, int size, int idx) {
        while(true) {
            int left = (idx << 1) + 1;
            int right = left + 1;

            int heaviest = idx;
            if (left < size && queue[heaviest] < queue[left]) heaviest = left;
            if (right < size && queue[heaviest] < queue[right]) heaviest = right;
            if (heaviest == idx) return;

            int temp = queue[idx];
            queue[idx] = queue[heaviest];
            queue[heaviest] = temp;

            idx = heaviest;
        }
    }

    void buildHeap(int[] queue) {
        for (int i = (queue.length >>> 1) - 1; i >= 0; i--) {
            pushDown(queue, queue.length, i);
        }
    }

    public int lastStoneWeight(int[] stones) {
        buildHeap(stones);

        int size = stones.length;
        while (size > 1) {
            int first = stones[0];
            stones[0] = stones[--size];
            pushDown(stones, size, 0);
            int second = stones[0];
            int diff = first - second;
            stones[0] = diff != 0 ? diff : stones[--size];
            pushDown(stones, size, 0);
        }

        return size == 0 ? 0 : stones[0];
    }
}

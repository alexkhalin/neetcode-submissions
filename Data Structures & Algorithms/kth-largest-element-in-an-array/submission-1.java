class Solution {
    private static class UniqueHeap {

        private int[] heap;
        private int size;

        public UniqueHeap(int capacity) {
            heap = new int[capacity];
            size = 0;
        }

        public void offer(int val) {
            if (size < heap.length) {
                heap[size] = val;
                size++;
                pushUp();
            } else {
                if (val > heap[0]) {
                    heap[0] = val;
                    pushDown();
                }
            }
        }

        public int peek() {
            return heap[0];
        }

        void pushUp() {
            for (int i = size - 1; i > 0;) {
                int parent = (i - 1) / 2;
                if (heap[parent] <= heap[i]) return;

                swap(i, parent);
                i = parent;
            }

        }

        void pushDown() {
            int i = 0;
            while (true) {
                int left = i * 2 + 1;
                int right = left + 1;

                int smallest = i;

                if (left < size && heap[left] < heap[smallest]) smallest = left;
                if (right < size && heap[right] < heap[smallest]) smallest = right;

                if (smallest == i) return;

                swap(smallest, i);
                i = smallest;
            }
        }

        void swap(int i, int j) {
            int tmp = heap[i];
            heap[i] = heap[j];
            heap[j] = tmp;
        }
    }

    public int findKthLargest(int[] nums, int k) {
        UniqueHeap heap = new UniqueHeap(k);
        for (int num : nums) {
            heap.offer(num);
        }

        return heap.peek();
    }
}

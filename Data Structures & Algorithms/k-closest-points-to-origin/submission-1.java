class Solution {

    private void pushDown(int[][] heap, int size, int idx) {
        while (true) {
            int left = idx * 2 + 1;
            int right = left + 1;

            int longest = idx;
            if (left < size && heap[left][0] > heap[longest][0]) longest = left;
            if (right < size && heap[right][0] > heap[longest][0]) longest = right;
            if (longest == idx) return;

            int[] tmp = heap[longest];
            heap[longest] = heap[idx];
            heap[idx] = tmp;

            idx = longest;
        }
    }

    private void popUp(int[][] heap, int idx) {
        while (idx != 0) {
            int parent = (idx - 1) / 2; 
            if (heap[parent][0] >= heap[idx][0]) {
                return;
            }
            int[] tmp = heap[parent];
            heap[parent] = heap[idx];
            heap[idx] = tmp;
            idx = parent;
        }
    }

    private int sqrDst(int x, int y) {
        return x * x + y * y;
    }

    public int[][] kClosest(int[][] points, int k) {
        
        int[][] heap = new int[k][2];
        for (int i = 0; i < k; i++) {
            heap[i][0] = sqrDst(points[i][0], points[i][1]);
            heap[i][1] = i;
            popUp(heap, i);
        }

        for (int i = k; i < points.length; i++) {
            int sd = sqrDst(points[i][0], points[i][1]);
            if (sd < heap[0][0]) {
                heap[0][0] = sd;
                heap[0][1] = i;
                pushDown(heap, k, 0);
            }
        }

        for (int i = 0; i < k; i++) {
            heap[i][0] = points[heap[i][1]][0];
            heap[i][1] = points[heap[i][1]][1];
        }

        return heap;
    }
}

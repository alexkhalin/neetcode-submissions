class MedianFinder {

    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Comparator.reverseOrder());      
    }
    
    public void addNum(int num) {
        if (max.isEmpty()) {
            max.offer(num);
        } else if (num <= max.peek()) {
            max.offer(num);
            if (max.size() - 1 > min.size()) {
                min.offer(max.poll());
            }
        } else {
            min.offer(num);
            if (min.size() > max.size()) {
                max.offer(min.poll());
            }
        }
    }
    
    public double findMedian() {
        return min.size() == max.size() ? (min.peek() + max.peek()) / 2. : max.peek();
    }
}

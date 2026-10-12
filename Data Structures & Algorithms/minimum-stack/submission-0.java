class MinStack {

    private int[] stack = new int[30_000];
    private int[] mins = new int[30_001];
    private int pointer = 0;

    public MinStack() {
        mins[0] = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        stack[pointer++] = val;
        mins[pointer] = Math.min(mins[pointer - 1], val);
    }
    
    public void pop() {
        --pointer;
    }
    
    public int top() {
        return stack[pointer - 1];
    }
    
    public int getMin() {
        return mins[pointer];
    }
}

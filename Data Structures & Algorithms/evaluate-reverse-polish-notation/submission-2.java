class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token: tokens) {
            switch (token) {
                case "+" : stack.push(stack.pop() + stack.pop()); break;
                case "-" : stack.push(-stack.pop() + stack.pop()); break;
                case "*" : stack.push(stack.pop() * stack.pop()); break;
                case "/" : int b = stack.pop(); stack.push(stack.pop() / b); break;
                default: stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}

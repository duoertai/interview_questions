package interview.pinterest.onsite.MinStack;

import java.util.Stack;

class MinStack {

    private Stack<Integer> nums;
    private Stack<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        this.nums = new Stack<Integer>();
        this.min = new Stack<Integer>();
    }

    public void push(int x) {
        if(nums.size() == 0) {
            nums.push(x);
            min.push(x);
        } else {
            nums.push(x);
            min.push(Math.min(x, min.peek()));
        }
    }

    public void pop() {
        nums.pop();
        min.pop();
    }

    public int top() {
        return nums.peek();
    }

    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

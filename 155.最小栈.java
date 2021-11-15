import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */

// @lc code=start
class MinStack {

    private LinkedList<Integer> stack;
    private LinkedList<Integer> min;

    public MinStack() {
        this.min = new LinkedList<>();
        this.stack = new LinkedList<>();
    }
    
    public void push(int val) {
        this.stack.addFirst(val);
        if (!this.min.isEmpty() && this.min.peekFirst() < val) {
            this.min.addFirst(this.getMin());   
        } else {
            this.min.addFirst(val);
        }
    }
    
    public void pop() {
        this.min.removeFirst();
        this.stack.removeFirst();
    }
    
    public int top() {
        return this.stack.peekFirst();
    }
    
    public int getMin() {
        return this.min.peekFirst();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end


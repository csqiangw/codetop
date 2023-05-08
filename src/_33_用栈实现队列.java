import java.util.Stack;

/**
 * 考虑每次入栈都入stack1，但是一旦发生取栈顶或出栈操作，若栈2为空则就拷贝到栈2，因为此时正好构成一个顺序
 */
public class _33_用栈实现队列 {

    public Stack<Integer> stack1;
    public Stack<Integer> stack2;

    public _33_用栈实现队列() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }

}

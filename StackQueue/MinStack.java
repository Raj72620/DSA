package StackQueue;
import java.util.Stack;

public class MinStack {

    Stack<Integer> st;
    int min;

    public MinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int data) {
        if(st.isEmpty()){
            st.push(data);
            min = data;
        }
        else if(data < min){
            int newValue = 2 * data - min;
            st.push(newValue);
            min = data;
        }
        else{
            st.push(data);
        }
    }

    public int getMin() {
        return min;
    }

    public int pop() {
        if(st.isEmpty()) return -1;
        int popped = st.pop();
        if(popped < min) {
            int prevMin = 2 * min - popped;
            min = prevMin;
        }
        return popped;
    }

    public int top() {
        if(st.isEmpty()) return -1;
        if(st.peek() < min) {
            return min;
        }
        return st.peek();
    }
    

    public static void main(String[] args) {
        // Create an instance of MinStack
        MinStack s = new MinStack();
        
        // Test the stack operations
        s.push(12);
        System.out.println("Pushed 12, Min: " + s.getMin());
        
        s.push(13);
        System.out.println("Pushed 13, Min: " + s.getMin());
        
        s.push(10);
        System.out.println("Pushed 10, Min: " + s.getMin());
        
        System.out.println("Top: " + s.top());
        System.out.println("Popped: " + s.pop());
        System.out.println("Min after pop: " + s.getMin());

    }
}
//implementing circul Queue
package Stack;

public class StackImplement {
     int[] arr;
     int top;
     int size;
     int count; // number of elements in stack

     StackImplement(int size) {
        this.size = size;
        arr = new int[size];
        top = -1;
        count = 0;
    }

     boolean isEmpty() {
        return count == 0;
    }

     boolean isFull() {
        return count == size;
    }

    void push(int data) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push " + data);
            return;
        }

        // Circular increment
        top = (top + 1) % size;
        arr[top] = data;
        count++;
        System.out.println("Pushed: " + data);
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow!");
            return -1;
        }

        int popped = arr[top];
        top = (top - 1 + size) % size; // Circular decrement
        count--;
        System.out.println("Popped: " + popped);
        return popped;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return arr[top];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }

        System.out.print("Stack elements: ");
        int index = (top - count + 1 + size) % size;
        for (int i = 0; i < count; i++) {
            System.out.print(arr[(index + i) % size] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackImplement st = new StackImplement(4);

        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);

        st.display();

        st.pop();
        st.push(60);

        st.display();

        System.out.println("Top element: " + st.peek());
    }
}

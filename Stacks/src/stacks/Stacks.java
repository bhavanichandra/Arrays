package stacks;

import java.util.Arrays;

/**
 *
 * @author Bhavani_Chandra
 */
public class Stacks {

    private String[] stackArray;
    private int stackSize;
    private int topOfStack = -1;

    public Stacks(int size) {
        stackSize = size;
        stackArray = new String[size];
        Arrays.fill(stackArray, "-1");
    }

    public void push(String input) {
        if (topOfStack + 1 < stackSize) {
            topOfStack++;
            stackArray[topOfStack] = input;
        } else {
            System.out.println("Sorry stack is full");
        }

        System.out.println("PUSH: " + input + " was added to stack");

    }

    public String pop() {
        if (topOfStack >= 0) {

            System.out.println("POP: " + stackArray[topOfStack] + " was removed.");
            stackArray[topOfStack] = "-1";
            return stackArray[topOfStack--];
        } else {

            System.out.println("Stack is empty");
        }
        return "-1";
    }

    public String peek() {

        if(topOfStack>=0){
        System.out.println("PEEK: " + stackArray[topOfStack] + " is at top of the stack");
        return stackArray[topOfStack];
        }
        return "Stack is empty";
    }

    public void displayStack() {
        System.out.print("[");
        for (String stack : stackArray) {
            if (!stack.equalsIgnoreCase("-1")) {
                System.out.print(stack + " ");
            }
        }
        System.out.print("]");
    }

    public void pushMany(String values) {
        String[] tempString = values.split(" ");
        for (String tempString1 : tempString) {
            push(tempString1);
        }
    }

    public void popAll() {
        for (int i = topOfStack; i >= 0; i--) {
            pop();
        }
    }

    public void popDisplayAll() {
        String reverse = "";
        for (int i = topOfStack; i >= 0; i--) {
            reverse += stackArray[i] + " ";
        }
        System.out.println("Removed from Stack: " +reverse);
        popAll();
    }

    public static void main(String[] args) {

        Stacks stack = new Stacks(10);
        stack.push("Bhavani");
        stack.push("Ravi");
        stack.peek();
        stack.pop();
        stack.push("Deepak");
        stack.pushMany("Aravind Ramesh Ramchanran");
        stack.displayStack();
        stack.popDisplayAll();
        stack.displayStack();
        System.out.println("\n" + stack.peek());
    }

}

package DataStructure.List;

import NEU.ET39.CSC250.DataStructure.List.Stack;
import org.junit.jupiter.api.Test;

public class Stack_Tests {
    @Test
    public void testPush() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assert stack.peek() == 3;
    }

    @Test
    public void testPop() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assert stack.pop() == 3;
        assert stack.peek() == 2;
    }

    @Test
    public void testPeek() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        assert stack.peek() == 2;
    }

    @Test
    public void testContains() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        assert stack.contains(1);
        assert !stack.contains(3);
    }

    @Test
    public void testGet() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assert stack.get(0) == 3;
        assert stack.get(1) == 2;
        assert stack.get(2) == 1;
    }
}

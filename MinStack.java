package cn.edu.sjtu.zzang;

public class MinStack {
	public static void main(String[] args) {
		MinStack ms = new MinStack();
		ms.push(512);
		ms.push(-1024);
		ms.push(-1024);
		ms.push(512);
		ms.pop();
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.getMin());
	}
	
	private int[] stack = new int[1];
	private int top = 0;
	private int min = Integer.MAX_VALUE;
	private int minIndx = -1;
	private int capacity = 1;
    public void push(int x) {
        stack[top++] = x;
        if (x < min) {
        	min = x;
        	minIndx = top - 1;
        }
        if (top > capacity * 3 / 4) {
        	int[] tmp = stack;
        	capacity *= 2;
        	stack = new int[capacity];
        	for (int i = 0; i < tmp.length; i++)
        		stack[i] = tmp[i];
        }
    }

    public void pop() {
    	if (top == 0)
    		return;
    	if (top - 1 == minIndx) {
    		if (minIndx == 0)
    			minIndx = -1;
    		min = stack[0];
    		minIndx = 0;
    		for (int i = 0; i < top - 1; i++) {
    			if (stack[i] < min) {
    				min = stack[i];
    				minIndx = i;
    			}
    		}
    	}
        top--;
        if (top < capacity / 2) {
        	capacity /= 2;
        	int[] tmp = new int[capacity];
        	for (int i = 0; i < capacity; i++)
        		tmp[i] = stack[i];
        	stack = tmp;
        }
    }

    public int top() {
        return stack[top - 1];
    }

    public int getMin() {
    	if (minIndx < 0)
    		return -Integer.MAX_VALUE;
        return stack[minIndx];
    }
}
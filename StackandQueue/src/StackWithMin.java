import java.util.Deque;
import java.util.LinkedList;

public class StackWithMin {
	private Deque<Integer> stack;
	private Deque<Integer> storage;
	public StackWithMin() {
		stack=new LinkedList<Integer>();
		storage=new LinkedList<Integer>();
	}
	
	public Integer min() {
		if(storage.isEmpty()) {
			return null;
		}
		return storage.peekFirst();
	}
	public void push(int value) {
		stack.offerFirst(value);
		if(storage.isEmpty()||(stack.peekFirst()<=storage.peekFirst())) {
			storage.offerFirst(value);
		}
	}
	public Integer pop() {
		if(stack.isEmpty()) {
			return null;
		}
		int result=stack.pollFirst();
		if(storage.peekFirst().equals(result)) {
			storage.pollFirst();
		}
		return result;
	}
	public Integer top() {
		if(stack.isEmpty()) {
			return null;
		}
		return stack.peekFirst();
	}
}

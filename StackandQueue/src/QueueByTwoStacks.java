import java.util.Deque;
import java.util.LinkedList;

public class QueueByTwoStacks {
	private Deque<Integer> stack;
    private Deque<Integer> buffer;
  public QueueByTwoStacks() {
    // Write your solution here.
    stack=new LinkedList<Integer>();
    buffer=new LinkedList<Integer>();
  }
  
  public Integer poll() {
      if(stack.isEmpty()&&buffer.isEmpty()){
          return null;
      }
      if(!buffer.isEmpty()){
          Integer result=buffer.pollFirst();
          return result;
      }
      else{
          while(!stack.isEmpty()){
              buffer.offerFirst(stack.pollFirst());
          }
          Integer result=buffer.pollFirst();
          return result;
      }
      
  }
  
  public void offer(int element) {
    stack.offerFirst(element);
  }
  
  public Integer peek() {
    if(stack.isEmpty()&&buffer.isEmpty()){
          return null;
    }
    if(!buffer.isEmpty()){
        Integer result=buffer.peekFirst();
        return result;
    }
    else{
      while(!stack.isEmpty()){
          buffer.offerFirst(stack.pollFirst());
      }
      Integer result=buffer.peekFirst();
      return result;
    }  
  }
  
  public int size() {
    if(buffer.isEmpty() && stack.isEmpty())return 0;
    return buffer.size()+stack.size();
  }
  
  public boolean isEmpty() {
    return (buffer.isEmpty() && stack.isEmpty());
  }
}

import java.util.EmptyStackException;

public class LinkedStack <T>{

	public GenericNode<T> top;
	
	public LinkedStack(){
		top = null;
	}
	
	public boolean isEmpty(){
		return (top == null);
	}
	
	public void push(T i){
		top = new GenericNode<T>(i, top);
		top.getData();
	}
	
	public T pop(){
		T cut;
		if(isEmpty())
			throw new EmptyStackException();
		
		cut = top.getData();
		top = top.getLink();
		return cut;
	}
	
	public T peek(){
		if(isEmpty())
			throw new EmptyStackException();
		
		return top.getData();
	}
	
	public int size(){
		return GenericNode.listLength(top);
	}
	
	public void display(){
		top.toString();
	}
}

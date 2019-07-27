public class ImmutableStack<T> implements Stack<T> {
	private T head = null;
	private ImmutableStack<T> tail = null;
		
	private ImmutableStack(T head, ImmutableStack<T>  tail) {
		this.head = head;
		this.tail = tail;
	}
	
	public ImmutableStack() {}
	
	@Override
	public ImmutableStack<T> push(T t) {
		return new ImmutableStack<T>(t, this); 
	}
	
	@Override
	public ImmutableStack<T> pop() {
		return tail;
	}
	
	@Override
	public T head() {
		return head;
	}
	
	@Override
	public boolean isEmpty() {
		return head == null;
	}
	
	public ImmutableStack<T> Reverse()
	{
		ImmutableStack<T> r = new ImmutableStack<T>();
       for (Stack<T> stack = this; !stack.isEmpty() && stack.head() != null; stack = stack.pop())
         r = r.push(stack.head());       
       return r;
	}

}

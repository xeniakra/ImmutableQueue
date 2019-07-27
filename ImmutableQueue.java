
public class ImmutableQueue<T> implements Queue<T> {
	private Stack<T> stackToEnqueue;
    private Stack<T> stackToDequeue;

	private  ImmutableQueue(Stack<T> stackToEnqueue, Stack<T> stackToDequeue) {
		this.stackToEnqueue = stackToEnqueue;
		this.stackToDequeue = stackToDequeue;
	}
	
	public  ImmutableQueue() {
	}
	
	@Override
	public ImmutableQueue<T> enQueue(T t) {
		if (stackToEnqueue == null) {
			stackToEnqueue = new ImmutableStack<T>();
		}
		
        return new ImmutableQueue<T>(stackToDequeue, stackToEnqueue.push(t));
	}

	@Override
	public ImmutableQueue<T> deQueue() {
		if (stackToDequeue == null) {
            return new ImmutableQueue<T>();
		}
		
		Stack<T> stackAfterPop = stackToDequeue.pop();
        if (!stackAfterPop.isEmpty())
            return new ImmutableQueue<T>(stackAfterPop, stackToEnqueue);
        
        else if (stackToEnqueue == null || stackToEnqueue.isEmpty())
            return new ImmutableQueue<T>();
        
        return new ImmutableQueue<T>(new ImmutableStack<T>(), stackToEnqueue.Reverse());
	}

	@Override
	public T head() {
		if (stackToDequeue == null) {
			return null;
		}
		return stackToDequeue.head();
	}

	@Override
	public boolean isEmpty() {
		return stackToDequeue == null || stackToDequeue.isEmpty();
	}
	
}
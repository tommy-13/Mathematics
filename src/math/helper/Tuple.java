package math.helper;

public class Tuple<T> {

	private T first;
	private T second;
	
	public Tuple(T first, T second) {
		this.first  = first;
		this.second = second;
	}
	
	public T getFirst() {
		return this.first;
	}
	public T getSecond() {
		return this.second;
	}
	
	public void setFirst(T first) {
		this.first = first;
	}
	public void setSecond(T second) {
		this.second = second;
	}
	
}
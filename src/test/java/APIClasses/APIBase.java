package APIClasses;

public class APIBase<T extends APIClass> {
	public T t = null;

	public APIBase(T t) {
		this.t = t;
	}

	public T getT() {
		return t;
	}

}

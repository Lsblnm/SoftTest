
public class NegativeException extends RuntimeException{
	public NegativeException() {
		super("weights要求不小于1, values、capacity要求不小于0; 或者重量数组的个数与价值数组个数不匹配");
	}
}

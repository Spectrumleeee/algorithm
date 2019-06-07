package xmu.cs.lgp.algorithm.bit;

public class Test {

	public static void main(String[] args) {
        Test tester = new Test();
        tester.printCurrentMethod();
	}

    public void printCurrentMethod( ) {
        String className = Thread.currentThread() .getStackTrace()[1].getClassName();
        String methodName = Thread.currentThread() .getStackTrace()[1].getMethodName();
        String message = String.format("Hello, this method is added from branch lgp in [%s.%s]", className, methodName);

        System.out.println(message);
    }

}

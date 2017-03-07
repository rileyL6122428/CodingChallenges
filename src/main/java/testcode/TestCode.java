package testcode;

public class TestCode {
	public static void main(String... args) throws ClassNotFoundException {
		System.out.println(new String[]{}.getClass().getName());
		Class.forName("[Ljava.lang.String;");
	}
}

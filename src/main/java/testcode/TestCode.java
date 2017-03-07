package testcode;

import com.google.common.base.Throwables;

public class TestCode {
	public static void main(String... args) throws ClassNotFoundException {
		Throwable throwable = new Throwable();
		Throwables.getStackTraceAsString(throwable);
	}
}

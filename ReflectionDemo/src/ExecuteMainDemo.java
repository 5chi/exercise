import java.lang.reflect.Method;

//カレントのclassファイルのmainメソッドを実行するプログラム
public class ExecuteMainDemo {
	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("CodeIQ");
			Method mainMethod = clazz.getMethod("main", String[].class);
			mainMethod.invoke(null, (Object)new String[]{});

		}catch(ClassNotFoundException e) {
			System.err.println("class not found");
			return;
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}

}

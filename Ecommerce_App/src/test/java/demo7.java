
public class demo7 {
	
	// fibonanci series 

	public static void main(String[] args) {

		int n = 7;
		int a = 0;
		int b = 1;
		int c;
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				System.out.println("0");
			} else if (i == 1) {
				System.out.println("1");
			} else {
				c = a + b;
				a = b;
				b = c;
				System.out.println(c);
			}

		}

	}
}

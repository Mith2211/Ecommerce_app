import java.io.StringBufferInputStream;

public class demo14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input = "I LOVE DOGS";
		String[] words = input.split(" ");

		StringBuilder word = new StringBuilder();
		for (int i = 0; i < words.length; i++) {
			word.append(words[i]);
		}

		String strword = word.toString();
		// System.out.println(strword);
		char[] a = strword.toCharArray();

		for (int j = 0; j < words.length; j++) {
			char c1 = a[j];
			// System.out.println(c1);

			for (int k = 0; k < words.length; k++) {
				char[] b = words[k].toCharArray();
				for (int l = 0; l < b.length; l++) {
					char c2 = b[l];
					if (c1 != c2) {
						String c11 = Character.toString(c1);
						String c12 = Character.toString(c2);
						System.out.print(c11 + c12 + ", ");
					}

				}

			}
			System.out.println();
		}

	}

}

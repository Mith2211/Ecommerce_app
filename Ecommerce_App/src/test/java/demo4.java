
public class demo4 {

	public static void main(String[] args) {

		String input = "I Love Dogs";

		String[] words = input.split(" ");
		
		StringBuilder word= new StringBuilder();
		
		for(int i=0;i<words.length;i++)
		{
			word.append(words[i]);
		}
		String strword= word.toString();

	//	System.out.println("strword"+strword);
		
		char [] a= strword.toCharArray();
		
		for(int j=0;j<words.length;j++)
		{
			char c1 = a[j];
		//	System.out.println(c1);
			
			for (int k=0;k<words.length;k++)
			{
				char [] b= words[k].toCharArray();
				for(int l=0;l<b.length;l++)
				{
					
					char c2 = b[l];
					//System.out.println("---"+b[l]);
					if(a[j] != b[l])
					{
						String c11= Character.toString(c1);
						String c12= Character.toString(c2);
						
						System.out.print(c11+c12+", ");
					}
					
				}
				
			}
			System.out.println();
		}
				
	
	}

}


public class demo3 {

	public static void main(String[] args) {
	
		
		String numbers = "1, 2, 3, 4, 5, 6, 7, 8";
			       
		String [] splitnum = numbers.split(",");
		
		System.out.println(splitnum[4].trim());
		
		//for (int i=0;i<splitnum.length;i++)
		//{
		//	System.out.println(splitnum[i].trim());
		//}
	

	}

}

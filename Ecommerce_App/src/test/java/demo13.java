import com.github.dockerjava.api.model.Secret;

public class demo13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] input = {-1,-2};
		
		int largest = Integer.MIN_VALUE;
		int secondlargest = Integer.MIN_VALUE;
		
		for(int i=0;i<input.length;i++)
		{
			if(input[i]>largest)
			{
				secondlargest=largest;
				largest= input[i];
			}
			else if(input[i]>secondlargest && input[i]!=largest)
			{
				secondlargest=input[i];
				
			}			
		}
		if(secondlargest==Integer.MIN_VALUE)
		{
			System.out.println("No 2nd largest Interger");
		}
		else
		{
			System.out.println("Secod Largest Number = "+ secondlargest);
		}

	}

}

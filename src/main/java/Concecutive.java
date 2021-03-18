
public class Concecutive {

	public static void main(String[] args) {
		int input = 34528261;
		int output = 43252816;

		String temp = "";
		while (input > 0) {
			int rem1 = input % 10; // 1 2
			int rem2 = ((input/10) % 10);// 6 8
			temp = "" + rem1 + rem2 + temp;
			input /= 100;
		}
		System.out.println(temp);
		
		
	}

}


import java.util.Scanner;

public class NewUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String usern, passw;
		
		System.out.println("Enter UserName: ");
		usern = sc.nextLine();
		
		System.out.println("Enter Password: ");
		passw = sc.nextLine();
		
		if (usern.equals("Username") && (passw.equals("Password"))) {
			System.out.println("Welcome!");
		}
		else {
			System.out.println("Incorrect. Try Again");
		}

	}

}

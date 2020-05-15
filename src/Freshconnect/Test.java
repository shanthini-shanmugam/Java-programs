package Freshconnect;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
public class Test {
	static Scanner in = new Scanner(System.in);
	public String editUsername()
	{
		System.out.println("Enter Firstname:");
		String firstName = in.next();
		System.out.println("Enter Lastname:");
		String lastName = in.next();
		String modified_username = firstName.concat(lastName);
		return modified_username;
		
	}
	public void validatePassword(String uname,String pswd)
	{
		System.out.println(pswd+":");
		if(uname.length()<8)
			System.out.print("Length of the password is below 8");
		else if(uname.contains(pswd))
			System.out.print("It contains the username");
		else if(!Pattern.compile( "[0-9]" ).matcher( pswd ).find())
			System.out.print("It doesn't contains numbers");
		else if(!Pattern.compile( "[^A-Za-z0-9]" ).matcher( pswd ).find())
			System.out.print("It doesn't contains special characters");
		else
			System.out.print("It is valid");
		System.out.println();
		
	}
	public static void main(String[] args) throws IOException{
		Test object = new Test();
		//Scanner in = new Scanner(System.in);
		Properties prop = new Properties();
		FileReader reader = new FileReader("/Users/shshanmugam/eclipse-workspace/Project/src/config.properties");
		prop.load(reader);
		System.out.println("Want to know Freshconnect credentials?(Yes/No)");
		String input = in.nextLine();
		if(input.equals("Yes"))
		{
			prop.list(System.out);
			System.out.println();
			System.out.println("1.Edit username?");
			System.out.println("2.Change password?");
			System.out.println("3.Validate password?");
			System.out.println("4.Password-Array");
			System.out.println("5.exit");
			System.out.println();
			int choice = in.nextInt();
			switch(choice)
			{
				case 1:String modified_username = object.editUsername();
						prop.setProperty("username",modified_username);
						prop.list(System.out);
				break;
				case 2:System.out.println("Enter password to change:");
				  	   String change_password = in.next();
				  	   prop.setProperty("password",change_password);
                       System.out.println("Changed password to:"+prop.getProperty("password"));
				break;
				case 3:object.validatePassword(prop.getProperty("username"),prop.getProperty("password"));
				break;
				case 4: String[] pswd = prop.getProperty("password_array").split(";");
						for(int i = 0;i < pswd.length;i++) {
							object.validatePassword(prop.getProperty("username"),pswd[i]);
						}
				break;
				case 5:System.out.println("THANK YOU");System.exit(0);
				break;
				default: System.out.println("Please enter valid choice");
			}
			System.out.println();
			System.out.println("THANK YOU");
			System.exit(0);
		}
		else
		{
			System.out.println("Withdrawed");
		}
		in.close();
	}
}

package Freshconnect;
import java.util.*;
class Login{
	Scanner in = new Scanner(System.in);
	static HashMap<String,String> values = new HashMap<String,String>();
	static String uname;
	public Login(String string, String string2) {
		values.put(string,string2);
	}
	
	 public void login(){
	    	System.out.println("Login Credentials");
			System.out.println("Enter Username:");
			uname = in.nextLine();
			if(values.containsKey(uname))
			{
				System.out.println("Enter Password:");
				String pswd = in.nextLine();
				while(true)
				{
					if(values.get(uname).equals(pswd))
					{
						System.out.println("*** Login successful ***");
						break;
					}
					else
					{
						System.out.println("Enter the correct password:");
						pswd = in.nextLine();
					}
				}
			}
			else
			{
				System.out.println("Enter the correct username and try again");
				System.exit(0);
			}
	 }
	
}
class CreateAccount extends Login{
	public CreateAccount(String a, String b) {
		super(a, b);
	}

	public void createAccount(){
			System.out.println("Create an account by entering the credentials");
			System.out.println("Enter the Username:");
			uname = in.nextLine();
			if(values.containsKey(uname))
			{
				System.out.println("You already have an account.");
			}
			else
			{
				System.out.println("Enter the Password:");
				String pswd1 = in.nextLine();
				System.out.println("Retype the Password:");
				String pswd2 = in.nextLine();
				while(true)
				{
					if(pswd1.equals(pswd2))
					{
						values.put(uname, pswd1);
						System.out.println("*** Account created!!!! ***");
						break;
					}
					else
					{
						System.out.println("Retype the correct Password:");
						pswd2 = in.nextLine();
					}
				}
			}
	}
}
class GroupCredentials{
	String group_name;
	ArrayList<String> groupMembers = new ArrayList<String>();
}
class Group{
	Scanner in =new Scanner(System.in);
	ArrayList<GroupCredentials> group = new ArrayList<GroupCredentials>();
	GroupCredentials cg = new GroupCredentials();
	public void createGroup() {
		
		System.out.println("Enter the group name to be created:");
		String create_group_name = in.next();
		cg.group_name = create_group_name;
		System.out.format("\nEnter the member count to be added in %s:",create_group_name);
		int member_count = in.nextInt();
		System.out.println("Enter the member names:");
		cg.groupMembers.add(Login.uname);
		for(int i=0;i< member_count; i++)
		{
			cg.groupMembers.add(in.next());
		}
		group.add(cg);
		System.out.println("*** A group is created successfully!! ***");
		for(int i=0;i<group.size();i++)
		{
			if(group.get(i).group_name.equals(create_group_name))
			{
				System.out.println(group.get(i).group_name);
				System.out.println(group.get(i).groupMembers);
			}
		}
	}
	public void addGroup(int first){
		GroupCredentials g = new GroupCredentials();
		GroupCredentials g1 = new GroupCredentials();
		GroupCredentials g2 = new GroupCredentials();
		GroupCredentials g3 = new GroupCredentials();
		if(first==0)
		{
		g.group_name="Test_group";
		g.groupMembers.add("Shanthini");
		g.groupMembers.add("Shivaa");
		g.groupMembers.add("Sugu");
		group.add(g);
		
		g1.group_name="New_group";
		g1.groupMembers.add("Ragav");
		g1.groupMembers.add("Sneha");
		g1.groupMembers.add("Shanthini");
		group.add(g1);
		
		
		g2.group_name="This_is_us";
		g2.groupMembers.add("Ragav");
		g2.groupMembers.add("Shanthini");
		g2.groupMembers.add("Sneha");
		g2.groupMembers.add("Shivaa");
		group.add(g2);
		
		
		g3.group_name="Family";
		g3.groupMembers.add("Nandhini");
		g3.groupMembers.add("Shanthini");
		g3.groupMembers.add("Sugu");
		group.add(g3);
		}
		
		System.out.println("Group names:");
		for(int i=0;i<group.size();i++)
		{
			System.out.println(group.get(i).group_name);
		}
		System.out.println("Enter the Group name a member to be added:");
		String add_group_name = in.next();
		
		for(int i=0;i<group.size();i++)
		{
			if(add_group_name.equals(group.get(i).group_name))
			{
				if(group.get(i).groupMembers.contains(Login.uname))
				{
					System.out.println("Enter the member name to be added: ");
					String member_name = in.next();
					if(group.get(i).groupMembers.contains(member_name))
					{
						System.out.format("\n %s is already part of %s",member_name,add_group_name);
					}
					else
					{
						if(i==0)
							g.groupMembers.add(member_name);
						else if(i==1)
							g1.groupMembers.add(member_name);
						else if(i==2)
							g2.groupMembers.add(member_name);
						else if(i==3)
							g3.groupMembers.add(member_name);
						else
							cg.groupMembers.add(member_name);
						System.out.format("\n*** %s is added successfully to %s ***",member_name,add_group_name);
					}
				}
				else
				{
					System.out.println("You are not part of this group!!");
				}
			}
		}
		
		
	}
}

public class App {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args)
	{
		CreateAccount ca = new CreateAccount("Shanthini","Shanu123");
		CreateAccount ca1 = new CreateAccount("Ragav","Freshworks");
		CreateAccount ca2 = new CreateAccount("Sneha","lal");
		CreateAccount ca3 = new CreateAccount("Shivaa","connect");
		CreateAccount ca4 = new CreateAccount("Sugu","testtest");
		CreateAccount ca5 = new CreateAccount("Nandhini","Sister");
		CreateAccount ca6 = new CreateAccount("Nandhini","Freshworks");
		Group object = new Group();
		System.out.println("Want to use freshconnect?(Yes/No)");
		String fc = in.nextLine();
		int first=-1;
		if(fc.equals("No"))
		{
			System.out.println("Withdrawed");
			System.exit(0);
		}
		else if(fc.equals("Yes"))
		{
			int i=1;
			while(true)
			{
				System.out.println();
				System.out.println("1.Want to create an account?");
				System.out.println("2.Login");
				System.out.println("3.Create a group");
				System.out.println("4.Add a member to a group");
				System.out.println("5.Logout");
				System.out.println();
				System.out.println("Please Enter your choice:");
				int choice = in.nextInt();
				if(i==1 && choice!=2 && choice!=1)
				{
					System.out.println("Please Login first");
					choice=2;
				}
				if(i!=1 && choice==1 || i!=1 && choice==2)
					choice = 6;
				switch(choice)
				{
					case 1:ca.createAccount();
						   i=0;
					break;
					case 2:ca.login();
					break;
					case 3:if(i==1) {ca.login();}
						   object.createGroup();
					break;
					case 4:if(i==1) {ca.login();}
							first++;
						   object.addGroup(first);
				    break;
					case 5:System.out.println("*** Logged out sccessfully!!!! ***");
						   System.exit(0);
					break;
					default:System.out.println("Please enter valid choice");
				}
				i=i+1;
			}
		}
		else
		{
			System.out.println("Enter the correct option");
			System.exit(0);
		}  

}
}

package ja;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class studentinformatin {
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
	    BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	    int num;
	    int ed;
		boolean test=true;
		while(test)
		{
	    System.out.println("*****MENU*****");
	    System.out.println("1.Create\n2.Insert \n3.Update\n4.Delete\n5.Student performence\n6.Exit\n");
	    num=sc.nextInt();
	  switch(num)
	  {
	  case 1:
	  case 2:
		 // if(num==2)
		  {
			  System.out.println("Enter the how many student details you want to enter");
			  ed=sc.nextInt();
			  System.out.println("Enter the"+ ed +"number of details"); 
			  //Connection conn1=null;
			  for(int i=0;i<ed;i++)
			  {
				  try {
					  Class.forName("com.mysql.jdbc.Driver");
					  Connection conn1 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/javaassinment","root","ksy$1531");
					  System.out.println("Connection success ");
					  String sql= "insert into student_info values(?,?,?,?)";
					  PreparedStatement   pstmt = (PreparedStatement) conn1.prepareStatement(sql);
					  System.out.println("Enter the roll number");
					  int rno=sc.nextInt();
					  pstmt.setInt(1, rno );
					  System.out.println("Enter name");
					  String name=sc.nextLine();
					  pstmt.setString(2,name);
					  
					    
				  }catch(Exception e)
				  {
					  System.err.println("Connection faild "+e);
				  }
			  }
		  }
	  }
		
		
	    }
	}

}

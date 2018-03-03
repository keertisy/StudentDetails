package ja;
import java.sql.*;
import java.io.*;
import java.util.*;


import java.*;


public class Test {

	public static void main(String[] args)
	{
		// TODO Auto-generated constructor stub
		 
		Scanner sc=new Scanner(System.in);
	    BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	    int num,ed,id,del;
		boolean test=true;
		
		while(test)
		{
	    System.out.println("*****MENU*****");
	    System.out.println("1.Insert \n2.Update\n3.Delete\n4.Display\n5.Exit");
	    System.out.println("Enter your choice");
	    num=sc.nextInt();
	  
	  if(num==1)
	  {
	    	 System.out.println("Enter the how many student details you want to enter");
			  ed=sc.nextInt();
			 
			  for(int i=0;i<ed;i++)
			  {
				  System.out.println("Enter the "+(i+1)+"student details");
				  try {
					  Class.forName("com.mysql.jdbc.Driver");
					  Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaassinment","root","ksy$1531");
					  String sql= "insert into student values(?,?,?,?,?)";
					  PreparedStatement   pstmt = conn1.prepareStatement(sql);
					  
					  System.out.println("Enter roll number:");
					  int rno=sc.nextInt();
					  
					  System.out.println("Enter usn:");
					  String susn=sc.next ();
				  
					  System.out.println("Enter name:");
					  String name=sc.next ();
					  
					  System.out.println("Enter sem:");
					  String sem=sc.next ();
					  
					  System.out.println("Enter branch:");
					  String branch=sc.next ();
					  
					 /* System.out.println("Enter roll GQ (range in between 0-10):");
					  int gq=sc.nextInt();
					  
					  System.out.println("Enter roll GPA ( 0,0.3,0.6,1):");
					  int gpa=sc.nextInt();*/
					  
					  pstmt.setInt(1, rno );
					  pstmt.setString(2,susn);
					  pstmt.setString(3,name);
					  pstmt.setString(4,sem);
					  pstmt.setString(5,branch);
					  /*if(gq<=10||gq>=0)
						  pstmt.setInt(6,gq );
					  if(gpa==0 || gpa==.3 || gpa==.6 || gpa==1)
						  pstmt.setInt(7,gq ); */
					  pstmt.executeUpdate();
					  System.out.println("insertion successful");
					  conn1.close();
					    
				  }catch(Exception e)
				  {
					  System.err.println("Insertion faild "+e);
				  }
	          }
			  
	     }
	     
	     if(num==2)
	     { 
			  try {
				  Class.forName("com.mysql.jdbc.Driver");
				 Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaassinment","root","ksy$1531");
				  System.out.println("Enter the student id to be ");
			      id=sc.nextInt();
			
			      String sql= "update student  set USN = ?,name = ?,sem = ?,branch = ? where Roll_no = ?";
				  PreparedStatement   pstmt = conn1.prepareStatement(sql);
				  
				  System.out.println("Enter USN");
				  String usn=sc.next ();
				  pstmt.setString(1,usn);
				  
				  System.out.println("Enter name");
				  String name=sc.next ();
				  pstmt.setString(2,name);
				  
				  System.out.println("Enter sem");
				  String sem=sc.next ();
				  pstmt.setString(3,sem);
				  
				  System.out.println("Enter branch");
				  String branch=sc.next ();
				  pstmt.setString(4,branch);
				  
				  pstmt.setInt(5,id);
				  
				  pstmt.executeUpdate();
				  System.out.println("update successful");
				  conn1.close();
			  }catch(Exception e)
			  {
				  System.err.println("update faild "+e);
			  }
	     }
	     
	    
		if(num==3)
	     {
	    	 try {
				  Class.forName("com.mysql.jdbc.Driver");
				  Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaassinment","root","ksy$1531");
				  System.out.println("Enter the student id to be deleted  ");
			      del=sc.nextInt();
				  String sql= " delete from student where Roll_no = ?";
				  PreparedStatement   pstmt = conn1.prepareStatement(sql);
				  pstmt.setInt(1,del);
				  pstmt.executeUpdate();
				  System.out.println("Deletion successful");
				  conn1.close();
	    	 }catch(Exception e)
			  {
				  System.err.println("Deletion faild "+e);
			  }
			
	    	 
	     }
	     
	    if(num==4)
	    {
	    	 System.out.println("Displying the table contents");
	    	 try {
	    	Class.forName("com.mysql.jdbc.Driver");
			 Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaassinment","root","ksy$1531");
			 PreparedStatement   pstmt = conn1.prepareStatement("select * from student");
			 ResultSet result =pstmt.executeQuery();
			 while(result.next())
			 {
				 System.out.println("Roll no: "+result.getInt(1)+"  USN: "+result.getString(2)+"  Name: "+result.getString(3)+"  Sem: "+result.getString(4)+"  Branch: "+result.getString(5));
			 
			 }
			// pstmt.executeUpdate();
			conn1.close();
			 
	    	 }
	    	 catch(Exception e)
			  {
				  System.err.println("unabel to display the cantens of table "+e);
			  }
	     }
	     
	     if(num==5)
	     {
	    	  test=false;
	     }
	     
	}
 }

}


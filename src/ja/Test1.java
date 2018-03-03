package ja;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class Test1 {
	public static void main(String[] args)   {
		// TODO Auto-generated constructor stub
		Scanner sc=new Scanner(System.in);
	    BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	    int num = 0, num1=0,num2=0,num3=0,num4=0,ed=0,ed1=0,id=0 ;
	    int tom=0,del=0;
		boolean test=true;
		
		while(test)
		{
	    System.out.println("*****MENU*****");
	    System.out.println("1.create\n2.Insert \n3.Update\n4.Delete\n5.Display\n6.To know whole class performance\n7.Exit");
	    System.out.println("Enter your choice");
	    num=sc.nextInt();
	    boolean test1=true; 
		boolean test2=true; 
		boolean test3=true;
		boolean test4=true;
	   
	  switch(num)
	  {
		
	  case 1:createTable();
	         break;
	         
	  case 2:{
		  while(test1) {
			 System.out.println("\n1.Insert into student information  table\n2.Insert into student mark's  table\n3.Go back to previous menu");
			 System.out.println("Enter your choice");
			 num1=sc.nextInt();
			 
			 switch(num1)
			 {
			 case 1:{
		   System.out.println("Enter the how many student details you want to enter");
	   	   ed=sc.nextInt();		 
		   for(int i=0;i<ed;i++)
		     {	
			   System.out.println("Enter the "+(i+1)+" student details");
		   try {
			  Connection conn1=getConnection();
		  String sql= "insert into   studenttable1 values(?,?,?,?,?)";
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
		  
		  pstmt.setInt(1, rno );
		  pstmt.setString(2,susn);
		  pstmt.setString(3,name);
		  pstmt.setString(4,sem);
		  pstmt.setString(5,branch);
		  pstmt.executeUpdate();
		  System.out.println("insertion successful ");
		  conn1.close();
		  }catch(Exception e)
		  {
			System.err.println("Insertion faild "+e);
		  }
		     }
			 }break;
			 
			 case 2:{
				 System.out.println("Enter the how many student details you want to enter");
				 ed1=sc.nextInt();
				 
				  for(int i=0;i<ed1;i++)
				  {
					  System.out.println("Enter the "+(i+1)+" student details");
				 try {
					  Connection conn1=getConnection();
				 String sql= "insert into  studenttable2 values(?,?,?)";
				 PreparedStatement   pstmt1 = conn1.prepareStatement(sql);
				 
				 System.out.println("Enter roll number:");
				  int rno=sc.nextInt();
				  
				  System.out.println("Enter Greaded Quize markes(0-10) :");
				  int gq=sc.nextInt();
				  
				  System.out.println("Enter  Greaded Programming Assignment(0,0.3,0.6,1):");
				  float gpa=sc.nextFloat();
				  int a;
				  a=(int)(gpa*10);
				  
				  pstmt1.setInt(1, rno );
				  if(gq<=10 && gq>=0)
				    pstmt1.setInt(2, gq );
				  else 
					 System.out.println("You have entered wrong markes");
				  
				  if(gpa==0 || (a==3) || ( a==6) || gpa==1)
				    pstmt1.setFloat(3, gpa );
				  else 
						 System.out.println("You have entered wrong markes");
				  pstmt1.executeUpdate();
				  System.out.println("insertion successful ");
				  conn1.close();
				 }catch(Exception e)
				  {
					  System.err.println("Insertion faild "+e);
				  }
				  }
			 }break;
			 case 3:test1=false;
			 break;
			 
			 default :System.out.println("You have entered wrong choice");
			 
		  }
		  } 
		   
	  }break;
	  
	  case 3:{
		  while(test2) {
				 System.out.println("\n1.Update student information table\n2.Update student mark's  table\n3.Go back to previous menu");
				 System.out.println("Enter your choice");
				 num2=sc.nextInt();
				 
				 switch(num2)
				 {
				 case 1:{
					 try {
					 Connection conn1=getConnection();
					 int z=0;
					 System.out.println("Enter the student id to be update");
				      id=sc.nextInt();
				
				      String sql= "update  studenttable1  set usn = ?,name = ?,sem = ?,branch = ? where rollno = ?";
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
					  
					  z=pstmt.executeUpdate();
					  if(z==1)
					  System.out.println("update successful");
					  else
						  System.out.println("update unsuccessful");
					 
					 
					  conn1.close();
					  }catch(Exception e)
					      {  
							  System.err.println("update faild "+e);
					      }
					 
				        }break;
				 case 2:{
					 try {
						 Connection conn1=getConnection();
						 int y=0;
						 System.out.println("Enter the student id to be update ");
					      tom=sc.nextInt();
					
					      String sql= "update studenttable2   set gq = ?,gpa = ? where rollno = ?";
						  PreparedStatement   pstmt1 = conn1.prepareStatement(sql);
						  
						  System.out.println("Enter Greaded Quize markes(0-10) :");
						  int gq=sc.nextInt();
						  
						  System.out.println("Enter  Greaded Programming Assignment(0,0.3,0.6,1):");
						  float gpa=sc.nextFloat();
						  y=(int)(gpa*10);
						  
						  if(gq<=10 && gq>=0)
						    pstmt1.setInt(1, gq );
						  else 
							 System.out.println("You have entered wrong markes");
						  
						  if(gpa==0 || (y==3) || ( y==6) || gpa==1)
							    pstmt1.setFloat(2, gpa );
						  else 
								 System.out.println("You have entered wrong markes");
						  pstmt1.setInt(3,tom);
						  
						  pstmt1.executeUpdate();
						 // System.out.println(pstmt1.executeUpdate() );
						  y=pstmt1.executeUpdate();
						  if(y==1)
						  System.out.println("Updation successful ");
						  else 
							  System.out.println("Updation unsuccessful ");  
						   
						  conn1.close();
					 }catch(Exception e)
				      {  
						  System.err.println("update faild "+e);
				      }
				 }break;
				 case 3:test2=false;
				 break;
				 
				 default :System.out.println("You have entered wrong choice");
				 
				 }
				}
	  }break;
	  
	  case 4:{
		  try {
			  Connection conn1=getConnection();
			  int x=0;
			  System.out.println("Enter the student id to be deleted  ");
		      del=sc.nextInt();
			  String sql= " delete from   studenttable2 where rollno = ?";
			  PreparedStatement   pstmt1 = conn1.prepareStatement(sql);
			  pstmt1.setInt(1,del);
			  pstmt1.executeUpdate();
			  String sql1= " delete from   studenttable1 where rollno = ?";
			  PreparedStatement   pstmt = conn1.prepareStatement(sql1);
			  pstmt.setInt(1,del); 
			  //System.out.println( pstmt.executeUpdate());
			  x= pstmt.executeUpdate();
			  if(x==1)
		         System.out.println("Deletion successful");
			  else
				  System.out.println("Deletion unsuccessful");
			  conn1.close();
    	 }catch(Exception e)
		  {
			  System.err.println("Deletion faild "+e);
		  }
		  
	  }break;
	  
	  case 5:{
	    	 while(test4) {
	   		  System.out.println("\n1. Diplay two separate tables\n2. Display in single table\n3. To know the total number of entry's in a table\n4. Go back to previous menu");
	   			 System.out.println("Enter your choice");
	   			 num4=sc.nextInt();
	   			 switch(num4) {
	   			 case 1:{
	   				 try {
	   				Connection conn1=getConnection();
	   				 System.out.println("\nDisplying the student information table contents");
	   				 PreparedStatement   pstmt = conn1.prepareStatement("select * from  studenttable1");
	   				 ResultSet result =pstmt.executeQuery();
	   				 
	   				 while(result.next())
	   				 {
	   					 System.out.println("Roll no: "+result.getInt(1)+"\t  USN: "+result.getString(2)+"\t  Name: "+result.getString(3)+"\t\t  Sem: "+result.getString(4)+"\t  Branch: "+result.getString(5));
	   				 
	   				 }
	   				 
	   				 System.out.println("\n\nDisplying the student marks table contents");
	   				 PreparedStatement   pstmt1 = conn1.prepareStatement("select * from  studenttable2");
	   				 ResultSet result1 =pstmt1.executeQuery();
	   				 
	   				 while(result1.next())
	   				 {
	   					 System.out.println("Roll no: "+result1.getInt(1)+"\t  GQ: "+result1.getInt(2)+"\t\t GPA : "+result1.getFloat(3) );
	   				 }
	   				 
	   			  conn1.close();
	   				 }catch(Exception e)
	   			  {
	   				  System.err.println("unabel to display the cantens of table "+e);
	   			  }
	   			 }break;
	   			 case 2:{
	   				 try {
	   					Connection conn1=getConnection();
	   				 System.out.println("Displying the table contents");
	   				 PreparedStatement   pstmt = conn1.prepareStatement("  select st1.rollno,st1.usn,st1.name,st1.sem,st1.branch,st2.gq,st2.gpa from studenttable1 st1\r\n" + 
	   				 		"  join studenttable2 st2 on st1.rollno=st2.rollno;");
	   				 ResultSet result =pstmt.executeQuery();
	   				 
	   				 while(result.next())
	   				 {
	   					 System.out.println("Roll no: "+result.getInt(1)+"\t  USN: "+result.getString(2) +"\t  Name: "+result.getString(3)+"\t\t  Sem: "+result.getString(4) +"\t  Branch: "+result.getString(5) +  "\t  GQ: "+result.getInt(6) +"\t\t  GPA : "+result.getFloat(7));
	   				 
	   				 }
	   				 
	   				conn1.close();
	   				 }catch(Exception e)
		   			  {
		   				  System.err.println("unabel to display the cantens of table "+e);
		   			  }
	   			 }break;
	   			 case 3:{
	   			//to find total numbers of rows in table
	   			  try {
	   				  Connection conn1=getConnection();
	   			  String sql= " select count(rollno) from  studenttable2 ";
	   			  PreparedStatement   pstmt1 = conn1.prepareStatement(sql);
	   			  ResultSet  results =pstmt1.executeQuery();
	   			  if(results.next()) {
	   				  String sum= results.getString("count(rollno)");
	   				  System.out.println("Total number of rows :"+sum); }
	   			  conn1.close(); 
	   			  } catch(Exception e)
	   			  {
	   				  System.err.println("unabel to display the cantens   "+e);
	   			  }
	   			 }break;
	   			 case 4:test4=false;
				 break;
				 
				 default :System.out.println("You have entered wrong choice");
				 
	   			 }
	    	 }
	  }break;
	  
	  case 6:{  
		  while(test3) {
		 
			  System.out.println("\n1.Diplay GQ student performance\n2.Diplay GQA student performance\n3.Go back to previous menu");
			  System.out.println("Enter your choice");
			  num3=sc.nextInt();
			  switch(num3) {
			  case 1:{
				  try {
		    Connection conn1=getConnection();
		     System.out.println("Student performanc in Graded Quizze\n");
		      for(int i=0;i<=10;i++) {
			  String sql = " select gq ,count(rollno) from studenttable2 group by gq having gq=?";
			  PreparedStatement   pstmt1 = conn1.prepareStatement(sql);
			  int c=i;
			  pstmt1.setInt(1,c);
			  ResultSet result2 =pstmt1.executeQuery();
			   
			 while(result2.next()) {
				 String gq=result2.getString(1);
				 String rollno=result2.getString(2);
			  System.out.println( gq +" markes taken by "+ rollno +" students");
			   
			 }
		      }
		      conn1.close(); 
			  
		  } catch(Exception e)
		  {
			  System.err.println("unabel to display the cantens   "+e);
		  }
		  }break;
			  case 2:
			  {
				  try {
					  Connection conn1=getConnection();
					  System.out.println("\nStudent performanc in Graded Programming Assignment\n");
					  for(float j=0;j<=0.9;j=(float) (j+0.3)) 
					  {
				      String sql = " select gpa ,count(rollno) from studenttable2 group by gpa having gpa=?";
					  PreparedStatement   pstmt1 = conn1.prepareStatement(sql);
					  float c=j;
					  pstmt1.setFloat(1,c);
					  ResultSet result2 =pstmt1.executeQuery();
					  
					 while(result2.next()) {
						 String gpa=result2.getString(1);
						 String rollno=result2.getString(2);
					  System.out.println( gpa +" markes taken by "+ rollno +" students"); 
					 }
					  }
					 
					 String sql = " select gpa ,count(rollno) from studenttable2 group by gpa having gpa=1";
					  PreparedStatement   pstmt3 = conn1.prepareStatement(sql);
					  ResultSet result31 =pstmt3.executeQuery();
					 while(result31.next()) {
						 String gpa=result31.getString(1);
						 String rollno=result31.getString(2);
					  System.out.println( gpa +" markes taken by "+ rollno +" students"); 
					 }
					 conn1.close();   
				  } catch(Exception e)
				  {
					  System.err.println("unabel to display the cantens   "+e);
				  }
			  }break;
			  case 3:test3=false;
				 break;
				 
				 default :System.out.println("You have entered wrong choice");
				 
			  } 
		  }
		  
	  }break;
	  case 7:{test=false;
	         System.out.println("Thank you......:)");}
	        break;
	        default :System.out.println("You have entered wrong choice");
	  }	
		}
}
	
	
	public static void createTable()  
	{
		try
		{	
			Connection conn1=getConnection();
			 conn1.setAutoCommit(true);
			PreparedStatement pstmt= conn1.prepareStatement("create table if not exists studenttable1 (rollno int(4)   not null unique key,"
					+ "usn varchar(20)  not null unique key,name varchar(30) not null,sem varchar(10) not null,branch varchar(30) not null,primary key(rollno,usn))");
			PreparedStatement pstmt1= conn1.prepareStatement("create table if not exists studenttable2 (rollno int(4) not null ,"
					+ "gq int(2) not null,gpa decimal(2,1) not null,foreign key(rollno) references studenttable1(rollno) )");
	        
			pstmt.executeUpdate();
			pstmt1.executeUpdate();
			
			 System.out.println("Table created");
			 conn1.setAutoCommit(true);
			 pstmt.close();
			 pstmt1.close();
			 conn1.close();
		}
		catch(Exception e) {
			  System.err.println("Table creation faild \n"+e);
		  }
		 	}
 
	
	 public static Connection getConnection()   {
		 try
		 {
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaassinment","root","ksy$1531");
			 System.out.println("Connected");
		     return conn1;
		 }catch(Exception e) {
			  System.err.println("Connection faild "+e);
		 }
		return null;
	 }
}

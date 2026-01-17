
package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Controller implements Methods {
	public void save() {
		Scanner s= new Scanner(System.in);
		
		try {
			Class.forName("org.postgresql.Driver");
			
			
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/crudoperation?user=postgres&password=root");
			PreparedStatement statement = connection.prepareStatement("insert into student values(?,?,?,?) ");
			
			
			
//			Long number=s.nextLong();
//			String email=s.next();
			System.out.println("Enter Details to be saved:");
			
			System.out.println("Enter ID:");
			statement.setInt(1,s.nextInt());
			
			System.out.println("Enter Name:");
			statement.setString(2, s.next());
			
			System.out.println("Enter Number:");
			statement.setLong(3,s.nextLong());
			
			System.out.println("Enter Email:");
			statement.setString(4,s.next() );
		
			boolean res = statement.execute();
			System.out.println("Records saved");

		}
		catch(Exception e) {
			e.printStackTrace();
			}
		}
		
	public void update(int id) throws Customized{
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/crudoperation?user=postgres&password=root");
			PreparedStatement statement = connection.prepareStatement("select * from student where id=? ");
			statement.setInt(1, id);
			
//			boolean execute = statement.execute();
//			if (execute) {
//				
//			}
//			else
//				System.out.println("ID not found--");
			
			ResultSet r = statement.executeQuery();
			Scanner s= new Scanner(System.in);
			if(r.next()) {
				System.out.println(" 1.UpdateName\n 2.UpdateMobNumber\n 3.UpdateEmail");
				System.out.print("Select choice:");
				int ch=s.nextInt();
				
				switch (ch) {
				case 1:{
					//update name
					PreparedStatement statement2 = connection.prepareStatement("update student set name=? where id=?");
					System.out.print("Enter Name to be updated:");
					statement2.setString(1, s.next());
					statement2.setInt(2, id);
					
					statement2.execute();
					System.out.println("Name updated");
				}
					break;
				case 2:{
//					update mobNo
					PreparedStatement statement2 = connection.prepareStatement("update student set mobileno=? where id=?");
					System.out.print("Enter Number to be updated:");
					statement2.setLong(1, s.nextLong());
					statement2.setInt(2, id);
					
					statement2.execute();
					System.out.println("Number updated");
				}
					break;
				case 3:{
//					update email
					PreparedStatement statement2 = connection.prepareStatement("update student set email=? where id=?");
					System.out.print("Enter Email to be updated:");
					statement2.setString(1, s.next());
					statement2.setInt(2, id);
					
					statement2.execute();
					System.out.println("Email updated");
				}
					break;

				default:{
					System.out.println("Invalid choice");
				}
					break;
				}
				
			}else {
				throw new Customized();
			}
			
			
		} catch (Exception e ) {
				e.printStackTrace();
				
				
		}
		
	}
	public void delete(int id) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/crudoperation?user=postgres&password=root");
			
			PreparedStatement s = connection.prepareStatement("delete  from student where id=?");
			s.setInt(1, id);
			boolean e = s.execute();
			System.out.println(e);
			
			System.out.println("Record Deleted");
			
			
			
			
		} catch (ClassNotFoundException | SQLException e ) {
			e.printStackTrace();
		}
		
	}
	
	public void  getalldata() {
		
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/crudoperation?user=postgres&password=root");
			Statement statement = connection.createStatement();
			ResultSet res = statement.executeQuery("select * from student");
			
		
				while(res.next()) {
					System.out.print( res.getInt(1)+" ");
					System.out.print(res.getString(2)+" ");
					System.out.print(res.getLong(3)+" ");
					System.out.print(res.getString(4)+" ");
					System.out.println();
				}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void getbyid(int id) {
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/crudoperation?user=postgres&password=root");
			Statement statement = connection.createStatement();
			ResultSet res = statement.executeQuery("select * from student");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}

package com.qsp;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		Methods c=new Controller();
		
		System.out.println(" 1.Save\n 2.Update\n 3.Delete\n 4.Get all Data\n 5.Get by Id");
		System.out.print("Enter your choice:");
		int choice = s.nextInt();
		
		switch (choice) {
		case 1:{
			//Save
			c.save();
		}
			break;
		case 2:{
			//Update
			System.out.print("Enter id:");
			int id=s.nextInt();
			try {
				c.update(id);
			} catch (Customized e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			break;
		case 3:{
			//Delete
			System.out.println("Enter Id:");
			int id=s.nextInt();
			c.delete(id);
		}
			break;
		case 4:{
			//Get all Data
			c.getalldata();
		}
			break;
		case 5:{
			// Get by Id
		}
			break;

		default:
			break;
		}
		
		
	}
}

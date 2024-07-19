package com.Alpha.Notepad.controller;

import com.Alpha.Notepad.dao.NotepadDao;
import com.Alpha.Notepad.dto.Notepad;

import java.sql.PreparedStatement;
import java.util.Scanner;

public class NotepadController {
	static Scanner sc = new Scanner(System.in);
	static NotepadDao notepadDao = new NotepadDao();
	Notepad n = new Notepad(); // Assuming this is your default Notepad instance

	public static void createNotepad() {
		System.out.print("Enter id:");
		int id = sc.nextInt();
		sc.nextLine(); // Consume newline left by nextInt()

		System.out.print("Enter title:");
		String title = sc.nextLine();

		System.out.print("Enter content:");
		String content = sc.nextLine();

		Notepad notepad = new Notepad(id, title, content);

		notepadDao.saveNotepad(notepad);
		
	}
    
	public static void update() {
	        
		    System.out.println("Enter id:"); 
		    int id1=sc.nextInt();sc.nextLine();
		
			System.out.print("Enter new title:");
            String title = sc.nextLine();
            
                       
            System.out.print("Enter new content:");
            String content = sc.nextLine();
            
            Notepad notepad = new Notepad(id1,title , content);

    		notepadDao.updateNotepad(notepad);
          
		
	}
	
	public void find() {
		System.out.print("Enter notepad ID to find:");
		int notepadId = sc.nextInt();
		

		Notepad note =notepadDao.findNotepadById(notepadId);
		System.out.println(note);
		
	}
	
	public void delete() {
		System.out.println("Enter id to delete:");
		int notepadId=sc.nextInt();
		
		boolean deleted = notepadDao.deleteById(notepadId);
	   
	    
	}
	public static void main(String[] args) {
		NotepadController nc = new NotepadController();
		System.out.println("=================WELCOME TO NOTEPAD====================");
		while (true) {
			System.out.println("1. Save");
			System.out.println("2. Update");
			System.out.println("3. Find");
			System.out.println("4. Display");
			System.out.println("5. Delete");
			System.out.println("6. exit");
			System.out.print("Enter your choice:");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1: {
				nc.createNotepad();
			}
				break;
			case 2: {
				nc.update();
			}
				break;
			case 3: {
				nc.find();
			}
				break;
			case 4: {
				notepadDao.displayAll().forEach((n) -> System.out.println(n));
			}
			break;
			case 5: {
			   nc.delete();
			}case 6:{
				System.exit(0);
			}
			break;
			default:
				System.out.println("Invalid choice");
			}
		}
	}
}

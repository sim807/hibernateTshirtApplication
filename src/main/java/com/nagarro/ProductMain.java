package com.nagarro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ProductMain {

	public static void main(String[] args) throws FileNotFoundException, IOException,InputMismatchException,Throwable {
		
		try {
			
			ReadFiles.readFiles();
			
			List<Character> genderList=new ArrayList<Character>();
			
			genderList.add('M');
			genderList.add('F');
			genderList.add('U');
		
		
			
			String color="";
			char size;
			char gender;
			int outputPreference=0;

			SearchLogic sl = new SearchLogic();
        
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.println("PRODUCT SEARCH APPLICATION");
			
			System.out.println("Enter Color of the T-Shirt:");
			color=sc.nextLine();
		
			System.out.println("Enter size");
			size=sc.next().charAt(0);
			
			System.out.println("Enter the gender(M for Male, F for Female, U for Unisex):");
			do {
				gender=sc.next().charAt(0);
				
				// try catch block to handle exception
				try {
					
					//conditional statement to check if entered gender type is correct or not
					if(!genderList.contains(Character.toUpperCase(gender))){
						throw new Exception("Unsupported value for Gender type,"
								+ " Please choose value from one of them (M/F/U)");
						
					} 
				} catch (Exception e){
					System.out.println(e.getMessage());
				}
					
			}while(!genderList.contains(Character.toUpperCase(gender)));
			
		
			System.out.println("Enter Output Preference(1 for Output sorted by price,"
				+ " 2 for output sorted by rating, 3 for output sorted by both price and rating):");
			outputPreference= sc.nextInt();
		
			ResourceUpdate rc= new ResourceUpdate(new File("src/main/resources"));
			rc.start();
		
			sl.searchProduct(color,size,gender);
			
			sl.sort(outputPreference);
			
		}catch(Exception e){
			System.out.println("Error Occured");
			System.out.println(e.getMessage());
			
		}
		
	} 
		
}



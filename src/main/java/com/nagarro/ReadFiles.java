package com.nagarro;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import db.ProductDao;
import model.TShirt;


public class ReadFiles extends Thread{

	private static final String path= "src/main/resources";
	private static ArrayList<String> filesList= new ArrayList<String>();
	
	//method to get all the files fro resource folder
	public static  ArrayList<String> getFiles() throws FileNotFoundException, IOException{
		
		try {
			
			File folder = new File(path);
			
			// fetching the name of files from a resource folder
			for(File file: folder.listFiles()) {
				
				String fileName= file.getName();
				
				if(!filesList.contains(fileName)) {
					filesList.add(fileName);
				}
			}
			
			} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return filesList;
	}
	
	static String[] elements;
	 
	// method to read the data of the files
	public static  void readFiles() throws FileNotFoundException,IOException  {
		 
		getFiles();
		if(filesList.size()>0) {
			
			for(String name: filesList) {
				
				try {
					
					CSVReader reader= new CSVReader(new FileReader(path+"/"+name));
					String[] singleData;
				
					while((singleData=reader.readNext()) != null){
						
						//data --> storing the line 
						for(String data: singleData) {

							String cell= data;
							// splitting each line with pipe
							if(!cell.isEmpty()){
								elements =cell.split("\\|");
								if(elements[0].equalsIgnoreCase("ID")) {
									continue;
								}
								TShirt tshirt=new TShirt();
								tshirt.setId(elements[0]);
								tshirt.setName(elements[1]);
								tshirt.setColor(elements[2]);
								tshirt.setGender(elements[3].charAt(0));
								tshirt.setSize(elements[4].charAt(0));
								tshirt.setPrice(Float.parseFloat(elements[5]));
								tshirt.setRating(Float.parseFloat(elements[6]));
								tshirt.setAvailability(elements[7]);
								
								SessionFactory sessionFactory= ProductDao.getSessionFactory();
										  
								Session session = sessionFactory.openSession();
								Transaction tn= session.beginTransaction();
										  
								session.save(tshirt);
								tn.commit();
										
							}
						}
					}
				}catch(Exception e){
					
					System.out.println(e.getMessage());
				}
			}
		}
	}
}




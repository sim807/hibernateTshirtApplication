package com.nagarro;

import java.io.File;

public class ResourceUpdate extends Thread {

	private File file;
	private long timeStamp;
	
	//Constructor
	public ResourceUpdate(File file) {
		this.file = file;
		this.timeStamp = file.lastModified();
	}

	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(3000);
				long newtimestamp = file.lastModified();

				if (this.timeStamp != newtimestamp) {
					this.timeStamp = newtimestamp;

					modified(file);// called only if there is any update in resource folder
				}
			}

		} catch (Exception e) {
			System.out.println("Thread didnt work");
		}

	}
	
	// read data for modified files
	@SuppressWarnings("static-access")
	public void modified(File file) {

		ReadFiles rd = new ReadFiles();

		try {
			rd.readFiles();

		} catch (Exception e) {

			System.out.println("Enter a Valid Input");
		}
	}
}

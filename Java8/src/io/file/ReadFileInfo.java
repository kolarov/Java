package io.file;

import java.io.*;

public class ReadFileInfo {
	public static void main(String[] args) throws IOException {
		File file = new File("src\\io\\file\\sample.txt"); // relative path
		File directory = new File("C:\\Users\\Kolarov\\Desktop\\JavaRepo\\Java8"
												,"src\\io\\file\\sampleFolder"); 
		//file=directory; 
		System.out.println("File exists: "+ file.exists());
		if(file.exists()) {
			System.out.println("Absolote Path: " + file.getAbsolutePath());
			System.out.println("Is directory: " + file.isDirectory());
			System.out.println("Parent Path: " + file.getParent());
			if(file.isFile()) {
				System.out.println("File siza: " + file.length());
				System.out.println("File last modified: "+ file.lastModified());
			} else {
				for (File subfile: file.listFiles()) 
					System.out.println("\t" + subfile.getName());
			}
		}
		
		try (InputStream is = new BufferedInputStream(
								new FileInputStream(file));) 
		{
			System.out.print((char) is.read()); //read() gets to EOF -> -1
			if(is.markSupported()) { //otherwise we can get an exception
				is.mark(4); // do not put a large value for memory concerns
				System.out.print((char) is.read());
				System.out.print((char) is.read());
				is.reset();
			}
			System.out.print((char) is.read());
			System.out.print((char) is.read());
			System.out.print((char) is.read());
			
		}
		
		
		
		
	}
}

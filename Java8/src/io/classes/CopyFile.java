package io.classes;

import java.io.*;

public class CopyFile {
	
	//creates or overwrites at the destination
	public static void copy(File source, File destination) throws IOException {
		try (InputStream in = new FileInputStream(source);
			 OutputStream out = new FileOutputStream(destination)) 
		{
			int b;
			while((b=in.read()) != -1) 
				out.write(b);
		}
	}
	
	public static void main(String[] args) throws IOException {
		//if the source file is not fount -> FileNotFoundException(IOException)
		File source = new File("src\\io\\file\\sample.txt");
		File destination = new File("src\\io\\file\\copy.txt"); 
		
		copy(source, destination);

	}

}

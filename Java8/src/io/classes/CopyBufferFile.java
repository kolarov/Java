package io.classes;

import java.io.*;

public class CopyBufferFile {
	//creates or overwrites at the destination
	public static void copy(File source, File destination) throws IOException {
		try (InputStream in = new BufferedInputStream(
									new FileInputStream(source));
			 OutputStream out = new BufferedOutputStream(
					 				new FileOutputStream(destination))) 
		{
			//instead of reading one byte at a time we use read(byte[]) which 
			//returns the number of bytes read into the provided byte array
			byte[] buffer = new byte[256]; //usually a power of 2
			int length;
			//the last read will likely only partially fill the byte array
			//the remaining bytes of the array will be filled with leftover data
			while((length = in.read(buffer)) > 0) 
				out.write(buffer, 0, length); //offset = 0
				out.flush(); //ensures that written data makes it to the disk
		}
	}
	
	public static void main(String[] args) throws IOException {
		//if the source file is not fount -> FileNotFoundException(IOException)
		File source = new File("src\\io\\file\\sample.txt");
		File destination = new File("src\\io\\file\\copy.txt"); 
		
		copy(source, destination);

	}

}

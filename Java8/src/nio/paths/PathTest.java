package nio.paths;

import java.io.IOException;
import java.nio.file.*;


//Most methods in Path and Paths do not communicate with the operating system
//There are still methods like Path.toRealPath() that do require the file to
//exist
public class PathTest {
	
	public static void printPathInfo(Path path) {
		System.out.println("File name is: " + path.getFileName());
		System.out.println("Root is: " + path.getRoot());
		Path currentParent = path;
		while ((currentParent = currentParent.getParent()) != null)
			System.out.println("Current parent is: " + currentParent);
	}
	
	public static void main(String[] args) throws IOException{
		
		printPathInfo(Paths.get("src\\io\\file\\sampleFolder\\SubFile1.txt"));
		System.out.println();
		printPathInfo(Paths.get("file\\sampleFolder\\SubFile1.txt"));
		
		Path p = Paths.get("src\\io\\file\\sampleFolder\\SubFile1.txt");
		Path p2 = Paths.get("src\\io\\file\\sampleFolder\\SubFile2.txt");
		Path p3 = Paths.get("..\\SubFile2.txt"); //no need to exist
		
		System.out.println(p.isAbsolute());  			//false
		System.out.println(p.toAbsolutePath());			
		System.out.println(p.subpath(1, 3));			//io\file
		
		//if we mix a relative and an absolute path -> IllegalArgumentException
		System.out.println(p.relativize(p2));		//..\SubFile2.txt
		
		//src\io\file\sampleFolder\SubFile1.txt\..\SubFile2.txt
		System.out.println(p.resolve(p3)); 
		
		// src\io\file\sampleFolder\SubFile2.txt
		System.out.println(p.resolve(p3).normalize());
		
		//if we use p3 the code will not compile
		System.out.println(p.toRealPath()); //throws IOException
		
	}

}

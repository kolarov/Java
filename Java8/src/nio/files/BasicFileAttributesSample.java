package nio.files;

import java.util.*;
import java.nio.file.*;
import java.io.IOException;
import java.nio.file.attribute.*;

public class BasicFileAttributesSample {
	
	public static void main(String[] args) throws IOException {
		
		Path p = Paths.get("src\\io\\file\\sampleFolder\\SubFile1.txt");
		BasicFileAttributes data = Files.readAttributes(p,
													BasicFileAttributes.class);
		System.out.println(data.isDirectory());
		System.out.println(data.isRegularFile());
		System.out.println(data.isSymbolicLink());
		System.out.println(data.isOther());
		System.out.println(data.size());
		System.out.println(data.creationTime());
		System.out.println(data.lastAccessTime());
		System.out.println(data.lastModifiedTime());
		System.out.println(data.fileKey());
		
		List<String> lines = Files.readAllLines(p);
		for (String line : lines) 
			System.out.println(line);
		
	}

}

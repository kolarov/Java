package nio.streamMethods;

import java.nio.file.*;
import java.util.stream.*;
import java.io.IOException;

public class FancyStreamMethods {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("src\\io");
		Path filePath = Paths.get("src\\io\\file\\sampleFolder\\SubFile1.txt");
		
		//Files.walk(path) returns a Stream<Path>
		Files.walk(path).filter(p -> p.toString().endsWith(".java"))
					 .forEach(System.out::println);
		System.out.println();
		
		
		//Files.find(path, int, BiPredicate) returns a Stream<Path>
		long dateFilter = 1420070400000L;
		Stream<Path> stream = Files.find(path, 4, 
				(p,a) -> p.toString().endsWith(".java") 
					&& a.lastModifiedTime().toMillis() > dateFilter);
		stream.forEach(System.out::println);
		System.out.println();
		
		//Files.list(path) returns a Stream<Path>
		//It is like java.io.File.listFiles() 
		Files.list(path).filter(p -> Files.isDirectory(p))
						.map(p -> p.toAbsolutePath())
						.forEach(System.out::println);
		System.out.println();
		
		//Files.lines(filePath) returns a Stream<String>
		//avoids the possibility of OutOfMemoryError when using readAllLines
		Files.lines(filePath).forEach(System.out::println);
	}

}

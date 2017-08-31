package nio.files;

import java.nio.file.*;
import java.io.IOException;
import java.nio.file.attribute.*;

public class BasicFileAttributeViewSample {

	public static void main(String[] args) throws IOException{
		Path p = Paths.get("src\\io\\file\\sampleFolder\\SubFile1.txt");
		BasicFileAttributeView view = Files.getFileAttributeView(p, 
												BasicFileAttributeView.class);
		BasicFileAttributes data = view.readAttributes();
		System.out.println(data.isDirectory());
		System.out.println(data.isRegularFile());
		System.out.println(data.isSymbolicLink());
		System.out.println(data.isOther());
		System.out.println(data.size());
		
		//There is only one update method setTimes(lastMod, lastAccess, created)
		FileTime  lastModTime = FileTime.fromMillis(
								data.lastModifiedTime().toMillis() + 10_000);
		view.setTimes(lastModTime, null, null);
		System.out.println(data.creationTime());
		System.out.println(data.lastAccessTime());
		System.out.println(data.lastModifiedTime()); //gets increase by 10sec
		
		System.out.println(data.fileKey());

	}

}

package Mp3Reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class CreateCategory {

	public static void main(String[] args) {
		
		System.out.println("Directory: ");
		Scanner sc = new Scanner(System.in);
		String dirPath = sc.nextLine();
		System.out.println("Property tag: ");
		String propertyTag = sc.nextLine();
		File directory = new File(dirPath);
		
		try {
			DirectoryScanner ds = new DirectoryScanner(directory, "mp3");
			List<File> mp3Files = ds.getMP3Files();
			for (File file2 : mp3Files)
			{
//				System.out.println(file2.getAbsolutePath());
				String pt = MusicIDTag.getMusicData(file2, propertyTag);
				DirectoryCreator.creatNewDirectory(file2.getAbsoluteFile(), pt);
				FileMover.moveFile(file2, pt);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NotDirectoryException e) {
			e.printStackTrace();
		}
		
	}

}

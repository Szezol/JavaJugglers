package mp3Reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateCategory
{

	public static void main(String[] args)
	{
		List<String> propertyList = new ArrayList<String>();
		propertyList.add("title");
		propertyList.add("artist");
		propertyList.add("album");
		propertyList.add("year");
		propertyList.add("genre");
		System.out.println("Directory: ");
		Scanner sc = new Scanner(System.in);
		String dirPath = sc.nextLine();
		System.out.println("Choose a property: ");
		for (String string : propertyList)
		{
			System.out.println(string);
		}
		String propertyTag = sc.nextLine().toLowerCase();
		while (!propertyList.contains(propertyTag))
		{
			System.out.println("Invalid property! Choose from the given list.");
			for (String string : propertyList)
			{
				System.out.println(string);
			}
			propertyTag = sc.nextLine().toLowerCase();
		}
		File directory = new File(dirPath);

		try
		{
			DirectoryScanner ds = new DirectoryScanner(directory, "mp3");
			List<File> mp3Files = ds.getMP3Files();
			int firstlistSize = mp3Files.size();
			System.out.println(firstlistSize);
			for (File file2 : mp3Files)
			{
				String propertyValue = MusicIDTag.getMusicData(file2, propertyTag);
				DirectoryCreator.creatNewDirectory(file2.getAbsoluteFile(), propertyValue);
				FileMover.moveFile(file2, propertyValue);
			}
			DirectoryScanner ds2 = new DirectoryScanner(directory, "mp3");
			List<File> mp3FilesAfter = ds2.getMP3Files();
			int lastlistSize = firstlistSize - mp3FilesAfter.size();
			System.out.println("Files moved: " + lastlistSize);
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (NotDirectoryException e)
		{
			e.printStackTrace();
		}
	}
}

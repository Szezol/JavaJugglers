package client;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class FileMover
{
	public static void moveFileToFolder(HashMap<String, ArrayList<File>> inputMap)
	{
		for (Entry<String, ArrayList<File>> entry : inputMap.entrySet())
		{
			String newPathStub = entry.getKey() + "\\";
			ArrayList<File> listOfFiles = entry.getValue();

			for (File file : listOfFiles)
			{
				String filePathString = newPathStub + file.getName();
				File filePath = new File(filePathString);
				if (file != filePath)
				{
					file.delete();
				} else
				{
					boolean success = file.renameTo(filePath);
				}

				System.out.println(filePath);
			}

		}

	}

	public static void main(String[] args)
	{

		HashMap<String, ArrayList<File>> hashmapDemo = new HashMap<>();
		hashmapDemo.put("Rock", new ArrayList<File>(Arrays.asList(new File("rock1.mp3"), new File("rock2.mp3"))));
		hashmapDemo.put("Swing", new ArrayList<File>(Arrays.asList(new File("swing1.mp3"), new File("swing2.mp3"))));
		hashmapDemo.put("Pop", new ArrayList<File>(Arrays.asList(new File("pop1.mp3"), new File("pop2.mp3"))));
		hashmapDemo.put("Jazz", new ArrayList<File>(Arrays.asList(new File("jazz1.mp3"), new File("jazz2.mp3"))));

		moveFileToFolder(hashmapDemo);

	}
}
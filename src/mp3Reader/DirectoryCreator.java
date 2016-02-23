package mp3Reader;

import java.io.File;

public class DirectoryCreator
{
	public static void creatNewDirectory(File file, String newDirectory)

	{
		String directoryOfFile = file.getAbsolutePath();
		directoryOfFile = directoryOfFile.substring(0, directoryOfFile.length() - file.getName().length());

		directoryOfFile = directoryOfFile + "\\" + newDirectory;

		File newMappa = new File(directoryOfFile);
		if (!newMappa.exists())
		{
			System.out.println("creating directory: " + directoryOfFile);
			boolean result = false;

			try
			{
				newMappa.mkdir();
				result = true;
			} catch (SecurityException se)
			{
			}
			if (result)
			{
				System.out.println("DIR created");
			}
		}

	}
}
package Mp3Reader;

import java.io.File;

public class DirectoryCreator
{
	public static void creatNewDirectory(File file, String a) // as parameter we need a
														// File(mp3) and a
														// String(new Mappa
														// name)
	{
		String directoryOfFile = file.getAbsolutePath();
		directoryOfFile = directoryOfFile.substring(0, directoryOfFile.length() - file.getName().length());
//		System.out.println(directoryOfFile);

		directoryOfFile = directoryOfFile + "\\" + a; // create the new mappa
														// path

		File newMappa = new File(directoryOfFile); // create the new mappa
		if (!newMappa.exists()) // if it is not exist
		{
			System.out.println("creating directory: " + directoryOfFile);
			boolean result = false;

			try
			{
				newMappa.mkdir();
				result = true;
			} catch (SecurityException se)
			{
				// handle it
			}
			if (result)
			{
				System.out.println("DIR created");
			}
		}

	}
}
package mp3Reader;

import java.io.File;

public class FileMover
{
	public static void moveFile(File file, String newDirectory)
	{
		String fileName = file.getName();
		String NewPath = file.getAbsolutePath().substring(0, file.getAbsolutePath().length() - fileName.length());
		NewPath += newDirectory;
		NewPath += "\\";
		NewPath += fileName;
		File newspace = new File(NewPath);
		if (file != newspace)
		{
			file.delete();
		} else
		{
			boolean success = file.renameTo(newspace);
		}
	}
}
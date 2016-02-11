package Mp3Reader;

import java.io.File;

public class FileMover
{
	public static void moveFile(File file, String a)
	{
		String fileName = file.getName();
		String getNewPath = file.getAbsolutePath().substring(0, file.getAbsolutePath().length() - fileName.length());
		getNewPath += a;
		getNewPath += "\\";
		getNewPath += fileName;

		File newspace = new File(getNewPath);
		
		boolean success = file.renameTo(newspace);
			
//		System.out.println("File moved: " + success);
//		System.out.println(file.getAbsolutePath());
		

	}
}
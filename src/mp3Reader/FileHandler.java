package mp3Reader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FileHandler implements IMP3FileArranger
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		try
		{
			ServerSocket serverSocket = new ServerSocket(1234);
			Socket socket = serverSocket.accept();
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			int i;
			while ((i = ois.read()) > -1)
			{
				try
				{
					Object object = ois.readObject();
					if (object instanceof Id3PropertyTags)
					{
						int j;
						while ((j = ois.read()) > -1)
						{
							Object object2 = ois.readObject();
							if (object2 instanceof HashMap<?, ?>)
							{
								FileHandler filehandler = new FileHandler();
								HashMap<String, List<File>> returnList = new HashMap<>();
								returnList = filehandler.arranger((HashMap<File, ID3Tag>) object2,
										(Id3PropertyTags) object);
								oos.writeObject(returnList);
							}
							break;
						}
					}
				} catch (ClassNotFoundException e)
				{
					e.printStackTrace();
				}

			}
			oos.close();
			os.close();
			ois.close();

		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public HashMap<String, List<File>> arranger(HashMap<File, ID3Tag> filesWithTags, Id3PropertyTags id3PropertyTag)
	{
		HashMap<String, List<File>> filesNewPathList = new HashMap<>();
		for (File file : filesWithTags.keySet())
		{
			ID3Tag id3Tag = filesWithTags.get(file);
			String propertyValue = MusicIDTag.getMusicData(id3Tag, id3PropertyTag);
			if (!filesNewPathList.containsKey(propertyValue))
			{
				List<File> fileList = new ArrayList<>();

				filesNewPathList.put(propertyValue, fileList);
			}
			List<File> fileList = filesNewPathList.get(propertyValue);
			fileList.add(file);

		}

		return filesNewPathList;
	}

}

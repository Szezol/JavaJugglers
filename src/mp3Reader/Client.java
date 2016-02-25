package mp3Reader;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;

public class Client {

	static String host;
	static int port;
	static Socket socket;
	static ObjectOutputStream oos;
	static ObjectInputStream ois;

	public static void send(ObjectOutputStream oos, Object object) throws IOException {
		oos.write(0);
		oos.writeObject(object);
	}

	public static void setHostAndPort(String string, int i) {
		Client.host = string;
		Client.port = i;
		try {
			Client.socket = new Socket(host, port);
			Client.oos = new ObjectOutputStream(socket.getOutputStream());
			Client.ois = new ObjectInputStream(socket.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static class CategoryHelper {
		HashMap<File, ID3Tag> filesWithTags;
		Id3PropertyTags id3tag;

		public CategoryHelper(HashMap<File, ID3Tag> filesWithTags, Id3PropertyTags id3tag) {
			this.filesWithTags = filesWithTags;
			this.id3tag = id3tag;
		}

	}

	public static void main(String[] args) throws UnknownHostException, IOException {

		String javatatlanKezekHost = "192.168.0.1";
		int javatatlanKezekPort = 1234;

		Commands command = Commands.CATEGORYBYTAG;
		// Object objectToSend = CategoryHelper.vmi();

		if (command.equals(Commands.CATEGORYBYTAG)) {
			Client.setHostAndPort("localhost", 1234);
			HashMap<File, ID3Tag> categoryPathAndTag = new HashMap<>();
			File mp3 = new File("C:\\mp3\\Robin Schulz - Sugar (Radio Edit).mp3");
			categoryPathAndTag.put(mp3, ID3Tag.parse(mp3));
			CategoryHelper categoryObject = new CategoryHelper(categoryPathAndTag, Id3PropertyTags.TITLE);
			send(oos, categoryObject);
		}
		if (command.equals(Commands.SPLITMP3)) {
			Client.setHostAndPort(javatatlanKezekHost, javatatlanKezekPort);
			// send(oos, objectToSend);
		}
		if (command.equals(Commands.SORTBYTAG)) {
			Client.setHostAndPort(javatatlanKezekHost, javatatlanKezekPort);
			// send(oos, objectToSend);
		}

	}

}

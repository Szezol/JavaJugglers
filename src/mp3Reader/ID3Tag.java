package mp3Reader;

import java.io.File;
import java.io.RandomAccessFile;
import java.io.Serializable;

public class ID3Tag implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4336227151410315243L;
	private String title;
	private String artist;
	private String album;
	private String year;
	private String comment;
	private Genre genre;

	private ID3Tag() {
	}

	private static byte[] readXBytes(byte[] byteArray, int fromPos, int toPos) {
		byte[] resultArray = new byte[toPos - fromPos];
		for (int i = fromPos; i < toPos; i++) {
			resultArray[i - fromPos] = byteArray[i];
		}
		return resultArray;
	}

	public static ID3Tag parse(File file) {
		byte[] last128 = tail(file);
		byte[] baTitle = readXBytes(last128, 3, 33);
		byte[] baArtist = readXBytes(last128, 33, 63);
		byte[] baAlbum = readXBytes(last128, 63, 93);
		byte[] baYear = readXBytes(last128, 93, 97);
		byte[] baComment = readXBytes(last128, 97, 127);
		byte baGenre = last128[127];
		String title = new String(baTitle);
		String artist = new String(baArtist);
		String album = new String(baAlbum);
		String year = new String(baYear);
		String comment = new String(baComment);
		Genre genre = Genre.getGenreByByteId(baGenre);
		ID3Tag tag = new ID3Tag();
		tag.setTitle(title.toLowerCase());
		tag.setArtist(artist.toLowerCase());
		tag.setAlbum(album.toLowerCase());
		tag.setYear(year);
		tag.setComment(comment.toLowerCase());
		tag.setGenre(genre);
		return tag;
	}

	public static byte[] tail(File file) {
		try {
			RandomAccessFile fileHandler = new RandomAccessFile(file, "r");
			long fileLength = fileHandler.length() - 1;
			byte[] buffer = new byte[128];
			for (int i = 0; i < buffer.length; i++) {
				fileHandler.seek(fileLength - 127 + i);
				buffer[i] = fileHandler.readByte();
			}
			fileHandler.close();
			return buffer;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Genre getGenre() {
		return genre;
	}

	// @Override
	// public String toString() {
	// return title + artist + album + year + comment + genre;
	// }

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	// public static void main(String[] args)
	// {
	// ID3Tag tag = ID3Tag.parse(new File("C:\\mp3\\zene1.mp3"));
	// System.out.println(tag.getTitle());
	// System.out.println(tag.getAlbum());
	// System.out.println(tag.getArtist());
	// System.out.println(tag.getYear());
	// System.out.println(tag.getGenre());
	// System.out.println(tag.getComment());
	// }
}
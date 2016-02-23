package mp3Reader;

import java.io.File;

public class MusicIDTag {

	public static String getMusicData(File file, String id3Tag){

		ID3Tag tag = ID3Tag.parse(file);

		switch (id3Tag) {
		case "title":
			id3Tag = tag.getTitle();
			break;
		case "artist":
			id3Tag = tag.getArtist();
			break;
		case "album":
			id3Tag = tag.getAlbum();
			break;
		case "year":
			id3Tag = tag.getYear();
			break;
		case "comment":
			id3Tag = tag.getComment();
			break;
		case "genre":
			id3Tag = tag.getGenre().toString();
			break;
		default:
			System.out.println("Wrong property!");
			id3Tag = "";
			break;
		}
		return id3Tag.trim();
		
	}
}

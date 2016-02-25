package mp3Reader;

public class MusicIDTag
{

	public static String getMusicData(ID3Tag tag, Id3PropertyTags id3PropertyTag)
	{

		String id3Tag;

		switch (id3PropertyTag)
		{
			case TITLE:
				id3Tag = tag.getTitle();
				break;
			case ARTIST:
				id3Tag = tag.getArtist();
				break;
			case ALBUM:
				id3Tag = tag.getAlbum();
				break;
			case YEAR:
				id3Tag = tag.getYear();
				break;
			case COMMENT:
				id3Tag = tag.getComment();
				break;
			case GENRE:
				id3Tag = tag.getGenre().toString();
				break;
			default:
				id3Tag = "";
				break;
		}
		return id3Tag.trim();

	}
}

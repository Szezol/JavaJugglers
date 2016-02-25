package mp3Reader;

import java.io.File;
import java.util.HashMap;

public class test {
	public static void main(String[] args) {
		HashMap<File, ID3Tag> categoryPathAndTag = new HashMap<>();
		File mp3 = new File("C:\\mp3\\Robin Schulz - Sugar (Radio Edit).mp3");
		categoryPathAndTag.put(mp3, ID3Tag.parse(mp3));
		CategoryHelper categoryObject = new CategoryHelper(categoryPathAndTag, Id3PropertyTags.TITLE);
	}

	static class CategoryHelper {
		HashMap<File, ID3Tag> filesWithTags;
		Id3PropertyTags id3tag;

		public CategoryHelper(HashMap<File, ID3Tag> filesWithTags, Id3PropertyTags id3tag) {
			this.filesWithTags = filesWithTags;
			this.id3tag = id3tag;
		}
	}
}

package mp3Reader;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public interface IMP3FileArranger {
	HashMap<String, List<File>> arranger(HashMap<File, ID3Tag> filesWithTags, Id3PropertyTags id3Tag);
}

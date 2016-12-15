import java.io.File;
import java.util.LinkedList;

/**
 * @author weichih.c
 * 
 * This class can recursive traversal a specific directory,
 * and return a list of files in the directory.
 *
 */
public class FileTraversal {
	private LinkedList<File> fileList = new LinkedList<>();

	/**
	 * listing all files in the folder parameter.
	 * 
	 * @param folder
	 * @return LinkedList<file>
	 */
	public LinkedList<File> listFilesForFolder(final File folder) {
				
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {	// if file is directory than recursively trace again
	        	listFilesForFolder(fileEntry);
	        } else {
	        	fileList.add(fileEntry);	// if file not a directory than add into list
	        }
	    }
	    
	    return fileList;
	}

}

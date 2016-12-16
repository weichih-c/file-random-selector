import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

/**
 * @author weichih.c
 * 
 * Randomly select some files in the file list.
 *
 */
public class FilePickup {
	
	/**
	 * selecting some files, the amount of files is according the 'selectNum'.
	 * After selecting, files will be saved in destination path.
	 * 
	 * @param fileList Whole fileList in source directory
	 * @param destinationPath
	 * @param selectNum
	 */
	public void randomSelectFile(LinkedList<File> fileList, File destinationPath, int selectNum){
		
		// randomly select some number to become the index of fileList
		FileController fctrl = new FileController();
		int allFileListSize = fileList.size();
		int[] selectedIndex = randomGenerateNumber(allFileListSize, selectNum);
		
		// Copying file from origin path  to destination path
		// the index of fileList is randomly get
		for(int index : selectedIndex){
			File tempFile = fileList.get(index);
			String dirPath = destinationPath.getPath();
			fctrl.copyFile(tempFile.getAbsolutePath(), dirPath);
		}
	}
	
	/**
	 * generate some numbers by specific amount in maxSize.
	 * 
	 * @param maxSize max number of random
	 * @param selectNum
	 * @return
	 */
	private int[] randomGenerateNumber(int maxSize, int selectNum){
		int[] pickIndex = new int[selectNum];
		
		ArrayList<Integer> list = new ArrayList<Integer>();	// Generate a arrayList to using shuffle
		
		for(int a=0; a<maxSize; a++){	// initialize the list
			list.add(a);
		}
		
		shuffle(list);	// randomly swapping the elements in the list
		
		for(int a=0; a<selectNum; a++){		// select the segment of list with number param
			pickIndex[a] = list.get(a);
		}
		
		return pickIndex;	// return the random number array
		
	}
	
	/**
	 * shuffling the specific list.
	 * 
	 * can be replaced with built-in method - Collections.shuffle()
	 * 
	 * @param list
	 */
	private void shuffle( ArrayList<Integer> list ){
		int size = list.size();
		
		Random random = new Random();
		for(int i=0; i<size; i++){
			int randIndex = random.nextInt(size);
			Collections.swap(list, i, randIndex);	// swap two elements in list
			
//			exchange(list, i, randIndex);	// using the faster built-in method - Collections.swap();
		}
	}
	
	/**
	 * exchanging two specific elements in the list.
	 * 
	 * can be replaced with built-in method - Collections.swap()
	 * 
	 * @param list
	 * @param first	first element be exchanged.
	 * @param second second element be exchanged.
	 */
	private static void exchange(ArrayList<Integer> list, int first, int second ){
		int temp = list.get(first);
		list.set(second, list.get(first));
		list.set(first, temp);
	}
	
}

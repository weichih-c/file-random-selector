import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;

public class FileController {
	
	/**
	 * 檢查檔案存不存在 存在就回傳該檔案 不存在回傳NULL
	 * 
	 * @param f 
	 * 			指定檔案
	 * @return
	 */
	public  String checkFileExist(File f) {
		if (f.exists()) {
			return f.getAbsolutePath();
		} else {
			System.out.println(f.getName() + " - 檔案不存在");
			return null;
		}
	}
	
	/**
	 * Copying File to a specific location
	 * 複製指定路徑的檔案到指定位置
	 * 
	 * @param oldPath
	 *            要複製的檔案的位置
	 * @param newPath
	 *            要貼上的新位置
	 */
	public boolean copyFile(String oldPath, String newPath) {
		try {
			int byteread = 0;
			File processFile = new File(oldPath);
			if (processFile.exists()) { // 檔存在時

				newPath = newPath + "/" + processFile.getName(); // 新的檔案存放位置為資料夾目錄加上檔名(含副檔名)

				InputStream inStream = new FileInputStream(oldPath);// 讀入原檔
				OutputStream outStream = new FileOutputStream(newPath);
				byte[] buffer = new byte[1024];
				while ((byteread = inStream.read(buffer)) != -1) {
					outStream.write(buffer, 0, byteread);
				}
				inStream.close();
				outStream.close();
			} else {
				throw new Exception();
				// System.out.println("查無此檔:" + processFile.getName());
			}
		} catch (Exception e) {
			System.out.println("複製單個檔操作出錯");
			System.out.println("ERROR:" + e.getMessage());
			return false;
		}

		return true;
	}
	
	
	/**
	 * 刪除檔案
	 * @param target 要刪除的檔案或資料夾
	 */
	public void removeFile(File target){	
		// 如果是資料夾，先把資料夾內容刪光再刪除資料夾本身
		if(target.isDirectory()){
			FileTraversal ft = new FileTraversal();
			LinkedList<File> list = ft.listFilesForFolder(target);
			for(File f : list){
				removeFile(f);
			}
		}
		
		target.delete();	// 刪除資料夾或檔案

	}


}

package kz.bee.bip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

public class Utils {
    public static byte[] method(File file) throws IOException
    {
        // Creating an object of FileInputStream to
        // read from a file
        FileInputStream fl = new FileInputStream(file);
        // Now creating byte array of same length as file
        byte[] arr = new byte[(int)file.length()];
        // Reading file content to byte array
        // using standard read() method
        fl.read(arr);
        // lastly closing an instance of file input stream
        // to avoid memory leakage
        fl.close();
        // Returning above byte array
        return arr;
    }
    public static String encoder(String filePath) {
        String base64File = "";
        File file = new File(filePath);
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            byte fileData[] = new byte[(int) file.length()];
            fileInputStream.read(fileData);
            base64File = Base64.getEncoder().encodeToString(fileData);
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading the File " + ioe);
        }
        return base64File;
    }

}

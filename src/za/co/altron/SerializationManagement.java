package za.co.altron;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Administrator
 */
public class SerializationManagement {
	static String fileFormat = "C:\\Serialized\\%1$s.dat";

	public void serialize(String dataIdentifier, Object dataObject) throws FileNotFoundException, IOException {
		FileOutputStream file = null;
		ObjectOutputStream out = null;
		try {
			file = new FileOutputStream(String.format(fileFormat, dataIdentifier));
			out = new ObjectOutputStream(file);
			out.writeObject(dataObject);
		} catch (FileNotFoundException ex) {
			System.out.println("FileNotFoundException");
		} catch (IOException io) {
			System.out.println("IOException");
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	public Object deserialize(String dataIdentifier) throws FileNotFoundException, IOException, ClassNotFoundException {
		FileInputStream file = null;
		ObjectInputStream in = null;
		try {
			file = new FileInputStream(String.format(fileFormat, dataIdentifier));
			in = new ObjectInputStream(file);
			return in.readObject();
		} catch (FileNotFoundException ex) {
			System.out.println("FileNotFoundException");
		} catch (IOException io) {
			System.out.println("IOException");
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return null;

	}
}


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FileDownload {
	
	public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
					Comparator<K> valueComparator = new Comparator<K>() {
						public int compare(K k1, K k2) {
						int compare = map.get(k2).compareTo(map.get(k1));
						if (compare == 0) 
							return 1;
						else 
							return compare;
						}
					};
			
			
				Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
				sortedByValues.putAll(map);
				return sortedByValues;
	}
	public static void main(String[] args) {

		try {
			//to download file from the server url --------------------------------------------------------------
//			URL url = new URL("https://www.w3.org/TR/PNG/iso_8859-1.txt");
//
//			ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
//
//			FileOutputStream fileOutputStream = new FileOutputStream("E:/TestFile.txt");
//
//			fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);

			// To read from the downloaded file in the system----------------------------------------------------
			Scanner sc = new Scanner(new File("E:/TestFile.txt"));

			//Storing the data in a arraylist -------------------------------------------------------------------
			ArrayList <String> inputList= new ArrayList<>();
			
			//ArrayList <String> score = new ArrayList<>();
			TreeMap<String,String> out=new TreeMap<>();
			TreeMap<String,String> notOut=new TreeMap<>();
			
			while(sc.hasNextLine()) {
				String input=sc.nextLine();
				String arr[]=(input.split("(?<=\\s\\S{1,100})\\s"));
				if(arr[1].matches("^[0-9]+$"))
					out.put(arr[0],arr[1]);
				else
					notOut.put(arr[0],arr[1].substring(0,arr[1].length()-1));
				
			}			

			Map highestOut = sortByValues(out);
			Map highestNotOut = sortByValues(notOut);
			
			System.out.println(highestOut);
			System.out.println(highestNotOut);
			
			
			

			//System.out.println("The player that is NOT OUT with highest score:"+highestNotOut.firstEntry());
			//System.out.println("The player that is OUT with highest score:"+highestOut.firstEntry());
			sc.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
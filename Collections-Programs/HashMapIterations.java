package collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapIterations {

	public static <V, K> void main(String[] args) {
		// creating a HashMap
		Map<Integer, String> mp = new HashMap<Integer, String>();

		mp.put(101, "C");
		mp.put(102, "C++");
		mp.put(103, "JAVA");
		mp.put(104, "C#");
		
		// displaying the HashMap using lambda expression
		mp.forEach((k, v) -> System.out.println(k + " -> " + v));

		System.out.println("***********************************");

		/*
		 * displaying the HashMap using the iterator getting the entry set and calling
		 * iterator() on it assigning to reference itr of type Iterator
		 */
		Iterator<Entry<Integer, String>> itr = mp.entrySet().iterator();

		while (itr.hasNext()) {
			/*
			 * if used itr.next directly in printing then it will print next EntrySet so we
			 * are assigning every entry set to e reference of type Entry<>
			 */
			Entry<Integer, String> e = itr.next();

			// Modifying the value at key 104
			if (e.getKey().compareTo(104) == 0) {
				e.setValue("F#");
			}

			System.out.println(e.getKey() + " -> " + e.getValue());
		}

	}

}

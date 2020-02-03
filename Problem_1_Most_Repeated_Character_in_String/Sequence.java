import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Sequence {

	public static void main(String[] args) throws Exception {

		// Accepting the input.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputLine = br.readLine();

		// Using counter to count the number of occurrences. Initializing it to 1
		// because we will start deleting from 2nd occurrence.
		int counter = 1;

		// Converting the input String to a sequence of characters ArrayList.
		ArrayList<Character> character = new ArrayList<Character>();
		for (char c : inputLine.toCharArray()) {
			character.add(c);
		}

		// Using Collections.sort to sort the characters in ascending order.
		Collections.sort(character);

		// Main logic--> Delete all the duplicate occurrences of the characters and keep
		// a count of it.
		ArrayList<Integer> maxOccurence = new ArrayList<>();
		for (int i = 0; i < character.size(); i++) {
			for (int j = i + 1; j < character.size(); j++) {
				if (character.get(i) == character.get(j)) {
					character.remove(j);
					j--;
					counter++;
				}
			}
			
			// Adding the counter value of a specific character to the new ArrayList i.e
			// maxOccurrence.
			maxOccurence.add(counter);

			// Reinitializing the counter.
			counter = 1;
		}

		// Printing the list of characters (all the duplicates removed).
		for (Character c : character) {
			System.out.print(c + "  ");
		}
		System.out.println("");

		// Printing the occurrences of all the characters.
		for (Integer number : maxOccurence) {
			System.out.print(number + "  ");
		}
		System.out.println("");

		// Finding the index of maximum occurred character.
		int index = maxOccurence.indexOf(Collections.max(maxOccurence));
		System.out.println("Maximum occurred character is : " + character.get(index));
	}
}

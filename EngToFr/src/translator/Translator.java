package translator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * A simple, bidirectional English-French dictionary.
 * This program demonstrates the logic of translation using HashMaps
 * for quick lookups.
 */
public class Translator {

    // We need two maps for bidirectional lookup.
    // One for English -> French
    private static final Map<String, String> englishToFrench = new HashMap<>();
    // One for French -> English
    private static final Map<String, String> frenchToEnglish = new HashMap<>();

    /**
     * Initializes the dictionaries with some sample words.
     */
    public static void initializeDictionaries() {
        // Add word pairs. We must add each pair to BOTH maps.

        // Pair 1
        englishToFrench.put("hello", "bonjour");
        frenchToEnglish.put("bonjour", "hello");

        // Pair 2
        englishToFrench.put("goodbye", "au revoir");
        frenchToEnglish.put("au revoir", "goodbye");

        // Pair 3
        englishToFrench.put("cat", "chat");
        frenchToEnglish.put("chat", "cat");

        // Pair 4
        englishToFrench.put("dog", "chien");
        frenchToEnglish.put("chien", "dog");

        // Pair 5
        englishToFrench.put("water", "eau");
        frenchToEnglish.put("eau", "water");

        // Pair 6
        englishToFrench.put("yes", "oui");
        frenchToEnglish.put("oui", "yes");

        // Pair 7
        englishToFrench.put("no", "non");
        frenchToEnglish.put("non", "no");

        // Pair 8
        englishToFrench.put("please", "s'il vous plaît");
        frenchToEnglish.put("s'il vous plaît", "please");

        // Pair 9
        englishToFrench.put("thank you", "merci");
        frenchToEnglish.put("merci", "thank you");
    }

    public static void main(String[] args) {
        // Load our sample words into the dictionaries
        initializeDictionaries();

        // Set up a scanner to read user input from the console
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Simple English/French Translator ===");
        System.out.println("Enter a word in English or French. Type 'exit' to quit.");
        System.out.println("==========================================");

        // Start an infinite loop to continuously ask for input
        while (true) {
            System.out.print("\nEnter a word: ");
            String input = scanner.nextLine();

            // Normalize the input to lowercase and remove whitespace
            // This makes our lookup case-insensitive
            String word = input.trim().toLowerCase();

            // Check if the user wants to quit
            if (word.equals("exit")) {
                break; // Exit the while loop
            }

            // --- Translation Logic ---
            
            // 1. Check if the word is in the English dictionary
            if (englishToFrench.containsKey(word)) {
                String translation = englishToFrench.get(word);
                System.out.println("Language: English");
                System.out.println("Translation (French): " + translation);
            } 
            // 2. If not, check if the word is in the French dictionary
            else if (frenchToEnglish.containsKey(word)) {
                String translation = frenchToEnglish.get(word);
                System.out.println("Language: French");
                System.out.println("Translation (English): " + translation);
            } 
            // 3. If it's in neither, we don't know the word
            else {
                System.out.println("Sorry, '" + input + "' is not in our dictionary.");
            }
        }

        // Close the scanner and say goodbye
        scanner.close();
        System.out.println("\nGoodbye! Au revoir!");
    }
}

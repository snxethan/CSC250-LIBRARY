package NEU.ET39.CSC250.Algorithms;

import java.util.*;

public class Isomorphs {

    /**
     * Exact Isomorphs is the same letter pattern.
     * ex: 'egg' & 'add' are both 0 1 1, the same pattern,
     * however, gag is 0 1 0, therefore not the same as egg or add.
     * @param arr The array of random chars/words that should result in the pattern
     * @return a giant string of the organized isomorphs
     */
    public static String exactIsomorphs(String[] arr) {
        // Create a Stringbuilder to hold the output
        StringBuilder isomorphsString = new StringBuilder(); // O(1)
        // use a hashmap to hold patterns and the list of words associated. HashMap<String, List<String>;
        HashMap<String,List<String>> exactIsomorphMap = new HashMap<>(); // O(1)
        // loop through the string array
        for (String s : arr) {  // O(n)
            // use a temporary string to hold the pattern for the word
            // use a temporary counter to hold the number for the character
            int counter = 0; // O(1)
            // use a 2nd hashmap to hold the numbers assigned to characters. HashMap<Character, Integer>;
            HashMap<Character, Integer> characterCodes = new HashMap<>(); // O(1)

            // loop through each character of the string
            List<Integer> pattern = new ArrayList<>(); // O(1)

            for (Character c : s.toCharArray()) { // O(n) = O(n^2)
                // assign numbers (starting from 0) to each individual character. Capitals should have different number from their noncapital counterpart
                // add to counter when a new unique letter has been found in the string

                // if the letter does not exist already in the hashmap
                if(!characterCodes.containsKey(c)) { // O(1)
                    // add the character to the hashmap
                    characterCodes.put(c, counter);
                    // update the counter
                    counter++; // O(1)
                }
                pattern.add(characterCodes.get(c)); // O(1)
            }


            // when reach end of loop, check if code exists in 1st hashmap
            // add the code as a new key and add word to the arraylist in the hashmap if code does not exist
            if(!exactIsomorphMap.containsKey(pattern.toString())) { // O(1)
                List<String> list = new ArrayList<>(); // O(1)
                list.add(s);  // O(1)
                exactIsomorphMap.put(pattern.toString(), list);  // O(1)
            } else {
                // else, add the word to the arraylist in the hashmap
                exactIsomorphMap.get(pattern.toString()).add(s);  // O(1)
            }
        }
        // after 1st loop, each word in array should be assigned to a code alongside a list of other words
        isomorphsString.append(checkIsomorphs("EXACT ISOMORPHS",exactIsomorphMap));  // O(1)
        isomorphsString.append(checkNoIsomorphs(exactIsomorphMap)); // O(1)


        // return a combined string of both exactIsoMorphs and nonIsomorphs
        return isomorphsString.toString();
    }
    // Big O Complexity:
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)


    /**
     * Check the amount of times the letter in a word appears, sorted from smallest to biggest
     * ex: ate = 111, a appears once, t appears once, etc.
     * ex: look = 112, l appears once, k appears once, o appears twice.
     * @param arr the array of random chars/words
     * @return a giant string of organized loose isomorps, with a given index for each given unique letter, then sorted.
     */
    public static String looseIsomorphs(String[] arr) {
        //Create a Stringbuilder to hold the output
        StringBuilder isomorphsString = new StringBuilder(); // O(1)
        // use a hashmap to hold patterns and the list of words associated. HashMap<String, List<String>;
        HashMap<String,List<String>> exactIsomorphMap = new HashMap<>();
        // loop through the string array
        // use a hashmap to hold patterns and the list of words associated. HashMap<String, List<String>;
        // loop through each character of the string
        for (String s : arr) {
            // use a temporary string to hold the pattern for the word
            StringBuilder pattern = new StringBuilder();
            // use a 2nd hashmap to hold the numbers assigned to characters. HashMap<Character, Integer>;
            HashMap<Character, Integer> characterCodes = new HashMap<>();

            // loop through each character of the string
            for (Character c : s.toCharArray()) {
                // assign a number to a character the amount of times it appears in the string.

                // if the letter does not exist already in the hashmap
                if(!characterCodes.containsKey(c)) {
                    // add the character to the hashmap
                    characterCodes.put(c, 1);
                } else {
                    characterCodes.put(c, characterCodes.get(c) + 1);
                }
            }

            // sort the patterns
            // GENERATED & ASSISTED BY CHATGPT: ----------------
            List<Integer> freqList = new ArrayList<>(characterCodes.values());
            Collections.sort(freqList);
            pattern = new StringBuilder(freqList.toString()); // e.g., "[1, 2]"
            // ----------------

            // when reach end of loop, check if code exists in 1st hashmap
            // add the code as a new key and add word to the arraylist in the hashmap if code does not exist
            if(!exactIsomorphMap.containsKey(pattern.toString())) {
                List<String> list = new ArrayList<>();
                list.add(s);
                exactIsomorphMap.put(pattern.toString(), list);
            } else {
                // else, add the word to the arraylist in the hashmap
                exactIsomorphMap.get(pattern.toString()).add(s);
            }
        }
        // after 1st loop, each word in array should be assigned to a code alongside a list of other words
        isomorphsString.append(checkIsomorphs("LOOSE ISOMORPHS",exactIsomorphMap));
        isomorphsString.append(checkNoIsomorphs(exactIsomorphMap));


        // return a combined string of both exactIsoMorphs and nonIsomorphs
        return isomorphsString.toString();
    }

    /**
     * Check a hashmap and see if there are no repeating keys/values
     * if it is not a repeating key/value then it is not an isomorph.
     * @param isomorphMap the hashmap you want to check to display
     * @return the string of non isomorphs.
     */
    public static String checkNoIsomorphs(HashMap<String,List<String>> isomorphMap) {
        StringBuilder nonIsomorphsString = new StringBuilder();
        nonIsomorphsString.append("\nNON ISOMORPHS: \n");
        for (Map.Entry<String, List<String>> entry : isomorphMap.entrySet()) {
            List<String> group = entry.getValue();

            if (group.size() == 1) {
                nonIsomorphsString.append(group.get(0)).append(" ");
            }
        }
        return nonIsomorphsString.toString();
    }

    /**
     * Check a hashmap and see if there are any repeating keys/values
     * if there are repeating key/values, it is an isomorph
     * @param title The title before notating which isomorph you are checking
     * @param isomorphMap the hashmap you want to check to display
     * @return a sorted string of isomorphs
     */
    public static String checkIsomorphs(String title, HashMap<String, List<String>> isomorphMap) {
        StringBuilder exactIsomorphsString = new StringBuilder();
        exactIsomorphsString.append("\n" + title + ": \n");

        // Sort the keys (which are strings like "[0, 1, 0]", "[0, 1, 1]", etc.)
        List<String> sortedKeys = new ArrayList<>(isomorphMap.keySet());
        Collections.sort(sortedKeys); // Alphabetical sort works fine for this pattern format

        // Loop through the sorted keys instead of entrySet()
        for (String pattern : sortedKeys) {
            List<String> group = isomorphMap.get(pattern);
            if (group.size() > 1) {
                exactIsomorphsString.append(pattern).append(": ");
                for (String word : group) {
                    exactIsomorphsString.append(word).append(" ");
                }
                exactIsomorphsString.append("\n");
            }
        }

        return exactIsomorphsString.toString();
    }




}

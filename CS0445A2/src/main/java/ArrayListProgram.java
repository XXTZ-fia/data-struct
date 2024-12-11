
/**
 * A vector of Strings program
 */
import java.util.ArrayList;

public class ArrayListProgram {

    public static void main(String args[]) {
        // Initialization of ArrayList, holding String objects
        ArrayList<String> words = new ArrayList<>();

        words.add("I");
        words.add("am");
        words.add("the");
        words.add("eggman");
        // The three operations
        // Operation 1
        words.add("We are the eggmen");
        // Operation 2
        words.add(3, "middle");
        // Operation 3
        words.remove(2);
        System.out.println(words);
    }
}

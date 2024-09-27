import java.util.*;
public class Main {


    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String why) {

        Stack<Character> stack = new Stack<>();
        for (char c : why.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;

            }

        }
        return stack.isEmpty();
    }

    // 2. reverseInteger
    public static String reverseInteger(int dumb) {
        int reversednum = 0;
        while (dumb != 0) {
            reversednum = reversednum * 10 + dumb % 10;
            dumb = dumb / 10;
        }
        return new String(String.valueOf(reversednum));
    }

    // 3. encryptThis
    public static String encryptThis(String text) {
        // Stack<Character> stack = new Stack<>();
        //  stack.pop();
        // hell no
        String[] words = text.split(" ");
        String encryptedText = "";

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char firstChar = word.charAt(0);
            int asciiValue = (int) firstChar;

            if (word.length() > 2) {
                char secondChar = word.charAt(1);
                char lastChar = word.charAt(word.length() - 1);
                String middleChars = word.substring(2, word.length() - 1);

                encryptedText = encryptedText + asciiValue + lastChar + middleChars + secondChar + " ";
            } else if (word.length() == 2) {
                char secondChar = word.charAt(1);
                encryptedText = encryptedText + asciiValue + secondChar + " ";
            } else {
                encryptedText = encryptedText + asciiValue + " ";
            }
        }
        return encryptedText.trim();
    }

    // 4. decipherThis // i give up on this one
    public static String decipherThis(String message) {
        String result = "";
        String[] words = message.split(" ");

        for (String word : words) {

            int spaceIndex = 0;
            while (spaceIndex < word.length() && Character.isDigit(word.charAt(spaceIndex))) {
                spaceIndex++;
            }
            int charCode = Integer.parseInt(word.substring(0, spaceIndex));
            char firstChar = (char) charCode;
            String decodedWord = firstChar + "";


            if (spaceIndex < word.length()) {
                String rest = word.substring(spaceIndex);
                if (rest.length() > 1) {

                    char secondChar = rest.charAt(1);
                    char lastChar = rest.charAt(rest.length() - 1);
                    decodedWord += secondChar;
                    decodedWord += rest.substring(2, rest.length() - 1);
                    decodedWord += lastChar;
                } else if (rest.length() == 1) {
                    decodedWord += rest.charAt(0);
                }
            }

            result += decodedWord + " ";
        }

        return result.trim();
    }

}
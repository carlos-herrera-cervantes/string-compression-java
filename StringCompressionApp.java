import java.util.Scanner;

class StringCompressionApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("THIS IS A PROGRAM THAT TAKES A STRING AND PRINTS THE COMPRESSION");
        System.out.print("Enter a string: ");
        
        String enteredString = scanner.nextLine();
        scanner.close();
        String compressedString = compress(enteredString);

        System.out.println("The compressed string is: " + compressedString);
    }

    /**
     * Returns a compression for the entered string
     * @param str String object
     * @return Compressed string
     */
    private static String compress(String str) {
        int finalLength = countCompression(str);
        if (finalLength >= str.length()) return str;

        StringBuilder compressed = new StringBuilder(finalLength);
        int countConsecutive = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }

        return compressed.toString();
    }

    /**
     * Returns the total of characters for the compressed string
     * @param str String object
     * @return Total of characters for compressed string
     */
    private static int countCompression(String str) {
        int compressedLength = 0;
        int countConsecutive = 0;

        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedLength += 1 + String.valueOf(countConsecutive).length();
                countConsecutive = 0;
            }
        }

        return compressedLength;
    }
}
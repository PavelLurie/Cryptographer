package CaesarСipher.Option1;
public class Cryptographer {
    public String encryptedString(String alphabet, String message, int key) {
        char[] chars = message.toCharArray();
        StringBuilder result = new StringBuilder();;
        for (char aChar : chars) {
            int index = alphabet.indexOf(aChar);
            int newIndex = (index + key) % alphabet.length();
            if (newIndex >= 0) {
                char temp = alphabet.charAt(newIndex);
                result.append(temp);
            }else {
                char temp = alphabet.charAt(newIndex + alphabet.length());
                result.append(temp);
            }
        }
        return result.toString();
    }
    public String decrypt(String alphabet, String message, int key) {
        return encryptedString(alphabet, message, key * (-1));
    }
}
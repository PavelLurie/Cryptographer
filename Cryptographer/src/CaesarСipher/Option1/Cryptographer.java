package CaesarСipher.Option1;

public class Cryptographer {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "абвгдеёжзийклмнопрстуфхцчшщъыьэюя" + "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ" +
            ".,\":!? +-*/\\@#$%^&(){}[];'|`~=_©«»—" + "0123456789";



    public int alphabetLength() {
        return ALPHABET.length();
    }

    public String getAlphabet(){
        return ALPHABET;
    }

    public String encryptedString(String alphabet, String message, int key) {
        char[] chars = message.toCharArray();
        StringBuilder result = new StringBuilder();
        ;
        for (char aChar : chars) {
            int index = alphabet.indexOf(aChar);

            if (index >= 0) {
                int newIndex = (index + key) % alphabet.length();
                char charAt = newIndex >= 0 ? alphabet.charAt(newIndex) : alphabet.charAt(newIndex + alphabet.length());
                result.append(charAt);
            }

        }
        return result.toString();
    }

    public String decrypt(String alphabet, String message, int key) {
        return encryptedString(alphabet, message, key * (-1));
    }
}
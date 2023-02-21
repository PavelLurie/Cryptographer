package CaesarСipher.Option1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class EnglishAlphabet {
    public Path englishAlphabet() throws IOException {
        File enAlphabet = new File("D:\\Russian alphabet.txt\\");
        String line = ".,\":-!? ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        Path path1 = Path.of("D:\\English alphabet.txt\\");
        Files.writeString(path1, line);
        return path1;
    }




}

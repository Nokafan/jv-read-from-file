package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>Дано файл, потрібно прочитати його вміст і вибрати всі слова що починаються на `w`.
 * Результат повернути у вигляді відсортованого масиву (за замовчуванням). Всі слова повинні
 * бути в нижньому регістрі. У випадку якщо таких слів не знайдено повернути пустий масив.
 * Приклад: Width world Wide web
 * Результат: web wide width world</p>
 */
public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> inputLines = new ArrayList<>();
        String[] resultArray = new String[]{};

        try {
            inputLines = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            return resultArray;
        }

        List<String> resultWords = new ArrayList<>();

        for (String string : inputLines) {
            string = string.toLowerCase();
//            System.out.println(string);
            string = string.replaceAll("[^a-z] | (\\.)", " ");
//            string = string.replaceAll(" ", ".");
            System.out.println(string);

//            List<String> tempList = Arrays.asList(string.split(" "));

            String[] arrayWords = string.split("\\s");

            for (String oneWord : arrayWords) {
                System.out.println(oneWord);
                if (oneWord.charAt(0) == 'w') {
                    resultWords.add(oneWord);
                }
            }

        }
        Collections.sort(resultWords);
        return resultWords.toArray(resultArray);
    }
}

package Attestation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

public class TestHelper {

    private static final Random random = new Random();


    private TestHelper() {
    }

    public static int RandomNumber() {
        return generateRandomNumber();
    }

    public static long RandomLongNumber() {
        return generateRandomLongNumber();
    }

    public static String generateRandomString() {
        return generateRandomWord() + " " +
                generateRandomWord() + " " +
                generateRandomWord();
    }

    public static HashMap<String, String> doHashMapFromString(String path) {
        File file = new File(path);
        List<String> list = new ArrayList<>();
        try (FileReader fileReader = new FileReader(file);
             BufferedReader reader = new BufferedReader(fileReader)) {
            String line = reader.readLine();
            while (line != null) {
                list.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listStringsToHashMap(list);
    }

    public static String convertDateFormat() {
        Date currentDate = new Date();
        return dateNewFormat(currentDate);
    }

    public static Double stringParseDouble(String string) {
        return stringParsToDouble(string);
    }

    private static int generateRandomNumber() {
        return random.nextInt(1970,
                LocalDateTime.now().getYear() + 1);
    }

    private static long generateRandomLongNumber() {
        return random.nextLong();
    }

    private static String generateRandomWord() {
        int length = random.nextInt(1, 11);
        String result = generateRandomLetter().toUpperCase();
        StringBuilder builder = new StringBuilder(result);

        for (int i = 1; i < length + 1; i++) {
            builder.append(generateRandomLetter());
        }
        return builder.toString();
    }

    private static String generateRandomLetter() {
        char[] result = new char[1];
        result[0] = (char) random.nextInt(97, 123);
        return String.copyValueOf(result);
    }

    private static HashMap<String, String> listStringsToHashMap(List<String> strings) {
        HashMap<String, String> hashMap = new HashMap<>();
        strings.forEach(s -> {
            String[] word = s.split("::");
            hashMap.put(word[0], word[1]);
        });
        return hashMap;
    }

    private static String dateNewFormat(Date currentDate) {
        SimpleDateFormat dateFormat;
        dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        return dateFormat.format(currentDate);
    }

    private static Double stringParsToDouble(String str) {
        double result;
        try {
            result = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            result = Double.POSITIVE_INFINITY;
        }
        return result;
    }
}

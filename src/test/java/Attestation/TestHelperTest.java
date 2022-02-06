package Attestation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

class TestHelperTest {


    @Test
    void generateRandomNumber() {
        int rndNumber = TestHelper.RandomNumber();
        Assertions.assertTrue(rndNumber >= 1970);
        Assertions.assertTrue(rndNumber <= LocalDateTime.now().getYear());
        int rndNumber2 = TestHelper.RandomNumber();
        Assertions.assertNotEquals(rndNumber, rndNumber2);
    }

    @Test
    void generateRandomLongNumber() {
        long rndNumber1 = TestHelper.RandomLongNumber();
        long rndNumber2 = TestHelper.RandomLongNumber();
        Assertions.assertNotEquals(rndNumber1, rndNumber2);
    }

    @Test
    void generateRandomString() {
        String rndString1 = TestHelper.generateRandomString();
        String rndString2 = TestHelper.generateRandomString();
        Assertions.assertNotEquals(rndString1, rndString2);
    }

    @Test
    void doHashMapFromString() {
        String key = "Vladimir";
        String value = "Mayakovskiy";
        HashMap<String, String> hashMap = TestHelper.doHashMapFromString("./test.txt");
        Assertions.assertEquals(value, hashMap.get(key));
    }

    @Test
    void convertDateFormat() {
        Date date = new Date();
        SimpleDateFormat newDate;
        newDate = new SimpleDateFormat("dd MMMM yyyy");
        String result = newDate.format(date);
        Assertions.assertEquals(result, TestHelper.convertDateFormat());
    }

    @Test
    void stringParseDouble() {
        String string = "not double!";
        Double result = Double.POSITIVE_INFINITY;
        Assertions.assertEquals(result, TestHelper.stringParseDouble(string));
    }
}
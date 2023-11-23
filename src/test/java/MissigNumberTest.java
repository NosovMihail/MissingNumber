import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class MissigNumberTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/CSVTest/MissingNumberTestHappyPath.csv", delimiterString = ";")
    void testFindMissingNumberInArrayHappyPath(String input, int expected) {
        Assertions.assertEquals(expected, new MissingNumber().findMissingNumberInArray(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/CSVTest/MissingNumberTestNullCheck.csv", delimiterString = ";")
    void testFindMissingNumberInArrayNullCheck(String input) {
        Assertions.assertNull(new MissingNumber().findMissingNumberInArray(input));
    }

    @Test
    void testFindMissingNumberInArrayEmpty() {
        Assertions.assertNull(new MissingNumber().findMissingNumberInArray(new Integer[0]));
    }

}

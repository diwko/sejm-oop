package sejm;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class URLReaderTest {
    private String testURL = "file:///" + System.getProperty("user.dir") + "/src/test/resources/loadTest.txt";

    @Test
    public void loadURL() throws Exception {
        assertEquals("123", URLReader.loadURL(testURL));
    }

    @Test
    public void runAndToString(){
        URLReader testReader = new URLReader(testURL);
        testReader.run();

        assertEquals("123", testReader.toString());
    }

}
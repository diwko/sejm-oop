package sejm;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;

public class URLReader extends Thread {
    private String url;
    private String content = null;

    public URLReader(String url) {
        this.url = url;
    }

    public static String loadURL(String url) throws IOException {
        return IOUtils.toString(new URL(url), "UTF-8");
    }

    @Override
    public String toString() {
        return content;
    }

    @Override
    public void run() {
        try {
            content = loadURL(url);
        } catch (IOException e) {
            System.out.println("URL loading problem: " + url);
        }
    }
}

package task14;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/task14/file.txt"))) {

            String line;
            int count = 0;

            while ((line = bufferedReader.readLine()) != null) {
                count += line.split(" ").length;
            }

            System.out.println(count);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}

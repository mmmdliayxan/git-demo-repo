package logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {

    public static void log(String mesage) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ayxan.txt", true))) {

            writer.write(LocalDateTime.now() + " " + mesage + "\n");

        }

    }
}

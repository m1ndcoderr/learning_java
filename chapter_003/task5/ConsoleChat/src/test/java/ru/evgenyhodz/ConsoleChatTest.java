package ru.evgenyhodz;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by alittlem1nd on 30.11.2016.
 */
public class ConsoleChatTest {
    /**
     * Создание файла с ответами чата.
     */
    private File file = null;
    /**
     * Создание файла ввода пользователя.
     */
    private File userInput = null;
    /**
     * Файл-лог, который создается после завершения чата.
     */
    private File log = null;

    /**
     * Создание файлов с ответами для теста.
     *
     * @throws IOException - - I/O exception.
     */
    @Before
    public void createFiles() throws IOException {
        try {
            file = File.createTempFile("Случайные ответы чата", ".txt");
            userInput = File.createTempFile("Ввод пользователя", ".txt");
            BufferedWriter stWriter = new BufferedWriter(new FileWriter(userInput));
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write("Случайный1 Случайный2 Случайный3 Случайный4 Случайный5");
            stWriter.write("Привет, чат!\r\nстоп\r\nпродолжить\r\nГовори, чат!\r\nзакончить");
            stWriter.close();
            bw.close();
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    /**
     * Создание ссылки с путем на файл лога.
     */
    @Before
    public void createReferenceToLog() {
        log = new File(String.format("%s%s%s", System.getProperty("user.dir"),
                File.separator, "\\chapter_003\\task5\\ConsoleChat\\src\\log.txt"));
    }

    /**
     * Тестирование работы консольного чата и получения лог-файла.
     *
     * @throws IOException - I/O exception.
     */
  // @Test
 //  public void whenRunChatWithUserInputThenGetFileLogTest() throws IOException {
   //    ConsoleChat consoleChat = new ConsoleChat();
   //    consoleChat.run(file, FileUtils.openInputStream(userInput));
//
 //  }
   //     try (InputStream in = FileUtils.openInputStream(userInput)) {
      //      ConsoleChat consoleChat = new ConsoleChat();
     //       consoleChat.run(file, in);
            //assert what?
     //   } catch (IOException x) {
      //      x.printStackTrace();
     //   }
  //  }
}
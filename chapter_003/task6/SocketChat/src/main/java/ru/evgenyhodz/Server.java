package ru.evgenyhodz;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by alittlem1nd on 01.12.2016.
 */
public class Server {

    private static Action action = new Action();

    /**
     * Get port from app.properties
     *
     * @return string value.
     */
    private String readPort() {
        Settings settings = new Settings();
        ClassLoader loader = Settings.class.getClassLoader();
        try (InputStream is = loader.getResourceAsStream("app.properties")) {
            settings.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return settings.getValue("port");
    }

    /**
     * Server starts here.
     */
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        try (ServerSocket serverSocket = new ServerSocket(Integer.valueOf(server.readPort()));
             Socket socket = serverSocket.accept();
             DataOutputStream out =
                     new DataOutputStream(socket.getOutputStream());
             DataInputStream in =
                     new DataInputStream((socket.getInputStream()))) {
            System.out.println("Сonnected.");
            while (true) {
                String input = in.readUTF();
                System.out.print("Execution of action: " + input + "\n");
                String DIR = "C:\\";
                if (input.equalsIgnoreCase("-upload")) {
                    // ACTION
                    String str1 = "File uploaded.";
                    out.writeUTF(str1);
                    out.flush();
                } else if (input.equalsIgnoreCase("-download")) {
                    String filename = in.readUTF();
                    File FILE_TO_SEND = action.download(filename);
                    FileInputStream fileInputStream = new FileInputStream(FILE_TO_SEND);
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                    byte[] mybytearray = new byte[(int) FILE_TO_SEND.length()];
                    out.write(bufferedInputStream.read(mybytearray, 0, mybytearray.length));
                    String str2 = "File downloaded.";
                    out.writeUTF(str2);
                    out.flush();
                } else if (input.equalsIgnoreCase("-gp")) {
                    String str3 = "We are going to parent directory: ";
                    out.writeUTF(str3 + action.openParent(DIR));
                    out.flush();
                } else if (input.equalsIgnoreCase("-gtd")) {
                    //ACTION
                    String str4 = "We are going to specified directory: ";
                    out.writeUTF(str4);
                    out.flush();
                } else if (input.equalsIgnoreCase("-spl")) {
                    String list = action.showParentList(DIR);
                    String str5 = "Parent LIST:\n";
                    out.writeUTF(str5 + list);
                    out.flush();
                } else {
                    String str6 = "What's that? Please, use commands: " +
                            "\n-upload - Upload file to server." +
                            "\n-download - Download file from server." +
                            "\n-gp - Going to parent directory." +
                            "\n-gtd - Going to specified directory." +
                            "\n-spl - Show all directories.";
                    out.writeUTF(str6);
                    out.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}







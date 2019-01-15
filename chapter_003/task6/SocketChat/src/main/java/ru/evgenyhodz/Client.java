package ru.evgenyhodz;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


/**
 * Created by alittlem1nd on 01.12.2016.
 */
public class Client {
    /**
     *
     */
    private static String path = String.format("%s%s%s", System.getProperty("user.dir"),
            File.separator, "chapter_003\\task6\\SocketChat\\src\\main\\download\\file.txt");
    /**
     *
     */
    private static Server server = new Server();
    private static Action action = new Action();

    /**
     * Client starts here.
     */
    public static void main(String[] args) throws IOException {
        InetAddress inetAddress = InetAddress.getByName(action.readSettings("ip"));
        try (Socket clientSocket = new Socket(inetAddress, Integer.valueOf(action.readSettings("port")));
             DataOutputStream out =
                     new DataOutputStream(clientSocket.getOutputStream());
             DataInputStream in =
                     new DataInputStream(clientSocket.getInputStream())) {
            Scanner reader = new Scanner(new InputStreamReader(System.in));
            String str;
            System.out.println("User, enter KEY phrase for server: \n-upload\n-download\n-gp\n-gtd\n-spl");
            while (true) {
                str = reader.nextLine();
                out.writeUTF(str);
                if (str.equalsIgnoreCase("-download")) {

                    System.out.print("User, enter the filename: ");
                    String filename = reader.nextLine();
                    out.writeUTF(filename);
                    Path root = Paths.get(path);
              //      root.
                    byte[] mybytearray = new byte[100000];
                    File file = new File(path);
                    FileOutputStream fos = new FileOutputStream(file);
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fos);
                    int bytesRead = in.read(mybytearray, 0, mybytearray.length);
                    int current = bytesRead;

                    do {
                        bytesRead =
                                in.read(mybytearray, current, (mybytearray.length - current));
                        if (bytesRead >= 0) current += bytesRead;
                    } while (bytesRead > -1);

                    bufferedOutputStream.write(mybytearray, 0, current);
                    bufferedOutputStream.flush();


                    // byte[] bytes = IOUtils.toByteArray(in);
                    //   File file = new File(path);
                    //   FileOutputStream fos = new FileOutputStream(file);
                    //   fos.write(bytes);
                    //   fos.close();

                } else if (str.equalsIgnoreCase("-upload")) {
                    System.out.print("User, enter the filename: ");
                    String filename = reader.nextLine();
                    out.writeUTF(filename);
                    //ACTION
                }
                System.out.println(in.readUTF());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

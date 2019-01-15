package ru.evgenyhodz;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Program to find files.
 * Created by alittlem1nd on 16.12.2016.
 */
public class FileSearcher {
    /**
     * Hint to print.
     */
    private String info =
            "This is a program to search files.\n" +
                    "Available commands:\n" +
                    "-d : Type directory to search.\n" +
                    "-n : Type name of the searching file.\n" +
                    "-f : Search file by name.\n" +
                    "-m : Search file by mask.\n" +
                    "-o : Write paths to log file.\n";
    /**
     * Available commands.
     */
    private String[] commands = {"-d", "-n", "-f", "-o", "-m", "-help"};
    /**
     * Data links.
     */
    private String DIR, NAME, MASK;
    /**
     * Parameters that user maybe will use.
     */
    private String[] parameters;

    /**
     * @param parameters - param of user.
     */
    private FileSearcher(String[] parameters) {
        this.parameters = parameters;
    }

    private String[] getParameters() {
        return parameters;
    }

    /**
     * Prints info.
     *
     * @param string - information you want to show.
     * @param array  - parameters.
     */
    private void printInfo(String string, String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("-help")) {
                System.out.print(string);
                break;
            }
        }
    }

    /**
     * Validate input commands.
     *
     * @param array - main array.
     * @return - true/false.
     */
    private boolean validate(String[] array) {
        boolean valid = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < this.commands.length; j++) {
                if (array[i].equals(this.commands[j])) {
                    valid = true;
                    break;
                }
            }
        }
        return valid;
    }

    /**
     * Set name for searching.
     *
     * @param array - main parameters.
     */
    private String setName(String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("-n") && !array[i + 1].startsWith("-")) {
                this.NAME = array[i + 1];
                list.add("Name for searching : " + this.NAME);
                break;
            }
        }
        return this.NAME;
    }

    /**
     * Set mask for searching.
     *
     * @param array - parameters.
     */
    private String setMask(String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("-m") && !array[i + 1].startsWith("-")) {
                this.MASK = array[i + 1];
                list.add("Mask for searching : " + this.MASK);
                break;
            }
        }
        return this.MASK;
    }

    /**
     * Set directory for searching.
     *
     * @param array - main parameters.
     * @return true/false.
     */
    private String setDirectory(String[] array) {
        try {
            for (int i = 0; i < array.length; i++) {
                if (array[i].equals("-d") && Files.isDirectory(new File(array[i + 1]).toPath()) &&
                        Files.exists(new File(array[i + 1]).toPath())) {
                    this.DIR = array[i + 1];
                    list.add("Directory of searching : " + this.DIR);
                    break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.printf("You forgot to enter the path.\n");
        }
        return this.DIR;
    }

    /**
     * Method is searching file by name. We type in filename and the directory to search.
     *
     * @param filename - name of file to searching.
     * @param root     - the directory where we want to search for file.
     * @throws IOException - I/O exceptions.
     */
    private void search(String filename, String root) throws IOException {
        /*
          Local class finds matches and creates array with them.
         */
        class Searcher {
            private File[] findFile(String filename, String root) {
                File direct = new File(root);
                return direct.listFiles((dir, name) -> name.startsWith(filename));
            }
        }
        Searcher searcher = new Searcher();
        File[] array = searcher.findFile(filename, root);
        if (!checkFileArr(array) && array != null) {
            for (File anArray : array) {
                list.add(anArray.getAbsolutePath());
            }
        } else {
            System.out.print("No matches found.");

        }
    }

    /**
     * Method is searching files by mask and print out all roots to all matches found.
     *
     * @param mask - mask to find in files.
     * @param root - the directory where we want to search.
     * @throws IOException - I/O exceptions.
     */
    private void mask(String mask, String root) throws IOException {
        File dirToSearchIn = new File(root);
        FilenameFilter filter = (dir, name) -> {
            if (name.indexOf(mask) > 0) return true;
            else return false;
        };
        File[] matches = dirToSearchIn.listFiles(filter);
        if (!checkFileArr(matches)) {
            if (matches != null) {
                for (int i = 0; i < matches.length; i++) {
                    list.add(matches[i].getAbsolutePath());
                }
            }
        } else {
            System.out.print("No matches by mask found.");
        }
    }

    /**
     * Array with the list of matches.
     */
    private ArrayList<String> list = new ArrayList<>();

    /**
     * Takes string values (roots of files) from array and writes it to log file.
     */
    private void writeToFile() {
        for (int i = 0; i < getParameters().length; i++) {
            if (getParameters()[i].equals("-o")) {
                if (!this.list.isEmpty()) {
                    try {
                        FileWriter fileWriter = new FileWriter(createLog());
                        fileWriter.write("_________RESULTS:_________\n");
                        for (Object str : this.list) {
                            fileWriter.write(str + "\n");
                        }
                        fileWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * Creating a log file.
     *
     * @return - log file.
     */
    private File createLog() {
        return new File(String.format("%s%s%s", System.getProperty("user.dir"),
                File.separator, "\\chapter_003\\taskTest\\FileFinder\\src\\main\\resources\\log.txt"));
    }

    /**
     * Check if array of FILES(!) contains something.
     *
     * @param files - Files[] array.
     * @return - true/false.
     */
    private boolean checkFileArr(File[] files) {
        boolean empty = true;
        try {
            for (int i = 0; i < files.length; i++) {
                if (files[i] != null) {
                    empty = false;
                    break;
                }
            }
        } catch (NullPointerException npe) {
            System.out.println("You didn't enter the directory to search or...\n" +
                    "you didn't enter the name to search.");
        }
        return empty;
    }

    /**
     * Method to start.
     */
    private void init() {
        FileSearcher fileSearcher = new FileSearcher(parameters);
        if (fileSearcher.validate(parameters)) {
            fileSearcher.printInfo(this.info, parameters);
            try {
                fileSearcher.search(fileSearcher.setName(parameters), fileSearcher.setDirectory(parameters));
                fileSearcher.mask(fileSearcher.setMask(parameters), fileSearcher.setDirectory(parameters));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        fileSearcher.writeToFile();
    }

    /**
     * START OF PROGRAM.
     *
     * @param parameters - :)
     */
    public static void main(String[] parameters) {
        new FileSearcher(parameters).init();
    }
}
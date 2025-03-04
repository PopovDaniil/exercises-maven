package file;

import java.io.*;
import java.time.Instant;
import java.time.ZoneId;

public class FileService {
    private static String dir = "/home/daniil/IdeaProjects/exercises-maven/data/";

    public static void main(String[] args) throws IOException {
        String fileName = "data.txt";
        createFile(fileName);
        System.out.println();
        //deleteFile(fileName);
        getFilesList();
        System.out.println();
        readFile("data.txt");
        System.out.println();
    }

    private static void createFile(String fileName) throws IOException {
        File dataDir = new File(dir);
        System.out.println(dataDir);

        if (dataDir.mkdirs()) {
            System.out.println("Data directory created");
        }

        File file = new File(dir + fileName);
        if (file.createNewFile()) {
            System.out.println("File created");
        }
    }

    private static void deleteFile(String fileName) {
        File file = getFile(fileName);
        if (file.exists()) {
            System.out.println("File exists");

            if (file.delete()) {
                System.out.println("File deleted");
            }
        }
    }

    private static void getFilesList() {
        File dataDir = new File(dir);
        System.out.println("Data directory listng:");
        File[] files = dataDir.listFiles();
        for (File file : files) {
            System.out.println(file.getAbsolutePath() + " | " + Instant.ofEpochMilli(file.lastModified()).atZone(ZoneId.systemDefault()));
        }
    }

    private static void readFile(String fileName) throws IOException {
        File file = getFile(fileName);
        try (Reader is = new BufferedReader(new FileReader(file))) {
            char[] buf = new char[8*1024];

            if (is.read(buf) != -1) {
                for (char c : buf){
                    System.out.print(c);
                }
            }
        }
    }

    private static void readData(String fileName) throws IOException {
        File file = getFile(fileName);
        try (Reader is = new BufferedReader(new FileReader(file))) {
            char[] buf = new char[8*1024];

            if (is.read(buf) != -1) {
                for (char c : buf){
                    System.out.print(c);
                }
            }
        }
    }

    public static File getFile(String fileName) {
        return new File(dir + fileName);
    }
}

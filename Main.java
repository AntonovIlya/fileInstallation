package fileInstallation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static StringBuilder log = new StringBuilder();

    public static void main(String[] args) {

        File[] dirs = {
                new File("C://SomeDir"),
                new File("C://SomeDir//src"),
                new File("C://SomeDir//res"),
                new File("C://SomeDir//saveGames"),
                new File("C://SomeDir//temp"),
                new File("C://SomeDir//src//main"),
                new File("C://SomeDir//src//test"),
                new File("C://SomeDir//res//drawables"),
                new File("C://SomeDir//res//vectors"),
                new File("C://SomeDir//res//icons")
        };

        File[] files = {
                new File("C://SomeDir//src//main//Main.java"),
                new File("C://SomeDir//src//main//Utils.java"),
                new File("C://SomeDir//temp//temp.txt")
        };
        for (File item : dirs) {
            addDir(item);
        }
        for (File item : files) {
            addFile(item);
        }

        try (FileWriter fileWriter = new FileWriter("C://SomeDir//temp//temp.txt",true)){
            fileWriter.write(log.toString());
            fileWriter.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void addDir(File f) {
        log.append("Каталог " + f.getPath() + (f.mkdir() ? " " : " не ") + "создан\n");
    }

    public static void addFile(File f) {
        try {
            log.append("Файл " + f.getPath() + (f.createNewFile() ? " " : " не ") + "создан\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

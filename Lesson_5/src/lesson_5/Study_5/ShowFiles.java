package lesson_5.Study_5;

import java.io.File;

public class ShowFiles {

    public static void main(String[] args) {
        File rootDir = new File("C:\\Users\\user\\Documents\\");
        viewDir("", rootDir);
    }

    private static void viewDir(String prefix, File rootDir) {
        if (rootDir.isFile()) {
            System.out.println(prefix + "File: " + rootDir.getName());
            return;
        }
        System.out.println(prefix + "Dir: " + rootDir.getName());
        for (File file : rootDir.listFiles()) {
            viewDir(prefix + " ", file);
        }
    }
}

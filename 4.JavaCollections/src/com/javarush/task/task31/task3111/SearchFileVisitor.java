package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.FileVisitResult.CONTINUE;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        long content = Files.size(file); // размер файла

        if (partOfName != null && !file.getFileName().toString().contains(partOfName)) {
            return CONTINUE;
        }

        if (minSize > 0 && content <= minSize) {
            return CONTINUE;
        }

        if (maxSize > 0 && content >= maxSize) {
            return CONTINUE;
        }

        if (partOfContent != null && !new String(Files.readAllBytes(file)).contains(partOfContent)) {
            return CONTINUE;
        }
        foundFiles.add(file);
        return CONTINUE;

//        boolean containName = true; // по умолчанию считаю что поле null
//        if (partOfName != null) {
//            containName = file.getFileName().toString().contains(partOfName);
//        }

//        boolean sizeMin = true;
//        if (minSize > 0) {
//            sizeMin = content.length > minSize;
//        }

//        boolean sizeMax = true;
//        if (maxSize > 0) {
//            sizeMax = content.length < maxSize;
//        }

//        boolean containPart = true;
//        if (partOfContent != null) {
//            try (BufferedReader reader = Files.newBufferedReader(file)) {
//                while (reader.ready()) {
//                    containPart = false;
//                    String line = reader.readLine();
//                    if (line.contains(partOfContent)) {
//                        containPart = true;
//                        break;
//                    }
//                }
//            }
//        }
//
//        if (containName && containPart && sizeMin && sizeMax) {
//            foundFiles.add(file);
//        }
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}
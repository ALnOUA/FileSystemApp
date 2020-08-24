package com.ua.springfilesystemapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ReplaceWordService {
    @Autowired
    ReadFilesPathService readFilesPathService;
    public void updateAllFiles(String startFilePath, String oldWord, String newWord) throws IOException {
        List<String> filePathes = readFilesPathService.readFilesPath(startFilePath);
        for (int i =0; i<filePathes.size();i++) {
            updateFile(filePathes.get(i),oldWord,newWord);
        }
    }

    public void updateFile(String filePath, String oldWord, String newWord) throws IOException {
        Path path = Paths.get(filePath);
        Stream<String> lines = Files.lines(path);
        List<String> replaced = lines.map(line -> line.replaceAll(oldWord, newWord)).collect(Collectors.toList());
        Files.write(path, replaced);
        lines.close();
    }
}

package com.ua.springfilesystemapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ReplaceWordService {
    @Autowired
    ReadFilesPathService readFilesPathService;

    public void updateAllFiles(String startFilePath, String oldWord, String newWord) throws IOException {
        List<String> allFiles = readFilesPathService.scanAllSubfolders(startFilePath);
        for(int i =0; i<allFiles.size();i++) {
            makeReplacement(allFiles.get(i), oldWord, newWord);
            renameIfNeeded(allFiles.get(i), oldWord, newWord);
        }
    }

    private void makeReplacement(String filePath, String oldWord, String newWord) throws IOException {
        Path path = Paths.get(filePath);
        Stream<String> lines = Files.lines(path);
        List<String> replaced = lines.map(line -> line.replaceAll(oldWord, newWord)).collect(Collectors.toList());
        Files.write(path, replaced);
        lines.close();
    }

    private void renameIfNeeded(String fileName, String oldWord, String newWord) {
        // TODO: 25.08.2020 rename directory
       File oldFile = new File(fileName);
       String newFileName = fileName.replaceAll(oldWord,newWord);
       File newFile = new File(newFileName);
        if (oldFile.renameTo(newFile)){
           System.out.println("File Renamed successfully");
       }
    }


}

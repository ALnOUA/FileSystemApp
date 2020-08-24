package com.ua.springfilesystemapp;

import com.ua.springfilesystemapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringFilesystemAppApplication implements CommandLineRunner {
    @Autowired
    PrintService printService;
    @Autowired
    ReadDataService readDataService;
    @Autowired
    ReadFilesPathService readFilesPathService;
    @Autowired
    ReplaceWordService replaceWordService;
    @Autowired
    InitService initService;

    public static void main(String[] args) {
        SpringApplication.run(SpringFilesystemAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String newWord = initService.initNewWord();
        String oldWord = initService.initOldWord();
        String startFilePath = initService.initStartFilePath();

        replaceWordService.updateAllFiles(startFilePath,oldWord,newWord);

    }
}

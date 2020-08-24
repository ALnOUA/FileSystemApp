package com.ua.springfilesystemapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitService {
    @Autowired
    PrintService printService;
    @Autowired
    ReadDataService readDataService;
    public String initOldWord(){
        printService.askToPrintOldWord();
        String oldWord = readDataService.read();
        return  oldWord;
    }

    public String initNewWord(){
        printService.askToPrintNewWord();
        String newWord = readDataService.read();
        return newWord;
    }

    public String initStartFilePath(){
        printService.askToPrintPath();
        String startFilePath = readDataService.read();
        return startFilePath;
    }


}

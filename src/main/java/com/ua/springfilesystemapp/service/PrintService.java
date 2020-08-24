package com.ua.springfilesystemapp.service;

import org.springframework.stereotype.Service;

@Service
public class PrintService {
    public void askToPrintPath(){
        System.out.println("Enter the path of directory that you want to update: ");
    }
    public void askToPrintOldWord(){
        System.out.println("Enter the old word: ");
    }
    public void askToPrintNewWord(){
        System.out.println("Enter the new word: ");
    }
}

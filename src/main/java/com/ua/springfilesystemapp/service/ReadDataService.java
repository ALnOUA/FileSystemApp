package com.ua.springfilesystemapp.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ReadDataService {
    Scanner scanner = new Scanner(System.in);
    public String read() {
        return scanner.nextLine();
    }
}

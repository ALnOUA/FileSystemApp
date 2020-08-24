package com.ua.springfilesystemapp.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ReadFilesPathService {

    public List<String> readFilesPath(String path) {
        List<String> pathes= Collections.emptyList();

        try (Stream<Path> walk = Files.walk(Paths.get(path))) {

            pathes = walk.map(x -> x.toString())
                    .filter(f -> f.endsWith(".txt")).collect(Collectors.toList());


        } catch (IOException e) {
            e.printStackTrace();
        }
        return pathes;
    }
}

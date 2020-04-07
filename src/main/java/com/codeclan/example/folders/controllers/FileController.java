package com.codeclan.example.folders.controllers;

import com.codeclan.example.folders.models.File;
import com.codeclan.example.folders.models.User;
import com.codeclan.example.folders.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FileController {

    @Autowired
    FileRepository fileRepository;

    @GetMapping(value = "/files")
    public ResponseEntity getAllFiles(){
        List<File> files = fileRepository.findAll();
        return new ResponseEntity(files, HttpStatus.OK);
    }

    @GetMapping(value="/files/{id}")
    public ResponseEntity getFiles(@PathVariable Long id){
        return new ResponseEntity(fileRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value="/files")
    public ResponseEntity postFile(@RequestBody File file){
        fileRepository.save(file);
        return new ResponseEntity(file, HttpStatus.CREATED);
    }
}

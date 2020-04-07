package com.codeclan.example.folders.components;

import com.codeclan.example.folders.models.File;
import com.codeclan.example.folders.models.Folder;
import com.codeclan.example.folders.models.User;
import com.codeclan.example.folders.repositories.FileRepository;
import com.codeclan.example.folders.repositories.FolderRepository;
import com.codeclan.example.folders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    UserRepository userRepository;

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        fileRepository.deleteAll();
        folderRepository.deleteAll();
        userRepository.deleteAll();

        User gareth = new User("Gareth");
        userRepository.save(gareth);
        Folder models = new Folder("Models", gareth);
        folderRepository.save(models);
        Folder controllers = new Folder("Controllers", gareth);
        folderRepository.save(controllers);
        File file = new File("File", "java", 50, models);
        fileRepository.save(file);
        File folder = new File("Folder", "java", 50, models);
        fileRepository.save(folder);
        File user = new File("User", "java", 50, models);
        fileRepository.save(user);
        File fileController = new File("FileController", "java", 50, controllers);
        fileRepository.save(fileController);
        File folderController = new File("FolderController", "java", 50, controllers);
        fileRepository.save(folderController);
        File userController = new File("UserController", "java", 50, controllers);
        fileRepository.save(userController);






    }



    }

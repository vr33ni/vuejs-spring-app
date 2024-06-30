package com.vr33ni.backend.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.vr33ni.backend.model.Board;
import com.vr33ni.backend.service.BoardItemService;

import com.vr33ni.backend.model.Wetsuit;
import com.vr33ni.backend.service.WetsuitItemService;

import com.vr33ni.backend.model.Accessory;
import com.vr33ni.backend.service.AccessoryItemService;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final BoardItemService boardItemService;
    private final WetsuitItemService wetsuitItemService;
    private final AccessoryItemService accessoryItemService;

    //private final DatabaseCleaner databaseCleaner;

    @Autowired
    public DatabaseSeeder(BoardItemService boardItemService, WetsuitItemService wetsuitItemService, AccessoryItemService accessoryItemService, DatabaseCleaner databaseCleaner) {
        this.boardItemService = boardItemService;
        this.wetsuitItemService = wetsuitItemService;
        this.accessoryItemService = accessoryItemService;

       // this.databaseCleaner = databaseCleaner;
    }

    @Override
    public void run(String... args) throws Exception {
    
        // Seed the database
        //seedDatabase();

        // Run migration scripts
        if (!boardItemService.getAllItems().isEmpty() && !wetsuitItemService.getAllItems().isEmpty() && !accessoryItemService.getAllItems().isEmpty()) {
            System.out.println("board, wetsuit & accessory migrations already exist");
            //databaseCleaner.cleanDatabases("mysurfboards");
            //databaseCleaner.cleanCollections();
        }
        else {
            System.out.println("running migration scripts");
            runMigrationScripts();

        }

    }

    private void seedDatabase() {
        // Check if the database is empty
        if (boardItemService.getAllItems().isEmpty()) {
            // Create and save an initial item
            Board item = new Board();
            item.setName("Delight Alliance Hoodoo Swallow");
            item.setPrice(10.0);
            boardItemService.createItem(item);
            System.out.println("First surfboard acquired");
        }
    }

    public void runMigrationScripts() {
        String migrationsPath = "migrations";
        File migrationsDirectory = new File(migrationsPath);

        List<File> migrationFiles = new ArrayList<>();
        if (migrationsDirectory.isDirectory()) {
            searchForMigrationFiles(migrationsDirectory, migrationFiles);
        }
        for (File migrationFile : migrationFiles) {
            executeMigrationScript(migrationFile);
        }
    }

    private void searchForMigrationFiles(File directory, List<File> migrationFiles) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // Recursive call to search in subdirectory
                    searchForMigrationFiles(file, migrationFiles);
                } else if (file.getName().endsWith(".js")) {
                    // Add .js file to the list
                    migrationFiles.add(file);
                }
            }
        }
    }

    private void executeMigrationScript(File migrationFile) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("node", migrationFile.getAbsolutePath());
            processBuilder.redirectErrorStream(true);

            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Migration script executed successfully: " + migrationFile.getName());
            } else {
                System.err.println("Error: Migration script execution failed: " + migrationFile.getName());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

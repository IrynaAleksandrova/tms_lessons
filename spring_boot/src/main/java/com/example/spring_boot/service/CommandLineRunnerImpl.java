package com.example.spring_boot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class CommandLineRunnerImpl implements CommandLineRunner {

    @Value("${file.path}")
    private String line;
    private final String PATH = "D:\\TeachMeSkills\\tms_lessons\\spring_boot\\src\\main";


    @Override
    @ConfigurationProperties(prefix = "file")
    public void run(String... args) throws Exception {

        Path pathWrite = Paths.get(PATH + "_" + line);
        String count;

        if (Files.exists(pathWrite)) {
            String number = Files.readString(pathWrite);
            count = String.valueOf(Integer.parseInt(number) + 1);
        } else {
            Files.createFile(pathWrite);
            count = "1";
        }

        try (FileOutputStream fos = new FileOutputStream(pathWrite.toFile())) {
            byte[] buf = count.getBytes();
            fos.write(buf, 0, buf.length);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
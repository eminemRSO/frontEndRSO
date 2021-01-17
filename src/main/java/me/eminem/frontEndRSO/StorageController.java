package me.eminem.frontEndRSO;

import org.modelmapper.ModelMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.stream.Stream;

@RestController
public class StorageController {

    TaskService taskService;

    ModelMapper modelMapper;

    public StorageController(TaskService taskService) {
        modelMapper = new ModelMapper();
        this.taskService = taskService;
    }



    @GetMapping(path="/tasks")
    public Stream<TaskDTO> getAllTasks(){
        return taskService.getAllTasks().stream().map(task -> modelMapper.map(task,TaskDTO.class));
    }

    @GetMapping(path="/UI")
    public String UI(){
        return "nek tekst haha kul 2 ";
    }
    @GetMapping(path="/UI2")
    public String UI2(){
        return "<p id=\"demo\" onclick=\"myFunction()\">Click me to change my text color.</p>"
            .concat("<script>")
            .concat("function myFunction() {")
            .concat("document.getElementById(\"demo\").style.color = \"red\";")
            .concat("}")
            .concat("</script>");
    }

    @GetMapping(path="/UI_debug")
    public String UI_debug()throws IOException {
        return "karkol";
    }

    @GetMapping(path="/UI3")
    public String UI3() throws IOException {
        //tole ne deluje v containerju zaradi nekega razloga
        //ClassLoader classLoader = getClass().getClassLoader();
        //File file = new File(classLoader.getResource("spletna_stran.txt").getFile());

        //String path  ="src"+ File.separator +"main"+ File.separator +"resources"+ File.separator +"spletna_stran.txt";

        String data = "";
        ClassPathResource cpr = new ClassPathResource("spletna_stran.txt");
        try {
            byte[] bdata = FileCopyUtils.copyToByteArray(cpr.getInputStream());
            data = new String(bdata, StandardCharsets.UTF_8);
        } catch (IOException e) {
        }
        return data;
//        File file = new File(path);
//        StringBuilder fileContents = new StringBuilder((int)file.length());
//
//        try (Scanner scanner = new Scanner(file)) {
//            while(scanner.hasNextLine()) {
//                fileContents.append(scanner.nextLine() + System.lineSeparator());
//            }
//            return fileContents.toString();
//        }
    }
}
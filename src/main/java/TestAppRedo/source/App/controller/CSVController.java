package TestAppRedo.source.App.controller;

import TestAppRedo.source.App.csvhelper.CSVHelper;
import TestAppRedo.source.App.entity.County;
import TestAppRedo.source.App.entity.Locality;
import TestAppRedo.source.App.message.ResponseMessage;
import TestAppRedo.source.App.service.CSVService;
import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin("http://localhost:8081")
@Controller
@RequestMapping("/api/cvs")
public class CSVController {

    @Autowired
    CSVService fileservice;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage>uploadFile(@RequestParam("file")MultipartFile file){
        String message;

        if(CSVHelper.hasCSVFormat(file)){
            try {
                fileservice.save(file);
                message = "Uploaded file succesfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            }catch (Exception e){
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }
        message = "Please upload a csv file ! ";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }

    @GetMapping("/locality")
    public ResponseEntity<List<Locality>>getAllLocality(){
        try {
            List<Locality> localities = fileservice.getAllLocalities();
            if (localities.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(localities,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/county")
    public ResponseEntity<List<County>>getAllCounty(){
        try {
            List<County> counties = fileservice.getAllCounties();
            if (counties.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
           return new ResponseEntity<>(counties,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> getFile() {
        String filename = "tutorials.csv";
        InputStreamResource file = new InputStreamResource(fileservice.load());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/csv"))
                .body(file);
    }

}

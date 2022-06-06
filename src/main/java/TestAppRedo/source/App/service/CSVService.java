package TestAppRedo.source.App.service;

import TestAppRedo.source.App.Repo.CountyRepo;
import TestAppRedo.source.App.Repo.LocalityRepo;
import TestAppRedo.source.App.csvhelper.CSVHelper;
import TestAppRedo.source.App.entity.County;
import TestAppRedo.source.App.entity.Locality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class CSVService {

    @Autowired
    CountyRepo countyRepo;

    @Autowired
    LocalityRepo localityRepo;

    public void save(MultipartFile file) {
        try {
            List<County> counties = CSVHelper.csvToTutorials(file.getInputStream());
            countyRepo.saveAll(counties);
        } catch (IOException e) {
            throw new RuntimeException("fail to store the csv data:" + e.getMessage());
        }
    }

    public ByteArrayInputStream load() {
        List<County> counties = countyRepo.findAll();

        ByteArrayInputStream inputStream = CSVHelper.tutorialsToCSV(counties);
        return inputStream;
    }

    public List<County> getAllCounties() {
        return countyRepo.findAll();
    }

    public List<Locality> getAllLocalities() {
        return localityRepo.findAll();
    }
}

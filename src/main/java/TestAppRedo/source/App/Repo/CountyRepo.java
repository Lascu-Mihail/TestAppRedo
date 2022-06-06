package TestAppRedo.source.App.Repo;

import TestAppRedo.source.App.entity.County;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountyRepo extends JpaRepository<County,Long> {


    List<County> findAll();
}

package TestAppRedo.source.App.Repo;

import TestAppRedo.source.App.entity.Locality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocalityRepo extends JpaRepository<Locality,Long> {

    List<Locality> findAll();
}

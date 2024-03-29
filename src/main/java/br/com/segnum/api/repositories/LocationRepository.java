package br.com.segnum.api.repositories;

import br.com.segnum.api.domain.Location;
import br.com.segnum.api.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository <Location, Integer> {

    List<Location> findByUser(User user);
}

package br.com.segnum.api.repositories;

import br.com.segnum.api.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository <Location, Integer> {
}

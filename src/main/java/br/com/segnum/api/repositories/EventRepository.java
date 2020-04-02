package br.com.segnum.api.repositories;

import br.com.segnum.api.domain.Event;
import br.com.segnum.api.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository <Event, Integer> {
    List<Event> findByUser(User user);

    @Query(value="SELECT * FROM Event as e " +
            "WHERE e.id in ( SELECT l.event_id" +
            "            FROM Location as l" +
            "            WHERE l.event_id = e.id and (6371 * acos(" +
            "            cos (radians(:longitude))" +
            "            * cos (radians(l.lx))" +
            "            * cos (radians(l.ly) - radians(:latitude))" +
            "            + sin (radians(l.lx))" +
            "            * sin (radians(:longitude))" +
            "            )) < :rangeKm)",
            nativeQuery = true)
    List<Event> findNear(String longitude, String latitude, int rangeKm);
}

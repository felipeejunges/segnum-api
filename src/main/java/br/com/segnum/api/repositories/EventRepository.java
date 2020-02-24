package br.com.segnum.api.repositories;

import br.com.segnum.api.domain.Event;
import br.com.segnum.api.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository <Event, Integer> {
    List<Event> findByUser(User user);
}

package br.com.segnum.api.repositories;

import br.com.segnum.api.domain.Event;
import br.com.segnum.api.domain.EventType;
import br.com.segnum.api.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventTypeRepository extends JpaRepository <EventType, Integer> {
}

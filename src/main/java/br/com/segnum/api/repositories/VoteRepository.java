package br.com.segnum.api.repositories;

import br.com.segnum.api.domain.Event;
import br.com.segnum.api.domain.User;
import br.com.segnum.api.domain.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository <Vote, Integer> {
    List<Vote> findByUser(User user);

    List<Vote> findByEvent(Event event);
}

package br.com.segnum.api.repositories;

import br.com.segnum.api.domain.Commentary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaryRepository extends JpaRepository <Commentary, Integer> {
}

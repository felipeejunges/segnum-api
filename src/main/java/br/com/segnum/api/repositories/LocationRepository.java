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
//
//    SELECT
//    id, (
//            3959 * acos (
//            cos ( radians(78.3232) )
//            * cos( radians( lat ) )
//            * cos( radians( lng ) - radians(65.3234) )
//            + sin ( radians(78.3232) )
//            * sin( radians( lat ) )
//            )
//            ) AS distance
//    FROM markers
//    HAVING distance < 30
//    ORDER BY distance
//    LIMIT 0 , 20;
//
//
//
//    @Query("SELECT l, " +
//            "10 as distanceCalculated, " +
////            "3959 * acos ( cos (radians(?1)) )" +
//            "3959 * function('acos', " +
//                "function('cos', function('radians', ?1))" +
//            ")" +
//            "FROM Location l HAVING distanceCalculated < ?3")
//    List<Location> findNear(double latitude, double longitude, int range);
}

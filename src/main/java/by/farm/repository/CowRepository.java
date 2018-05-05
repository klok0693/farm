package by.farm.repository;

import by.farm.NotNullByDefault;
import by.farm.entity.Cow;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;

/**
 * Created by klok on 4.5.18.
 */
@NotNullByDefault

@Repository
@Transactional(propagation = REQUIRED)
public interface CowRepository extends CrudRepository<Cow, Integer> {

    @Modifying
    @Query(value = "INSERT INTO cows VALUES (:cowId, :nickName)", nativeQuery = true)
    void GiveBirth (@Param("cowId") Integer childCowId, @Param("nickName") String nickName);
}

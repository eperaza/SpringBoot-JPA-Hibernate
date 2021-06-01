package com.example.jpa.model;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    
    @Query("select f from user f")
    //@Query(value="select * from user a left join roles b on a.id=b.id_user", nativeQuery=true)
    //@Query(value="select a from user a join role b on a.id_role=b.id", nativeQuery=true)
    List<User> customquery();
}

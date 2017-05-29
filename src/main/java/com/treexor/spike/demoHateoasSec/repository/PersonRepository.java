package com.treexor.spike.demoHateoasSec.repository;

import com.treexor.spike.demoHateoasSec.domain.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.annotation.Secured;

@Secured({"ROLE_ADMIN"})
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query("select o from Person as o where o.id = ?1 and o.owner = ?#{ T(java.lang.Long).parseLong(principal?.username )}")
    Person findById(@Param("id") Long id);
}

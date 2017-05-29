package com.treexor.spike.demoHateoasSec.repository;

import com.treexor.spike.demoHateoasSec.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Override
    @Query("select o from Person as o where o.id = ?1 and o.owner = ?#{ principal?.username}")
    Person findOne(Long id);

    @Override
    @Query("select o from Person as o where o.owner = ?#{ principal?.username}")
    Page<Person> findAll(Pageable pageable);
}

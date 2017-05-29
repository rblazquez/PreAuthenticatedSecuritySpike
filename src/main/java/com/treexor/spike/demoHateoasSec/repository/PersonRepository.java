package com.treexor.spike.demoHateoasSec.repository;

import com.treexor.spike.demoHateoasSec.domain.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PersonRepository extends CrudRepository<Person, Long> {

}

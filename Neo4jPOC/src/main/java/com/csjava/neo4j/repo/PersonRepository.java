package com.csjava.neo4j.repo;

import com.csjava.neo4j.model.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;


@EnableNeo4jRepositories
public interface PersonRepository extends Neo4jRepository<Person, String> {
    void deleteByName(String name);

//    Mono<Movie> findOneByTitle(String title);
}

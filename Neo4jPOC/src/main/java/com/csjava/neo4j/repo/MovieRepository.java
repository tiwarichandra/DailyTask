package com.csjava.neo4j.repo;

import com.csjava.neo4j.model.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@EnableNeo4jRepositories
public interface MovieRepository extends Neo4jRepository<Movie, String> {

    Movie findOneByTitle(String title);

    void deleteByTitle(String title);
}

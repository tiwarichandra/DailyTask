package com.csjava.neo4j.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Node("movie")
public class Movie implements Serializable {

    @Id
    private String title;

//    @Property("tagline")
    private String description;


    @Relationship(type = "ACTED_IN", direction = Relationship.Direction.INCOMING)
    private List<Person> actors;

//    @Relationship(type = "DIRECTED", direction = Relationship.Direction.INCOMING)
//    private List<Person> directors = new ArrayList<>();


    public Movie(String title, String description) {
        this.title = title;
        this.description = description;
    }


}

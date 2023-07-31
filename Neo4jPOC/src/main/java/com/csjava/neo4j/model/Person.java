package com.csjava.neo4j.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.*;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Node("person")
//@RelationshipProperties
public class Person implements Serializable {


    @Id
    private String name;
    private Integer born;

    @Relationship(type = "ACTED_IN")
    private List<Movie> movies;


}

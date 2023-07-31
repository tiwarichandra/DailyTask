package com.csjava.neo4j.controller;


import com.csjava.neo4j.model.Movie;
import com.csjava.neo4j.model.Person;
import com.csjava.neo4j.repo.MovieRepository;
import com.csjava.neo4j.repo.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieRepository movieRepository;
    private final PersonRepository personRepository;

    @PostMapping()
    void createOrUpdateMovie(@RequestBody Movie newMovie) {

        Person person = new Person();
        person.setName(newMovie.getActors().get(0).getName());

        Movie movie = new Movie();
        movie.setTitle(newMovie.getTitle());
        movie.setDescription(newMovie.getDescription());

        // Add the movie to the person's movies list
        person.setMovies(newMovie.getActors().get(0).getMovies());

        // Add the person to the movie's actors list
        List<Person> actors = newMovie.getActors();
        actors.add(person);
        movie.setActors(actors);

        // Save the person and movie entities
        personRepository.save(person);
        movieRepository.save(movie);

//        Person person1 = new Person();
//        Person person = newMovie.getActors();
//        person1.setName(person.getName());
//        person1.setBorn(person.getBorn());
//        personRepository.save(person1);



//        Person person2 = new Person();
//        Person person3 = newMovie.getDirectors().get(0);
//        person2.setName(person3.getName());
//        person2.setBorn(person3.getBorn());
//        personRepository.save(person2);
//        personRepository.save(newMovie.getDirectors().get(0));

//        Movie movie = new Movie();
//        movie.setTitle("The Matrix");
//        movieRepository.save(movie);

//        ActedIn actedIn = new ActedIn();
//        actedIn.setPerson(person1);
//        actedIn.setMovie(movie);
//        actedIn.setRole("Neo");
//        actedInRepository.save(actedIn);
//        return movieRepository.save(newMovie);
    }

    @GetMapping(value = { "", "/" }, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/by-title")
    Movie byTitle(@RequestParam String title) {
        return movieRepository.findOneByTitle(title);
    }

    @DeleteMapping("/{title}")
    void delete(@PathVariable String title) {
         movieRepository.deleteByTitle(title);
    }

    @DeleteMapping("/person/{name}")
    void deleteBYName(@PathVariable String name) {
        personRepository.deleteByName(name);
    }

}

package com.zipcodewilmington.streams;

import com.zipcodewilmington.streams.anthropoid.Person;
import com.zipcodewilmington.streams.anthropoid.PersonFactory;
import com.zipcodewilmington.streams.tools.RandomUtils;
import com.zipcodewilmington.streams.tools.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/2/17.
 */
public class StreamFilter {
    private final Stream<Person> personStream;
    public final String startingCharacter;
    Random rand = new Random();

    /**
     * No arg constructor
     */ //construct person stream of 100 person objects; startingCharacter is a random capital letter
    public StreamFilter() {
        personStream = Stream.generate(new PersonFactory()::createRandomPerson).limit(100);
        startingCharacter = String.valueOf(rand.nextInt());
    }


    /**
     * @param people - Array of person objects
     * @param startingCharacter - character to filter by
     */ //TODO
    public StreamFilter(Person[] people, Character startingCharacter) {
        this(Arrays.stream(people), startingCharacter);
    }

    /**
     * @param people - List of person objects
     * @param startingCharacter - character to filter by
     */ //TODO
    public StreamFilter(List<Person> people, Character startingCharacter) {
        this(people.stream(), startingCharacter);
    }


    /**
     * @param people - Stream of person objects
     * @param startingCharacter - character to filter by
     */ // I took care of the easy constructor (͡° ͜ʖ ͡°)
    public StreamFilter(Stream<Person> people, Character startingCharacter) {
        this.personStream = people;
        this.startingCharacter = startingCharacter.toString();
    }


    /**
     * Using multi-line lambda syntax
     * @return a list of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public List<Person> toListMultiLine() {
        List plist = new ArrayList();
        personStream.forEach( p -> {
            if (p.getName().charAt(0) == this.startingCharacter.charAt(0)) {
                plist.add(p);
            }
        });
        return plist;
    }


    /**
     * Using one-line lambda syntax
     * @return a list of person objects whose name starts with `this.startingCharacter`
     */ //TODO
    public List<Person> toListOneLine() {
        return personStream.filter(p -> p.getName().charAt(0) == this.startingCharacter.charAt(0)).collect(Collectors.toList());
    }


    /**
     * Using one-line lambda syntax
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public Person[] toArrayOneLine() {
        return personStream.filter(p -> p.getName().charAt(0) == this.startingCharacter.charAt(0)).toArray(Person[]::new);
    }


    /**
     * Using multi-line lambda syntax
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public Person[] toArrayMultiLine() {
        return toListMultiLine().toArray(new Person[0]);
    }

}

package com.it.demo.mapper;

import ma.glasnost.orika.MapperFacade;

import java.util.List;

public class OrikaMapper {

    private MapperFacade mapperFacade;

    /**
     * Constructs an instance of this class.
     *
     */
    public OrikaMapper(MapperFacade mapperFacade) {
        this.mapperFacade = mapperFacade;
    }

    /**
     * Maps the properties of a source object into a destination object.
     *
     * @param source
     *            the source object
     * @param destinationClass
     *            the destination object
     * @param <S>
     *            the type of the source objects
     * @param <D>
     *            the type of the destination objects
     * @return the <b>destination</b> object, whose properties are mapped from <b>source</b>
     */
    public <S, D> D map(S source, Class<D> destinationClass) {
        return this.mapperFacade.map(source, destinationClass);
    }

    /**
     * Maps the properties of a source object into a newly allocated object.
     *
     * @param source
     *            the source object
     * @param destination
     *            the class of the new object
     * @param <S>
     *            the type of the source objects
     * @param <D>
     *            the type of the destination objects
     * @return a new instance of <b>destinationClass</b>, whose properties are mapped from <b>source</b>
     */
    public <S, D> D map(S source, D destination) {
        this.mapperFacade.map(source, destination);
        return destination;
    }

    /**
     * Maps an {@link Iterable} of <b>S</b> objects into a new {@link List} parameterized with <b>D</b>.
     *
     * @param <S>
     *            the class of the source items
     * @param <D>
     *            the class of the destination items
     * @param source
     *            an {@link Iterable} source object
     * @param destinationClass
     *            the destination class of the items of the list
     * @return a {@link List} of items of class <b>D</b>
     */
    public <S, D> List<D> mapAsList(Iterable<S> source, Class<D> destinationClass) {
        return this.mapperFacade.mapAsList(source, destinationClass);
    }

    /**
     * Maps an array of S <b>objects</b> into a new {@link List} parameterized with D.
     *
     * @param <S>
     *            the class of the source items
     * @param <D>
     *            the class of the destination items
     * @param source
     *            an {@link Iterable} source object
     * @param destinationClass
     *            the destination class of the items of the list
     * @return a {@link List} of items of class <b>D</b>
     */
    public <S, D> List<D> mapAsList(S[] source, Class<D> destinationClass) {
        return this.mapperFacade.mapAsList(source, destinationClass);
    }
}

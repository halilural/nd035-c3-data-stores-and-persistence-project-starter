package com.udacity.jdnd.course3.critter.model.pet;

/**
 * A example list of pet type metadata that could be included on a request to create a pet.
 */
public enum PetType {
    CAT(0), DOG(1), LIZARD(2), BIRD(3), FISH(4), SNAKE(5), OTHER(6);

    PetType(Integer value) {
        this.value = value;
    }

    private final Integer value;

    public int getValue() {
        return value;
    }
}

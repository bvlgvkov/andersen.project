package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

class SquareTriangleTest {
    private static final Logger LOGGER = Logger.getLogger(SquareTriangleTest.class.getName());
    private static SquareTriangle triangle;

    @BeforeEach
    public void init() {
        LOGGER.info("Triangle initialization");
        triangle = new SquareTriangle(3, 4, 5);
    }

    @Test
    @DisplayName("perimeter")
    public void perimeterTest() {
        LOGGER.info("Checking the calculation of the perimeter of a triangle");

        LOGGER.info("Perimeter calculation");
        Double perimeter = triangle.perimeter();

        LOGGER.info("Result checking");
        Assertions.assertEquals(perimeter, triangle.perimeter());
    }

    @Test
    @DisplayName("square")
    public void squareTest() {
        LOGGER.info("Checking the calculation of the square of a triangle");

        LOGGER.info("Square calculation");
        Double square = triangle.square();

        LOGGER.info("Result checking");
        Assertions.assertEquals(square, triangle.square());
    }
}

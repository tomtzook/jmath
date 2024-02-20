package com.jmath;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AngleMathTest {

    private static final double EQUAL_MARGIN = 0.0001;

    @ParameterizedTest(name = "shortestAngularDistance({0}, {1}) = {2}")
    @CsvSource({
            "0.0, 360.0, 0.0",
            "0.0, 90.0, 90.0",
            "360.0, 90.0, 90.0",
            "150.0, 325.0, 175.0",
            "0.0, 30.0, 30.0",
            "30.0, 0.0, 30.0",
            "30.0, 30.0, 0.0",
    })
    public void shortestAngularDistance_forInput_producesExpectedOutput(double from, double to, double expectedOutput) throws Exception {
        assertEquals(expectedOutput, AngleMath.shortestAngularDistance(from, to), EQUAL_MARGIN);
    }

    @ParameterizedTest(name = "motionDirection({0}, {1}) = {2}")
    @MethodSource("motionDirectionArgumentSource")
    public void motionDirection_forInput_producesExpectedOutput(double from, double to, int expectedOutput) throws Exception {
        int direction = AngleMath.motionDirection(from, to);
        assertEquals(expectedOutput, direction);
    }

    private static Stream<Arguments> motionDirectionArgumentSource() {
        return Stream.of(
                Arguments.of(0.0, 30.0, 1),
                Arguments.of(0.0, 360.0, 1),
                Arguments.of(90.0, 0.0, -1),
                Arguments.of(0.0, 90.0, 1),
                Arguments.of(360.0, 90.0, 1),
                Arguments.of(0.0, 270.0, -1),
                Arguments.of(360.0, 270.0, -1),
                Arguments.of(270.0, 360.0, 1),
                Arguments.of(339.0, 334.0, -1),
                Arguments.of(334.0, 339.0, 1),
                Arguments.of(329.45625, 329.2875, -1),
                Arguments.of(329.2875, 329.45625, 1)
        );
    }
}
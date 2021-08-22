package com.kodilla.patterns2.exception.test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class probablyIWillThrowExceptionTestSuite {
    @Test
    void testProbablyIWillThrowExceptionTestSuite() {
        // given
        SecondChallenge secondChallenge = new SecondChallenge();
        // when & then
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0.99, 1.1));
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2, 1));
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0, 1.5));
        Assertions.assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.4, 1.3));
    }
}

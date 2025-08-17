package chess.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

  @Test
  void shouldReturnTrueForValidPositions() {
    assertTrue(new Position(0, 0).isValid());
    assertTrue(new Position(7, 7).isValid());
    assertTrue(new Position(3, 4).isValid());
  }

  @Test
  void shouldReturnFalseForInvalidPositions() {
    assertFalse(new Position(-1, 0).isValid());
    assertFalse(new Position(0, -1).isValid());
    assertFalse(new Position(8, 0).isValid());
    assertFalse(new Position(0, 8).isValid());
  }

  @Test
  void shouldMovePositionByStep() {
    Position start = new Position(3, 3);
    Step step = new Step(1, 2); // move down 1, right 2
    Position result = start.move(step);

    assertEquals(new Position(4, 5), result);
  }
}
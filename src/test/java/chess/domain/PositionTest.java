package chess.domain;

import org.junit.jupiter.api.Test;

import java.util.Optional;

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

  @Test
  void shouldConvertRowAndColToCorrectPosition() {
    assertEquals("A1", Position.toPositionNotation(new Position(0, 0)));
    assertEquals("H8", Position.toPositionNotation(new Position(7, 7)));
    assertEquals("D5", Position.toPositionNotation(new Position(4, 3)));
  }

  @Test
  void shouldConvertPositionNotationToCorrectRowAndCol() {
    Optional<Position> result = Position.fromPositionNotation("A1");

    assertTrue(result.isPresent());
    assertEquals(new Position(0, 0), result.get());
  }

  @Test
  void shouldReturnEmptyOptionalForInvalidColumn() {
    Optional<Position> result = Position.fromPositionNotation("Z5");

    assertFalse(result.isPresent());
  }

  @Test
  void shouldReturnEmptyOptionalForInvalidRow() {
    Optional<Position> result = Position.fromPositionNotation("A9");

    assertFalse(result.isPresent());
  }

  @Test
  void shouldReturnEmptyOptionalForInvalidPositionLength() {
    Optional<Position> result = Position.fromPositionNotation("A");

    assertFalse(result.isPresent());
  }

  @Test
  void shouldReturnEmptyOptionalForNullPosition() {
    Optional<Position> result = Position.fromPositionNotation(null);

    assertFalse(result.isPresent());
  }
}
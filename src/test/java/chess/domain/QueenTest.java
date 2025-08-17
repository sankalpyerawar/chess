package chess.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {
  private final Queen queen = new Queen();

  @Test
  void shouldReturnAllMovesFromCenter() {
    Position start = new Position(4, 4);

    List<Position> moves = queen.getMoves(start);

    assertEquals(27, moves.size());
    assertTrue(moves.contains(new Position(0, 0)));
    assertTrue(moves.contains(new Position(7, 7)));
  }

  @Test
  void shouldReturnNoMovesFromInvalidPosition() {
    Position start = new Position(-1, -1);

    List<Position> moves = queen.getMoves(start);

    assertEquals(0, moves.size());
  }
}
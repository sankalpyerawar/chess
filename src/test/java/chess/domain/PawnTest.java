package chess.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {
  private final Pawn pawn = new Pawn();

  @Test
  void shouldReturnOneForwardMoveIsValid() {
    Position start = new Position(4, 4);

    List<Position> moves = pawn.getMoves(start);

    assertEquals(1, moves.size());
    assertTrue(moves.contains(new Position(5, 4)));
  }

  @Test
  void shouldReturnNoMovesWhenForwardMoveIsInvalid() {
    Position start = new Position(7, 0);

    assertEquals(0, pawn.getMoves(start).size());
  }

}
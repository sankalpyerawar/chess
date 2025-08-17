package chess.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class KingTest {

  private final King king = new King();

  @Test
  void shouldReturnEightMovesFromCenterForKing() {
    Position start = new Position(4, 4);

    List<Position> moves = king.getMoves(start);

    assertThat(moves)
      .hasSize(8)
      .containsExactlyInAnyOrder(
        new Position(5, 4),
        new Position(3, 4),
        new Position(4, 5),
        new Position(4, 3),
        new Position(5, 5),
        new Position(5, 3),
        new Position(3, 5),
        new Position(3, 3)
      );
  }

  @Test
  void shouldReturnThreeMovesFromTopLeftCorner() {
    Position start = new Position(0, 0);

    List<Position> moves = king.getMoves(start);

    assertThat(moves)
      .hasSize(3)
      .containsExactlyInAnyOrder(
        new Position(1, 0),
        new Position(0, 1),
        new Position(1, 1)
      );
  }

  @Test
  void shouldReturnFiveMovesFromEdge() {
    Position start = new Position(0, 4);

    List<Position> moves = king.getMoves(start);

    assertThat(moves)
      .hasSize(5)
      .containsExactlyInAnyOrder(
        new Position(0, 3),
        new Position(0, 5),
        new Position(1, 4),
        new Position(1, 3),
        new Position(1, 5)
      );
  }
}

package chess.applications;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ChessServiceTest {
  private final ChessService chessService = new ChessService();

  @Test
  void shouldReturnErrorWhenInputFormatIsInvalid() {
    assertEquals(
      "Error: Invalid input. Format: <Piece>, <Position>",
      chessService.getMovesForInput("King-D5")
    );
  }

  @Test
  void shouldReturnErrorWhenPieceTypeIsInvalid() {
    assertEquals(
      "Error: Given piece type is invalid : Snake",
      chessService.getMovesForInput("Snake, D5")
    );
  }

  @Test
  void shouldReturnErrorWhenPositionIsInvalid() {
    assertEquals(
      "Error: Given starting position is invalid : Z9",
      chessService.getMovesForInput("King, Z9")
    );
  }

  @Test
  void shouldReturnNoValidMovesWhenPieceBlocked() {
    assertEquals(
      "No valid moves for Pawn from H8",
      chessService.getMovesForInput("Pawn, H8")
    );
  }

  @Test
  void shouldReturnMovesWhenValidPieceAndPosition() {
    String result = chessService.getMovesForInput("King, D5");
    assertThat(result).startsWith("Possible moves:");
    assertThat(result).contains("C4").contains("E6");
  }
}
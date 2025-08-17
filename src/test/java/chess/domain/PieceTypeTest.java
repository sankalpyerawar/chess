package chess.domain;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PieceTypeTest {
  @Test
  void shouldMatchValidPieceNamesIgnoringCase() {
    assertEquals(Optional.of(PieceType.KING), PieceType.fromString("king"));
    assertEquals(Optional.of(PieceType.QUEEN), PieceType.fromString("Queen"));
    assertEquals(Optional.of(PieceType.PAWN), PieceType.fromString("PAWN"));
  }

  @Test
  void shouldMatchValidPieceNamesAfterTrimming() {
    assertEquals(Optional.of(PieceType.KING), PieceType.fromString("  King  "));
  }

  @Test
  void shouldReturnEmptyOptionalForInvalidPieceNames() {
    assertEquals(Optional.empty(), PieceType.fromString(""));
    assertEquals(Optional.empty(), PieceType.fromString("invalid"));
    assertEquals(Optional.empty(), PieceType.fromString("Kign"));
    assertEquals(Optional.empty(), PieceType.fromString(null));
  }
}
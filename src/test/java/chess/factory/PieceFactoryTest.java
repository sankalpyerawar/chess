package chess.factory;

import chess.domain.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PieceFactoryTest {

  @Test
  void shouldCreatePawn() {
    Piece piece = PieceFactory.createPiece(PieceType.PAWN);

    assertNotNull(piece);
    assertInstanceOf(Pawn.class, piece);
  }

  @Test
  void shouldCreateKing() {
    Piece piece = PieceFactory.createPiece(PieceType.KING);

    assertNotNull(piece);
    assertInstanceOf(King.class, piece);
  }

  @Test
  void shouldCreateQueen() {
    Piece piece = PieceFactory.createPiece(PieceType.QUEEN);

    assertNotNull(piece);
    assertInstanceOf(Queen.class, piece);
  }
}
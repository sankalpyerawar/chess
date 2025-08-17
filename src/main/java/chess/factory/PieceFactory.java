package chess.factory;

import chess.domain.*;

public class PieceFactory {
  public static Piece createPiece(PieceType type) {
    return switch (type) {
      case PAWN -> new Pawn();
      case KING -> new King();
      case QUEEN -> new Queen();
    };
  }

  private PieceFactory() {}
}

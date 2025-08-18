package chess.applications;

import chess.domain.Piece;
import chess.domain.PieceType;
import chess.domain.Position;
import chess.factory.PieceFactory;
import chess.utils.ErrorMessages;

import java.util.List;

public class ChessService {
  public String getMovesForInput(String input) {
    try {
      String[] parts = parseInput(input);
      String pieceType = parts[0].trim();
      String startingPosition = parts[1].trim().toUpperCase();

      Piece piece = parsePiece(pieceType);
      Position position = parsePosition(startingPosition);

      List<Position> moves = piece.getMoves(position);
      if (moves.isEmpty()) {
        return String.format(ErrorMessages.NO_VALID_MOVES, pieceType, startingPosition);
      }

      return printMoves(moves);

    } catch (IllegalArgumentException e) {
      return String.format(ErrorMessages.ERROR, e.getMessage());
    }
  }

  private String[] parseInput(String input) {
    String[] parts = input.split(",");
    if (parts.length != 2) {
      throw new IllegalArgumentException(ErrorMessages.INVALID_INPUT_FORMAT);
    }
    return parts;
  }

  private Piece parsePiece(String pieceType) {
    return PieceType.fromString(pieceType)
      .map(PieceFactory::createPiece)
      .orElseThrow(() -> new IllegalArgumentException(
        String.format(ErrorMessages.INVALID_PIECE_TYPE, pieceType)));
  }

  private Position parsePosition(String positionNotation) {
    return Position.fromPositionNotation(positionNotation)
      .orElseThrow(() -> new IllegalArgumentException(
        String.format(ErrorMessages.INVALID_POSITION, positionNotation)));
  }

  private String printMoves(List<Position> moves) {
    return "Possible moves: " + String.join(", ",
      moves.stream().map(Position::toPositionNotation).toList());
  }
}

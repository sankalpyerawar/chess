package chess.utils;

public final class ErrorMessages {
  public static final String INVALID_INPUT_FORMAT =
    "Invalid input. Format: <Piece>, <Position>";

  public static final String INVALID_PIECE_TYPE =
    "Given piece type is invalid : %s";

  public static final String INVALID_POSITION =
    "Given starting position is invalid : %s";

  public static final String NO_VALID_MOVES =
    "No valid moves for %s from %s";

  public static final String ERROR = "Error: %s";

  private ErrorMessages() {
  }
}


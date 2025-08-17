package chess.domain;

import java.util.Arrays;
import java.util.Optional;

public enum PieceType {
  PAWN,
  KING,
  QUEEN;

  public static Optional<PieceType> fromString(String input) {
    if (input == null) return Optional.empty();
    return Arrays.stream(values())
      .filter(p -> p.name().equalsIgnoreCase(input.trim()))
      .findFirst();
  }
}


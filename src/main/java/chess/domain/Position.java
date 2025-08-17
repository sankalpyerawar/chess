package chess.domain;

import java.util.Optional;

public record Position(int row, int col) {
  private static final int MIN = 0;
  private static final int MAX = 7;
  private static final String COLUMNS = "ABCDEFGH";

  public boolean isValid() {
    return row >= MIN && row <= MAX && col >= MIN && col <= MAX;
  }

  public Position move(Step step) {
    return new Position(row + step.rowStep(), col + step.colStep());
  }

  public static String toPositionNotation(Position position) {
    return COLUMNS.charAt(position.col()) + String.valueOf(position.row() + 1);
  }

  public static Optional<Position> fromPositionNotation(String cell) {
    if (cell == null || cell.length() != 2) {
      return Optional.empty();
    }

    char colChar = cell.charAt(0);
    char rowChar = cell.charAt(1);

    int col = COLUMNS.indexOf(colChar);
    if (col == -1) {
      return Optional.empty();
    }

    int row = Character.getNumericValue(rowChar) - 1;
    Position position = new Position(row, col);
    if (!position.isValid()) {
      return Optional.empty();
    }

    return Optional.of(position);
  }
}

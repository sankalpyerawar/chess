package chess.domain;

public record Position(int row, int col) {
  private static final int MIN = 0;
  private static final int MAX = 7;

  public boolean isValid() {
    return row >= MIN && row <= MAX && col >= MIN && col <= MAX;
  }

  public Position move(Step step) {
    return new Position(row + step.rowStep(), col + step.colStep());
  }
}

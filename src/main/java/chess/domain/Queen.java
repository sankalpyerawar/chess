package chess.domain;

public class Queen extends King {
  @Override
  protected boolean isRepeating() {
    return true;
  }
}

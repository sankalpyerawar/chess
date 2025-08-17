package chess.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
  protected abstract List<Step> getPieceSteps();

  protected abstract boolean isRepeating();

  public List<Position> getMoves(Position position) {
    if (!position.isValid()) { return List.of();}

    List<Position> moves = new ArrayList<>();
    boolean repeating = isRepeating();

    for (Step step : getPieceSteps()) {
      Position nextPosition = position.move(step);

      while (nextPosition.isValid()) {
        moves.add(nextPosition);
        if (!repeating) {
          break;
        }
        nextPosition = nextPosition.move(step);
      }
    }
    return moves;
  }
}

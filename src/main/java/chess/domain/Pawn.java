package chess.domain;

import java.util.List;

public class Pawn extends Piece {
  private static final List<Step> POSSIBLE_STEPS = List.of(
    new Step(1, 0)
  );

  @Override
  protected List<Step> getPieceSteps() {
    return POSSIBLE_STEPS;
  }

  @Override
  protected boolean isRepeating() {
    return false;
  }
}

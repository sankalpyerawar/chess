package chess.domain;

import java.util.List;

public class King extends Piece {
  private static final List<Step> POSSIBLE_STEPS = List.of(
    new Step(1, 0),
    new Step(-1, 0),
    new Step(0, 1),
    new Step(0, -1),
    new Step(1, 1),
    new Step(1, -1),
    new Step(-1, 1),
    new Step(-1, -1)
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

# Chess Application

A simple console-based Chess application built in Java.  
The application allows you to enter a chess piece type and a board position, and it returns the possible moves for that piece from the given position.

---

## Assumptions
To keep the application simple, the following assumptions are made:
- The board is fixed to standard 8x8 chess board size.
- Input format is strictly `PieceType, Position` and case-insensitive.
- The application only calculates possible moves for a single piece from a position.
- Application is built for current set of rules only, other chess rules which are not part of problem statement are not considered.
- Colored Pieces are not considered

---

## How to Run

```shell

  ./gradlew run --console=plain -q
  
```
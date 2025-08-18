package chess.applications;

import java.util.Scanner;

import static java.lang.System.*;

public class ChessApplication {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(in);
    out.print("Enter piece and position: ");
    String input = scanner.nextLine().trim();
    scanner.close();

    ChessService service = new ChessService();
    String output = service.getMovesForInput(input);

    out.println(output);
  }
}

package edu.grinnell.csc207;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import edu.grinnell.csc207.blocks.Boxed;
import edu.grinnell.csc207.blocks.ChessBoard;


/**
 * Tests of the new block.
 * 
 * @author Ben Sheeley
 * @author Myles Bohrer-Purnell
 */
public class TestNewBlock {
  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  @Test
  public void testChess() throws Exception {
    assertEquals("X\n", TestUtils.toString(new ChessBoard("X", 1, 1)),
        "R: 1x1 ChessBoard");
    assertEquals("""
                 Y Y
                  Y 
                 """,
        TestUtils.toString(new ChessBoard("Y", 3, 2)),
        "R: 3x2 ChessBoard");
  } // testRect()

  @Test
  public void testBoxed() throws Exception {
    assertEquals("/----\\\n" + //
                  "|x x |\n" + //
                  "| x x|\n" + //
                  "|x x |\n" + //
                  "| x x|\n" + //
                  "\\----/\n" ,
                  TestUtils.toString(new Boxed(new ChessBoard("x", 4, 4))));
  }


  @Test
  public void testEmpty() throws Exception {
    assertEquals("/----\\\n" + //
                  "|    |\n" + //
                  "|    |\n" + //
                  "|    |\n" + //
                  "|    |\n" + //
                  "\\----/\n" ,
        TestUtils.toString(new Boxed(new ChessBoard(" ", 4, 4))),
        "4x4  Blank Boxed ChessBoard");


    assertEquals(" \n", TestUtils.toString(new ChessBoard(" ", 1, 1)), "1 x 1 Blank Chessboard");

  }
} // class TestNewBlock

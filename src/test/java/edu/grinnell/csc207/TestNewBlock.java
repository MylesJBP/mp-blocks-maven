package edu.grinnell.csc207;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import edu.grinnell.csc207.blocks.ChessBoard;
import edu.grinnell.csc207.blocks.Rect;
import edu.grinnell.csc207.blocks.Boxed;


/**
 * Tests of the new block.
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
} // class TestNewBlock

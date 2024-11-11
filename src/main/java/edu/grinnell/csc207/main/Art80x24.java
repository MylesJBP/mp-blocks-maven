package edu.grinnell.csc207.main;

import java.io.PrintWriter;

import edu.grinnell.csc207.blocks.AsciiBlock;
import edu.grinnell.csc207.blocks.Boxed;
import edu.grinnell.csc207.blocks.HAlignment;
import edu.grinnell.csc207.blocks.HComp;
import edu.grinnell.csc207.blocks.HFlip;
import edu.grinnell.csc207.blocks.Line;
import edu.grinnell.csc207.blocks.Rect;
import edu.grinnell.csc207.blocks.VAlignment;
import edu.grinnell.csc207.blocks.VComp;
import edu.grinnell.csc207.blocks.VFlip;

/**
 * Create and print an amazing 80x24 ASCII artwork.
 *
 * @author Your Name Here
 * @author Your Name Here
 */
public class Art80x24 {
  /**
   * Create the artwork.
   *
   * @param args
   *   Command-line arguments (currently ignored).
   *
   * @exception Exception
   *   If something goes wrong with one of the underlying classes.
   */
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);

    AsciiBlock outsideRect31 = new Rect('#', 1, 3);
    AsciiBlock outsideRect32 = new Rect('%', 1, 3);

    AsciiBlock outsideRect21 = new Rect('#', 1, 5);
    AsciiBlock outsideRect22 = new Rect('%', 1, 5);

    AsciiBlock outsideRect11 = new Rect('#', 3, 7);
    AsciiBlock outsideRect12 = new Rect('%', 3, 7);

    AsciiBlock midRect1 = new Rect('#', 3, 9);
    AsciiBlock midRect2 = new Rect('%', 3, 9);
    AsciiBlock insideLine = new Line("*".repeat(7));
    AsciiBlock midPiece = new VComp(HAlignment.CENTER, new AsciiBlock[]
          {insideLine, midRect1, insideLine});
    AsciiBlock midPiece2 = new VComp(HAlignment.CENTER, new AsciiBlock[]
          {insideLine, midRect2, insideLine});
    AsciiBlock halfCircle1 = new HComp(VAlignment.CENTER, new AsciiBlock[]
          {outsideRect31, outsideRect21, outsideRect11, midPiece});
    AsciiBlock revHalfCircle1 = new HFlip(halfCircle1);
    AsciiBlock halfCircle2 = new HComp(VAlignment.CENTER, new AsciiBlock[]
          {outsideRect32, outsideRect22, outsideRect12, midPiece2});
    AsciiBlock revHalfCircle2 = new HFlip(halfCircle2);
    // create a 19x11 circle
    AsciiBlock circle1 = new HComp(VAlignment.CENTER, new AsciiBlock[]
          {halfCircle1, revHalfCircle1});
    AsciiBlock circle2 = new HComp(VAlignment.CENTER, new AsciiBlock[]
          {halfCircle2, revHalfCircle2});
    AsciiBlock stackCircle = new VComp(HAlignment.CENTER, new AsciiBlock[]
          {circle1, circle2});
    AsciiBlock stackCircleFlip = new VFlip(stackCircle);
    AsciiBlock preArt = new HComp(VAlignment.CENTER, new AsciiBlock[]
          {stackCircle, stackCircleFlip});
    AsciiBlock art = new Boxed(preArt);
    AsciiBlock.print(pen, art);
    pen.close();
  } // main(String[])
} // class Art80x24

package edu.grinnell.csc207.blocks;

/**
 * A mutable rectangular block of one repeated character.
 *
 * @author Samuel A. Rebelsky
 */
public class ChessBoard implements AsciiBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * One row of the rectangle.
   */
  String row;

  /**
   * The height of the rectangle.
   */
  int height;

    /**
   * The width of the rectangle.
   */
  int width;

   /**
   * Board spcae character
   */
  String ch;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a ChessBoard.
   *
   * @param ch
   *   The character from which we build the rectangle.
   *
   * @param chessWidth
   *   The width of the rectangle.
   *
   * @param chessHeight
   *   The height of the rectangle.
   */
  public ChessBoard(String ch, int chessWidth, int chessHeight)
      throws Exception {
    // Sanity check
    if (chessWidth <= 0) {
      throw new Exception("ChessBoard width must be positive");
    } else if (chessHeight <= 0) {
      throw new Exception("ChessBoard height must be positive");
    } // if/else
    // Set up the fields
    this.height = chessHeight;
    this.width = chessWidth;
    this.ch = ch;
  } // Rect(String)

  // +--------------------+------------------------------------------
  // | AsciiBlock methods |
  // +--------------------+

  /**
   * Get one row from the block.
   *
   * @param i the number of the row
   *
   * @return row i.
   *
   * @exception Exception
   *   if i is outside the range of valid rows.
   */
  public String row(int i) throws Exception {
    if ((i < 0) || (i >= this.height())) {
      throw new Exception("Invalid row " + i);
    } // if
    if(this.width() == 1){
      if(i % 2 == 0){
      this.row = ch;
      } else{
        this.row = " ";
      } // else
    } else if(i % 2 == 0){
      if (this.width() % 2 == 0) {
        this.row = new String(ch.toString() + " ").repeat(this.width()/2);
      } else{
        this.row = new String(ch + " ").repeat(this.width()/2) + ch;
      } // else
    } else{
        this.row = new String(" " + ch).repeat(this.width()/2);
    } // else 
    return this.row;
  } // row(int)

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  public int height() {
    return this.height;
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the number of columns
   */
  public int width() {
    return this.width;
  } // width()

  /**
   * Determine if another block is structurally equivalent to this block.
   *
   * @param other
   *   The block to compare to this block.
   *
   * @return true if the two blocks are structurally equivalent and
   *    false otherwise.
   */
  public boolean eqv(AsciiBlock other) {
    if (other instanceof ChessBoard) {
      if (AsciiBlock.eq(other, this)) {
        return true;
      }
      else {
        return false;
      }
    }
    else {
      return false;
    }     // STUB
  } // eqv(AsciiBlock)
} // class Rect


package edu.grinnell.csc207.blocks;

import java.util.Arrays;

/**
 * The horizontal composition of blocks.
 *
 * @author Samuel A. Rebelsky
 * @author Ben Sheeley
 * @author Myles Bohrer-Purnell
 */
public class HComp implements AsciiBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The blocks.
   */
  AsciiBlock[] blocks;

  /**
   * How the blocks are aligned.
   */
  VAlignment align;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a horizontal composition of two blocks.
   *
   * @param alignment
   *   The way in which the blocks should be aligned.
   * @param leftBlock
   *   The block on the left.
   * @param rightBlock
   *   The block on the right.
   */
  public HComp(VAlignment alignment, AsciiBlock leftBlock,
      AsciiBlock rightBlock) {
    this.align = alignment;
    this.blocks = new AsciiBlock[] {leftBlock, rightBlock};
  } // HComp(VAlignment, AsciiBlock, AsciiBlock)

  /**
   * Build a horizontal composition of multiple blocks.
   *
   * @param alignment
   *   The alignment of the blocks.
   * @param blocksToCompose
   *   The blocks we will be composing.
   */
  public HComp(VAlignment alignment, AsciiBlock[] blocksToCompose) {
    this.align = alignment;
    this.blocks = Arrays.copyOf(blocksToCompose, blocksToCompose.length);
  } // HComp(Alignment, AsciiBLOCK[])

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

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
    String resultString = "";
    int diffHeight;
    int diffHeightCheck;
    if (this.align == VAlignment.CENTER) {
      // go through each AsciiBlock in blocks
      for (int j = 0; j < this.blocks.length; j++) {
        // get difference of AsciiBlock height and composed block height
        diffHeight = (this.height() - this.blocks[j].height()) / 2;
        diffHeightCheck = this.height() - this.blocks[j].height();
        // check if difference is even
        if (diffHeightCheck % 2 == 0) {
          // if the element would be in the center given the differences in height
          if (i >= diffHeight && i < (this.height() - (diffHeight))) {
            // print element row
            resultString = resultString.concat(this.blocks[j].row(i - diffHeight));
          } else {
            // else print blank lines
            resultString = resultString.concat(" ".repeat(blocks[j].width()));
          } // else
        } else {
          if (i >= diffHeight && i < (this.height() - (diffHeight + 1))) {
            resultString = resultString.concat(this.blocks[j].row(i - diffHeight));
          } else {
            resultString = resultString.concat(" ".repeat(blocks[j].width()));
          } // else
        } // if/else
      } // for
    } else if (this.align == VAlignment.TOP) {
      for (int j = 0; j < this.blocks.length; j++) {
        if (i < this.blocks[j].height()) {
          resultString = resultString.concat(this.blocks[j].row(i));
        } else {
          resultString = resultString.concat(" ".repeat(blocks[j].width()));
        } // else
      } // for
    } else if (this.align == VAlignment.BOTTOM) {
      for (int j = 0; j < this.blocks.length; j++) {
        diffHeight = this.height() - this.blocks[j].height();
        if (i >= diffHeight) {
          resultString = resultString.concat(this.blocks[j].row(i - diffHeight));
        } else {
          resultString = resultString.concat(" ".repeat(blocks[j].width()));
        } // else
      } // for
    } // else if
    return resultString;
  } // row(int)

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  public int height() {
    int maxHeight = 0;
    for (AsciiBlock block : this.blocks) {
      if (block.height() > maxHeight) {
        maxHeight = block.height();
      } // if
    } // for
    return maxHeight;
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the number of columns
   */
  public int width() {
    int blockWidth = 0;
    for (AsciiBlock block : this.blocks) {
      blockWidth += block.width();
    } // for
    return blockWidth;
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
    if (other instanceof HComp) {
      return AsciiBlock.equal(other, this);
    } else {
      return false;
    } // if/else
  } // eqv()
} // class HComp

package edu.grinnell.csc207.blocks;

import java.util.Arrays;

/**
 * The vertical composition of blocks.
 *
 * @author Samuel A. Rebelsky
 * @author Ben Sheeley
 * @author Myles Bohrer-Purnell
 */
public class VComp implements AsciiBlock {
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
  HAlignment align;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a vertical composition of two blocks.
   *
   * @param alignment
   *   The way in which the blocks should be aligned.
   * @param topBlock
   *   The block on the top.
   * @param bottomBlock
   *   ThetoString block on the bottom.
   */
  public VComp(HAlignment alignment, AsciiBlock topBlock,
      AsciiBlock bottomBlock) {
    this.align = alignment;
    this.blocks = new AsciiBlock[] {topBlock, bottomBlock};
  } // VComp(HAlignment, AsciiBlock, AsciiBlock)

  /**
   * Build a vertical composition of multiple blocks.
   *
   * @param alignment
   *   The alignment of the blocks.
   * @param blocksToCompose
   *   The blocks we will be composing.
   */
  public VComp(HAlignment alignment, AsciiBlock[] blocksToCompose) {
    this.align = alignment;
    this.blocks = Arrays.copyOf(blocksToCompose, blocksToCompose.length);
  } // VComp(HAlignment, AsciiBLOCK[])

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
    String rowStr = "";
    int heightSoFar = 0;
    if (this.align ==  HAlignment.LEFT) {
      for (int j = 0; j < this.blocks.length; j++) {
        int diff = this.width() - blocks[j].width();
        if ((blocks[j].height() + heightSoFar) - 1 >= i) {
          rowStr = rowStr.concat(blocks[j].row(i - heightSoFar)) + " ".repeat(diff);
          break;
        }
        else {
          heightSoFar += blocks[j].height();
        }
      }
    } else if (this.align == HAlignment.RIGHT) {
      for (int j = 0; j < this.blocks.length; j++) {
        int diff = this.width() - blocks[j].width();
        if ((blocks[j].height() + heightSoFar) - 1 >= i) {
          rowStr = " ".repeat(diff) + rowStr.concat(blocks[j].row(i - heightSoFar));
          break;
        }
        else {
          heightSoFar += blocks[j].height();
        }
      }
    } else if (this.align == HAlignment.CENTER) {
      for (int j = 0; j < this.blocks.length; j++) {
        int diff = this.width() - blocks[j].width();
        if ((blocks[j].height() + heightSoFar) - 1 >= i) {
          if (diff % 2 != 0){
            diff /= 2;
            rowStr = " ".repeat(diff) + rowStr.concat(blocks[j].row(i - heightSoFar)) + " ".repeat(diff + 1);
            break;
          }
          else {
            diff /= 2;
            rowStr = " ".repeat(diff) + rowStr.concat(blocks[j].row(i - heightSoFar)) + " ".repeat(diff);
            break;
          }
        }
        else {
          heightSoFar += blocks[j].height();
        }
      }
    }
    return rowStr;  // STUB
  } // row(int)



  public String getRows(AsciiBlock block) throws Exception {
    String result = "";
    for (int i = 0; i < block.height(); i++) {
        result = result.concat(block.row(i));
    } // for
    return result.toString();
  }

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  public int height() {
    int totalHeight = 0;
    for (int i = 0; i < blocks.length; i++) {
      totalHeight += blocks[i].height();
    }
    return totalHeight;   // STUB
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the number of columns
   */
  public int width() {
    int widest;
    widest = 0;
    for (int i = 0; i < this.blocks.length; i++) {
      if (this.blocks[i].width() > widest) {
        widest = this.blocks[i].width();
      }
    }
    return widest;   // STUB
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
    if (other instanceof VComp) {
      if (AsciiBlock.equal(other, this)) {
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
} // class VComp

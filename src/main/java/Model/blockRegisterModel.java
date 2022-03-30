package Model;

public class blockRegisterModel {

   public String blockModel;
   public String blockName;
   public String blockType;
   public float blockLength;
   public float blockWeight;
   public int blockCount;
   public int blockCapacity;

   public void setBlockModel (String blockModel) { this.blockModel = blockModel; }
   public void setBlockName (String blockName) { this.blockName = blockName; }
   public void setBlockType (String blockType) { this.blockType = blockType; }
   public void setBlockLength (float blockLength) { this.blockLength = blockLength; }
   public void setBlockWeight (float blockWeight) { this.blockWeight = blockWeight; }
   public void setBlockCount (int blockCount) { this.blockCount = blockCount; }
   public void setBlockCapacity(int blockCapacity) { this.blockCapacity = blockCapacity; }

  public String getBlockModel() { return blockModel; }
  public String getBlockName() { return blockName; }
  public String getBlockType() { return blockType; }
  public float getBlockLength() { return blockLength; }
  public float getBlockWeight() { return blockWeight; }
  public int getBlockCount() { return blockCount; }
  public int getBlockCapacity() { return blockCapacity; }

}

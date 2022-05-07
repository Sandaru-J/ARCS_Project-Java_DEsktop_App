package Admin.Model;

public class blockRegisterModel {


    public String BlockModel;
    public String BlockName;
    public String BlockType;
    public float BlockLength;
    public float BlockWeight;
    public int BlockCount;
    public int BlockCapacity;

    public void setBlockModel(String BlockModel){this.BlockModel=BlockModel;}
    public void setBlockName(String BlockName){this.BlockName=BlockName;}
    public void setBlockType(String BlockType){this.BlockType=BlockType;}
    public void setBlockLength(float BlockLength){this.BlockLength=BlockLength;}
    public void setBlockWeight(float BlockWeight){this.BlockWeight=BlockWeight;}
    public void setBlockCount(int BlockCount){this.BlockCount=BlockCount;}
    public void setBlockCapacity(int BlockCapacity){this.BlockCapacity=BlockCapacity;}

    public String getBlockModel() {
        return BlockModel;
    }

    public String getBlockName() {
        return BlockName;
    }

    public String getBlockType() {
        return BlockType;
    }

    public float getBlockLength() {
        return BlockLength;
    }

    public float getBlockWeight() {
        return BlockWeight;
    }

    public int getBlockCount() {
        return BlockCount;
    }

    public int getBlockCapacity() {
        return BlockCapacity;
    }
}

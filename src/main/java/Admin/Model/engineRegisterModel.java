package Admin.Model;

public class engineRegisterModel {

    public String engineName;
    public float engineCapacity;
    public String engineType;

    public void setEngineName(String engineName) { this.engineName = engineName; }
    public void setEngineCapacity(float engineCapacity) {this.engineCapacity = engineCapacity; }
    public void setEngineType(String engineType) { this.engineType = engineType; }

    public String getEngineName(){ return engineName; }
    public float getEngineCapacity(){ return engineCapacity; }
    public String getEngineType(){ return engineType; }
    
}

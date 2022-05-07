package Admin.Model;

public class adminSignupModel {

    public String adminFullName;
    public String adminUserName;
    public String adminNIC;
    public int adminContactNumber;
    public String adminEmail;
    public String adminPassword;


    public void setAdminFullName(String adminFullName) {this.adminFullName=adminFullName;}
    public void setAdminUserName(String adminUserName) {this.adminUserName=adminUserName;}
    public void setAdminadminNIC(String adminNIC) {this.adminNIC=adminNIC;}
    public void setAdminContactNumber(int adminContactNumber) {this.adminContactNumber=adminContactNumber;}
    public void setAdminEmail(String adminEmail) {this.adminEmail=adminEmail;}
    public void setAdminPassword(String adminPassword) {this.adminPassword=adminPassword;}

    public String getAdminFullName(){
        return adminFullName;
    }
    public String getAdminUserName() {
        return adminUserName;
    }
    public String getAdminNIC() {
        return adminNIC;
    }
    public int getAdminContactNumber() {
        return adminContactNumber;
    }
    public String getAdminEmail() {
        return adminEmail;
    }
    public String getAdminPassword() {
        return adminPassword;
    }
}

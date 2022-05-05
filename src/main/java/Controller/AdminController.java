package Controller;

import Model.adminSignupModel;
import Service.AdminService;

public class AdminController {

    public boolean adminSignup(String adminFullName, String adminUserName, String adminNIC, int adminContactNumber, String adminEmail, String adminPassword) {

        adminSignupModel adminSignupModel = new adminSignupModel();

        adminSignupModel.setAdminFullName(adminFullName);
        adminSignupModel.setAdminUserName(adminUserName);
        adminSignupModel.setAdminadminNIC(adminNIC);
        adminSignupModel.setAdminContactNumber(adminContactNumber);
        adminSignupModel.setAdminEmail(adminEmail);
        adminSignupModel.setAdminPassword(adminPassword);

        AdminService.adminSignup(adminSignupModel);
        return false;
    }

}

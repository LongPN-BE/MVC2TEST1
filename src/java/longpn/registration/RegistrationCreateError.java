/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longpn.registration;

import java.io.Serializable;

/**
 *
 * @author tunbe
 */
public class RegistrationCreateError implements Serializable {

    private String usernameIsExisted;
    private String usernameLengViolent;
    private String fullnameLengViolent;
    private String passwordLengViolent;
    private String confirmNotMatch;

    public RegistrationCreateError(String usernameIsExisted, String usernameLengViolent, String passwordLengViolent, String confirmNotMatch, String fullnameLengViolent) {
        this.usernameIsExisted = usernameIsExisted;
        this.usernameLengViolent = usernameLengViolent;
        this.passwordLengViolent = passwordLengViolent;
        this.confirmNotMatch = confirmNotMatch;
        this.fullnameLengViolent = fullnameLengViolent;
    }

    public RegistrationCreateError() {
    }

    public String getConfirmNotMatch() {
        return confirmNotMatch;
    }

    public void setConfirmNotMatch(String confirmNotMatch) {
        this.confirmNotMatch = confirmNotMatch;
    }

    public String getFullnameLengViolent() {
        return fullnameLengViolent;
    }

    public void setFullnameLengViolent(String fullnameLengViolent) {
        this.fullnameLengViolent = fullnameLengViolent;
    }

    public String getUsernameIsExisted() {
        return usernameIsExisted;
    }

    public void setUsernameIsExisted(String usernameIsExisted) {
        this.usernameIsExisted = usernameIsExisted;
    }

    public String getUsernameLengViolent() {
        return usernameLengViolent;
    }

    public void setUsernameLengViolent(String usernameLengViolent) {
        this.usernameLengViolent = usernameLengViolent;
    }

    public String getPasswordLengViolent() {
        return passwordLengViolent;
    }

    public void setPasswordLengViolent(String passwordLengViolent) {
        this.passwordLengViolent = passwordLengViolent;
    }

}

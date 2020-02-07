package ddns.net.data.entities;


import javax.validation.constraints.NotNull;

public class UserWithConfirmPass extends User {

    @NotNull
    private String confirm_pass;

    public String getConfirm_pass() {
        return confirm_pass;
    }

    public void setConfirm_pass(String confirm_pass) {
        this.confirm_pass = confirm_pass;
    }
}

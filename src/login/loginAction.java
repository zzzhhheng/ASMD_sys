package login;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class loginAction implements Action {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }


    @Override
    public String execute() throws Exception {
        ActionContext ac=ActionContext.getContext();
        //把登录名保存到application中
        ac.getApplication().put("username",getUsername());
        ac.getApplication().put("password",getPassword());
        return SUCCESS;
    }
}

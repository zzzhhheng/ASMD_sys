package login;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class loginAction implements Action {
    private String username;
    private String password;
    //登录统计用户数量
    int loginNumber=0;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String execute() throws Exception {
        ActionContext ac=ActionContext.getContext();
        //把登录名保存到application中
        ac.getApplication().put("userName",getUsername());
        return SUCCESS;
    }
}

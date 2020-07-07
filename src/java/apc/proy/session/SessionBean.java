/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apc.proy.session;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

/**
 *
 * @author desa
 */
@Named(value = "sessionBean")
@SessionScoped
public class SessionBean implements Serializable {

    String user;
    String userid;

    @PostConstruct
    public void init() {
        HttpSession session = SessionUtils.getSession();

        this.user = (String) session.getAttribute("username");
        this.userid = (String) session.getAttribute("userid");

        // int x=1;
    }

    public SessionBean() {
    }

    public String getUser() {
        return user;
    }

    public String getUserid() {
        return userid;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import model.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
/**
 *
 * @author MarkoMB
 */
@ManagedBean
@SessionScoped
public class Login implements Serializable{

    @PersistenceContext(unitName = "CS230-ProjekatPU")
    private EntityManager em;
      boolean admin = false;



    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    private String userUsername;
    private String userPassword;
    private boolean loggedIn = false;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }



    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    //validate login
    public String login() {
        User user = null;
        boolean valid;

        try {
            user = (User) em.createNamedQuery("User.findByUsername").setParameter("username", userUsername).getSingleResult();
            valid = validateUser(user);
        } catch (NoResultException e) {
            valid = false;
        }

        if (valid) {
            HttpSession session = SessionUtils.getSession();

            session.setAttribute("data", user);
            loggedIn = true;
            if (userUsername.equalsIgnoreCase("marko")){
                admin=true;
            }
            return "index";




        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Uneti podaci nisu ispravni.",
                            "Molimo Vas da proverite podatke i pokušate ponovo."));
            return "Login";
        }
    }

    private boolean validateUser(User user) {
        System.out.println("STAGOD" + user.toString());;
        if (userUsername.equalsIgnoreCase(user.getUsername()) && userPassword.equals(user.getPassword())) {
            return true;
        }

        return false;
    }

    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "/index";
    }

    public User korisnikId(){
       HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);


        return (User) session.getAttribute("data");
    }


     public int userId(){
       HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);

       User s = (User) session.getAttribute("data");
       s.getId();

     int id = s.getId();

        return id;
    }


}

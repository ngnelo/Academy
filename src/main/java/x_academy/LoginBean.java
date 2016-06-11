package x_academy;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable
{
   /**
    * 
    */
   private static final long serialVersionUID = -3552591680693218012L;

   private String name;

   private String password;

   public String getPassword()
   {
      return password;
   }

   public String getName()
   {
      return name;
   }

   public void setPassword(String password)
   {
      this.password = password;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   // validate login
   public String validateUsernamePassword()
   {
      if(name.equals("admin") && password.equals("admin"))
      {
         HttpSession session = SessionBean.getSession();
         session.setAttribute("username", name);
         // System.out.println(session.getAttribute("userid").toString());
         System.out.println(session.getAttribute("username").toString());
         return "menu";
      }
      else
      {
         System.out.println("the pasword or user is not set");
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Incorrect Username and Passowrd",
               "Please enter correct username and Password"));
         return "index";
      }
   }

   // logout event, invalidate session
   public String logout()
   {
      HttpSession session = SessionBean.getSession();
      session.invalidate();
      return "index";
   }
}

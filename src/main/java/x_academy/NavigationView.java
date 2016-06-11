package x_academy;

import javax.faces.bean.ManagedBean;
 
@ManagedBean
public class NavigationView {
 
    public String gotoSecond() {
        return "pm:second";
    }
}
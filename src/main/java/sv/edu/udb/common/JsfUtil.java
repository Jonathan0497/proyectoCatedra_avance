package sv.edu.udb.common;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.servlet.http.HttpServletRequest;
public class JsfUtil {
    public static void setErrorMessage(final String idClient, final
    String msg) {
        FacesMessage mensaje = new
                FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);

        FacesContext.getCurrentInstance().addMessage(idClient,
                mensaje);
    }
    /*Este método permite definir un mensaje de tipo flash (mensaje que
    se elimina de forma automatica en cuanto una vista lo muestre)*/
    public static void setFlashMessage(final String name, final String
            msg) {
        FacesContext.getCurrentInstance().getExternalContext()
                .getFlash().put(name, msg);
    }
    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
    }
}

package AppGestion;

public class Mensaje {
    private String mensaje;
    private String asunto;

    public Mensaje(String mensaje, String asunto) {
        this.mensaje = mensaje;
        this.asunto = asunto;
    }
    
    public String getAsunto() {
        return asunto;
    }
    
    public String getMensaje() {
        return mensaje;
    }
    
}

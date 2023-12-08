package AppGestion;

public class Transferencia {
    private String destinatario;
    private String remitente;

    public Transferencia(String destinatario, String remitente) {
        this.destinatario = destinatario;
        this.remitente = remitente;
    }
    
    public String getDestinatario() {
        return destinatario;
    }
    
    public String getRemitente() {
        return remitente;
    }
}

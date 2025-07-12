package tp.esgis.org.gestionpresence.model;

public class PresenceRequest {
    private  int idEtudiant;
    private int idCours;
    private boolean present;
    private String datePresence;

    public PresenceRequest() {
    }

    public String getDatePresence() {
        return datePresence;
    }

    public void setDatePresence(String datePresence) {
        this.datePresence = datePresence;
    }

    public int getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public int getIdCours() {
        return idCours;
    }

    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }
}

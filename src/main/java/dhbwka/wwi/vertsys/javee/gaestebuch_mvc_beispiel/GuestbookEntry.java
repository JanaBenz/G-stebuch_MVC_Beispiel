package dhbwka.wwi.vertsys.javee.gaestebuch_mvc_beispiel;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
* Persistenzklasse für einen Gästebucheintrag.
*/
@Entity
public class GuestbookEntry implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name = "";
    private Date visitDate = new Date(System.currentTimeMillis());
    private Time visitTime = new Time(System.currentTimeMillis());

    public GuestbookEntry() {
    }

    public GuestbookEntry(String name) {
        this.name = name;
    }

    //<editor-fold defaultstate="collapsed" desc="Setter und Getter">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Time getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Time visitTime) {
        this.visitTime = visitTime;
    }
    //</editor-fold>
}
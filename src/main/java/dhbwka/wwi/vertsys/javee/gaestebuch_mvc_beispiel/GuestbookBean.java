/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.vertsys.javee.gaestebuch_mvc_beispiel;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Enterprise Java Bean zum Auslesen und Speichern von Gästebucheinträgen.
 */
@Stateless
public class GuestbookBean {

    @PersistenceContext
    EntityManager em;

    /**
     * @return Liste mit allen Gästebucheinträgen
     */
    public List<GuestbookEntry> findAllEntries() {
        return em.createQuery("SELECT e FROM GuestbookEntry e "
                            + "  ORDER BY e.visitDate DESC, "
                            + "           e.visitTime DESC")
                .getResultList();
    }

    /**
     * Speichert einen neuen Gästebucheintrag.
     * @param name Name des Besuchers
     * @return Der gespeicherte Eintrag
     */
    public GuestbookEntry createNewEntry(String name) {
        GuestbookEntry entry = new GuestbookEntry(name);
        em.persist(entry);
        return em.merge(entry);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Banque;

import Controllers.AbstractFacade;
import Entites.Banque.ClientBanque;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author PJES465
 */
@Stateless
public class ClientBanqueFacade extends AbstractFacade<ClientBanque> implements ClientBanqueFacadeLocal {
    @PersistenceContext(unitName = "PrestaZone-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientBanqueFacade() {
        super(ClientBanque.class);
    }
    
    @Override
    public long chercherClient(String nom, String prenom) throws Exceptions.ClientInconnuException {
        try {
            Query q = em.createQuery(
               "select c from Client c where c.nom = :nom and c.prenom = :prenom");
            q.setParameter("nom", nom);
            q.setParameter("prenom", prenom);
            ClientBanque c = (ClientBanque) q.getSingleResult();
            return c.getId();
        } catch(NoResultException e) {
            throw new Exceptions.ClientInconnuException();
        }
    }
    
}

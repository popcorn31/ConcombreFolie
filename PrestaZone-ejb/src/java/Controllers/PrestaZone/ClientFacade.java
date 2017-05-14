/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.PrestaZone;

import Controllers.AbstractFacade;
import Entites.PrestaZone.Client;
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
public class ClientFacade extends AbstractFacade<Client> implements ClientFacadeLocal {
    @PersistenceContext(unitName = "PrestaZone-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() 
    {
        super(Client.class);
    }
    
    @Override
    public long chercherClient(String nom, String prenom) throws Exceptions.ClientInconnuException {
        try {
            Query q = em.createQuery(
               "select c from Client c where c.nom = :nom and c.prenom = :prenom");
            q.setParameter("nom", nom);
            q.setParameter("prenom", prenom);
            Client c = (Client) q.getSingleResult();
            return c.getId();
        } catch(NoResultException e) {
            throw new Exceptions.ClientInconnuException();
        }
    }

    @Override
    public Client authentification(String p_login, String p_mp) throws Exceptions.ClientInconnuException
    {
        try {
            Query q = em.createQuery(
               "select c from Client c where c.login = :p_login and c.mp = :mp ");
            q.setParameter("login", p_login);
            q.setParameter("mp", p_mp);
            Client c = (Client) q.getSingleResult();
            return c ;
        } catch(NoResultException e) {
            throw new Exceptions.ClientInconnuException();
        }
    }
    
}

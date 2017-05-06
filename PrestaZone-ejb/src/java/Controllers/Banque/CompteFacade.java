/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Banque;

import Controllers.AbstractFacade;
import Entites.Banque.Compte;
import Exceptions.SoldeInsuffisantException;
import Services.Position;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PJES465
 */
@Stateless
public class CompteFacade extends AbstractFacade<Compte> implements CompteFacadeLocal {
    @PersistenceContext(unitName = "PrestaZone-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompteFacade() {
        super(Compte.class);
    }
    
    @Override
    public void crediter(Compte c, float somme) {
        c.setSolde(c.getSolde()+somme);
    }

    @Override
    public void debiter(Compte c, float somme)  throws SoldeInsuffisantException{
        c.setSolde(c.getSolde() - somme);
    }

    @Override
    public void virementplus(Compte c, float somme) {
        c.setSolde(c.getSolde() + somme);
    }

    @Override
    public void virementmoins(Compte c, float somme)  throws SoldeInsuffisantException{
         c.setSolde(c.getSolde() - somme);
    }

    @Override
    public Position consulter(Compte c) {
        return new Position(c.getId(), c.getSolde(),new Date());
    }

    @Override
    public void cloturer(Compte c) {
        c.setCloture(true);
    }
}

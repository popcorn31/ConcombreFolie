/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metiers.Banque;

import Controllers.Banque.CompteFacadeLocal;
import Controllers.Banque.OperationFacadeLocal;
import Entites.Banque.Compte;
import Entites.Banque.Operation;
import Services.Position;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Charlie
 */
@Stateless
public class GestionComptes implements GestionComptesLocal {

    @EJB
    private OperationFacadeLocal operationFacade;

    @EJB
    private CompteFacadeLocal compteFacade;

    @Override
    public void ajouter(long idCompte, float somme) throws Exceptions.CompteInconnuException {
        Compte c = compteFacade.find(idCompte);
        if (c == null)
            throw new Exceptions.CompteInconnuException();
        c.setSolde(c.getSolde()+somme);
        Operation op = new Operation();
        op.setLeCompte(c);
        op.setType("CREDIT");
        op.setSomme(somme);
        op.setDate(new Date());
        operationFacade.create(op);
    }

    @Override
    public void retirer(long idCompte, float somme)  throws Exceptions.CompteInconnuException, Exceptions.SoldeInsuffisantException {
        Compte c = compteFacade.find(idCompte);
        if (c == null)
            throw new Exceptions.CompteInconnuException();
        if (c.getSolde() < somme)
            throw new Exceptions.SoldeInsuffisantException();
        
        c.setSolde(c.getSolde()-somme);
        Operation op = new Operation();
        op.setLeCompte(c);
        op.setType("DEBIT");
        op.setSomme(somme);
        op.setDate(new Date());
        operationFacade.create(op);
    }
    
    @Override
    public Position position(long idCompte) throws Exceptions.CompteInconnuException {
        Compte c = compteFacade.find(idCompte);
        if (c == null)
            throw new Exceptions.CompteInconnuException();
        Position p = new Position();
        p.setIdCompte(idCompte);
        p.setDate(new Date());
        p.setSolde(c.getSolde());
        return p;
    }
    
}


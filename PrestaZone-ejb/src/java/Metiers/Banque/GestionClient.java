/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metiers.Banque;

import Controllers.Banque.ClientBanqueFacadeLocal;
import Controllers.Banque.CompteFacadeLocal;
import Entites.Banque.ClientBanque;
import Entites.Banque.Compte;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Charlie
 */
@Stateless
public class GestionClient implements GestionClientLocal {

    @EJB
    private CompteFacadeLocal compteFacade;

    @EJB
    private ClientBanqueFacadeLocal clientFacade;
    

    @Override
    public ClientBanque creerClient(String nom, String prenom) throws Exceptions.ClientExistantException {
        try {
            // si le client n'existe pas il y aura une exception
            clientFacade.chercherClient(nom, prenom);
            // ici on est sûr qu'il existe donc on lance l'exception
            throw new Exceptions.ClientExistantException();
        } catch (Exceptions.ClientInconnuException e) {
        }
        ClientBanque c = new ClientBanque ();
        c.setNom(nom);
        c.setPrenom(prenom);
        clientFacade.create(c);
        return c ;
    }

    @Override
    public long chercherClient(String nom, String prenom) throws Exceptions.ClientInconnuException {
        return clientFacade.chercherClient(nom, prenom);
    }

    @Override
    public List<Long> listeNumComptes(long idClient)  throws Exceptions.ClientInconnuException {
        ClientBanque c = this.clientFacade.find(idClient);
        if (c == null)
            throw new Exceptions.ClientInconnuException();
        ArrayList<Long> listeNC = new ArrayList<Long>();
        for (Compte compte : c.getLesComptes()) {
            listeNC.add(compte.getId());
        }
        return listeNC;
    }

    @Override
    public Compte creerCompte(long idClient) throws Exceptions.ClientInconnuException  {
        ClientBanque c = this.clientFacade.find(idClient);
        if (c == null)
            throw new Exceptions.ClientInconnuException();
        Compte compte = new Compte();
        compte.setLeClient(c);
        c.getLesComptes().add(compte);
        compteFacade.create(compte);
        return compte ;
    }
    
    
    
}


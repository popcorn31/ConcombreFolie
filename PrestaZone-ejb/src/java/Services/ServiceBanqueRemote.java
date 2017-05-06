/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Charlie
 */
@Remote
public interface ServiceBanqueRemote {
    long creerClient(String nom, String prenom) throws Exceptions.ClientExistantException;

    long chercherClient(String nom, String prenom) throws Exceptions.ClientInconnuException;

    List<Long> listeNumComptes(long idClient) throws Exceptions.ClientInconnuException;

    long creerCompte(long idClient) throws Exceptions.ClientInconnuException;
    
    public void ajouter(long idCompte, float somme) throws Exceptions.CompteInconnuException;

    public void retirer(long idCompte, float somme) throws Exceptions.CompteInconnuException, Exceptions.SoldeInsuffisantException;
    
    public Position position(long idCompte) throws Exceptions.CompteInconnuException;
}

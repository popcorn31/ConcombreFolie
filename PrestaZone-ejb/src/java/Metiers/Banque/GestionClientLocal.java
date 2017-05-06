/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metiers.Banque;

import Entites.Banque.ClientBanque;
import Entites.Banque.Compte;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Charlie
 */
@Local
public interface GestionClientLocal {

    ClientBanque creerClient(String nom, String prenom) throws Exceptions.ClientExistantException;

    long chercherClient(String nom, String prenom) throws Exceptions.ClientInconnuException;

    List<Long> listeNumComptes(long idClient) throws Exceptions.ClientInconnuException;

    Compte creerCompte(long idClient) throws Exceptions.ClientInconnuException;
    
}

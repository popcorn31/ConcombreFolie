/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metiers.Banque;

import Services.Position;
import javax.ejb.Local;

/**
 *
 * @author Charlie
 */
@Local
public interface GestionComptesLocal {

    public void ajouter(long idCompte, float somme) throws Exceptions.CompteInconnuException;

    public void retirer(long idCompte, float somme) throws Exceptions.CompteInconnuException, Exceptions.SoldeInsuffisantException;
    
    public Position position(long idCompte) throws Exceptions.CompteInconnuException;
    
}
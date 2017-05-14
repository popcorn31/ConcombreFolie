/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier.PrestaZone;

import Entites.Banque.Compte;
import Exceptions.SoldeInsuffisantException;
import javax.ejb.Local;

/**
 *
 * @author PC-FAUSTIN
 */
@Local
public interface ServiceCompatbleLocal
        /*Gestion Facturation 
            - Prelevement compte client
        */

{
     void ordonnerPrelevement (Compte c, float somme)throws SoldeInsuffisantException;
}

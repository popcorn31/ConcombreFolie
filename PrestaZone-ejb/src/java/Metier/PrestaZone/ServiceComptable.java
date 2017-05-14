/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier.PrestaZone;

import Controllers.Banque.CompteFacadeLocal;
import Entites.Banque.Compte;
import Exceptions.SoldeInsuffisantException;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author PC-FAUSTIN
 */
@Stateless
public class ServiceComptable implements ServiceCompatbleLocal
{
   @EJB
    private CompteFacadeLocal CompteFacade;

    @Override
    public void ordonnerPrelevement(Compte c, float somme)throws SoldeInsuffisantException 
    {
       if ( c.getSolde()- somme>0)
       {
        CompteFacade.debiter(c, somme);
       }
    }

   
    }
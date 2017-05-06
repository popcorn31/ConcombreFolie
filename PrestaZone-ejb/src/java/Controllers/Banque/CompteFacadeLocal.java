/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Banque;

import Entites.Banque.Compte;
import Exceptions.SoldeInsuffisantException;
import Services.Position;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PJES465
 */
@Local
public interface CompteFacadeLocal {

    void create(Compte compte);

    void edit(Compte compte);

    void remove(Compte compte);

    Compte find(Object id);

    List<Compte> findAll();

    List<Compte> findRange(int[] range);

    int count();
    
    void crediter(Compte c, float somme);
    void debiter (Compte c, float somme)  throws SoldeInsuffisantException;
    void virementplus(Compte c, float somme);
    void virementmoins(Compte c, float somme) throws SoldeInsuffisantException;
    Position consulter(Compte c);
    void cloturer(Compte c);
}

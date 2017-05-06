/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Banque;

import Entites.Banque.ClientBanque;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PJES465
 */
@Local
public interface ClientBanqueFacadeLocal {

    void create(ClientBanque client_B);

    void edit(ClientBanque client_B);

    void remove(ClientBanque client_B);

    ClientBanque find(Object id);

    List<ClientBanque> findAll();

    List<ClientBanque> findRange(int[] range);
    
    long chercherClient(String nom, String prenom) throws Exceptions.ClientInconnuException;
}

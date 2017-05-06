/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Banque;

import Entites.Banque.Compte;
import Entites.Banque.Operation;
import Exceptions.SoldeInsuffisantException;
import java.util.List;
import javax.ejb.Local;
import javax.swing.text.Position;

/**
 *
 * @author PJES465
 */
@Local
public interface OperationFacadeLocal {

    void create(Operation operation);

    void edit(Operation operation);

    void remove(Operation operation);

    Operation find(Object id);

    List<Operation> findAll();

    List<Operation> findRange(int[] range);

    int count();

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Charlie
 */
public class Position implements Serializable {
    private long idCompte;
    private float solde;
    private Date date;

    public long getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(long idCompte) {
        this.idCompte = idCompte;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Position(long idCompte, float solde, Date date) {
        this.idCompte = idCompte;
        this.solde = solde;
        this.date = date;
    }

    public Position() {
    }

    @Override
    public String toString() {
        return "Position{" + "idComte=" + idCompte + ", solde=" + solde + ", date=" + date + '}';
    }
    
}

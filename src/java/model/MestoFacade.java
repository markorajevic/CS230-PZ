/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MarkoMB
 */
@Stateless
public class MestoFacade extends AbstractFacade<Mesto> {

    @PersistenceContext(unitName = "CS230-ProjekatPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MestoFacade() {
        super(Mesto.class);
    }
    
}

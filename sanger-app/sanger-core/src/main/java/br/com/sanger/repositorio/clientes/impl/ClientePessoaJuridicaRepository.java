/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sanger.repositorio.clientes.impl;

import br.com.sanger.modelo.clientes.ClientePessoaJuridica;
import br.com.sanger.repositorio.AbstractRepository;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author eugenio
 */
public class ClientePessoaJuridicaRepository extends AbstractRepository<ClientePessoaJuridica> {

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientePessoaJuridicaRepository() {
        super( ClientePessoaJuridica.class );
        factory = Persistence.createEntityManagerFactory( AbstractRepository.PERSISTENCE_UNIT_NAME );
        em = factory.createEntityManager();
    }
}

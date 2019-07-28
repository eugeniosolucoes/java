/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eugeniosolucoes.main;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import br.com.eugeniosolucoes.bono.Bono;
import br.com.eugeniosolucoes.util.XmlUtils;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

/**
 *
 * @author eugenio
 */
public class Main {

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger( Main.class.getName() );

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory( "BONO_PU" );

    static EntityManager em = emf.createEntityManager();

    public static void main( String[] args ) {
        try {
            TypedQuery<Bono> query = em.createNamedQuery( "Bono.findAll", Bono.class );

            List<Bono> lista = query.setMaxResults( 2 ).getResultList();
            Whitelist whitelist = new Whitelist();

            whitelist.addTags( "<br>" );

            for ( Bono bono : lista ) {
                bono.setConteudo( Jsoup.clean( bono.getConteudo(), whitelist ) );
                try {
                    String xml = XmlUtils.createXmlFromObject( bono );
                    Files.write( Paths.get( path( bono ) ), xml.getBytes(), StandardOpenOption.CREATE );
                } catch ( IOException ex ) {
                    LOG.error( ex.getMessage(), ex );
                }
            }
        } catch ( Exception e ) {
            LOG.error( e.getMessage(), e );
        } finally {
            em.close();
            emf.close();
        }
    }

    private static String path( Bono bono ) {
        int numero = bono.getNumero();
        int ano = bono.getAno();
        BigDecimal id = bono.getId();
        return String.format( "%d-%03d-%05d.xml", ano, numero, id.intValue() );
    }

}
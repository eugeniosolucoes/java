/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eugeniosolucoes.bono;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eugenio
 */
@Entity
@Table( name = "materia" )
@XmlRootElement
@NamedQueries( { 
    @NamedQuery( name = "Materia.findAll", query = "SELECT m FROM Materia m" )
    , @NamedQuery( name = "Materia.findById", query = "SELECT m FROM Materia m WHERE m.id = :id" )
    , @NamedQuery( name = "Materia.findByAssunto", query = "SELECT m FROM Materia m WHERE m.assunto = :assunto" )
    , @NamedQuery( name = "Materia.findByDataCriacao", query = "SELECT m FROM Materia m WHERE m.dataCriacao = :dataCriacao" )
    , @NamedQuery( name = "Materia.findByDataPublicacao", query = "SELECT m FROM Materia m WHERE m.dataPublicacao = :dataPublicacao" )
    , @NamedQuery( name = "Materia.findByAprovada", query = "SELECT m FROM Materia m WHERE m.aprovada = :aprovada" )
    , @NamedQuery( name = "Materia.findByPublicada", query = "SELECT m FROM Materia m WHERE m.publicada = :publicada" )
    , @NamedQuery( name = "Materia.findByCategoria", query = "SELECT m FROM Materia m WHERE m.categoria = :categoria" )
    , @NamedQuery( name = "Materia.findByTipo", query = "SELECT m FROM Materia m WHERE m.tipo = :tipo" ) } )
public class Materia implements Serializable {

    private static final long serialVersionUID = 1L;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic( optional = false )
    @Column( name = "id" )
    private BigDecimal id;

    @Column( name = "assunto" )
    private String assunto;

    @Lob
    @Column( name = "conteudo" )
    private String conteudo;

    @Lob
    @Column( name = "conteudo_html" )
    private String conteudoHtml;

    @Basic( optional = false )
    @Column( name = "data_criacao" )
    @Temporal( TemporalType.TIMESTAMP )
    private Date dataCriacao;

    @Basic( optional = false )
    @Column( name = "data_publicacao" )
    @Temporal( TemporalType.TIMESTAMP )
    private Date dataPublicacao;

    @Basic( optional = false )
    @Column( name = "aprovada" )
    private boolean aprovada;

    @Basic( optional = false )
    @Column( name = "publicada" )
    private boolean publicada;

    @Basic( optional = false )
    @Column( name = "categoria" )
    private int categoria;

    @Basic( optional = false )
    @Column( name = "tipo" )
    private int tipo;

    @JoinColumn( name = "autor_id", referencedColumnName = "id" )
    @ManyToOne( optional = false )
    private Autor autorId;

    @JoinColumn( name = "bono_id", referencedColumnName = "id" )
    @ManyToOne
    private Bono bonoId;

    @JoinColumn( name = "om_id", referencedColumnName = "id" )
    @ManyToOne( optional = false )
    private OrganizacaoMilitar omId;

    public Materia() {
    }

    public Materia( BigDecimal id ) {
        this.id = id;
    }

    public Materia( BigDecimal id, Date dataCriacao, Date dataPublicacao, boolean aprovada, boolean publicada, int categoria, int tipo ) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.dataPublicacao = dataPublicacao;
        this.aprovada = aprovada;
        this.publicada = publicada;
        this.categoria = categoria;
        this.tipo = tipo;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId( BigDecimal id ) {
        this.id = id;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto( String assunto ) {
        this.assunto = assunto;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo( String conteudo ) {
        this.conteudo = conteudo;
    }

    public String getConteudoHtml() {
        return conteudoHtml;
    }

    public void setConteudoHtml( String conteudoHtml ) {
        this.conteudoHtml = conteudoHtml;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao( Date dataCriacao ) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao( Date dataPublicacao ) {
        this.dataPublicacao = dataPublicacao;
    }

    public boolean getAprovada() {
        return aprovada;
    }

    public void setAprovada( boolean aprovada ) {
        this.aprovada = aprovada;
    }

    public boolean getPublicada() {
        return publicada;
    }

    public void setPublicada( boolean publicada ) {
        this.publicada = publicada;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria( int categoria ) {
        this.categoria = categoria;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo( int tipo ) {
        this.tipo = tipo;
    }

    public Autor getAutorId() {
        return autorId;
    }

    public void setAutorId( Autor autorId ) {
        this.autorId = autorId;
    }

    public Bono getBonoId() {
        return bonoId;
    }

    public void setBonoId( Bono bonoId ) {
        this.bonoId = bonoId;
    }

    public OrganizacaoMilitar getOmId() {
        return omId;
    }

    public void setOmId( OrganizacaoMilitar omId ) {
        this.omId = omId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += ( id != null ? id.hashCode() : 0 );
        return hash;
    }

    @Override
    public boolean equals( Object object ) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if ( !( object instanceof Materia ) ) {
            return false;
        }
        Materia other = (Materia) object;
        if ( ( this.id == null && other.id != null ) || ( this.id != null && !this.id.equals( other.id ) ) ) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mb.siscpo.bono.Materia[ id=" + id + " ]";
    }
    
}

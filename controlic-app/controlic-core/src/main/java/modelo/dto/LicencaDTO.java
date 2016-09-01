/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

/**
 *
 * @author eugenio
 */
public class LicencaDTO {

    private String id;
    
    private String dataOrdenacao;

    private String dataLicenca;
    
    private String dataExibicao;

    private String motivo;
    
    private String militar;
    
    private String tipo;
    
    private String pd;

    public LicencaDTO() {
    }

    public LicencaDTO( String id, String dataOrdenacao, String dataLicenca, String motivo ) {
        this.id = id;
        this.dataOrdenacao = dataOrdenacao;
        this.dataLicenca = dataLicenca;
        this.motivo = motivo;
    }

    public LicencaDTO( String id, String dataOrdenacao, String dataLicenca, String dataExibicao, String motivo, String militar, String tipo, String pd ) {
        this.id = id;
        this.dataOrdenacao = dataOrdenacao;
        this.dataLicenca = dataLicenca;
        this.dataExibicao = dataExibicao;
        this.motivo = motivo;
        this.militar = militar;
        this.tipo = tipo;
        this.pd = pd;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo( String motivo ) {
        this.motivo = motivo;
    }

    public String getId() {
        return id;
    }

    public void setId( String id ) {
        this.id = id;
    }

    public String getDataOrdenacao() {
        return dataOrdenacao;
    }

    public void setDataOrdenacao( String dataOrdenacao ) {
        this.dataOrdenacao = dataOrdenacao;
    }

    public String getDataLicenca() {
        return dataLicenca;
    }

    public void setDataLicenca( String dataLicenca ) {
        this.dataLicenca = dataLicenca;
    }

    public String getMilitar() {
        return militar;
    }

    public void setMilitar( String militar ) {
        this.militar = militar;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo( String tipo ) {
        this.tipo = tipo;
    }

    public String getPd() {
        return pd;
    }

    public void setPd( String pd ) {
        this.pd = pd;
    }

    public String getDataExibicao() {
        return dataExibicao;
    }

    public void setDataExibicao( String dataExibicao ) {
        this.dataExibicao = dataExibicao;
    }
}

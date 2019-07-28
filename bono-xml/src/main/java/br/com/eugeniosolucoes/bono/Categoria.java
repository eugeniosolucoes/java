package br.com.eugeniosolucoes.bono;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Categoria")
@XmlEnum
public enum Categoria implements Tipo, Serializable
{

    BLANK(0), GERAL(1), ESPECIAL(2);

    private final int tipo;

    Categoria( int tipo )
    {

        this.tipo = tipo;

    }

    @Override
    public String getDescricao()
    {
        return this.name().toLowerCase();
    }

    @Override
    public String getSigla()
    {
        return this.name();
    }

    @Override
    public int getTipo()
    {
        return tipo;
    }

    public static Categoria getTipo( int tipo )
    {
        for (Categoria t : Categoria.values())
        {
            if (t.getTipo() == tipo)
            {
                return t;
            }
        }
        return null;
    }
}

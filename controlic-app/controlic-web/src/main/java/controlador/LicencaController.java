/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.jpa.Licenca;
import modelo.jpa.Militar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import servico.LicencaServico;
import servico.impl.LicencaServicoImpl;
import util.MyStrings;

/**
 *
 * @author eugenio
 */
@Controller
public class LicencaController {

    protected LicencaServico servico;

    protected Licenca obj;

    protected String entidade;

    @Autowired
    HttpServletRequest request;

    public LicencaController() {
        servico = new LicencaServicoImpl();
        obj = new Licenca( "" );
        entidade = obj.getClass().getSimpleName().toLowerCase();
    }

    @InitBinder
    public void initBinder( WebDataBinder webDataBinder ) {
        SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" );
        dateFormat.setLenient( false );
        webDataBinder.registerCustomEditor( Date.class,
                new CustomDateEditor( dateFormat, true ) );
    }

    @RequestMapping( value = "/licenca/{id}", method = RequestMethod.GET )
    public String editar( @PathVariable Long id, Model model ) {
        model.addAttribute( "tipos", Licenca.TipoLicenca.values() );
        try {
            obj = servico.retornar( id );
            model.addAttribute( entidade, obj );
        } catch ( Exception ex ) {
            model.addAttribute( "tipoMensagem", Mensagem.TYPE_ERROR );
            model.addAttribute( "mensagem",
                    MyStrings.cleanMessage( ex.getMessage() ) );
        }
        return entidade + "/formulario";
    }

    @RequestMapping( value = "/licenca/excluir/{id}", method = RequestMethod.GET )
    public String excluir( @PathVariable Long id, Model model ) {
        try {
            obj = servico.retornar( id );
            servico.excluir( obj );
            model.addAttribute( "tipoMensagem", Mensagem.TYPE_SUCCESS );
            model.addAttribute( "mensagem", "Registro excluído com sucesso!" );
            List<Licenca> lista = servico.listarPorMilitar( (Militar) request.getSession().getAttribute( "usuario" ) );
            model.addAttribute( "lista", lista );
        } catch ( Exception ex ) {
            model.addAttribute( "tipoMensagem", Mensagem.TYPE_ERROR );
            model.addAttribute( "mensagem",
                    MyStrings.cleanMessage( ex.getMessage() ) );
            return editar( id, model );
        }
        return entidade + "/listagem";
    }

    @RequestMapping( "/licenca/listar" )
    public String listar( Model model ) {
        try {
            List<Licenca> lista = servico.listarPorMilitar( (Militar) request.getSession().getAttribute( "usuario" ) );
            model.addAttribute( "lista", lista );
        } catch ( Exception ex ) {
            model.addAttribute( "tipoMensagem", Mensagem.TYPE_ERROR );
            model.addAttribute( "mensagem",
                    MyStrings.cleanMessage( ex.getMessage() ) );
        }
        return entidade + "/listagem";
    }

    @RequestMapping( "/licenca/novo" )
    public String formulario( Model model ) {
        model.addAttribute( "tipos", Licenca.TipoLicenca.values() );
        model.addAttribute( entidade, new Licenca( "" ) );
        return "licenca/formulario";
    }

    @RequestMapping( "/licenca/salvar" )
    public String salvar( Licenca obj, Model model ) {
        try {
            obj.setMilitar( (Militar) request.getSession().getAttribute( "usuario" ) );
            servico.salvar( obj );
            model.addAttribute( "tipoMensagem", Mensagem.TYPE_SUCCESS );
            model.addAttribute( "mensagem", "Registro salvo com sucesso!" );
        } catch ( Exception ex ) {
            model.addAttribute( "tipoMensagem", Mensagem.TYPE_ERROR );
            model.addAttribute( "mensagem",
                    MyStrings.cleanMessage( ex.getMessage() ) );
        }
        model.addAttribute( "tipos", Licenca.TipoLicenca.values() );
        model.addAttribute( "licenca", obj );
        return entidade + "/formulario";
    }

    @RequestMapping( "/licenca/visualizar/{ano}/{mes}" )
    public String visualizar( @PathVariable Integer ano,
            @PathVariable Integer mes, Model model ) {
        try {
            List<Licenca> licencas = servico.listarPorAnoMes( ano, mes );
            model.addAttribute( "url", String.format( "%s/licenca/visualizar/json/%d/%d", request.getContextPath(), ano, mes ) );
            model.addAttribute( "licencas", licencas );
            model.addAttribute( "anos", servico.listarAnos() );
            model.addAttribute( "meses", MESES );
            model.addAttribute( "ano", ano );
            model.addAttribute( "mes", mes );
        } catch ( Exception ex ) {
            model.addAttribute( "tipoMensagem", Mensagem.TYPE_ERROR );
            model.addAttribute( "mensagem",
                    MyStrings.cleanMessage( ex.getMessage() ) );
        }
        return entidade + "/visualizar";
    }

    @RequestMapping( "/licenca/visualizar" )
    public String visualizar( Model model ) {
        try {
            Calendar calendar = Calendar.getInstance();
            Integer ano = calendar.get( Calendar.YEAR );
            Integer mes = calendar.get( Calendar.MONTH ) + 1;
            List<Licenca> licencas = servico.listarPorAnoMes( ano, mes );
            model.addAttribute( "url", String.format( "%s/licenca/visualizar/json/%d/%d", request.getContextPath(), ano, mes ) );
            model.addAttribute( "licencas", licencas );
            model.addAttribute( "anos", servico.listarAnos() );
            model.addAttribute( "meses", MESES );
            model.addAttribute( "ano", ano );
            model.addAttribute( "mes", mes );
        } catch ( Exception ex ) {
            model.addAttribute( "tipoMensagem", Mensagem.TYPE_ERROR );
            model.addAttribute( "mensagem",
                    MyStrings.cleanMessage( ex.getMessage() ) );
        }
        return entidade + "/visualizar";
    }

    @RequestMapping( "/licenca/visualizar/json" )
    public void visualizarJSON( HttpServletResponse response ) throws Exception {
        response.setContentType( "application/json" );
        PrintWriter out = response.getWriter();
        Calendar calendar = Calendar.getInstance();
        Integer ano = calendar.get( Calendar.YEAR );
        Integer mes = calendar.get( Calendar.MONTH ) + 1;
        JSONArray licencasJSON = servico.listarPorAnoMesJSON( ano, mes );
        out.print( licencasJSON );
        out.flush();
    }

    @RequestMapping( "/licenca/visualizar/json/{ano}/{mes}" )
    public void visualizarJSON( @PathVariable Integer ano,
            @PathVariable Integer mes, HttpServletResponse response ) throws Exception {
        response.setContentType( "application/json" );
        PrintWriter out = response.getWriter();
        JSONArray licencasJSON = servico.listarPorAnoMesJSON( ano, mes );
        out.print( licencasJSON );
        out.flush();
    }
    
    static final String[][] MESES = {
        {"1", "janeiro"},
        {"2", "fevereiro"},
        {"3", "março"},
        {"4", "abril"},
        {"5", "maio"},
        {"6", "junho"},
        {"7", "julho"},
        {"8", "agosto"},
        {"9", "setembro"},
        {"10", "outubro"},
        {"11", "novembro"},
        {"12", "dezembro"},
    };
    
}

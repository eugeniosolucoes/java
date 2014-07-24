<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="#">CPO-20</a>
            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li class="active"><a href="<c:url value='/'/>">In&iacute;cio</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Licen�as<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="<c:url value='/licenca/novo' />">Nova</a></li>
                            <li><a href="<c:url value='/licenca/listar' />">Minhas Licen�as</a></li>
                        </ul>
                    </li>                     
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Visualizar<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="<c:url value='/licenca/visualizar' />">Mensal</a></li>
                        </ul>
                    </li>                    
                    <li><a href="<c:url value='/logout' />">Sair</a></li>
                </ul>
            </div><!--/.nav-collapse -->
            <div class="usuario-ativo">Usu�rio: ${usuario.loginNome}</div>
        </div>
    </div>
</div>

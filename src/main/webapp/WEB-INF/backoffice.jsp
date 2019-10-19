<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.scss" media="screen" />
     <title>Posto Tades</title>
  </head>
  <header>
      <nav class="navbar navbar-light nav-color">
      <a class="navbar-brand">Postos Tades</a>
      <div class="nav-item text-nowrap">
          <a class="nav-link" href="#">Sair</a>
      </div>
    </nav>
  </header>
  <body>
      <div class="page-title">
          <h1>Painel BackOffice</h1>
      </div>
      
      <ul class="nav flex-column">
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/backoffice/cadastrar-produto">Cadastrar Produto</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/backoffice/pesquisar-produto">Pesquisar Produto</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Visualizar Vendas    </a>
        </li>
      </ul>
        
      <c:if test="${criadoAttr}">
          <div class="alert alert-success">
              Produto cadastrado com sucesso!
          </div>
      </c:if>
         <c:if test="${deletadoAttr}">
          <div class="alert alert-success">
              Produto deletado com sucesso!
          </div>
      </c:if>
         <c:if test="${editadodoAttr}">
          <div class="alert alert-success">
              Produto editado com sucesso!
          </div>
      </c:if>
        
      <div style="margin-top: -100px; width: 203px; height: 640px; background-color: black;"></div>
  </body>
</html>
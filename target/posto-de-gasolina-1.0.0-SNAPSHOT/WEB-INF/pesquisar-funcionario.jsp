<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/rh.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/rh.scss" media="screen" />
        <title>Posto Tades</title>
    </head>
    <header>
        <nav class="navbar navbar-light nav-color">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/rh">Postos Tades</a>
            <div class="nav-item text-nowrap">
                <a class="nav-link" href="#">Sair</a>
            </div>
        </nav>
    </header>
    <body>
        <div class="page-title">
            <h1>Pesquisar Funcionário</h1>
        </div>

        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/rh/cadastrar-funcionario">Cadastrar Funcionário</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/rh/pesquisar-funcionario">Pesquisar Funcionário</a>
            </li>
        </ul>
            
        <form method="get" action="${pageContext.request.contextPath}/rh/pesquisa-de-funcionario" class="needs-validation" novalidate>
            <div class="form-group row">
              <label for="inputCpf" class="col-md-1 offset-md-3">CPF:</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" name="cpf" id="inputCpf" placeholder="Digite o cpf do funcionário" required>
                 <div class="invalid-feedback">
                    Digite um CPF
                </div>
              </div>
              <div class="col-sm-4">
                <button type="submit" class="btn btn-primary mb-2">Pesquisar</button>
              </div>
            </div>
        </form>

            <c:if test="${naoEncontradoAttr}">
                <div class="alert alert-danger">
                    Funcionário não encontrado
                </div>
            </c:if>
            <c:if test="${idAttr != null}">
                <table class="table table-sm offset-md-2">
                    <thead>
                      <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Nome</th>
                        <th scope="col">CPF</th>
                        <th scope="col">Departamento</th>
                        <th scope="col"> </th>
                        <th scope="col"> </th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <th scope="row"><c:out value="${idAttr}"/></th>
                        <td ><c:out value="${nomeAttr}"/></td>
                        <td> <c:out value="${cpfAttr}"/></td>
                        <td><c:out value="${dptoAttr}"/></td>
                        <td><a data-method="get" href="${pageContext.request.contextPath}/rh/editar-funcionario?id=${idAttr}" class="btn btn-primary mb-1">Editar</button></td>
                        <td><a data-confirm="Tem certeza?" data-method="post" href="${pageContext.request.contextPath}/rh/excluir-funcionario?id=${idAttr}" class="btn btn-primary mb-1">Excluir</button></td>
                      </tr>
                    </tbody>
                  </table>
            </c:if>
    </body>
    <script>
        (function() {
          'use strict';
          window.addEventListener('load', function() {
            var forms = document.getElementsByClassName('needs-validation');
            var validation = Array.prototype.filter.call(forms, function(form) {
              form.addEventListener('submit', function(event) {
                if (form.checkValidity() === false) {
                  event.preventDefault();
                  event.stopPropagation();
                }
                form.classList.add('was-validated');
              }, false);
            });
          }, false);
        })();
    </script>
</html>
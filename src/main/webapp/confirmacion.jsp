<html> 
<head>
<meta charset="UTF-8">
<title>Confirmación Inscripción</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>

<body>
   
   <% int idInsc = (Integer)request.getAttribute("idInsc");%>
   <h1>Solicitud Generada Correctamente</h1>
   Su codigo de inscripción es: <%=idInsc%>
   
   <div class="container">
  <h2>Listado de inscripciones</h2>
  <p>Listado de inscripciones</p>            
  <table class="table">
    <thead>
      <tr>
       <!-- <th>Id Inscripcion</th> --> 
        <th>Nombre</th>
        <th>Telefono</th>
        <th>Id Curso</th>
        <th>Id Forma de Pago</th>
      </tr>
    </thead>
    <tbody> 
      <tr>
        <td><%=request.getParameter("nombre")%></td>
        <td><%=request.getParameter("telefono")%></td>
        <td><%=request.getParameter("idCurso")%></td>
        <td><%=request.getParameter("idFormaPago")%></td>
      </tr>
      
    </tbody>
  </table>
</div>
</body>
</html>

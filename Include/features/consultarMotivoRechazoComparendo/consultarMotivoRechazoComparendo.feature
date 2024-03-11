#language: es

@MotivoRechazo
Característica: Consultar motivo de rechazo de los comparendos
  yo como usuario automatizador requiero consultar el motivo de rechazo de los comparendos

Antecedentes:
  Dado yo Estoy logueado Multas
  Y Se selecciona la opcion Reportes

  @ConsultaExitosa
    
  Escenario: Consulta de motivo de rechazo exitosa
    Dado Se selecciona la opcion Consulta motivo de rechazo
    Y Se ingresa nro comparendo 05088000000040564918
    Y Se selecciona Buscar
    Entonces Se verifica que no se presente el mensaje No se encuentra ningún registro relacionado con el criterio de búsqueda.
@administrarTalonario
Feature: Administrar un talonario
  Yo como administrador quiero crear,editar,inactivar,eliminar,activar y asignar a un agente

  @crearTalonario
  Scenario: Crear un talonario para un agente
    Given ingreso a multas
    And selecciono administrar talonarios
    And selecciono adicionar
    When ingrese los datos solicitados
    And guardo el nuevo talonario
    Then verifico mensaje confirmacion exitoso

  @consultarTalonario
  Scenario: Consultar,descargar e imprimir talonarios
    Given ingreso criterios de busqueda
    When consulte el reporte
    And descargo la consulta
    And selecciono imprimir consulta
    Then verifico tabla de resultados impresion y descarga

  @accionesTalonario
  Scenario: Editar,inactivar,eliminar y activar un talonario
    Given consulte los talonarios de una entidad
    When selecciono el primer registro y lo edito
    And luego lo inactivo e ingreso motivo
    And luego lo activo de nuevo e ingreso motivo
    Then finalizo eliminando el registro y verifico

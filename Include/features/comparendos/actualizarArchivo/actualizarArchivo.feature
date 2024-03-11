@ActualizarArchivo
Feature: Actualizar archivo plano
  Yo como usuario automatizador requiero actualizar un archivo plano

  Background: Realizar login exitoso
    Given Me encuentro en la pagina de Multas
    When Ingresar el usuario
    And Ingresar password
    And Selecciona la opcion iniciar sesion
    Then Verifico que se presenta el mensaje

  @ActualizacionExitosa
  Scenario: Actualizar archivo plano exitosa
    Given seleccione la opcion Actualizar archivo
    When escoger la secretaria y criterio de busqueda 20
    And seleccionar Buscar
    And seleccionar accion Actualizar
    Then verifico mensaje presente
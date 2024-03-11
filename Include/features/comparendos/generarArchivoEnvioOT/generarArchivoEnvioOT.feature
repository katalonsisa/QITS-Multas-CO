@generarArchivoEnvioOT
Feature: generar archivo para envío a OT
  Yo como administrador quiero generar archivo para envío a OT

  Background: Realizar login exitoso
    Given Me encuentro en la pagina de Multas
    When Ingresar el usuario
    And Ingresar password
    And Selecciona la opcion iniciar sesion
    Then Verifico que se presenta el mensaje

  @generarArchivo
  Scenario: generar archivo para envío a OT
    Given ingreso a la opcion generar archivo para envío a OT
    And selecciono una secretaria
    And selecciono un tipo de comparendo
    When ingrese la fecha
    Then presiono el boton generar y verifico descarga del archivo
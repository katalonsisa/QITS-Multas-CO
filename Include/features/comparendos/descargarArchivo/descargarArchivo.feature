@DescargarArchivo
Feature: Descargar archivo plano
  Yo como usuario automatizador requiero descargar un archivo plano

  Background: Realizar login exitoso
    Given Me encuentro en la pagina de Multas
    When Ingresar el usuario
    And Ingresar password
    And Selecciona la opcion iniciar sesion
    Then Verifico que se presenta el mensaje

  @DescargaExitosa
  Scenario: Descargar archivo plano exitosa
    Given Seleccione la opcion Descargar archivo
    When Selecciono la secretaria 22
    And Selecciono Buscar
    And selecciono Descargar
    Then Verifico que el mesaje no se presente
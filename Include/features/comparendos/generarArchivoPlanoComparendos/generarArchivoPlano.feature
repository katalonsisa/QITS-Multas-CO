
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
    Given Seleccione la opcion Generar archivo plano
    When Selecciono secretaria 3
    And Selecciono tipo comparendo 16
    And Selecciono criterio de busqueda 5
    And Ingreso la Fecha desde 
    And Ingreso la Fecha hasta 
    And Selecciono Generar
    Then Verifico que no se presente el mensaje


@buscarAgente
Feature: Realizar la edición de un agente de transito
  Yo como administrador de la aplicación edito los agentes de tránsito

Background: Realizar login exitoso
	 Given Me encuentro en la pagina de Multas
    When Ingresar el usuario
    And Ingresar password
    And Selecciona la opcion iniciar sesion
    Then Verifico que se presenta el mensaje

  @edicionExitosa
  Scenario: Editar informacion agente de tránsito
  	Given estoy en multas
    And voy a la opción Editar Agente como administrador de la aplicación
    Then visualizo y verifico la información modificada del agente de tránsito
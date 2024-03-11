
@buscarAgente
Feature: Realizar consulta de agente de transito
  Yo como administrador de la aplicación consulto los agentes de tránsito

Background: Realizar login exitoso
	 Given Me encuentro en la pagina de Multas
    When Ingresar el usuario
    And Ingresar password
    And Selecciona la opcion iniciar sesion
    Then Verifico que se presenta el mensaje

  @busquedaExitosa
  Scenario: Consultar agente de tránsito
  	Given logueado en multas
    And voy a la opción Buscar Agente como administrador de la aplicación
    Then visualizo y verifico la información del agente de tránsito
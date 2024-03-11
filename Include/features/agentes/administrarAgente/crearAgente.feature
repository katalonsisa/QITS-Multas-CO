
@buscarAgente
Feature: Realizar la edición de un agente de transito
  Yo como administrador de la aplicación edito los agentes de tránsito

Background: Realizar login exitoso
	 Given Me encuentro en la pagina de Multas
    When Ingresar el usuario
    And Ingresar password
    And Selecciona la opcion iniciar sesion
    Then Verifico que se presenta el mensaje
   
  @creacionAgenteExitoso
  Scenario: Creación de agente de tránsito
  	Given estoy en modulo de multas
    When voy a la opción Adicionar como administrador de la aplicación
    And adiciono un nuevo agente en el sistema multas
    Then visualizo y verifico que se adicione la información del agente de tránsito
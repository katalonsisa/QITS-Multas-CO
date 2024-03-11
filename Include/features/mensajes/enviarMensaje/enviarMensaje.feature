@EnviarMensaje
Feature: Enviar mensajes a agentes
  Yo como usuario automatizador requiero enviar un mensaje a unagente

  Background: Realizar login exitoso
    Given Me encuentro en la pagina de Multas
    When Ingresar el usuario
    And Ingresar password
    And Selecciona la opcion iniciar sesion
    Then Verifico que se presenta el mensaje

  @EnvioExitosa
  Scenario: Envio mensaje exitoso
    Given Seleccione la opcion enviar mensaje
    When Consulto agente
    And Ingreso los datos solicitados
    And Selecciono Enviar
    Then Verifico que se presente el mensaje
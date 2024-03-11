#language: es


@Login
	Característica: Realizar login Multas
  Yo como usuario automatizador quiero ingresar al sitio Qits Multas

  @LoginExitoso
	Escenario: Realizar login exitoso
    Dado Me encuentro en la pagina de Multas
    Cuando Ingresar el usuario
    Y Ingresar password
    Y Selecciona la opcion iniciar sesion
    Entonces Verifico que se presenta el mensaje

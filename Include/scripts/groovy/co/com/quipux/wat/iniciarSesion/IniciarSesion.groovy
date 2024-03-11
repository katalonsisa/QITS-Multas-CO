package co.com.quipux.wat.iniciarSesion

import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When


class IniciarSesion {

	@Given("Me encuentro en la pagina de Multas")
	def Me_encuentro_en_la_pagina_de_Multas() {
		WebUI.openBrowser(GlobalVariable.url)
	}

	@When("Ingresar el usuario")
	def Ingresar_el_usuario() {
		WebUI.setText(findTestObject('cas-server-webapp/input_usuario'), GlobalVariable.username)
	}

	@When("Ingresar password")
	def Ingresar_password() {
		WebUI.setEncryptedText(findTestObject('cas-server-webapp/input_contrasenna'), GlobalVariable.password)
	}

	@When("Selecciona la opcion iniciar sesion")
	def Selecciona_la_opcion_iniciar_sesion() {
		WebUI.click(findTestObject('cas-server-webapp/input_iniciarSesion'))
		WebUI.comment("Di click en login")
	}

	@Then("Verifico que se presenta el mensaje")
	def Verifico_que_se_presenta_el_mensaje() {
		WebUI.verifyElementPresent(findTestObject("Object Repository/cas-server-webapp/span_verificacionTitulo"), 30)
	}
}
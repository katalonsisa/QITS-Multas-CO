package co.com.quipux.wat.mensajes
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class enviarMensaje {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("Seleccione la opcion enviar mensaje")
	def Seleccione_la_opcion_enviar_mensaje() {
		WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/mensajes/enviarMensajes/a_menuEnviarMensaje'))
	}

	@When("Consulto agente")
	def Consulto_agente() {
		WebUI.selectOptionByLabel(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/mensajes/enviarMensajes/select_criterioBusqueda'), 'Agente', false)
		WebUI.delay(1)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/mensajes/enviarMensajes/select_criterioAgente'), 'Placa agente', false)
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/mensajes/enviarMensajes/input_placaAgente'), '044')
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/mensajes/enviarMensajes/button_buscar'))
		WebUI.delay(1)
	}

	@And("Ingreso los datos solicitados")
	def Ingreso_los_datos_solicitados() {
		WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/mensajes/enviarMensajes/li_resultado_busqueda'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/mensajes/enviarMensajes/button_add'))
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/mensajes/enviarMensajes/input_asunto'), 'Prueba Mensaje')
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/mensajes/enviarMensajes/textarea_mensaje'), 'Este es un mensaje de pruebas automatizadas')
		WebUI.delay(1)
	}


	@And("Selecciono Enviar")
	def Selecciono_Enviar() {
		WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/mensajes/enviarMensajes/button_enviar'))
		WebUI.delay(1)
	}



	@Then("Verifico que se presente el mensaje")
	def Verifico_que_se_presente_el_mensaje() {
		WebUI.verifyElementPresent(findTestObject("Object Repository/qxmultas_co/qits/menuPrincipalMultas/mensajes/enviarMensajes/span_verificarEnvio"), 30)
	}
}
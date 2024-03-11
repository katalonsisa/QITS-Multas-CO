package co.com.quipux.wat.comparendos
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


class ActualizarArchivo {

	@Given("seleccione la opcion Actualizar archivo")
	def seleccione_la_opcion_Actualizar_archivo() {
		WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/comparendos/actualizarArchivo/a_verMasOpciones'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/comparendos/actualizarArchivo/a_actualizarArchivo'))
		WebUI.delay(1)
	}

	@When("escoger la secretaria y criterio de busqueda (.*)")
	def escoger_la_secretaria_y_criterio_de_busqueda(String criterio) {
		WebUI.selectOptionByLabel(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/comparendos/actualizarArchivo/select_secretaria'), "Medellin", false)
		WebUI.selectOptionByValue(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/comparendos/actualizarArchivo/select_criterioBusqueda'), criterio, true)
		WebUI.executeJavaScript("document.getElementById('content:fechaGeneracion_input').value = arguments[0]", Arrays.asList('08/06/2016'))
		WebUI.delay(1)
	}

	@And("seleccionar Buscar")
	def seleccionar_Buscar() {
		WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/comparendos/actualizarArchivo/button_buscar'))
		WebUI.delay(1)
	}

	@And("seleccionar accion Actualizar")
	def seleccionar_accion_Actualizar() {
		WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/comparendos/actualizarArchivo/button_accionActualizar'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/comparendos/actualizarArchivo/span_estadoActualizar'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/comparendos/actualizarArchivo/button_guardarActualizacion'))
		WebUI.delay(1)
		
	}

	@Then("verifico mensaje presente")
	def verifico_mensaje_presente() {
		WebUI.verifyElementPresent(findTestObject("Object Repository/qxmultas_co/qits/menuPrincipalMultas/comparendos/actualizarArchivo/div_verificaActualizacion"), 30)
		
	}
}
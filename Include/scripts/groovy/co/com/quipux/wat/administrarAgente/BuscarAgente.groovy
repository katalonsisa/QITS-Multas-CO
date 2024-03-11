package co.com.quipux.wat.administrarAgente
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



class BuscarAgente {

	@Given("logueado en multas")
	def logueado_en_multas() {
		WebUI.verifyElementPresent(findTestObject("Object Repository/agentes/administrarAgente/buscarAgente/span_verificacionTitulo"), 30)
	}

	@And("voy a la opción Buscar Agente como administrador de la aplicación")
	def voy_a_la_opción_Buscar_Agente_como_administrador_de_la_aplicación() {
		WebUI.click(findTestObject('Object Repository/agentes/administrarAgente/buscarAgente/a_administrarAgente'))
		WebUI.delay(1)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/agentes/administrarAgente/buscarAgente/select_criterioBusqueda'), "Placa agente", false)
		WebUI.setText(findTestObject('Object Repository/agentes/administrarAgente/buscarAgente/input_criterioPlaca'), "2020")
		WebUI.click(findTestObject('Object Repository/agentes/administrarAgente/buscarAgente/bnt_buscarAgente'))
		WebUI.delay(1)
	}

	@Then("visualizo y verifico la información del agente de tránsito")
	def visualizo_y_verifico_la_información_del_agente_de_tránsito() {
		WebUI.verifyElementPresent(findTestObject("Object Repository/agentes/administrarAgente/buscarAgente/td_verificacionBuscar"), 30)
	}
}
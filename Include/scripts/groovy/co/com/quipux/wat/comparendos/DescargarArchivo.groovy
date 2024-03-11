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



class DescargarArchivo {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("Seleccione la opcion Descargar archivo")
	def Seleccione_la_opcion_Descargar_archivo() {
		WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/comparendos/descargarArchivo/a_descargarArchivo'))
	}

	@When("Selecciono la secretaria (.*)")
	def Selecciono_la_secretaria(String secretaria) {
		WebUI.selectOptionByValue(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/comparendos/descargarArchivo/select_secretaria'), secretaria, true)
		WebUI.delay(1)
	}

	@And("Selecciono Buscar")
	def Selecciono_Buscar() {
		WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/comparendos/descargarArchivo/button_buscar'))
		WebUI.delay(1)
	}

	@And("selecciono Descargar")
	def selecciono_Descargar() {
		WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/comparendos/descargarArchivo/button_descargar'))
		WebUI.delay(1)
	}

	@Then("Verifico que el mesaje no se presente")
	def Verifico_que_el_mesaje_no_se_presente() {
		WebUI.verifyElementNotPresent(findTestObject("Object Repository/qxmultas_co/qits/menuPrincipalMultas/comparendos/descargarArchivo/span_verificarDescargarArchivo"), 30)
	}
}
package co.com.quipux.wat.comparendos

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
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
import org.openqa.selenium.Keys as Keys

class GenerarArchivoPlano {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("Seleccione la opcion Generar archivo plano")
	def Seleccione_la_opcion_Generar_archivo_plano() {
		WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/comparendos/generarArchivoPlano/a_menuGenerarArchivoPlanoComparendo'))
	}

	@When("Selecciono secretaria (.*)")
	def Selecciono_secretaria(String secretaria) {
		WebUI.selectOptionByValue(findTestObject('qxmultas_co/qits/menuPrincipalMultas/comparendos/generarArchivoPlano/select_secretaria'), secretaria, true)
		WebUI.delay(1)
	}

	@And("Selecciono tipo comparendo (.*)")
	def Selecciono_tipo_comparendo(String transito) {
		WebUI.selectOptionByValue(findTestObject('qxmultas_co/qits/menuPrincipalMultas/comparendos/generarArchivoPlano/select_tipoComparendo'), transito, true)
		WebUI.delay(1)
	}

	@And("Selecciono criterio de busqueda (.*)")
	def Selecciono_criterio_de_busqueda(String rangoFechas) {
		WebUI.selectOptionByValue(findTestObject('qxmultas_co/qits/menuPrincipalMultas/comparendos/generarArchivoPlano/select_criterioBusqueda'), rangoFechas, true)
	}

	@And("Ingreso la Fecha desde")
	def Ingreso_la_Fecha_desde () {
		WebUI.executeJavaScript("document.getElementById('content:fechaInicial_input').value = arguments[0]", Arrays.asList('01/03/2019'))
		WebUI.delay(2)
	}

	@And("Ingreso la Fecha hasta")
	def Ingreso_la_Fecha_hasta () {
		WebUI.executeJavaScript("document.getElementById('content:fechaFinal_input').value = arguments[0]", Arrays.asList('30/03/2019'))
		WebUI.delay(3)
	}

	@And("Selecciono Generar")
	def Selecciono_Generar () {
		WebUI.click(findTestObject('qxmultas_co/qits/menuPrincipalMultas/comparendos/generarArchivoPlano/span_generar'))
		WebUI.delay(7)
	}

	@Then("Verifico que no se presente el mensaje")
	def Verifico_que_no_se_presente_el_mensaje() {
		WebUI.verifyElementNotPresent(findTestObject("Object Repository/qxmultas_co/qits/menuPrincipalMultas/comparendos/generarArchivoPlano/span_verificacionRegistroC"), 30)
	}
}
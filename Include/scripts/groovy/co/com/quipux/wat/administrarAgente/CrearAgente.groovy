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



class CrearAgente {
	
	@Given("estoy en modulo de multas")
	def estoy_en_modulo_de_multas() {
		WebUI.verifyElementPresent(findTestObject("Object Repository/agentes/administrarAgente/editarAgente/span_verificacionTitulo"), 30)
	}
	
	@When("voy a la opción Adicionar como administrador de la aplicación")
	def voy_a_la_opción_Adicionar_como_administrador_de_la_aplicación() {
		WebUI.click(findTestObject('Object Repository/agentes/administrarAgente/crearAgente/a_administrarAgente'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/agentes/administrarAgente/crearAgente/btn_adicionarAgente'))
		WebUI.delay(1)
	}
	
	@And("adiciono un nuevo agente en el sistema multas")
	def adiciono_un_nuevo_agente_en_el_sistema_multas() {
		WebUI.setText(findTestObject('Object Repository/agentes/administrarAgente/crearAgente/input_usuario'), "cruz")
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/agentes/administrarAgente/crearAgente/input_placaAgente'), "333")
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/agentes/administrarAgente/crearAgente/btn_guardarAgente'))
	}
	
	@Then("visualizo y verifico que se adicione la información del agente de tránsito")
	def visualizo_y_verifico_que_se_adicione_la_información_del_agente_de_tránsito() {
		WebUI.verifyElementPresent(findTestObject(""), 30)
	}
}
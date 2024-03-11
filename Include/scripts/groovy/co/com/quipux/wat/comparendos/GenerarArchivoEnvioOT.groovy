package co.com.quipux.wat.comparendos
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.lang.reflect.Array

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

class GenerarArchivoEnvioOT 
{
	ArrayList<String> datos = findTestData('Data Files/generarArchivoEnvioOT/generarArchivoEnvioOT (1)').getAllData()
	
	@Given('ingreso a la opcion generar archivo para envío a OT')
	def ingreso_a_la_opcion_generar_archivo_para_envío_a_OT()
	{
		WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/comparendos/generarArchivoEnvioOT/a_generarArchivoParaEnvioOT'))
	}

	@And ('selecciono una secretaria')
	def selecciono_una_secretaria()
	{
		WebUI.selectOptionByLabel(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/comparendos/generarArchivoEnvioOT/select_secretaria'),datos[0][0], false)
	}
	
	@And ('selecciono un tipo de comparendo')
	def selecciono_un_tipo_de_comparendo()
	{
		WebUI.selectOptionByLabel(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/comparendos/generarArchivoEnvioOT/select_tipoComparendo'),datos[0][1], false)
	}
		
	@When('ingrese la fecha')
	def ingrese_la_fecha()
	{
		WebUI.executeJavaScript("document.getElementById('content:textFechaGeneracion_input').value = arguments[0]", Arrays.asList(datos[0][2]))
	}
	
	@Then('presiono el boton generar y verifico descarga del archivo')
	def presiono_el_boton_generar_y_verifico_descarga_del_archivo() 
	{
		WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/comparendos/generarArchivoEnvioOT/button_generar'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/comparendos/generarArchivoEnvioOT/span_mensajeGeneradoExitosamente'), 30)
	}
}
package co.com.quipux.wat.talonarios

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import static org.junit.Assert.assertArrayEquals

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.driver.DriverFactory
import internal.GlobalVariable

import cucumber.api.java.en.Given
import cucumber.api.java.en.And
import cucumber.api.java.en.When
import cucumber.api.java.en.Then


public class AdministrarTalonario {
	ArrayList<String> datos = findTestData('Data Files/talonarios/talonarios (1)').getAllData()

	@Given("ingreso a multas")
	def ingreso_a_multas() {
		WebUI.openBrowser(GlobalVariable.url)
		WebUI.setText(findTestObject('cas-server-webapp/input_usuario'), GlobalVariable.username2)
		WebUI.setEncryptedText(findTestObject('cas-server-webapp/input_contrasenna'), GlobalVariable.password2)
		WebUI.click(findTestObject('cas-server-webapp/input_iniciarSesion'))
		WebUI.delay(2)
		WebUI.maximizeWindow()
	}

	@And ("selecciono administrar talonarios")
	def selecciono_administrar_talonarios() {
		WebUI.click(findTestObject("Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/administrarTalonarios/a_administrarTalonarios"))
	}


	@And 	("selecciono adicionar")
	def selecciono_adicionar() {
		WebUI.click(findTestObject("Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/administrarTalonarios/btn_adicionar"))
	}

	@When  ("ingrese los datos solicitados")
	def ingrese_los_datos_solicitados() {
		WebUI.selectOptionByValue(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/administrarTalonarios/select_tipoTalonario'), datos[0][0], false)
		WebUI.setText(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/administrarTalonarios/input_placaAgente'), datos[0][1])
		WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/administrarTalonarios/input_nroInicialRango'))
		WebUI.delay(2)

		if(datos[0][0].equals('16')) {
			WebUI.setText(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/administrarTalonarios/input_nroInicialRango'), datos[0][2])
			WebUI.setText(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/administrarTalonarios/input_nroFinalRango'), datos[0][3])
		}
		else if(datos[0][0].equals('17')) {
			WebUI.setText(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/administrarTalonarios/input_nroInicialRango'), datos[0][4])
			WebUI.setText(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/administrarTalonarios/input_nroFinalRango'), datos[0][5])
		}
	}


	@And 	("guardo el nuevo talonario")
	def guardo_el_nuevo_talonario() {
		WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/administrarTalonarios/button_guardarTalonario'))
		WebUI.delay(2)
	}


	@Then  ("verifico mensaje confirmacion exitoso")
	def verifico_mensaje_confirmacion_exitoso() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/administrarTalonarios/span_mensajeAlmacenadoExitoso'),30)
	}
}

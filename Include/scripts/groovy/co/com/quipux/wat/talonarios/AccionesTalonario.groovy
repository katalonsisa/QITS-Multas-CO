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

import cucumber.api.java.en.Given
import cucumber.api.java.en.When
import cucumber.api.java.en.And
import cucumber.api.java.en.Then
import internal.GlobalVariable

public class AccionesTalonario {
	
	// Se crea un objeto de la clase ConsultarTalonario() para hacer uso del Data file de excel
	ConsultarTalonario consulta = new ConsultarTalonario()
			
	@Given ('consulte los talonarios de una entidad')
	def consulte_los_talonarios_de_una_entidad() {
		WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/consultarTalonario/button_buscar'))
	}

	@When ('selecciono el primer registro y lo edito')
	def selecciono_el_primer_registro_y_lo_edito() {
		WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/consultarTalonario/accionesTalonario/editar/button_editar'))
		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/consultarTalonario/accionesTalonario/editar/input_placaAgente'), consulta.datos[0][13])
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/consultarTalonario/accionesTalonario/editar/button_guardar'))
		WebUI.delay(2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/consultarTalonario/accionesTalonario/editar/div_leyendaTalonario'), 30)
		WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/consultarTalonario/button_buscar'))
	}

	@And ('luego lo inactivo e ingreso motivo')
	def luego_lo_inactivo_e_ingreso_motivo() {
		WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/consultarTalonario/accionesTalonario/inactivar/button_inactivar'))
		WebUI.setText(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/consultarTalonario/accionesTalonario/inactivar/textarea_motivoInactivacion'), consulta.datos[0][14])
		WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/consultarTalonario/accionesTalonario/inactivar/button_siInactivacion'))
		WebUI.delay(2)
	}

	@And ('luego lo activo de nuevo e ingreso motivo')
	def luego_lo_activo_de_nuevo_e_ingreso_motivo() {
		WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/consultarTalonario/accionesTalonario/activar/button_activar'))
		WebUI.setText(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/consultarTalonario/accionesTalonario/activar/textarea_motivoActivacion'), consulta.datos[0][15])
		WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/consultarTalonario/accionesTalonario/activar/button_siActivacion'))
		WebUI.delay(2)
	}

	@Then ('finalizo eliminando el registro y verifico')
	def finalizo_eliminando_el_registro_y_verifico() {

		WebUI.verifyElementPresent(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/consultarTalonario/span_mensajeConfirmacion'), 30)
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/consultarTalonario/accionesTalonario/eliminar/button_eliminar'))
		WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/consultarTalonario/accionesTalonario/eliminar/button_siEliminarTalonario'))
		WebUI.delay(2)
		WebUI.verifyElementPresent(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/consultarTalonario/accionesTalonario/eliminar/span_mensajeEliminacion'), 30)
		
	}
}

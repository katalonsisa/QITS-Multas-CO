package co.com.quipux.wat.talonarios

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.apache.poi.sl.usermodel.Sheet

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import cucumber.api.java.en.Given
import cucumber.api.java.en.And
import cucumber.api.java.en.When
import cucumber.api.java.en.Then
import internal.GlobalVariable



public class ConsultarTalonario {

	ArrayList<String> datos = findTestData('Data Files/talonarios/talonarios (1)').getAllData()



	@Given('ingreso criterios de busqueda')
	def ingreso_criterios_de_busqueda() {
		if(datos[0][6].equals('Defecto')) {
			WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/consultarTalonario/button_buscar'))
		}
		else if(datos[0][6].equals('Entidad')) {
			WebUI.selectOptionByLabel(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/consultarTalonario/consultaPorEntidad/select_concesionario'), datos[0][9], false)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/consultarTalonario/consultaPorEntidad/select_zona'), datos[0][10], false)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/consultarTalonario/consultaPorEntidad/select_departamento'), datos[0][11], false)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/consultarTalonario/consultaPorEntidad/select_entidadCiudad'), datos[0][12], false)
		}
		else if(datos[0][6].equals('Tipo talonario')) {
			WebUI.selectOptionByLabel(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/consultarTalonario/select_criterioBusqueda'), datos[0][6], false)
			WebUI.selectOptionByValue(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/consultarTalonario/consultaPorTipoTalonario/select_tipoTalonario'), datos[0][0], false)
		}
		else if(datos[0][6].equals('Rango')) {
			WebUI.selectOptionByLabel(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/consultarTalonario/select_criterioBusqueda'), datos[0][6], false)
			WebUI.setText(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/consultarTalonario/consultaPorRango/input_nroInicialRango'), datos[0][2])
			WebUI.setText(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/consultarTalonario/consultaPorRango/input_nroFinalRango'), datos[0][3])
		}
		else if(datos[0][6].equals('Fecha registro')) {
			WebUI.selectOptionByLabel(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/consultarTalonario/select_criterioBusqueda'), datos[0][6], false)
			WebUI.delay(2)
			WebUI.executeJavaScript("document.getElementById('formAdmonTalonarios:fechaDesde_input').value = arguments[0]", Arrays.asList(datos[0][7]))
			WebUI.delay(2)
			WebUI.executeJavaScript("document.getElementById('formAdmonTalonarios:fechaHasta_input').value = arguments[0]", Arrays.asList(datos[0][8]))

			//Se crean los objetos de fechas pero no se estan utilizando en el momento
			//WebUI.setText(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/consultarTalonario/consultaPorFechaRegistro/input_fechaDesde'), datos[0][7])
			//WebUI.setText(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/consultarTalonario/consultaPorFechaRegistro/input_fechaHasta'), datos[0][8])
		}
		else {
			KeywordUtil.markErrorAndStop("El criterio de búsqueda ingresado no existe, por favor verifique")
		}
	}

	@When ('consulte el reporte')
	def consulte_el_reporte() {
		WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/consultarTalonario/button_buscar'))
	}

	boolean descarga=false

	@And ('descargo la consulta')
	def descargo_la_consulta() {
		String home = System.getProperty("user.home");
		File dir = new File(home+"/Downloads/");
		int tamañoI = dir.list().size();
		//println('Cantidad antes'+ ' ' + tamañoI)
		WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/consultarTalonario/exportarExcel/button_exportarExcel'))
		WebUI.delay(1)
		int tamañoF = dir.list().size();
		//println('Cantidad despues'+ ' ' + tamañoF)
		if(tamañoI==tamañoF){
			descarga=false
			KeywordUtil.markErrorAndStop("No descargo el archivo")
		}
		else
		{
			descarga=true
		}
	}

	@And ('selecciono imprimir consulta')
	def selecciono_imprimir_consulta()
	{
		WebUI.click(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/consultarTalonario/opcionImprimir/button_imprimir'))
	}

	@Then ('verifico tabla de resultados impresion y descarga')
	def verifico_tabla_de_resultados_impresion_y_descarga()
	{
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/consultarTalonario/span_mensajeNoResultado'), 30)
		WebUI.verifyElementPresent(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/consultarTalonario/opcionImprimir/span_mensajeProcesoExitoso'), 30)
		if(descarga) WebUI.comment('Se descargo el archivo correctamente')
		WebUI.verifyElementPresent(findTestObject('Object Repository/qxmultas_co/qits/menuPrincipalMultas/talonarios/consultarTalonario/div_tablaResultado'), 30)
	}
}

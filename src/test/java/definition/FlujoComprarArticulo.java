package definition;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configuracionbase.BaseFlow;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.Constants;
import utils.GenericMethods;

public class FlujoComprarArticulo {
  private static final Log log = LogFactory.getLog(FlujoComprarArticulo.class);
	
	@Given("^Ingreso la url de google\"(.*?)\"$")
	public void ingreso_la_url_de_google(String url) throws Throwable {
	  try {
        BaseFlow.driver.manage().deleteAllCookies();
        BaseFlow.driver.get(Constants.URL);
        System.out.println("     Paso 1: Se encuentra en la url: " +url);
        
	  } catch (Exception e) {
        String msgError = "     Paso 1: No pudo ingresar a la url: " +url;
        System.out.println(msgError);
         Assert.fail(msgError);
      }
	}

	@When("^busco la palabra falabella\"(.*?)\"$")
	public void busco_la_palabra_falabella(String pagina) throws Throwable {
	  try {
	    BaseFlow.pageModel.getPalabra().sendKeys(pagina);
	    BaseFlow.pageModel.getBtnBuscar().click();	    
        System.out.println("     Paso 2: Se realiza la busqueda de: " + pagina);
        
      } catch (Exception e) {
        String msgError = "     Paso 2: No pudo se pudo realizar la busqueda de: " + pagina;
        System.out.println(msgError);
        Assert.fail(msgError);
      }
	}

	@When("^selecciono el texto correspondiente\"(.*?)\"$")
	public void selecciono_el_texto_correspondiente(String texto) throws Throwable {
	   try {
	        BaseFlow.pageModel.getTexto().click();
	        System.out.println("     Paso 3: Se selecciono el texto correspondiente");
	        
	      } catch (Exception e) {
	        String msgError = "     Paso 3: No selecciono el texto correspondiente";
	        System.out.println(msgError);
	         Assert.fail(msgError);
	      }
	}

	@When("^ingresar producto\"(.*?)\"$")
	public void ingresar_producto(String producto) throws Throwable {
	  try {
	    GenericMethods.isClickable(BaseFlow.pageModel.getProducto(), 10);
	    BaseFlow.pageModel.getProducto().sendKeys(producto);
	    WebElement table = BaseFlow.driver.findElement(By.xpath("//*[@id='suggestions-list']/div[1]/ul/li"));
        List<WebElement> div = table.findElements(By.tagName("div"));
        for (int x = 0; x < div.size(); x++) {
          if (div.get(x).getText().contains(producto)) {
            WebElement b = BaseFlow.driver.findElement(By.tagName("b"));
            System.out.println(b.getText());
            div.get(x).click();
                System.out.println("  Paso 4: Se busca el producto: "+producto);
                break;
          }
        }
      } catch (Exception e) {
        String msgError = "      Paso 4: No se pudo buscar el producto correcto : "+ producto;
        System.out.println(msgError);
        Assert.fail(msgError);
      }
	}

	@When("^seleccionar producto$")
	public void seleccionar_producto() throws Throwable {
	  try {
        BaseFlow.pageModel.getSelPro().click();
        System.out.println(" Paso 5: No se selecciono el producto correcto");
      } catch (Exception e) {
        String msgError = "      Paso 5: No se selecciono el producto correcto : ";
        System.out.println(msgError);
        Assert.fail(msgError);
      }
	}

	@When("^agregar producto al carro$")
	public void agregar_producto_al_carro() throws Throwable {
	  try {
        BaseFlow.pageModel.getBtnAgregar().click();
        System.out.println(" Paso 6: Se agrega el produto al carro");
      } catch (Exception e) {
        String msgError = "      Paso 6: No se pudo agregar el producto al carro ";
        System.out.println(msgError);
        Assert.fail(msgError);
      }
	}

	@When("^ingresar a la bolsa de compras$")
	public void ingresar_a_la_bolsa_de_compras() throws Throwable {
	  try {
	    WebElement Table = BaseFlow.driver.findElement(By.xpath("//div[@class='fb-overlay__inject']"));
        List<WebElement> a = Table.findElements(By.tagName("a"));
        for (int x = 0; x < a.size(); x++) {
          if (a.get(x).getText().contains("VER BOLSA DE COMPRAS")) {
            a.get(x).click();
            System.out.println(" Paso 7: Se ingresa a la bolsa de compras");
            break;
          }
        }
      } catch (Exception e) {
        String msgError = "      Paso 7: No se pudo ingresar a la bolsa de compras";
        System.out.println(msgError);
        Assert.fail(msgError);
      }
	}

	@When("^aumento cantidad de productos\"(.*?)\"$")
	public void aumento_cantidad_de_productos(String cant) throws Throwable {
	  try {
        BaseFlow.pageModel.getIncrementar().click();
        System.out.println(" Paso 8: Se aumenta la cantidad de productos");
      } catch (Exception e) {
        String msgError = "      Paso 8: No se pudo aumentar la cantidad de productos";
        System.out.println(msgError);
        Assert.fail(msgError);
      }
	}

	@When("^agregar garantia extendida$")
	public void agregar_garantia_extendida() throws Throwable {
	  try {
        Actions act = new Actions(BaseFlow.driver);
        act.moveToElement(BaseFlow.pageModel.getReferencia(), 0, 500).perform();
        BaseFlow.pageModel.getDropdow().click();
        WebDriverWait wait = new WebDriverWait(BaseFlow.driver, 10);
        WebElement ver = wait.until(ExpectedConditions.elementToBeClickable(BaseFlow.pageModel.getGarantia()));
        ver.click();
        System.out.println(" Paso 9: Se selecciona la garantia");
      } catch (Exception e) {
        String msgError = "      Paso 9: No se pudo seleccionar la garantia";
        System.out.println(msgError);
        Assert.fail(msgError);
      }
	}

	@When("^seleccionar boton ir a compra$")
	public void seleccionar_boton_ir_a_compra() throws Throwable {
	  try {
        BaseFlow.pageModel.getBtnCompra().click();
        System.out.println(" Paso 10: Se ingresa a la seccion IR A COMPRAR");
      } catch (Exception e) {
        String msgError = "      Paso 10: No se pudo ingresar a la seccion IR A COMPRAR";
        System.out.println(msgError);
        Assert.fail(msgError);
      }
	}

	@Then("^verifico que muestre la seccion ir a comprar$")
	public void verifico_que_muestre_la_seccion_ir_a_comprar() throws Throwable {
	  try {
        if(BaseFlow.pageModel.getValidar().getText().equals("Bienvenid@ a Falabella.com!")){
          System.out.println(" Paso 11: Se ingresa a la seccion 'Ir a comprar' ");
        }else {
          String msgError = "      Paso 11: No se se encuentra en la seccion correspodiente";
          System.out.println(msgError);
          Assert.fail(msgError);
        }
      } catch (Exception e) {
       log.error("No esta en la seccion correspondiente");
      }
	}
	
}
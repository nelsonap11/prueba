package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageModel {

	// Objetos de la pagina
	@FindBy(how = How.XPATH, using = "//input[@class='gLFyf gsfi']")
	private WebElement palabra;
	
	
	
	@FindBy(how = How.XPATH, using = "//input[@value='Buscar con Google']")
    private WebElement btnBuscar;

	@FindBy(how = How.XPATH, using = "//h3[contains(text(),'Falabella.com - Mejor Compra Online')]")
    private WebElement texto;
	
	@FindBy(how = How.XPATH, using = "//input[@name='Ntt']")
	private WebElement producto;

	@FindBy(how = How.XPATH, using = "//*[@id='suggestions-list']/div[1]/ul/li")
    private WebElement tableProducto;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Consola PS4 500GB + 1 Control')]")
    private WebElement selPro;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Agregar a la bolsa')]")
    private WebElement btnAgregar;

	@FindBy(how = How.XPATH, using = "//a[@href='/falabella-cl/basket'][3]")
    private WebElement bolsaCom;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'+')]")
    private WebElement incrementar;
	
	@FindBy(how = How.XPATH, using = "//input[@value='quantity-ci53862009230']")
    private WebElement valCant;
	
	@FindBy(how = How.XPATH, using = "//h2[contains(text(),' Opciones de pago')]")
	private WebElement referencia;
	    
	@FindBy(how = How.XPATH, using = "//a[@class='fb-inline-dropdown__link js-inline-dropdown__link']")
    private WebElement dropdow;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'2 Años')]")
    private WebElement garantia;

	@FindBy(how = How.XPATH, using = "//button[@class='fb-btn fb-btn-primary fb-btn-icon fb-order-status__continue-purchase js-fb-continue-purchase']")
    private WebElement btnCompra;

    @FindBy(how = How.XPATH, using = "//h1[@class='fbra_heading fbra_unrecognizedUser__fasterCheckoutTitle fbra_test_unrecognizedUser__fasterCheckoutTitle']")
    private WebElement validar;
	
  public WebElement getPalabra() {
    return palabra;
  }

  public void setPalabra(WebElement palabra) {
    this.palabra = palabra;
  }

  public WebElement getBtnBuscar() {
    return btnBuscar;
  }

  public void setBtnBuscar(WebElement btnBuscar) {
    this.btnBuscar = btnBuscar;
  }

  public WebElement getTexto() {
    return texto;
  }

  public void setTexto(WebElement texto) {
    this.texto = texto;
  }

  public WebElement getProducto() {
    return producto;
  }

  public void setProducto(WebElement producto) {
    this.producto = producto;
  }

  public WebElement getSelPro() {
    return selPro;
  }

  public void setSelPro(WebElement selPro) {
    this.selPro = selPro;
  }

  public WebElement getBtnAgregar() {
    return btnAgregar;
  }

  public void setBtnAgregar(WebElement btnAgregar) {
    this.btnAgregar = btnAgregar;
  }

  public WebElement getBolsaCom() {
    return bolsaCom;
  }

  public void setBolsaCom(WebElement bolsaCom) {
    this.bolsaCom = bolsaCom;
  }

  public WebElement getIncrementar() {
    return incrementar;
  }

  public void setIncrementar(WebElement incrementar) {
    this.incrementar = incrementar;
  }

  public WebElement getValCant() {
    return valCant;
  }

  public void setValCant(WebElement valCant) {
    this.valCant = valCant;
  }

  public WebElement getDropdow() {
    return dropdow;
  }

  public void setDropdow(WebElement dropdow) {
    this.dropdow = dropdow;
  }

  public WebElement getGarantia() {
    return garantia;
  }

  public void setGarantia(WebElement garantia) {
    this.garantia = garantia;
  }

  public WebElement getReferencia() {
    return referencia;
  }

  public void setReferencia(WebElement referencia) {
    this.referencia = referencia;
  }

  public WebElement getBtnCompra() {
    return btnCompra;
  }

  public void setBtnCompra(WebElement btnCompra) {
    this.btnCompra = btnCompra;
  }

  public WebElement getValidar() {
    return validar;
  }

  public void setValidar(WebElement validar) {
    this.validar = validar;
  }

  public WebElement getTableProducto() {
    return tableProducto;
  }

  public void setTableProducto(WebElement tableProducto) {
    this.tableProducto = tableProducto;
  }
}
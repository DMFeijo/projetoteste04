package tests;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class CadastrarProdutoTest {

	WebDriver driver;

	@Dado("^Acessar a pagina de cadastro deproduto$")
	public void acessar_a_pagina_de_cadastro_deproduto() {

		System.setProperty("webdriver.chrome.driver", "c:\\teste\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://exercteste01-001-site1.gtempurl.com/Home/Exercicio05");

	}

	@Dado("^Informar o nome do produto \"([^\"]*)\"$")
	public void informar_o_nome_do_produto(String nome) {

		driver.findElement(By.xpath("//*[@id=\"nome\"]")).sendKeys(nome);
	}

	@Dado("^Informar o preco do produto \"([^\"]*)\"$")
	public void informar_o_preco_do_produto(String preco) {

		driver.findElement(By.xpath("//*[@id=\"preco\"]")).sendKeys(preco);

	}

	@Dado("^Informar a quantidade do produto \"([^\"]*)\"$")
	public void informar_a_quantidade_do_produto(String quantidade) {

		driver.findElement(By.xpath("//*[@id=\"quantidade\"]")).sendKeys(quantidade);

	}

	@Quando("^Solicitar a realizacao do cadastro$")
	public void solicitar_a_realizacao_do_cadastro() {

		driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();

	}

	@Então("^Sistema exibe a mensagem \"([^\"]*)\"$")
	public void sistema_exibe_a_mensagem(String resultado) {

		String mensagem = driver.findElement(By.xpath("//*[@id=\"mensagem\"]")).getText();
		assertEquals(mensagem, resultado);

		// gerando a evidencia do teste
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(file, new File("c:\\evidencas\\cadastrarproduto.png"));
		} catch (Exception e) {

		}

		driver.close();
		driver.quit();

	}

}

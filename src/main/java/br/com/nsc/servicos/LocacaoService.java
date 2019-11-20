package br.com.nsc.servicos;

import static br.com.nsc.utils.DataUtils.adicionarDias;

import java.util.Date;

import br.com.nsc.entidades.Filme;
import br.com.nsc.entidades.Locacao;
import br.com.nsc.entidades.Usuario;
import br.com.nsc.utils.DataUtils;

public class LocacaoService {
	
	public Locacao alugarFilme(Usuario usuario, Filme filme) {
		Locacao locacao = new Locacao();
		locacao.setFilme(filme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValor(filme.getPrecoLocacao());

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);
		
		//Salvando a locacao...	
		//TODO adicionar método para salvar
		
		return locacao;
	}

	public static void main(String[] args) {
		//Cen�rio
		LocacaoService locacaoService = new LocacaoService();
		Usuario usuario = new Usuario("Usu�rio 1");
		Filme filme = new Filme("Filme 1", 2, 5.0);
		
		//A��o
		Locacao locacao = locacaoService.alugarFilme(usuario, filme);
		
		//Verifica��o
		System.out.println(locacao.getValor() == 5.0);
		System.out.println(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		System.out.println(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
	}
	/*	
	Fast
	Independent
	Repeatable
	Self Verifying
	Timely
	*/
}
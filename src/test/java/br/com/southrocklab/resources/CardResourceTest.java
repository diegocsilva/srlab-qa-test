package br.com.southrocklab.resources;

import br.com.southrocklab.ApplicationTests;
import org.junit.Test;

public class CardResourceTest extends ApplicationTests {

    @Test
    public void deve_salvar_novo_card_no_sistema() {
    }

    @Test
    public void deve_retornar_status_400_quando_salvar_card_com_cvv_maior_que_999() {
    }

    @Test
    public void deve_retornar_status_400_quando_salvar_card_com_expiration_month_maior_que_12() {
    }

    @Test
    public void deve_retornar_status_400_quando_salvar_card_com_expiration_year_menor_que_2022() {
    }

    @Test
    public void deve_retornar_status_400_quando_salvar_card_com_number_de_15_digitos() {
    }

    @Test
    public void deve_deletar_um_card_salvo_no_sistema() {
    }

    @Test
    public void deve_retornar_status_404_ao_deletar_um_card_com_id_nao_salvo_no_sistema() {
    }
}

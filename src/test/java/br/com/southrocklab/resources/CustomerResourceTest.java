package br.com.southrocklab.resources;

import br.com.southrocklab.ApplicationTests;
import org.junit.Test;

public class CustomerResourceTest extends ApplicationTests {

    @Test
    public void deve_salvar_novo_customer_no_sistema() {
    }

    @Test
    public void deve_retornar_status_400_quando_salvar_customer_ja_salvo() {
    }

    @Test
    public void deve_retornar_status_400_quando_salvar_customer_com_birth_date_maior_que_hoje() {
    }

    @Test
    public void deve_procurar_customer_pelo_name_e_last_name() {
    }

    @Test
    public void deve_retornar_status_404_quando_buscar_customer_por_name_e_last_name_inexistente() {
    }

    @Test
    public void deve_atualizar_o_last_name_de_um_customer() {
    }

    @Test
    public void deve_retornar_status_404_ao_atualizar_um_customer_com_id_nao_salvo_no_sistema() {
    }

    @Test
    public void deve_deletar_um_customer_salvo_no_sistema() {
    }

    @Test
    public void deve_retornar_status_404_ao_deletar_um_customer_com_id_nao_salvo_no_sistema() {
    }
}

import br.com.cielo.bootcampdesafio02.domain.entity.Cliente;
import br.com.cielo.bootcampdesafio02.domain.entity.Empresa;


public class Factory {


    public static Cliente createCliente(){
        Cliente cliente = new Cliente(
                1l,
                "37625734846",
                "0004" ,
                "rafael",
                "rafael@gmail.com");
        return cliente;
    }
    public static Empresa createEmpresa(){
        Empresa empresa = new Empresa(1l,
                "37625734846234",
                "empresa teste",
                "0020",
                "37625734899",
                "contrato teste",
                "emprega@gmail.com");
        return empresa;
    }

}

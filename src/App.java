public class App {
    public static void main(String[] args) throws Exception {
        
        Agencia caixaLuizote = new Agencia("0205-08");
        ContaCorrente contaCorrente = new ContaCorrente(caixaLuizote, "1164-9",500d,1000);
        ContaPoupanca contaPoupanca = new ContaPoupanca(caixaLuizote, "1324-9",700d);
        ContaSalario contaSalario = new ContaSalario(caixaLuizote, "1216-9", 1500d);

        caixaLuizote.addContaRentavel(contaPoupanca);
        caixaLuizote.addContaEssencial(contaCorrente);
        caixaLuizote.addContaEssencial(contaSalario);
        caixaLuizote.saque("1164-9",1200);
        caixaLuizote.saque("1324-9", 700);
        caixaLuizote.saque("1216-9", 500);
        caixaLuizote.atualizarRendimentoContas(0.05);

        caixaLuizote.getExtratoConta("1164-9");
        caixaLuizote.getExtratoConta("1324-9");
        caixaLuizote.getExtratoConta("1216-9");
    }
}

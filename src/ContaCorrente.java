public class ContaCorrente implements ContaEssencial {

   private Agencia agencia;
   private String numeroConta;
   private double saldo;
   private double limiteChequeEspecial;

   public ContaCorrente(Agencia agencia, String numeroConta, double saldo, double limiteChequeEspecial) {
      this.agencia = agencia;
      this.numeroConta = numeroConta;
      this.saldo = saldo;
      this.limiteChequeEspecial = limiteChequeEspecial;
   }

   @Override
   public void saque(Double valor) throws ContaException {
      if (valor > 0) {
         if (this.saldo + limiteChequeEspecial >= valor) {
            this.saldo -= valor;
         } else {
            throw new ContaException("Conta sem saldo suficiente: " + this.saldo);
         }
      } else {
         throw new ContaException("Valor inválido para saque " + valor);
      }
   }

   @Override
   public void deposito(Double valor) throws ContaException {
      if (valor > 0) {
         this.saldo += valor;
      } else {
         throw new ContaException("Valor invalido para deposito " + valor);
      }
   }

   @Override
   public String getNumeroConta() {
      return numeroConta;
   }

}


public class ContaCorrente implements ContaEssencial, Tarifavel {

   private Agencia agencia;
   private String numeroConta;
   private double saldo;
   private double limiteChequeEspecial;

   public ContaCorrente(Agencia agencia, String numeroConta, double saldo, double limiteChequeEspecial) throws ContaException {
      this.agencia = agencia;
      this.numeroConta = numeroConta;
      this.saldo = tarifaConta(saldo);
      this.limiteChequeEspecial = limiteChequeEspecial;
   }

   @Override
   public void saque(Double valor) throws ContaException {
      if (valor > 0) {
         if (this.saldo + limiteChequeEspecial >= valor) {
            this.saldo -= valor;
         } else {
            throw new ContaException("Conta corrente sem saldo suficiente: " + this.saldo);
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

   @Override
   public double tarifaConta(Double saldo) throws ContaException {

      double tarifa = 30.0;

      if(saldo > 30.0) {
         saldo -= tarifa;   
         return saldo;

      } else {
         throw new ContaException("Saldo insuficiente para cobrança da taxa");
      }

   }

   @Override
   public String toString() {
      return "ContaCorrente [agencia=" + agencia.getNumero() + ", numeroConta=" + numeroConta + ", saldo=" + saldo
            + ", limiteChequeEspecial=" + limiteChequeEspecial + "]";
   }

   

}


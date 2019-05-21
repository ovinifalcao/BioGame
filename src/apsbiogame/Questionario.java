
package apsbiogame;

public class Questionario {
    

    private String Questao;
    private String Resposta;
    private String Op_01;
    private String Op_02;    
    private String Op_03;    
    private String Op_04;   
    
    public Questionario(String Qst, String Resp, String Op1, String Op2, String Op3, String Op4)
    {
        this.Questao = Qst;
        this.Resposta = Resp;
        this.Op_01 = Op1;
        this.Op_02 = Op2;
        this.Op_03 = Op3;
        this.Op_04 = Op4;
        
    }

    Questionario() {
  
    }
    
    public void MeImprime()
    {
        System.out.print(Questao);
    }
    
    public String getQuestao() { return Questao; }
    public String getResposta() { return Resposta; }
    public String getOp1() { return Op_01; }
    public String getOp2() { return Op_02; }
    public String getOp3() { return Op_03; }
    public String getOp4() { return Op_04; }
}

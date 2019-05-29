package apsbiogame;

import java.util.Random;
import javax.swing.JCheckBox;

public class ExcluiOp extends HelperTip {

    private javax.swing.JCheckBox[] Checkb;
    private String Resposta;
    private javax.swing.JCheckBox ChekbEscolhido;
    
    @Override
    protected void Ajudar() {
        
        int Rand;
        boolean ChkEncontrado = false;
        
        do{
            Random r = new Random();
            Rand = r.nextInt((4 - 0) + 1) + 0;
            
            if(!Checkb[Rand].getText().isEmpty() && !Checkb[Rand].getText().equals(Resposta))
            {
                ChkEncontrado = true;
                ChekbEscolhido = Checkb[Rand];
            }
            
        }while(!ChkEncontrado);
    }
    
    public void setCheckb(JCheckBox[] TodosOsCks)
    {
        Checkb = TodosOsCks;
    }

    public void setResposta(String Resposta)
    {
        this.Resposta = Resposta;
    }    
    
    public javax.swing.JCheckBox getChekFinal()
    {
        if(ChekbEscolhido != null)
        {
            return ChekbEscolhido;
        }
        else
        {
            return null;
        }
    }


}

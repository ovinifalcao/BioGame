package apsbiogame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;


public class Perguntas_frame extends javax.swing.JFrame {

        private String Resposta;
        private String RespEscolhida;
        private List<Questionario> XmlToList;
        private int Dificuldade;
        private ArrayList<Integer> QuestDone = new ArrayList<>();
        private int ContadorGeral = 0;
        private int Pontuacao = 0;
    
    public Perguntas_frame(int Dificuldade)
    {
        initComponents();
        this.Dificuldade = Dificuldade;
        LerDados();  
        VerificaRangePerguntas(9);
    }
    
    private void LerDados()
    {
        XmlToList = XmlLoader.XmlToList();  
    }
    
    private void VerificaRangePerguntas(int FinalRange)
    {
        if(ContadorGeral <= FinalRange)
        {
            SelecionaPerguntaRamdon();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Parece que você respodeu todas as questões, reinicie o jogo para jogar novamente");
            this.setVisible(false);
            
            Frm_EntradaGama TelaInicial = new Frm_EntradaGama();
            TelaInicial.setVisible(true);
        }
    
    }
    
    private void SelecionaPerguntaRamdon()
    {
        AtualizaPainel();
        
        int Rand;

        do{
            Random r = new Random();
            Rand = r.nextInt((9 - 0) + 1) + 0;
        }while(QuestDone.contains(Rand));
        
        QuestDone.add(Rand);
        ContadorGeral++;
        Resposta = XmlToList.get(Rand).getResposta();

        String[] OpcoesOrdenas = new String[Dificuldade];
        OpcoesOrdenas[0] = XmlToList.get(Rand).getResposta();
        OpcoesOrdenas[1] = XmlToList.get(Rand).getOp1();
        OpcoesOrdenas[2] = XmlToList.get(Rand).getOp2();
        if(Dificuldade > 3) OpcoesOrdenas[3] = XmlToList.get(Rand).getOp3();
        if(Dificuldade > 4) OpcoesOrdenas[4] = XmlToList.get(Rand).getOp4();

        String[] todasAsOpcoes =  PopulaQuestRandomico(OpcoesOrdenas);

        jTextArea1.setText(XmlToList.get(Rand).getQuestao());
        jCheckBox6.setText(todasAsOpcoes[0]);
        jCheckBox7.setText(todasAsOpcoes[1]);
        jCheckBox8.setText(todasAsOpcoes[2]); 

        if(Dificuldade > 3){
            jCheckBox9.setText(todasAsOpcoes[3]); 
        } 
        else{
            jCheckBox9.setVisible(false);
        }


        if(Dificuldade > 4){
            jCheckBox10.setText(todasAsOpcoes[4]); 
        } 
        else{
            jCheckBox10.setVisible(false);
        }      
    }
    
    private void AtualizaPainel()
    {
       jLabel7.setText("Pontos:" + Pontuacao);
       jLabel5.setText("Pergunta nº "+ (ContadorGeral +1) +" / 50");
    }
    
    private String[] PopulaQuestRandomico(String[] OpcoesOrdenas)
    {     
        String[] OpcsFinal;
        OpcsFinal = new String[OpcoesOrdenas.length];
        
        
        boolean valorValido;
        
        int Rand;
            for (String OpcoesOrdena : OpcoesOrdenas) {
                do {
                    Random r = new Random();
                    Rand = r.nextInt(((OpcoesOrdenas.length - 1) - 0) + 1) + 0;
                    if (OpcsFinal[Rand] == null) {
                        OpcsFinal[Rand] = OpcoesOrdena;
                        valorValido = false;
                    } else {
                        valorValido = true;
                    }
                } while (valorValido);
            }
            
        return OpcsFinal;
    }
    
    public Perguntas_frame() {
        initComponents();
    }

    private void setAllChecks(JCheckBox meuCheck, boolean IsEndQuest)
    {
        jCheckBox6.setSelected(false);
        jCheckBox7.setSelected(false);
        jCheckBox8.setSelected(false);
        jCheckBox9.setSelected(false);
        jCheckBox10.setSelected(false); 
        
        if(!IsEndQuest)
        {
            meuCheck.setSelected(true);
            RespEscolhida = meuCheck.getText();  
        }
        
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Pergunta nº 1 / 50");
        jLabel5.setAlignmentX(10.0F);
        jLabel5.setAlignmentY(5.0F);
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("BioGame 1.0.0");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("PontosUser: 50");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addGap(164, 164, 164)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jButton2.setText("Confirmar Resposta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jCheckBox6.setText("jCheckBox1");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        jCheckBox7.setText("jCheckBox2");
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });

        jCheckBox8.setText("jCheckBox3");
        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox8ActionPerformed(evt);
            }
        });

        jCheckBox9.setText("jCheckBox4");
        jCheckBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox9ActionPerformed(evt);
            }
        });

        jCheckBox10.setText("jCheckBox5");
        jCheckBox10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox10ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setAutoscrolls(false);
        jTextArea1.setBorder(null);
        jTextArea1.setFocusable(false);
        jScrollPane1.setViewportView(jTextArea1);
        jTextArea1.getAccessibleContext().setAccessibleName("txtArea");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCheckBox6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCheckBox8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jCheckBox9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCheckBox10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.getAccessibleContext().setAccessibleName("PnHeader");
        jButton2.getAccessibleContext().setAccessibleName("btnConfirmar");
        jCheckBox6.getAccessibleContext().setAccessibleName("ckBox1");
        jCheckBox6.getAccessibleContext().setAccessibleDescription("");
        jCheckBox7.getAccessibleContext().setAccessibleName("ckBox1");
        jCheckBox8.getAccessibleContext().setAccessibleName("ckBox1");
        jCheckBox9.getAccessibleContext().setAccessibleName("ckBox1");
        jCheckBox10.getAccessibleContext().setAccessibleName("ckBox1");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        setAllChecks(jCheckBox6, false);
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
        setAllChecks(jCheckBox7, false);
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox8ActionPerformed
        setAllChecks(jCheckBox8, false);
    }//GEN-LAST:event_jCheckBox8ActionPerformed

    private void jCheckBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox9ActionPerformed
        setAllChecks(jCheckBox9, false);
    }//GEN-LAST:event_jCheckBox9ActionPerformed

    private void jCheckBox10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox10ActionPerformed
        setAllChecks(jCheckBox10, false);
    }//GEN-LAST:event_jCheckBox10ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(RespEscolhida != null)
        {
            if(RespEscolhida.equals(Resposta))
            {
                System.out.print("Certo");
                JOptionPane.showMessageDialog(null,"AcertouMizerávore");
                Pontuacao++;
            }
            else
            {
                System.out.print("Errado");
                JOptionPane.showMessageDialog(null,"ErrouMizerávore");
            }
            setAllChecks(null, true);
            SelecionaPerguntaRamdon();
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Perguntas_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Perguntas_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Perguntas_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Perguntas_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Perguntas_frame().setVisible(true);
            }
        });
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}

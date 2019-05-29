package apsbiogame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

public class Perguntas_frame extends javax.swing.JFrame {

    private String Resposta;
    private String RespEscolhida;
    private List< Questionario> XmlToList;
    private int Dificuldade;
    private ArrayList< Integer> QuestDone = new ArrayList<>();
    private int ContadorGeral = 0;
    private int Pontuacao = 0;

    public Perguntas_frame() {
        initComponents();
    }

    public Perguntas_frame(int Dificuldade) {
        initComponents();
        this.Dificuldade = Dificuldade;
        LerDados();
        SelecionaPerguntaRamdon();
    }

    private void LerDados() {
        XmlToList = XmlLoader.XmlToList();
    }

    private void VerificaRangePerguntas(int FinalRange) {
        if (!(ContadorGeral >= FinalRange)) {
            SelecionaPerguntaRamdon();
        } else {
            JOptionPane.showMessageDialog(null, "Você respondeu todas as questões! Sua pontuação foi: " + Pontuacao + ". Para jogar novamente, reinicie o jogo");
            this.setVisible(false);
        }
    }

    private void SelecionaPerguntaRamdon() {
        AtualizaPainel();
        int Rand;
        do {
            Random r = new Random();
            Rand = r.nextInt((XmlToList.size() - 0) + 1) + 0;
        } while (QuestDone.contains(Rand));
        QuestDone.add(Rand);
        ContadorGeral++;
        Resposta = XmlToList.get(Rand).getResposta();
        String[] OpcoesOrdenas = new String[Dificuldade];
        OpcoesOrdenas[0] = XmlToList.get(Rand).getResposta();
        OpcoesOrdenas[1] = XmlToList.get(Rand).getOp1();
        OpcoesOrdenas[2] = XmlToList.get(Rand).getOp2();
        if (Dificuldade > 3) {
            OpcoesOrdenas[3] = XmlToList.get(Rand).getOp3();
        }
        if (Dificuldade > 4) {
            OpcoesOrdenas[4] = XmlToList.get(Rand).getOp4();
        }
        String[] todasAsOpcoes = PopulaQuestRandomico(OpcoesOrdenas);
        jTextArea1.setText(XmlToList.get(Rand).getQuestao());
        jCheckBox6.setText(todasAsOpcoes[0]);
        jCheckBox7.setText(todasAsOpcoes[1]);
        jCheckBox8.setText(todasAsOpcoes[2]);
        if (Dificuldade > 3) {
            jCheckBox9.setText(todasAsOpcoes[3]);
        } else {
            jCheckBox9.setVisible(false);
        }
        if (Dificuldade > 4) {
            jCheckBox10.setText(todasAsOpcoes[4]);
        } else {
            jCheckBox10.setVisible(false);
        }
    }

    private javax.swing.JCheckBox[] TodosOsChks() {
        javax.swing.JCheckBox[] CheksErrados = {
            jCheckBox6,
            jCheckBox7,
            jCheckBox8,
            jCheckBox9,
            jCheckBox10,};
        return CheksErrados;
    }

    private void AtualizaPainel() {
        jLabel2.setText("Pontos:" + Pontuacao);
        jLabel1.setText("Pergunta nº " + (ContadorGeral + 1) + " / 50");
        jCheckBox10.setVisible(true);
        jCheckBox9.setVisible(true);
        jCheckBox8.setVisible(true);
        jCheckBox7.setVisible(true);
        jCheckBox6.setVisible(true);
        RespEscolhida = "";
    }

    private String[] PopulaQuestRandomico(String[] OpcoesOrdenas) {
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

    private void setAllChecks(JCheckBox meuCheck, boolean IsEndQuest) {
        jCheckBox6.setSelected(false);
        jCheckBox7.setSelected(false);
        jCheckBox8.setSelected(false);
        jCheckBox9.setSelected(false);
        jCheckBox10.setSelected(false);
        if (!IsEndQuest) {
            meuCheck.setSelected(true);
            RespEscolhida = meuCheck.getText();
        }
    }

    //polimorfismo    
    private void ChamarPorAjuda(HelperTip Ajudador) {
        Ajudador.Ajudar();
        Ajudador.setJaUsada(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pergunta nº 1/50");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pontos:0");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("BioGame 1.0.0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(205, 205, 205)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 253, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Confirmar Resposta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Remover uma opção");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Pular Questão");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jCheckBox6.setText("jCheckBox6");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        jCheckBox7.setText("jCheckBox7");
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });

        jCheckBox8.setText("jCheckBox8");
        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox8ActionPerformed(evt);
            }
        });

        jCheckBox9.setText("jCheckBox9");
        jCheckBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox9ActionPerformed(evt);
            }
        });

        jCheckBox10.setText("jCheckBox10");
        jCheckBox10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox10)
                            .addComponent(jCheckBox8)
                            .addComponent(jCheckBox7)
                            .addComponent(jCheckBox6)
                            .addComponent(jCheckBox9))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox6)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox7)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox8)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox9)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        PulaQuest AjudaPlOp = new PulaQuest();
        int input = JOptionPane.showOptionDialog(null, "Você só pode esse botão uma vez, tem certeza que quer usar agora?", "Continuar?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
        if (input == JOptionPane.OK_OPTION) {
            ChamarPorAjuda(AjudaPlOp);
        }
        if (AjudaPlOp.JaUsada) {
            jButton3.setEnabled(false);
        }
        if (AjudaPlOp.PontoDePulo) {
            Pontuacao++;
            setAllChecks(null, true);
            SelecionaPerguntaRamdon();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!RespEscolhida.isEmpty()) {
            if (RespEscolhida.equals(Resposta)) {
                System.out.print("Certo");
                JOptionPane.showMessageDialog(null, "Resposta correta");
                Pontuacao++;
            } else {
                System.out.print("Errado");
                JOptionPane.showMessageDialog(null, "Resposta Errada");
            }
            setAllChecks(null, true);
            VerificaRangePerguntas(XmlToList.size());
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, escolha ao menos uma resposta antes de confirmar.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ExcluiOp AjudaExOp = new ExcluiOp();
        int input = JOptionPane.showOptionDialog(null, "Você só pode esse botão uma vez, tem certeza que quer usar agora?", "Continuar?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
        if (input == JOptionPane.OK_OPTION) {
            AjudaExOp.setCheckb(TodosOsChks());
            AjudaExOp.setResposta(Resposta);
            ChamarPorAjuda(AjudaExOp);
            AjudaExOp.getChekFinal().setVisible(false);
        }
        if (AjudaExOp.JaUsada) {
            jButton2.setEnabled(false);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}

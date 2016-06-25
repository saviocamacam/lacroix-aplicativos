/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MainFrameController;
import controller.ModeloMainFrameController;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import dao.UsuarioDao;
import java.awt.CardLayout;
import model.Aula;
import model.Curso;
import model.Usuario;
import model.Evento;
import model.Materia;
import model.TipoEvento;

/**
 *
 * @author a1647890
 */
public class ModeloMainFrame extends javax.swing.JFrame {
	
	private ModeloMainFrameController controller;

    /**
     * Creates new form NovoJFrame
     */
    public ModeloMainFrame() {
        initComponents();
    }

    public ModeloMainFrame(Usuario usuario, Curso curso) {
    	controller = new ModeloMainFrameController(usuario, curso);
		initComponents();
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				for(Evento evento : controller.getEventos()){
					((EventoTableModel)tableProximosEventos.getModel()).addRow(evento);
				}
				
			}
		});
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				for(Aula aula : controller.getAulasDia()){
					((AulaTableModel)tableAulasDoDia.getModel()).addRow(aula);
				}
				
			}
		});
	}

	/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelCabecalho = new java.awt.Panel();
        nomeUsuarioLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelColuna = new java.awt.Panel();
        eventoPanel = new javax.swing.JPanel();
        novoEventoButton = new javax.swing.JToggleButton();
        esperaEventoButton = new javax.swing.JButton();
        finalizadosEventoButton = new javax.swing.JToggleButton();
        materiaPanel = new javax.swing.JPanel();
        novaMateriaButton = new javax.swing.JButton();
        todasMateriaButton = new javax.swing.JButton();
        professoresMateriaButton = new javax.swing.JButton();
        periodoPanel = new javax.swing.JPanel();
        historicoPeriodoButton = new javax.swing.JButton();
        novoPeriodoButton = new javax.swing.JButton();
        cursoPanel = new javax.swing.JPanel();
        informacoesCursoButton = new javax.swing.JButton();
        panelProximosEventos = new java.awt.Panel();
        proximosEventosPanel = new javax.swing.JPanel();
        proximosEventosLabel = new java.awt.Label();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableProximosEventos = new javax.swing.JTable();
        eventosFinalizadosPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableEventosFinalizados = new javax.swing.JTable();
        eventosFinalizadosLabel = new java.awt.Label();
        novoEventoPanel = new javax.swing.JPanel();
        novoEventoLabel = new java.awt.Label();
        botaoConcluirEvento = new javax.swing.JButton();
        comboboxTipoEvento = new javax.swing.JComboBox<>();
        labelTipoEvento = new javax.swing.JLabel();
        scrollPaneTextObservacoes = new javax.swing.JScrollPane();
        textObservacoes = new javax.swing.JTextPane();
        labelDescricao = new javax.swing.JLabel();
        comboboxMaterias = new javax.swing.JComboBox<>();
        dateEvento = new com.toedter.calendar.JDateChooser();
        labelMaterias = new javax.swing.JLabel();
        campoDescricao = new javax.swing.JTextField();
        labelDataFinal = new javax.swing.JLabel();
        labelObservacoes = new javax.swing.JLabel();
        labelLocal = new javax.swing.JLabel();
        campoLocal = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        panelDiaDaSemana = new java.awt.Panel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableAulasDoDia = new javax.swing.JTable();
        diaDaSemanaLabel = new java.awt.Label();
        panelDiaDaSemana1 = new java.awt.Panel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableAulasDoDia1 = new javax.swing.JTable();
        diaDaSemanaLabel1 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setFocusableWindowState(false);
        setMinimumSize(new java.awt.Dimension(840, 600));
        setName("mainFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(840, 600));

        panelCabecalho.setBackground(new java.awt.Color(200, 198, 198));
        panelCabecalho.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        nomeUsuarioLabel.setText("Nome Do Usuário");

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout panelCabecalhoLayout = new javax.swing.GroupLayout(panelCabecalho);
        panelCabecalho.setLayout(panelCabecalhoLayout);
        panelCabecalhoLayout.setHorizontalGroup(
            panelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCabecalhoLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(nomeUsuarioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(45, 45, 45))
        );
        panelCabecalhoLayout.setVerticalGroup(
            panelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCabecalhoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeUsuarioLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        getContentPane().add(panelCabecalho, java.awt.BorderLayout.NORTH);

        panelColuna.setBackground(new java.awt.Color(200, 198, 198));
        panelColuna.setLayout(new javax.swing.BoxLayout(panelColuna, javax.swing.BoxLayout.Y_AXIS));

        eventoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Eventos"));
        eventoPanel.setLayout(new javax.swing.BoxLayout(eventoPanel, javax.swing.BoxLayout.Y_AXIS));

        novoEventoButton.setText("Novo");
        novoEventoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoEventoButtonActionPerformed(evt);
            }
        });
        eventoPanel.add(novoEventoButton);

        esperaEventoButton.setText("Espera");
        esperaEventoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esperaEventoButtonActionPerformed(evt);
            }
        });
        eventoPanel.add(esperaEventoButton);

        finalizadosEventoButton.setText("Finalizados");
        finalizadosEventoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizadosEventoButtonActionPerformed(evt);
            }
        });
        eventoPanel.add(finalizadosEventoButton);

        panelColuna.add(eventoPanel);

        materiaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Matérias"));
        materiaPanel.setLayout(new javax.swing.BoxLayout(materiaPanel, javax.swing.BoxLayout.Y_AXIS));

        novaMateriaButton.setText("Nova");
        novaMateriaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novaMateriaButtonActionPerformed(evt);
            }
        });
        materiaPanel.add(novaMateriaButton);

        todasMateriaButton.setText("Todas");
        todasMateriaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todasMateriaButtonActionPerformed(evt);
            }
        });
        materiaPanel.add(todasMateriaButton);

        professoresMateriaButton.setText("Professores");
        professoresMateriaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                professoresMateriaButtonActionPerformed(evt);
            }
        });
        materiaPanel.add(professoresMateriaButton);

        panelColuna.add(materiaPanel);

        periodoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Períodos"));
        periodoPanel.setLayout(new javax.swing.BoxLayout(periodoPanel, javax.swing.BoxLayout.Y_AXIS));

        historicoPeriodoButton.setText("Histórico");
        historicoPeriodoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historicoPeriodoButtonActionPerformed(evt);
            }
        });
        periodoPanel.add(historicoPeriodoButton);

        novoPeriodoButton.setText("Novo");
        novoPeriodoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoPeriodoButtonActionPerformed(evt);
            }
        });
        periodoPanel.add(novoPeriodoButton);

        panelColuna.add(periodoPanel);

        cursoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Cursos"));
        cursoPanel.setLayout(new javax.swing.BoxLayout(cursoPanel, javax.swing.BoxLayout.Y_AXIS));

        informacoesCursoButton.setText("Informações");
        informacoesCursoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                informacoesCursoButtonActionPerformed(evt);
            }
        });
        cursoPanel.add(informacoesCursoButton);

        panelColuna.add(cursoPanel);

        getContentPane().add(panelColuna, java.awt.BorderLayout.WEST);

        panelProximosEventos.setBackground(new java.awt.Color(200, 198, 198));
        panelProximosEventos.setLayout(new java.awt.CardLayout());

        proximosEventosLabel.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        proximosEventosLabel.setText(" Próximos Eventos");

        tableProximosEventos.setModel(new EventoTableModel());
        tableProximosEventos.setColumnSelectionAllowed(true);
        jScrollPane3.setViewportView(tableProximosEventos);
        tableProximosEventos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout proximosEventosPanelLayout = new javax.swing.GroupLayout(proximosEventosPanel);
        proximosEventosPanel.setLayout(proximosEventosPanelLayout);
        proximosEventosPanelLayout.setHorizontalGroup(
            proximosEventosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(proximosEventosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(proximosEventosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(proximosEventosLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE))
                .addContainerGap())
        );
        proximosEventosPanelLayout.setVerticalGroup(
            proximosEventosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(proximosEventosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(proximosEventosLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelProximosEventos.add(proximosEventosPanel, "ProximosEventos");

        tableEventosFinalizados.setModel(new EventoTableModel());
        tableEventosFinalizados.setColumnSelectionAllowed(true);
        jScrollPane5.setViewportView(tableEventosFinalizados);
        tableEventosFinalizados.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        eventosFinalizadosLabel.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        eventosFinalizadosLabel.setText("  Eventos Finalizados");

        javax.swing.GroupLayout eventosFinalizadosPanelLayout = new javax.swing.GroupLayout(eventosFinalizadosPanel);
        eventosFinalizadosPanel.setLayout(eventosFinalizadosPanelLayout);
        eventosFinalizadosPanelLayout.setHorizontalGroup(
            eventosFinalizadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eventosFinalizadosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eventosFinalizadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eventosFinalizadosLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        eventosFinalizadosPanelLayout.setVerticalGroup(
            eventosFinalizadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eventosFinalizadosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(eventosFinalizadosLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelProximosEventos.add(eventosFinalizadosPanel, "EventosFinalizados");

        novoEventoPanel.setLayout(new javax.swing.BoxLayout(novoEventoPanel, javax.swing.BoxLayout.Y_AXIS));

        novoEventoLabel.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        novoEventoLabel.setText("  Novo Evento");
        novoEventoPanel.add(novoEventoLabel);

        botaoConcluirEvento.setText("Concluir");
        botaoConcluirEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConcluirEventoActionPerformed(evt);
            }
        });
        novoEventoPanel.add(botaoConcluirEvento);

        comboboxTipoEvento.setModel(new javax.swing.DefaultComboBoxModel<>());
        comboboxTipoEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxTipoEventoActionPerformed(evt);
            }
        });
        novoEventoPanel.add(comboboxTipoEvento);

        labelTipoEvento.setText("Tipo");
        novoEventoPanel.add(labelTipoEvento);

        scrollPaneTextObservacoes.setViewportView(textObservacoes);

        novoEventoPanel.add(scrollPaneTextObservacoes);

        labelDescricao.setText("Nome");
        novoEventoPanel.add(labelDescricao);

        comboboxMaterias.setModel(new javax.swing.DefaultComboBoxModel<>());
        comboboxMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxMateriasActionPerformed(evt);
            }
        });
        novoEventoPanel.add(comboboxMaterias);
        novoEventoPanel.add(dateEvento);

        labelMaterias.setText("Materia");
        novoEventoPanel.add(labelMaterias);

        campoDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDescricaoActionPerformed(evt);
            }
        });
        novoEventoPanel.add(campoDescricao);

        labelDataFinal.setText("Data Final");
        novoEventoPanel.add(labelDataFinal);

        labelObservacoes.setText("Observações");
        novoEventoPanel.add(labelObservacoes);

        labelLocal.setText("Local");
        novoEventoPanel.add(labelLocal);

        campoLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoLocalActionPerformed(evt);
            }
        });
        novoEventoPanel.add(campoLocal);

        panelProximosEventos.add(novoEventoPanel, "NovoEvento");

        getContentPane().add(panelProximosEventos, java.awt.BorderLayout.CENTER);

        panelDiaDaSemana.setBackground(new java.awt.Color(200, 198, 198));

        tableAulasDoDia.setModel(new AulaTableModel());
        tableAulasDoDia.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(tableAulasDoDia);
        tableAulasDoDia.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        diaDaSemanaLabel.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        diaDaSemanaLabel.setText(controller.getDiaSemana().toString());

        javax.swing.GroupLayout panelDiaDaSemanaLayout = new javax.swing.GroupLayout(panelDiaDaSemana);
        panelDiaDaSemana.setLayout(panelDiaDaSemanaLayout);
        panelDiaDaSemanaLayout.setHorizontalGroup(
            panelDiaDaSemanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDiaDaSemanaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDiaDaSemanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(diaDaSemanaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelDiaDaSemanaLayout.setVerticalGroup(
            panelDiaDaSemanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDiaDaSemanaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(diaDaSemanaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelDiaDaSemana1.setBackground(new java.awt.Color(200, 198, 198));

        tableAulasDoDia1.setModel(new AulaTableModel());
        jScrollPane4.setViewportView(tableAulasDoDia1);
        tableAulasDoDia1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        diaDaSemanaLabel1.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        diaDaSemanaLabel1.setText(controller.getDiaSemana().toString());

        javax.swing.GroupLayout panelDiaDaSemana1Layout = new javax.swing.GroupLayout(panelDiaDaSemana1);
        panelDiaDaSemana1.setLayout(panelDiaDaSemana1Layout);
        panelDiaDaSemana1Layout.setHorizontalGroup(
            panelDiaDaSemana1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDiaDaSemana1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDiaDaSemana1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(diaDaSemanaLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelDiaDaSemana1Layout.setVerticalGroup(
            panelDiaDaSemana1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDiaDaSemana1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(diaDaSemanaLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDiaDaSemana, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelDiaDaSemana1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(panelDiaDaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(panelDiaDaSemana1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.EAST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void esperaEventoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esperaEventoButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_esperaEventoButtonActionPerformed

    private void novaMateriaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novaMateriaButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_novaMateriaButtonActionPerformed

    private void todasMateriaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todasMateriaButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_todasMateriaButtonActionPerformed

    private void professoresMateriaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_professoresMateriaButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_professoresMateriaButtonActionPerformed

    private void historicoPeriodoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historicoPeriodoButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_historicoPeriodoButtonActionPerformed

    private void novoPeriodoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoPeriodoButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_novoPeriodoButtonActionPerformed

    private void informacoesCursoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_informacoesCursoButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_informacoesCursoButtonActionPerformed

    private void finalizadosEventoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizadosEventoButtonActionPerformed
        CardLayout layout = (CardLayout) panelProximosEventos.getLayout();
        if( finalizadosEventoButton.isSelected()){
            layout.show(panelProximosEventos, "EventosFinalizados" );
        } else {
            layout.show(panelProximosEventos, "ProximosEventos");
        }
    }//GEN-LAST:event_finalizadosEventoButtonActionPerformed

    private void botaoConcluirEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConcluirEventoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoConcluirEventoActionPerformed

    private void comboboxTipoEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxTipoEventoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxTipoEventoActionPerformed

    private void comboboxMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxMateriasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxMateriasActionPerformed

    private void campoDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDescricaoActionPerformed

    private void campoLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoLocalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoLocalActionPerformed

    private void novoEventoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoEventoButtonActionPerformed

        if( novoEventoButton.isSelected()){
            CardLayout layout = (CardLayout) panelProximosEventos.getLayout();
            layout.show(panelProximosEventos, "NovoEvento" );
        }
    }//GEN-LAST:event_novoEventoButtonActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoConcluirEvento;
    private javax.swing.JTextField campoDescricao;
    private javax.swing.JTextField campoLocal;
    private javax.swing.JComboBox<Materia> comboboxMaterias;
    private javax.swing.JComboBox<TipoEvento> comboboxTipoEvento;
    private javax.swing.JPanel cursoPanel;
    private com.toedter.calendar.JDateChooser dateEvento;
    private java.awt.Label diaDaSemanaLabel;
    private java.awt.Label diaDaSemanaLabel1;
    private javax.swing.JButton esperaEventoButton;
    private javax.swing.JPanel eventoPanel;
    private java.awt.Label eventosFinalizadosLabel;
    private javax.swing.JPanel eventosFinalizadosPanel;
    private javax.swing.JToggleButton finalizadosEventoButton;
    private javax.swing.JButton historicoPeriodoButton;
    private javax.swing.JButton informacoesCursoButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel labelDataFinal;
    private javax.swing.JLabel labelDescricao;
    private javax.swing.JLabel labelLocal;
    private javax.swing.JLabel labelMaterias;
    private javax.swing.JLabel labelObservacoes;
    private javax.swing.JLabel labelTipoEvento;
    private javax.swing.JPanel materiaPanel;
    private javax.swing.JLabel nomeUsuarioLabel;
    private javax.swing.JButton novaMateriaButton;
    private javax.swing.JToggleButton novoEventoButton;
    private java.awt.Label novoEventoLabel;
    private javax.swing.JPanel novoEventoPanel;
    private javax.swing.JButton novoPeriodoButton;
    private java.awt.Panel panelCabecalho;
    private java.awt.Panel panelColuna;
    private java.awt.Panel panelDiaDaSemana;
    private java.awt.Panel panelDiaDaSemana1;
    private java.awt.Panel panelProximosEventos;
    private javax.swing.JPanel periodoPanel;
    private javax.swing.JButton professoresMateriaButton;
    private java.awt.Label proximosEventosLabel;
    private javax.swing.JPanel proximosEventosPanel;
    private javax.swing.JScrollPane scrollPaneTextObservacoes;
    private javax.swing.JTable tableAulasDoDia;
    private javax.swing.JTable tableAulasDoDia1;
    private javax.swing.JTable tableEventosFinalizados;
    private javax.swing.JTable tableProximosEventos;
    private javax.swing.JTextPane textObservacoes;
    private javax.swing.JButton todasMateriaButton;
    // End of variables declaration//GEN-END:variables
}

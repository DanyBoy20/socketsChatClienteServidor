
package SocketChatClienteServidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Dany
 */
public class cliente extends javax.swing.JFrame {

    // STREAMS DE ENTRADA Y SALIDA PARA LEER Y ESCRIBIR LOS MENSAJES DEL CHAT    
    static DataInputStream leer;
    static DataOutputStream escribir;
    // SOCKET PARA LADO DE CLIENTE
    static Socket socketComunicacion;    
    
    // SE CREA EL FORMULARIO (INICIALIZANDO LOS COMPONENTES)
    public cliente() {
        initComponents();
    }

    // METODO QUE INICIALIZA COMPONENTES DEL FORMULARIO
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbltitulo = new javax.swing.JLabel();
        lblalumno = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblcliente = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtareaMensajes = new javax.swing.JTextArea();
        txtMensaje = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("VENTANA CLIENTE");

        lbltitulo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbltitulo.setText("CONEXIÓN EN RED - CHAT CON SOCKETS");

        lblalumno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblalumno.setText("DH");

        lblcliente.setText("TERMINAL CLIENTE");

        txtareaMensajes.setColumns(20);
        txtareaMensajes.setRows(5);
        jScrollPane1.setViewportView(txtareaMensajes);

        btnEnviar.setText("ENVIAR");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbltitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblcliente)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtMensaje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblalumno, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbltitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblalumno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblcliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMensaje))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // BOTON PARA ENVIAR LOS MENSAJES DENTRO DE UN BLOQUE TRY ... CATCH
    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        try{        
            // variable que captura lo que se escribe en el control caja de texto
            String mensajeSalida = txtMensaje.getText().trim();
            // recordemos que escribir se le paso por parametro el socket de lectura (linea 164)
            // por lo que, lo que se escriba en la caja de texto, se ira al servidor a traves del socket
            escribir.writeUTF(mensajeSalida);   
            // limpio la caja de texto tras haber enviado el mensaje
            txtMensaje.setText("");
        }catch(IOException e){ // si hay errores
            JOptionPane.showMessageDialog(null, "No se pudo enviar el mensaje\n" + e); 
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new cliente().setVisible(true);
        });
        
        // EN UN BLOQUE TRY ... CATCH CREAMOS EL SOCKET DE LADO DEL CLIENTE
        try{
            // como trabajamos en local, la idreccion es 127.0.0.1, asignamos el puerto (en este caso el 1201)
            // si nos conectaramos a un servidor externo, deberemos escribir la direccion de ese servidor
            socketComunicacion = new Socket("127.0.0.1",1201);
            // se obtiene el stream de lectura del socket y se asigna al stream de datos "leer" 
            leer = new DataInputStream(socketComunicacion.getInputStream());
            // se obtiene el stream de lectura del socket y se asigna al estream de datos "escribir
            escribir = new DataOutputStream(socketComunicacion.getOutputStream());
            String mensajeEntrada = ""; // esta variable de tipo string nos servira para escribir los mensajes obtenidos     
            while(!mensajeEntrada.equals("Terminar")){ // mientras no se escriba el mensaje                
                // se asigna a la variable lo que se lee del stream de lectura obtenido del socket
                mensajeEntrada = leer.readUTF(); 
                // y lo insertamos en el control de area de texto
                txtareaMensajes.setText(txtareaMensajes.getText().trim()+"\nMensaje del Servidor:\t"+mensajeEntrada);                
            }
            socketComunicacion.close();
            leer.close();
            escribir.close(); 
        }catch(IOException e){ // si hay errores
            JOptionPane.showMessageDialog(null, "Se cerro la conexion\n"); // mensaje de error
        }        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblalumno;
    private javax.swing.JLabel lblcliente;
    private javax.swing.JLabel lbltitulo;
    private javax.swing.JTextField txtMensaje;
    private static javax.swing.JTextArea txtareaMensajes;
    // End of variables declaration//GEN-END:variables
}

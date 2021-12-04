
package Frames;

import Classes.*;
import static Classes.Admin.*;
import static Classes.LaundrySystem.*;
import javax.swing.JOptionPane;

public class SearchForOrder extends javax.swing.JFrame {
   
    LaundrySystem LaundrySystem2 = LaundrySystem.getL();

    public SearchForOrder() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Search = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(410, 820));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 100, 139));
        jButton2.setText("Search");
        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, 270, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/logoCrystalClean.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 290, 200));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 100, 139));
        jLabel2.setText("Search for a specific order");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, 90));

        Search.setText("\n");
        Search.setBorder(null);
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });
        getContentPane().add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, 200, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Enter the order ID:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/backButton50.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 40, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Search for order-1.png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(404, 820));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String search= this.Search.getText().trim();
        boolean flag = true;
        for (int i = 0; i < search.length(); i++) {
           
            // if the user entered the order ID incorrectly error message will be displayed
            if (!Character.isDigit(search.charAt(i)) || search.length()!=5 ) {
                  flag = false;
                  JOptionPane.showMessageDialog(null, "The order ID only 5 digits with no letters and symbols!", "Error", JOptionPane.ERROR_MESSAGE); 
                  break;
            }          
        }
        if (flag) {
          
            // search for order by id
            Order o = searchForOrder(Integer.parseInt(search));
            // if order is not null, that means order with this id exists
            if (o != null) {
                this.dispose();
                OrderedIsFound OrderedIsFound =  new OrderedIsFound();
                
                // print the found order details
                OrderedIsFound.setTextField("The customer name: "+o.getCustomer().getFirstName()+ " "+ o.getCustomer().getLastName()+" \n"
                +" The customer phone: "+o.getCustomer().getPhoneNumber()+" \n"+ " The customer address: "+o.getCustomer().getAddress() );
                for (int i = 0; i < o.getPiece().size(); i++) {
                    
                OrderedIsFound.setTextFieldp("The service: "+o.getPiece().get(i).getPieceType()+ "\n"+ 
                        "   The price "+o.getPiece().get(i).getPrice(o.getPiece().get(i).getPieceType()));
                 
                }
                OrderedIsFound.setTextFieldp(OrderedIsFound.GetTextFieldp()+ "\n"+ "Status: "+o.getStatus()+ 
                       " Tax:  "+  (o.getCustomer().getCheckout().getTax()*100)+
                        " Delivery: "+ o.getCustomer().getCheckout().getDeliveryPrice()+"\n"+" Total: "
                     + o.getCustomer().getCheckout().getTotalPrice()  );
                 
                OrderedIsFound. setTextID(o.getOrderID()+"");
                OrderedIsFound.setVisible(true);
            }// if the order was not found the user will be taken to a page tha informs them of that
            else {
                 this.dispose();
                 new OrderIsNOTFound().setVisible(true);
             }             
        } 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        
    }//GEN-LAST:event_SearchActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // take user to the previous page
        new AdminView().setVisible(true);
    }//GEN-LAST:event_jLabel5MouseClicked

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
            java.util.logging.Logger.getLogger(SearchForOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchForOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchForOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchForOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchForOrder().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Search;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}

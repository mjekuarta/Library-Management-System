/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.View;

import BLL.Klienti;
import BLL.Libri;
import DAL.CrudFormException;
import DAL.KlientiRepository;
import DAL.LibriRepository;
import GUI.Model.KlientiComboBox;
import GUI.Model.LibriTableModel;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.PatternSyntaxException;
import javax.imageio.ImageIO;
import javax.swing.ComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Arta
 */
public class BooksForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form BooksForm
     */
    /* public class Work extends JFrame{
    JButton button;
    JButton button1;
    JLabel label;
  
   
    public Work(){
    super("Set Picture Into A JLabel Using JFileChooser In Java");
    button = new JButton("Browse");
    button1 = new JButton(saveButtonActionPerformed(java.awt.event.ActionEvent evt);
    button.setBounds(300,300,100,40);
    label = new JLabel();
    label.setBounds(10,10,670,250);
    add(button);
    add(label);
   
    button.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
        
          JFileChooser file = new JFileChooser();
          file.setCurrentDirectory(new File(System.getProperty("user.home")));
          //filter the files
          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
          file.addChoosableFileFilter(filter);
          int result = file.showSaveDialog(null);
           //if the user click on save in Jfilechooser
          if(result == JFileChooser.APPROVE_OPTION){
              File selectedFile = file.getSelectedFile();
              String path = selectedFile.getAbsolutePath();
              label.setIcon(ResizeImage(path));
          }
           //if the user click on save in Jfilechooser


          else if(result == JFileChooser.CANCEL_OPTION){
              System.out.println("No File Select");
          }
        }
    });
    
    setLayout(null);
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setLocationRelativeTo(null);
    setSize(700,400);
    setVisible(true);
    }
     
     // Methode to resize imageIcon with the same size of a Jlabel
    public ImageIcon ResizeImage(String ImagePath)
    {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

   }
    */
    

     LibriRepository lr = new LibriRepository();
     KlientiRepository kpr = new KlientiRepository();
     LibriTableModel ltm = new LibriTableModel();
     KlientiComboBox kcmb = new KlientiComboBox();
     
    public BooksForm(int i) {
        initComponents();
        loadTable();
        tabelaSelectedIndexChange();
        loadComboBox();
        sortTable();
        if(i !=1){
          raportiButton.setVisible(false);
        }
    }
    
    public void sortTable(){
        table.setAutoCreateRowSorter(true);
    }

     public void loadTable(){
        try{
            List<Libri> lista = lr.findAll();
            ltm.addList(lista);
            table.setModel(ltm);
            ltm.fireTableDataChanged();
        }catch(CrudFormException ex){
            Logger.getLogger(BooksForm.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
     
      private void tabelaSelectedIndexChange(){
        final ListSelectionModel rowSM = table.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener(){

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(e.getValueIsAdjusting()){
                    return;
                }
                
                ImageIcon im =new ImageIcon();
                jButton4.setIcon(im);
                
                ListSelectionModel rowSM = (ListSelectionModel) e.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if(selectedIndex > -1){
                    Libri l = ltm.getLibri(selectedIndex);
                    
                    idField.setText(l.getLibriID().toString());
                    titulliField.setText(l.getTitulliLibrit());
                    
                    if(l.getPath() != null){
                    try {
                        BufferedImage img = ImageIO.read(new File(l.getPath()));
                        ImageIcon icon = new ImageIcon(img);
                        jButton4.setIcon(icon);
                        
                    } catch (IOException ex) {
                        Logger.getLogger(BooksForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    }
                     
                    
                    
                    kcmb.setSelectedItem(l.getKlientiID());
                    klientiCMB.repaint();
                   // autoriField.setText(l.getAutoriID().toString());
                    //kategoriaField.setText(l.getKategoriaID().toString());
                    //publikuesiField.setText(l.getPublikuesiID().toString());
                    
                }
            }
        });
    }
       

    /*      
     BufferedImage imga = getImage("C:\\ImageTest\\pic2.jpg");

    private BufferedImage getImage(String filename) {
        // This time, you can use an InputStream to load
        try {
            // Grab the InputStream for the image.                    
            InputStream in = getClass().getResourceAsStream(filename);

            // Then read it.
            return ImageIO.read(in);
        } catch (IOException e) {
            System.out.println("The image was not loaded.");
            //System.exit(1);
        }

        return null;
    }
      */
      
      public void loadComboBox(){
        try{
            List<Klienti> lista = kpr.findAll();
            kcmb.add(lista);
            klientiCMB.setModel((ComboBoxModel)kcmb);
            klientiCMB.repaint();
        }catch(CrudFormException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
      
      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        raportiButton = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        titulliField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        klientiCMB = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        filterField = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        saveButton.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        saveButton.setText("Save Book");
        saveButton.setPreferredSize(new java.awt.Dimension(160, 54));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        deleteButton.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        deleteButton.setText("Delete Book");
        deleteButton.setPreferredSize(new java.awt.Dimension(160, 54));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.setPreferredSize(new java.awt.Dimension(160, 54));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        raportiButton.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        raportiButton.setText("Raporti");
        raportiButton.setPreferredSize(new java.awt.Dimension(160, 54));
        raportiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                raportiButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(raportiButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(raportiButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        jLabel1.setText("ID:");

        idField.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        jLabel2.setText("Titulli:");

        titulliField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titulliFieldActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table.setGridColor(new java.awt.Color(204, 204, 204));
        table.setIntercellSpacing(new java.awt.Dimension(0, 0));
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);

        klientiCMB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        jLabel3.setText("Klienti:");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setText("Filter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 13)); // NOI18N
        jButton2.setText("Choose file");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(titulliField, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(klientiCMB, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(filterField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titulliField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(klientiCMB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(filterField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton3.setText("X");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        try{
            int row = table.getSelectedRow();
            if(row == -1){
              Libri l = new Libri();
              //l.setLibriID(Integer.parseInt(idField.getText()));
              l.setTitulliLibrit(titulliField.getText());
              l.setKlientiID((Klienti)kcmb.getSelectedItem());
              l.setPath(path);
              lr.create(l);
            }else{
               Libri l = ltm.getLibri(row);
                //Id nuk e lejojm me ndryshu vetem emertimin ose fielda tjere qe mundeni me pas
                l.setTitulliLibrit(titulliField.getText());
                l.setKlientiID((Klienti)kcmb.getSelectedItem());
                l.setPath(path);
                lr.edit(l);
            }
            //E krijojm ni metode per me i clear fieldat mbasi ti shtojme
            clear();
            loadTable();
        }catch(CrudFormException ex){
            JOptionPane.showMessageDialog(this, "E dhena ekziston!");
        }
 
    }//GEN-LAST:event_saveButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
         int row = table.getSelectedRow();
        if(row != -1){
            Object[] ob = {"Po","Jo"};
            int i = JOptionPane.showOptionDialog(this,"A deshironi ta fshini?","Fshirja", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
            if(i == 0){
                Libri l = ltm.getLibri(row);
                try{
                    lr.delete(l);
                }catch(CrudFormException ex){
                    JOptionPane.showMessageDialog(this,ex.getMessage());
                }
                clear();
                loadTable();
            }else{
                clear();
            }
        }else{
            JOptionPane.showMessageDialog(this, "Nuk keni selektuar asgje per te fshire!");
        }
    

        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        clear();
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void raportiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raportiButtonActionPerformed
         try {
            // TODO add your handling code here:
            InputStream in = new FileInputStream(new File("C:\\Users\\Arbenita\\Desktop\\FAKULTET FILES\\LibraryManagementSystem\\src\\Raportet\\Libri_Report.jrxml"));
            JasperDesign jd = JRXmlLoader.load(in);
            String sql = "select LibriID, TitulliLibrit from Libri";
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText(sql);
            jd.setQuery(newQuery);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            HashMap para = new HashMap();
            Connection con = null;
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Library", "Arta" , "artanita3");
            JasperPrint j = JasperFillManager.fillReport(jr, para, con);
            JasperViewer.viewReport(j, false); 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
// TODO add your handling code here:
    }//GEN-LAST:event_raportiButtonActionPerformed

    private void titulliFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titulliFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titulliFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         TableRowSorter<LibriTableModel> sorter = new TableRowSorter<LibriTableModel>(ltm);
            table.setRowSorter(sorter);
        
        String text = filterField.getText();
            if(text.length() == 0) {
               sorter.setRowFilter(null);
            } else {
               try {
                  sorter.setRowFilter(RowFilter.regexFilter(text));
               } catch(PatternSyntaxException pse) {
                     JOptionPane.showMessageDialog(this, pse.getMessage());
               }
            }
            
        
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    String path;
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      //  new Work();
    try { JFileChooser picchooser = new JFileChooser();
    picchooser.showOpenDialog(null);
    File pic = picchooser.getSelectedFile();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images","png","jpg");
    picchooser.addChoosableFileFilter(filter); 
    
    path = pic.getAbsolutePath(); 
    BufferedImage img; 
    img = ImageIO.read(picchooser.getSelectedFile());
    ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage()); 
    jButton4.setIcon(imageIcon);
    File image = new File(path);
    FileInputStream fis = new FileInputStream(image);
    ByteArrayOutputStream baos= new ByteArrayOutputStream();
    byte[] buff = new byte[1024]; 
    for(int readNum; (readNum=fis.read(buff)) !=-1 ; ) {
    baos.write(buff,0,readNum);
        } 
    
        byte[] userimage = baos.toByteArray();
    } catch (IOException ex) {
    Logger.getLogger(BooksForm.class.getName()).log(Level.SEVERE,null,ex);
    }

// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
    public String getPath1(){
        return path;
    }   
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed
/**/
     public void clear(){
        
        table.clearSelection();
        idField.setText("");
        titulliField.setText("");
        klientiCMB.setSelectedIndex(-1);
        klientiCMB.repaint();
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField filterField;
    private javax.swing.JTextField idField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox klientiCMB;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton raportiButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JTable table;
    private javax.swing.JTextField titulliField;
    // End of variables declaration//GEN-END:variables
}

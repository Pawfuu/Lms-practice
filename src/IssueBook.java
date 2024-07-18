
import jframe.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;

        
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Keziah
 */
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }
    
    
    //To fetch the book details from the database and display it to book details panel 
    public void getBookDetails(){
        int bookId = Integer.parseInt(txt_bookId.getText());
    
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from book_details where book_id = ?");
            pst.setInt(1, bookId);
            /*
            ResultSet in Java is an object that holds data retrieved from a database after executing a SELECT
            */
             // Execute a SELECT query
            ResultSet rs = pst.executeQuery();
            /*
                 The ResultSet object has a method called next(). This method moves the cursor to the next row in the ResultSet.
            */
            if(rs.next()){
                  lbl_bookId.setText(rs.getString("book_Id"));
                  lbl_bookName.setText(rs.getString("book_name"));
                  lbl_author.setText(rs.getString("author"));
                  lbl_quantity.setText(rs.getString("quantity"));
            }
            else{
                  lbl_bookError.setText("Invalid Book Id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }

    
    //To fetch the student details from the database and display it to student details panel 
    public void getStudentDetails(){
        int studentId = Integer.parseInt(txt_studentId.getText());
    
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from student_details where student_id = ?");
            pst.setInt(1, studentId);
            /*
            ResultSet in Java is an object that holds data retrieved from a database after executing a SELECT
            */
             // Execute a SELECT query
            ResultSet rs = pst.executeQuery();
            /*
                 The ResultSet object has a method called next(). This method moves the cursor to the next row in the ResultSet.
            */
            if(rs.next()){
                  lbl_studentId.setText(rs.getString("student_Id"));
                  lbl_studentName.setText(rs.getString("name"));
                  lbl_course.setText(rs.getString("course"));
                  lbl_branch.setText(rs.getString("branch"));
            }
            else{
                    lbl_studentError.setText("Invalid Student Id");
                    }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
    
    //insert issue book details to database
    public boolean issueBook(){
        boolean isIssued = false;
        int bookId = Integer.parseInt(txt_bookId.getText());
        int studentId = Integer.parseInt(txt_studentId.getText());
        String bookName = lbl_bookName.getText();
        String studentName = lbl_studentName.getText();
        
        Date uIssueDate = date_issueDate.getDatoFecha();
        Date uDueDate = date_dueDate.getDatoFecha();
        
        Long l1 = uIssueDate.getTime();
        Long l2 = uDueDate.getTime();
        
        java.sql.Date sIssueDate = new java.sql.Date(l1);
        java.sql.Date sDueDate = new java.sql.Date(l2);
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into issue_book_details(book_id, book_name, student_id," 
                    + "student_name, issue_date, due_date, status) values(?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setString(2, bookName);
            pst.setInt(3, studentId);
            pst.setString(4, studentName);
            pst.setDate(5, sIssueDate);
            pst.setDate(6, sDueDate);
            pst.setString(7, "pending");
            
            //(4) EXECUTES THE UPDATE. IT RETURNS AN 'INT' INDICATING THE NUMBER OF ROWS AFFECTED
            int rowCount = pst.executeUpdate();
            if(rowCount > 0){
                isIssued = true;
            }else{
                    isIssued = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
      return isIssued;
    }
    
    //updating the amount of books issued
    public void updateBookCount(){
          int bookId = Integer.parseInt(txt_bookId.getText());
        try {
            //(1) establish database connection
            Connection con = DBConnection.getConnection();
            //(2) sql command to decrease the book quantity by 1
            String sql = "update book_details set quantity = quantity - 1 where book_id = ?";
            //(3) Prepare the SQL statement
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            
            //(4) EXECUTES THE UPDATE. IT RETURNS AN 'INT' INDICATING THE NUMBER OF ROWS AFFECTED
            int RowCount = pst.executeUpdate();
            if(RowCount > 0 ){
            JOptionPane.showMessageDialog(this, "Book count updated");
            int initialCount = Integer.parseInt(lbl_quantity.getText());
            lbl_quantity.setText(Integer.toString(initialCount - 1));
            }else{
            JOptionPane.showMessageDialog(this, "Can't update book count");
            }
        } catch (Exception e) {
            e.printStackTrace();
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

        panel_main = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        panel_main1 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        panel_main2 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        lbl_studentName = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        lbl_branch = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        lbl_course = new javax.swing.JLabel();
        lbl_studentId = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        lbl_studentError = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        lbl_bookName = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        lbl_bookId = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        lbl_bookError = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        txt_bookId = new app.bolivia.swing.JCTextField();
        jLabel50 = new javax.swing.JLabel();
        txt_studentId = new app.bolivia.swing.JCTextField();
        jLabel51 = new javax.swing.JLabel();
        date_issueDate = new rojeru_san.componentes.RSDateChooser();
        jLabel52 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        date_dueDate = new rojeru_san.componentes.RSDateChooser();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_main.setBackground(new java.awt.Color(255, 255, 255));
        panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(102, 102, 255));

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 35)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("X");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(30, 30, 30))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        panel_main.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 0, 90, 50));

        panel_main1.setBackground(new java.awt.Color(255, 255, 255));
        panel_main1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(102, 102, 255));

        jLabel32.setFont(new java.awt.Font("Verdana", 0, 35)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("X");
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel32MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel32)
                .addGap(30, 30, 30))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel32)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        panel_main1.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 0, 90, 50));

        panel_main2.setBackground(new java.awt.Color(255, 255, 255));
        panel_main2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBackground(new java.awt.Color(102, 102, 255));
        jPanel15.setForeground(new java.awt.Color(255, 255, 255));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel15.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 330, 5));

        jLabel35.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Branch:");
        jPanel15.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 150, -1));

        jLabel36.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Student name:");
        jPanel15.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 150, -1));

        jLabel37.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Course:");
        jPanel15.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 150, -1));

        lbl_studentName.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_studentName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel15.add(lbl_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 210, 30));

        jLabel38.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Student Id:");
        jPanel15.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 150, -1));

        lbl_branch.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_branch.setForeground(new java.awt.Color(255, 255, 255));
        jPanel15.add(lbl_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 490, 210, 30));

        jLabel39.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jPanel15.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 210, 30));

        lbl_course.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_course.setForeground(new java.awt.Color(255, 255, 255));
        jPanel15.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 210, 30));

        lbl_studentId.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_studentId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel15.add(lbl_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 210, 30));

        jLabel40.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel40.setText("  Student Details");
        jPanel15.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 300, 110));

        lbl_studentError.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_studentError.setForeground(new java.awt.Color(255, 255, 0));
        jPanel15.add(lbl_studentError, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, 280, -1));

        panel_main2.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 420, 810));

        jPanel17.setBackground(new java.awt.Color(251, 51, 51));
        jPanel17.setForeground(new java.awt.Color(255, 255, 255));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel18.setBackground(new java.awt.Color(102, 102, 255));

        jLabel41.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel41.setText(" Back");
        jLabel41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel41MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addComponent(jLabel41))
        );

        jPanel17.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 50));

        jLabel42.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel42.setText("  Book Details");
        jPanel17.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 300, 110));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel17.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 330, 5));

        jLabel44.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Book name:");
        jPanel17.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 150, -1));

        jLabel45.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Author:");
        jPanel17.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 150, -1));

        lbl_bookName.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel17.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 210, 30));

        jLabel46.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Book Id:");
        jPanel17.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 150, -1));

        lbl_quantity.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_quantity.setForeground(new java.awt.Color(255, 255, 255));
        jPanel17.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 490, 210, 30));

        jLabel47.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jPanel17.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 210, 30));

        lbl_author.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_author.setForeground(new java.awt.Color(255, 255, 255));
        jPanel17.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 210, 30));

        lbl_bookId.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel17.add(lbl_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 210, 30));

        jLabel53.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Quantity:");
        jPanel17.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 150, -1));

        lbl_bookError.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(255, 255, 0));
        jPanel17.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 150, -1));

        panel_main2.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 810));

        jLabel48.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 51, 51));
        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel48.setText(" Issue Book");
        panel_main2.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 110, 300, 110));

        jPanel20.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        panel_main2.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 220, 430, 5));

        jPanel21.setBackground(new java.awt.Color(102, 102, 255));

        jLabel49.setFont(new java.awt.Font("Verdana", 0, 35)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("X");
        jLabel49.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel49MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel49)
                .addGap(30, 30, 30))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jLabel49)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        panel_main2.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 0, 90, 50));

        txt_bookId.setBackground(new java.awt.Color(255, 255, 255));
        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        txt_bookId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_bookId.setPlaceholder("Enter Book Id...");
        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        txt_bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookIdActionPerformed(evt);
            }
        });
        panel_main2.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 250, 360, 50));

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 51, 51));
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel50.setText("Book Id:");
        panel_main2.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 250, 150, 70));

        txt_studentId.setBackground(new java.awt.Color(255, 255, 255));
        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        txt_studentId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_studentId.setPlaceholder("Enter Student Id...");
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        txt_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIdActionPerformed(evt);
            }
        });
        panel_main2.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 340, 360, 50));

        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 51, 51));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel51.setText("Issue Date:");
        panel_main2.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 420, 150, 70));

        date_issueDate.setColorBackground(new java.awt.Color(255, 51, 51));
        date_issueDate.setColorForeground(new java.awt.Color(255, 51, 51));
        date_issueDate.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        date_issueDate.setPlaceholder("Select Issue Date");
        panel_main2.add(date_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 430, 360, -1));

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 51, 51));
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel52.setText("Student Id:");
        panel_main2.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 340, 150, 70));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Issue Date:");
        panel_main2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 510, 150, 70));

        date_dueDate.setColorBackground(new java.awt.Color(255, 51, 51));
        date_dueDate.setColorForeground(new java.awt.Color(255, 51, 51));
        date_dueDate.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        date_dueDate.setPlaceholder("Select Due Date");
        panel_main2.add(date_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 520, 360, -1));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle1.setText("ISSUE BOOK");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        panel_main2.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 610, 400, 70));

        panel_main1.add(panel_main2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 810));

        panel_main.add(panel_main1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 810));

        getContentPane().add(panel_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 810));

        setSize(new java.awt.Dimension(1411, 803));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel32MouseClicked

    private void jLabel41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel41MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel41MouseClicked

    private void jLabel49MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel49MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel49MouseClicked

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
       if(issueBook() == true){
           JOptionPane.showMessageDialog(this, "Book issued successfully");
           
       } else{
           JOptionPane.showMessageDialog(this, "Can't issue the book");
       }
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
        if (!txt_bookId.getText().equals("")){
            getBookDetails();
        }
        
    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
      if (!txt_studentId.getText().equals("")){
            getStudentDetails();
            updateBookCount();
    }//GEN-LAST:event_txt_studentIdFocusLost
    }
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_dueDate;
    private rojeru_san.componentes.RSDateChooser date_issueDate;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_bookId;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_branch;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_studentError;
    private javax.swing.JLabel lbl_studentId;
    private javax.swing.JLabel lbl_studentName;
    private javax.swing.JPanel panel_main;
    private javax.swing.JPanel panel_main1;
    private javax.swing.JPanel panel_main2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}

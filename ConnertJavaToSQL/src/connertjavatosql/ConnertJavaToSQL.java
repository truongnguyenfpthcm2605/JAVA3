/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package connertjavatosql;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.*;

/**
 *
 * @author truong
 */
public class ConnertJavaToSQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=QLSINHVIEN;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "12345";
        String query = "select * from students";
        try ( Connection conn = DriverManager.getConnection(dbURL, user, pass)) {
            if (conn != null) {
                DatabaseMetaData dm = conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
                Statement st = conn.createStatement();
                ResultSet re = st.executeQuery(query);
                while (re.next()) {
                    System.out.print(re.getString("Masv") + ", ");
                    System.out.print(re.getString("Hoten") + ", ");
                    System.out.print(re.getString("Email") + ", ");
                    System.out.print(re.getString("SoDT") + ", ");
                    System.out.print(re.getString("GioiTinh") + ", ");
                    System.out.println(re.getString("Diachi") + ", ");
                }
                conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}

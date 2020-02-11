import java.sql.*;


import static com.oracle.jrockit.jfr.ContentType.Address;

public class DatabaseMethods {
    Connection con;
    ResultSet rs;
    Statement st;

    DatabaseMethods() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll", "root", "shovaacharya.");
            st = con.createStatement();
            System.out.println("Payroll database connection successful");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    boolean checkUsernameLogin(String uname, String pass) throws SQLException {
        ResultSet rs = st.executeQuery(String.format("Select password from main where userid = '%s'",uname));

        while (rs.next()){
            if(rs.getString("password").equals(pass)){
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public void addEmployee(String uid, String first, String last, String address, int salary, int working, int sick, int paid, int unpaid) throws SQLException {
        st.executeUpdate(String.format("insert into main values('%s','nopassword','%s','%s','%s',%d, %d, %d, %d, %d)",uid,first,last,address,salary, working, sick, paid, unpaid));
        //columnn counnt milena bhanchha.. so i think u need to add all okay
    }

    public void delEmployee(String uid, String first, String last) throws SQLException {
        String t = String.format("delete from main where userid = '%s' and FirstName = '%s' and LastName = '%s'",uid,first,last);
        System.out.println(t);
        st.executeUpdate(t);
        System.out.println("employee successfully deleted");
    }

    public ResultSet viewEmployee(String uid) throws SQLException{
        rs = st.executeQuery(String.format("Select userid, FirstName, LastName, Address, Salary, Working, Sick, Paid, Unpaid from main where userid = '%s'", uid));
        System.out.println("employee successfully can be view");
        return rs;
    }

    public ResultSet allEmployee() throws SQLException{
        rs = st.executeQuery(String.format("Select * from main"));
        return rs;
    }
    public void attendance(String uid, int uwork, int usick, int upaid, int unpd) throws SQLException {
        st.executeUpdate(String.format("insert into main values('%d','%d','%d',%d)", uwork,usick,upaid,unpd +
                "where userid = '%s'", uid));
    }
    public void salCalculate (String uid) throws SQLException {
        rs = st.executeQuery(String.format("Select userid, Salary, Working, Sick, Paid, Unpaid from main where userid = '%s'", uid));

    }

    public int getSalary(String uid) throws SQLException {
        rs = st.executeQuery(String.format("Select Salary from main where userid = '%s'",uid));
        if(rs.next()){
            return rs.getInt("Salary");
        }
        return -999;
    }

    public int getWorkingDays(String uid) throws SQLException {
        rs = st.executeQuery(String.format("Select Working from main where userid = '%s'",uid));
        if(rs.next()){
            return rs.getInt("Working");
        }
        return -999;
    }

    public int getSickDays(String uid) throws SQLException {
        rs = st.executeQuery(String.format("Select Sick from main where userid = '%s'",uid));
        if(rs.next()){
            return rs.getInt("Sick");
        }
        return -999;

    }

    public int getPaidLeave(String uid) throws SQLException {
        rs = st.executeQuery(String.format("Select Paid from main where userid = '%s'",uid));
        if(rs.next()){
            return rs.getInt("Paid");
        }
        return -999;
    }

    public int getUnpaidLeave(String uid) throws SQLException {
        rs = st.executeQuery(String.format("Select Unpaid from main where userid = '%s'",uid));
        if(rs.next()){
            return rs.getInt("Unpaid");
        }
        return -999;
    }

    public String getEmployeeName(String uid) throws SQLException {
        String name = null;
        rs = st.executeQuery(String.format("Select FirstName, LastName from main where userid = '%s'",uid));
        if(rs.next()){
            name = String.format("%s %s",rs.getString("FirstName"),rs.getString("LastName"));
        }
        return name;
    }
}



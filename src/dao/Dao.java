package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.Account;
import bean.Loan;
import bean.Transaction;

public class Dao implements Idao {

	public Dao() throws Exception {
	}			
		String url="jdbc:mysql://localhost:3306/data";
		String uname="root",password="viswesh23";		
		Connection conn = DriverManager.getConnection(url,uname,password);
		Statement st = conn.createStatement();
		
		int amount = 0;	
		@Override
		public void createAccount(Account account) throws SQLException {			
			Transaction t = (Transaction) account;
			String colinsert = "insert into customer2 "+
								"(id,name,address,dapositamt,loanid,loanamt,loantype)"+"values(?,?,?,?,?,?,?)";
																																					/*+ t.getAccountId()+","+t.getAccountName()+","+t.getAddres()+","+t.getDepositAmount()+","+t.getLoanId()+","+t.getLoanAmount()+","+t.getLoanType()+")";*/	
			PreparedStatement prestmt = conn.prepareStatement(colinsert);
			prestmt.setString(1, t.getAccountId());
			prestmt.setString(2, t.getAccountName());
			prestmt.setString(3, t.getAddres());
			prestmt.setDouble(4, t.getDepositAmount());
			prestmt.setInt(5,t.getLoanId());
			prestmt.setInt(6, t.getLoanAmount());
			prestmt.setString(7, String.valueOf(t.getLoanType()));			
			int str = prestmt.executeUpdate();
			System.out.println(str);
		}
		@Override
		public int depositAmount(String accountId, int depamt) throws SQLException {
			String depAmount = "select dapositamt from customer2 where id = ?";
			PreparedStatement prestmt = conn.prepareStatement(depAmount);		
			prestmt.setString(1, accountId);
			ResultSet rs = prestmt.executeQuery();
			rs.next();			
			int newamt = rs.getInt(1)+depamt;			
			String newdepamt = "update customer2 set dapositamt = ? where id = ?";
			PreparedStatement prestmt1 = conn.prepareStatement(newdepamt);
			prestmt1.setInt(1, newamt);
			prestmt1.setString(2, accountId);
			prestmt1.executeUpdate();
			return newamt;
		}

		@Override
		public int withdrawAmount(String accountId, int widamt) throws SQLException {			
			String widAmount = "select dapositamt from customer2 where id = ?";
			PreparedStatement prestmt = conn.prepareStatement(widAmount);			
			prestmt.setString(1, accountId);
			ResultSet rs = prestmt.executeQuery();
			rs.next();			
			int  newamt = rs.getInt(1)-widamt;			
			String newwid = "update customer2 set dapositamt = ? where id = ?";
			PreparedStatement prestmt1 = conn.prepareStatement(newwid);
			prestmt1.setInt(1, newamt);
			prestmt1.setString(2, accountId);
			prestmt1.executeUpdate();
			return newamt;
		}

		@Override
		public Account showAccountDetails(String accountNo) throws SQLException {

			String getAccDetails = "select accountId,accountName,address,depositAmount from customer1 where accountId = ?";
			PreparedStatement pst = conn.prepareStatement(getAccDetails);
			pst.setString(1, accountNo);
			ResultSet rs = pst.executeQuery();
			rs.next();
			Account account =new Account();
			account.setAccountId(rs.getString(1));
			account.setAccountName(rs.getString(2));
			account.setAddres(rs.getString(3));
			account.setDepositAmount(rs.getInt(4));
			
			return account;
		}

		

		@Override
		public int getLoan(int loanid, int loanamt) throws SQLException {
			int loanbal = 0;
			String getLoan = "select loanamt from customer2 where loanid = ?";
			PreparedStatement prestmt = conn.prepareStatement(getLoan);
			prestmt.setInt(1, loanid);
			ResultSet rs = prestmt.executeQuery();
			rs.next();
			loanbal = rs.getInt(1);
			loanbal += loanamt;			
			String updateLoan = "update customer2 set loanamt = ? where loanid = ?";
			PreparedStatement prestmt1 = conn.prepareStatement(updateLoan);
			prestmt1.setInt(1, loanbal);
			prestmt1.setInt(2, loanid);
			prestmt1.executeUpdate();			
			return loanbal;
		}

		@Override
		public Loan showLoanDetails(int loanid) throws SQLException {			
			PreparedStatement pst = conn.prepareStatement("select loanid,loanamt,loantype from customer2 where loanid = ?");
			pst.setInt(1, loanid);
			ResultSet r = pst.executeQuery();
			r.next();
			Loan loan = new Loan();
			loan.setLoanId(r.getInt(1));
			loan.setLoanAmount(r.getInt(2));
			loan.setLoanType(r.getString(3));
			return loan;
					
		}

		@Override
		public int payLoan(int loanid, int loanamt) throws SQLException {
			int loanbal1 = 0;
			String getLoan = "select loanAmount from customer2 where loanid = ?";
			PreparedStatement pst = conn.prepareStatement(getLoan);
			pst.setInt(1, loanid);
			ResultSet r = pst.executeQuery();
			r.next();
			loanbal1 = r.getInt(1);
			loanbal1 =loanbal1-loanamt;
			String newloan = "update customer2 set loanamt = ? where loanid = ?";
			PreparedStatement pst1 = conn.prepareStatement(newloan);
			pst1.setInt(1, loanbal1);
			pst1.setInt(2, loanid);
			pst1.executeUpdate();
			return loanbal1;
			
		}

	}



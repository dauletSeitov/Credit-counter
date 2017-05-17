package www.lounger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBHelper {
	
	private Connection connection = null;
	
	public DBHelper() throws ClassNotFoundException, SQLException{
		connect();
	};
	
	private void connect() throws ClassNotFoundException, SQLException {
	 
	
	      Class.forName("org.sqlite.JDBC");
	      connection = DriverManager.getConnection("jdbc:sqlite:CreditCounterDB.db");

	    System.out.println("Opened database successfully");

	}
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*public void querry (){

		    Statement stmt = null;
		    try {
		     
		      stmt = connection.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM Kontragent;" );
		      while ( rs.next() ) {
		         
		         System.out.println( "ID = " + rs.getInt("id") );
		         System.out.println( "FIO = " + rs.getString("fio") );
		         System.out.println( "iin = " + rs.getString("iin") );
		  
		         System.out.println();
		      }
		      rs.close();
		      stmt.close();
		     // connection.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    System.out.println("Operation done successfully");
		
	}*/
	
		
		
	public ArrayList<ArrayList<Object>> getAllKrediti (){
		
	    Statement stmt = null;
	    try {
	     
	      stmt = connection.createStatement();
	      ResultSet rs = stmt.executeQuery( "select krediti.id id, " 
	    		  + " krediti.mesyats mesyats, "
	    		  + " krediti.name name, "
	    		  + " krediti.procent procent"
	    		  + " from krediti krediti;" 
	    		  );
	      ArrayList<Object> row = null; 
	      ArrayList<ArrayList<Object>> table = new ArrayList<ArrayList<Object>>();
	      
	      while ( rs.next() ) {
	         
	    	 row = new ArrayList<Object>();
	    	 row.add( rs.getInt("id"));
	    	 row.add( rs.getString("name"));
	    	 row.add( rs.getInt("mesyats"));
	    	 row.add( rs.getFloat("procent"));
	    	 
	    	 table.add(row);

	      }
	      rs.close();
	      stmt.close();
	      
	      return table;
	      
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Operation done successfully");
		return null;
	
	}

	public ArrayList<ArrayList<Object>> getAllRegistr (){
		
	    Statement stmt = null;
	    try {
	     
	      stmt = connection.createStatement();
	      ResultSet rs = stmt.executeQuery( " select     registr.id    id, "
	      		+ " Dogovara.name    Dogovor,  "
	      		+ " DokumentPlatezh.name    Dokument, "
	      		+ " registr.sum    sum,"
	      		+ " registr.DataPlatezha     DataPlatezha, "
	      		+ " registr.DataPlatezhaPoRaspisaniy     DataPlatezhaPoRaspisaniy "
	      		+ " from registr registr "
	      		+ " left join Dogovara  Dogovara on registr.refDogovor = Dogovara.id "
	      		+ " left join DokumentPlatezh DokumentPlatezh on registr.refDokument = DokumentPlatezh.id;" 
	    		  );
	      ArrayList<Object> row = null; 
	      ArrayList<ArrayList<Object>> table = new ArrayList<ArrayList<Object>>();
	      
	      while ( rs.next() ) {
	         
	    	 row = new ArrayList<Object>();
	    	 row.add( rs.getInt("id"));
	    	 row.add( rs.getString("Dogovor"));
	    	 row.add( rs.getString("Dokument"));
	    	 row.add( rs.getFloat("sum"));
	    	 row.add( rs.getString("DataPlatezha"));
	    	 row.add( rs.getString("DataPlatezhaPoRaspisaniy"));
	    	
	    	 
	    	 table.add(row);

	      }
	      rs.close();
	      stmt.close();
	      
	      return table;
	      
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Operation done successfully");
		return null;
	
	}
				
	public ArrayList<ArrayList<Object>> getAllDokumentSozdat (){
		
	    Statement stmt = null;
	    try {
	     
	      stmt = connection.createStatement();
	      ResultSet rs = stmt.executeQuery( "select DokumenSozdat.id        id,"
	      		+ " krediti.name kredit, "
	      		+ " Dogovara.name dogovor, "
	      		+ " DokumenSozdat.name      dokument , "
	      		+ " DokumenSozdat.sum sum, "
	      		+ " DokumenSozdat.Data      DateProvod, "
	      		+ " DokumenSozdat.Data_nachala Data_nachala, "
	      		+ " DokumenSozdat.Data_kontsa  Data_kontsa, "
	      		+ " DokumenSozdat.sostoyanie sostoyanie "
	      		+ " from DokumenSozdat DokumenSozdat "
	      		+ " left join Dogovara Dogovara on Dogovara.id = DokumenSozdat.ref_dogovor "
	      		+ " left join krediti krediti on krediti.id = DokumenSozdat.ref_kredit "
	      		+ ""
	      		+ ""
	      		+ ";" 
	    		  );
	      ArrayList<Object> row = null; 
	      ArrayList<ArrayList<Object>> table = new ArrayList<ArrayList<Object>>();
	      
	      while ( rs.next() ) {
	         
	    	 row = new ArrayList<Object>();
	    	 row.add( rs.getInt("id"));
	    	 row.add( rs.getString("kredit"));
	    	 row.add( rs.getString("dogovor"));
	    	 row.add( rs.getString("dokument"));
	    	 row.add( rs.getFloat("sum"));
	    	 row.add( rs.getString("DateProvod"));
	    	 row.add( rs.getString("Data_nachala"));
	    	 row.add( rs.getString("Data_kontsa"));
	    	 row.add( rs.getString("sostoyanie"));
	    	// row.add( rs.getString(""));
	    	 //row.add( rs.getString(""));
	    	
	    	 
	    	 table.add(row);

	      }
	      rs.close();
	      stmt.close();
	      
	      return table;
	      
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Operation done successfully");
		return null;
	
	}

	public ArrayList<ArrayList<Object>> getAllDokumentZakrit(){
	
    Statement stmt = null;
    try {
     
      stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery( "Select DokumentZakrit.id     id, "
      		+ "   DokumentZakrit.name      name, "
      		+ "    DokumentZakrit.Data     Data, "
      		+ " Dogovara.name              Dogovor, "
      		+ " krediti.name               Kredit, "
      		+ "  DokumentZakrit.DataNachala DataNachala, "
      		+ " DokumentZakrit.DataKontsa DataKontsa, "
      		+ " DokumentZakrit.Sostoyanie Sostoyanie "
      		+ " from DokumentZakrit DokumentZakrit "
      		+ " left join Dogovara Dogovara on DokumentZakrit.refDogovor = Dogovara.id "
      		+ " left join krediti krediti on  DokumentZakrit.ref_Kredit = krediti.id "
      		+ ""
      		+ ""
      		+ ";" 
    		  );
      ArrayList<Object> row = null; 
      ArrayList<ArrayList<Object>> table = new ArrayList<ArrayList<Object>>();
      
      while ( rs.next() ) {
         
    	 row = new ArrayList<Object>();
    	 row.add( rs.getInt("id"));
    	 row.add( rs.getString("name"));
    	 row.add( rs.getString("Data"));
    	 row.add( rs.getString("Dogovor"));
    	 row.add( rs.getString("Kredit"));
    	 row.add( rs.getString("DataNachala"));
    	 row.add( rs.getString("DataKontsa"));
    	 row.add( rs.getString("Sostoyanie"));
    	// row.add( rs.getString(""));
    	 //row.add( rs.getString(""));
    	
    	 
    	 table.add(row);

      }
      rs.close();
      stmt.close();
      
      return table;
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Operation done successfully");
	return null;

}
	
	public ArrayList<ArrayList<Object>> getAllDokumentPlatezh(){
	
    Statement stmt = null;
    try {
     
      stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery( " Select DokumentPlatezh.id, "
      		+ " Dogovara.name        dogovor, "
      		+ " DokumentPlatezh.name name, "
      		+ " DokumentPlatezh.sum sum, "
      		+ " DokumentPlatezh.data data, "
      		+ " DokumentPlatezh.sostoyanie sostoyanie "
      		+ " from DokumentPlatezh DokumentPlatezh "
      		+ "left join Dogovara Dogovara on DokumentPlatezh.refDogovor = Dogovara.id "
      		+ ""
      		+ ""
      		+ ""
      		+ ""
      		+ ";" 
    		  );
      ArrayList<Object> row = null; 
      ArrayList<ArrayList<Object>> table = new ArrayList<ArrayList<Object>>();
      
      while ( rs.next() ) {
         
    	 row = new ArrayList<Object>();
    	 row.add( rs.getInt("id"));
    	 row.add( rs.getString("dogovor"));
    	 row.add( rs.getString("name"));
    	 row.add( rs.getFloat("sum"));
    	 row.add( rs.getString("data"));
    	 row.add( rs.getString("sostoyanie"));
    	 //row.add( rs.getString("DataKontsa"));
    	 //row.add( rs.getString("Sostoyanie"));
    	// row.add( rs.getString(""));
    	 //row.add( rs.getString(""));
    	
    	 
    	 table.add(row);

      }
      rs.close();
      stmt.close();
      
      return table;
      
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Operation done successfully");
	return null;

}
	
	//-------nastroika
	public ArrayList<ArrayList<Object>> getAllNastroika (){
		
	    Statement stmt = null;
	    try {
	     
	      stmt = connection.createStatement();
	      ResultSet rs = stmt.executeQuery( "Select nastroiki.id id, " 
	    		  + " nastroiki.name name, "
	    		  + " nastroiki.nastroika nastroika "
	    		  + " from nastroiki nastroiki;" 
	    		  );
	      ArrayList<Object> row = null; 
	      ArrayList<ArrayList<Object>> table = new ArrayList<ArrayList<Object>>();
	      
	      while ( rs.next() ) {
	         
	    	 row = new ArrayList<Object>();
	    	 row.add( rs.getInt("id"));
	    	 row.add( rs.getString("name"));
	    	 row.add( rs.getString("nastroika"));
	    	 
	    	 table.add(row);

	      }
	      rs.close();
	      stmt.close();
	      
	      return table;
	      
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Operation done successfully");
		return null;
	
	}

	public void insertNastroika(String key, String value) throws SQLException{
	
		PreparedStatement insertNastroika = null; 
		
		
		insertNastroika = connection.prepareStatement(" insert into nastroiki (name, nastroika) VALUES (? , ? );");
	
		insertNastroika.setString(1, key);
		insertNastroika.setString(2, value);
		
		insertNastroika.executeUpdate();
		//connection.commit();
	
	} 
	
	public void deleteNastroika(int id) {
		
		PreparedStatement insertNastroika = null; 
		
		
		try {
			insertNastroika = connection.prepareStatement(" DELETE from nastroiki where ID = ?;");
			
			insertNastroika.setInt(1, id);

			insertNastroika.executeUpdate();
			//connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
	
	} 
		
	public void updateNastroika(int id, String key, String value) throws SQLException {
		
		PreparedStatement insertNastroika = null; 
		insertNastroika = connection.prepareStatement(" UPDATE nastroiki set name = ?, nastroika = ? where id = ? ;");
		insertNastroika.setString(1, key);
		insertNastroika.setString(2, value);
		insertNastroika.setInt(3, id);
		insertNastroika.executeUpdate();

	} 
	//-------nastroika
	
	
	//-------kontragent
	public ArrayList<ArrayList<Object>> getAllKontragents (){
		
	    Statement stmt = null;
	    try {
	     
	      stmt = connection.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT     Kontragent.id id, " 
	    		  + " Kontragent.fio fio, "
	    		  + " Kontragent.iin iin "
	    		  + " FROM Kontragent Kontragent;" 
	    		  );
	      ArrayList<Object> row = null; 
	      ArrayList<ArrayList<Object>> table = new ArrayList<ArrayList<Object>>();
	      
	      while ( rs.next() ) {
	         
	    	 row = new ArrayList<Object>();
	    	 row.add( rs.getInt("id"));
	    	 row.add( rs.getString("fio"));
	    	 row.add( rs.getString("iin"));
	    	 
	    	 table.add(row);

	      }
	      rs.close();
	      stmt.close();
	      
	      return table;
	      
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Operation done successfully");
		return null;
	
	}

	public void insertKontragent(String fio, String iin) throws SQLException{
	
		PreparedStatement insertNastroika = null; 
	
		insertNastroika = connection.prepareStatement(" insert into Kontragent (fio, iin) VALUES (? , ? );");

		insertNastroika.setString(1, fio);
		insertNastroika.setString(2, iin);
	
		insertNastroika.executeUpdate();

	} 
	
	public void updateKontragent(int id, String fio, String iin) throws SQLException 
	{
		
		PreparedStatement pt = null; 
		pt = connection.prepareStatement(" UPDATE Kontragent set fio = ?, iin = ? where id = ? ;");
		pt.setString(1, fio);
		pt.setString(2, iin);
		pt.setInt(3, id);
		pt.executeUpdate();

	} 
	
	public void deleteKontragent(int id) {
		
		PreparedStatement insertNastroika = null; 
		
		
		try {

			insertNastroika = connection.prepareStatement(" DELETE from Kontragent where ID = ?;");	
			insertNastroika.setInt(1, id);
			insertNastroika.executeUpdate();
		
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	
	}
	//-------kontragent
	
	
	//-------kredit
	public void insertKredit(String name, int time, float procent) throws SQLException{
		
		PreparedStatement insertNastroika = null; 
	
		insertNastroika = connection.prepareStatement(" insert into krediti (name, procent, mesyats) VALUES (? , ? , ?); ");

		insertNastroika.setString(1, name);
		insertNastroika.setFloat(2, procent);
		insertNastroika.setInt(3, time);
		
		insertNastroika.executeUpdate();

	} 	
	
	
	public void updateKredit(int id, String name, int time, float procent) throws SQLException{
		
		PreparedStatement pt = null; 
	
		pt = connection.prepareStatement(" update krediti set name = ?, procent = ?, mesyats = ? where id = ? ; ");

		pt.setString(1, name);
		pt.setFloat(2, procent);
		pt.setInt(3, time);
		pt.setInt(4, id);
		pt.executeUpdate();

	} 
	
	public void deleteKredit(int id) {
		
		PreparedStatement insertNastroika = null; 
		
		
		try {

			insertNastroika = connection.prepareStatement(" DELETE from krediti where ID = ?;");	
			insertNastroika.setInt(1, id);
			insertNastroika.executeUpdate();
		
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	
	}
	//-------kredit


























}

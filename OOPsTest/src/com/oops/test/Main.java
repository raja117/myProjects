package com.oops.test;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Main {
  public static void main(String[] argv) throws Exception {
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    model.addColumn("Col1");
    model.addColumn("col2");
    model.addColumn("col3");
    model.addRow(new Object[] { "r1" });
    model.addRow(new Object[] { "r2" });
    model.addRow(new Object[] { "r3" });
    
    model.setValueAt(23, 2, 2);
    
    // Get all the table data
    Vector data = model.getDataVector();
    // Copy the second row
    Vector row = (Vector) data.elementAt(1);
    row = (Vector) row.clone();

    String s  = "select hist.receipient_id, hca.attribute15, hca.attribute16, hca.attribute5, hcsu.attribute23\r\n" + 
    	"  from xxmi.XXMI_FTW_CUSTOMER_HIST_ALL hist\r\n" + 
    	"      ,ar.hz_cust_accounts hca\r\n" + 
    	"      ,AR.HZ_CUST_ACCT_SITES_ALL hcas\r\n" + 
    	"      ,ar.HZ_CUST_SITE_USES_ALL hcsu\r\n" + 
    	" where hist.attribute3 = 'DFTWRECIP20170906124.asc' --<file_name> \r\n" + 
    	"   and hist.receipient_id = hca.account_number\r\n" + 
    	"   and hca.attribute_category = 'FTW'\r\n" + 
    	"   and hca.attribute15 = 'N'  --native american cs exempt\r\n" + 
    	"   and hca.attribute16 = 'N'  --native american prem exempt\r\n" + 
    	"   and hca.attribute5 is null  -- preg end date\r\n" + 
    	"   and hcas.cust_account_id = hca.cust_account_id \r\n" + 
    	"   and hcas.cust_acct_site_id = hcsu.cust_acct_site_id\r\n" + 
    	"   and hcsu.attribute23 not like 'F%'; -- flint start date";
    
    
   String s1 = "select hist.receipient_id, hca.attribute15, hca.attribute16, hca.attribute5, hcsu.attribute23";
    s1 = s1+"from xxmi.XXMI_FTW_CUSTOMER_HIST_ALL hist, ar.hz_cust_accounts hca, AR.HZ_CUST_ACCT_SITES_ALL hcas, ar.HZ_CUST_SITE_USES_ALL hcsu";
    s1 = s1 + "where hist.attribute3 = 'DFTWRECIP20170906124.asc' and hist.receipient_id = hca.account_number and hca.attribute_category = 'FTW' and hca.attribute15 = 'N'";
    s1 = s1 + "and hca.attribute16 = 'N' and hca.attribute5 is null and hcas.cust_account_id = hca.cust_account_id and hcas.cust_acct_site_id = hcsu.cust_acct_site_id and hcsu.attribute23 not like 'F%';";
    
    JFrame f = new JFrame();
    f.setSize(300, 300);
    f.add(new JScrollPane(table));
    f.setVisible(true);
  }
}
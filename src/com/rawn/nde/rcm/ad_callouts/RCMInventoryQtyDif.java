package com.rawn.nde.rcm.ad_callouts;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import org.openbravo.utils.FormatUtilities;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.financial.FinancialUtils;
import org.apache.log4j.Logger;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;

public class RCMInventoryQtyDif extends SimpleCallout {

  private static Logger log = Logger.getLogger(RCMInventoryQtyDif.class);

  @Override
  protected void execute(CalloutInfo info) throws ServletException {

    // TODO Auto-generated method stub

    String strQtyCount = info.vars.getNumericGlobalVariable("inpqtycount", null, null);
    String strQtyBook = info.vars.getNumericGlobalVariable("inpqtybook", null, null);
    //String strQtyOrdered = "5";
   
    BigDecimal qtyCount = new BigDecimal(strQtyCount.trim());
    BigDecimal qtyBook = new BigDecimal(strQtyBook.trim());
    

  log.info(qtyCount);
  log.info(qtyBook);

//  String strPrecision = "0", strPricePrecision = "0";


  BigDecimal getQtyDiff = BigDecimal.ZERO;

  getQtyDiff = qtyCount.subtract(qtyBook);
  

  log.info(getQtyDiff);
//  log.info(PricePrecision);

    info.addResult("inpemRcmDiffQty", getQtyDiff);

  }

}
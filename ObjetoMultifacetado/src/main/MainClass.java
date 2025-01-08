package main;

import core.EmissorNF;
import oracle.ORAEcommerceTaxDocument;
import sap.SAPInvoiceManager;

public class MainClass {
	public static void main(String[] args) {
		// integrando com SAP
		SAPInvoiceManager manager = new EmissorNF();
		manager.processInvoice("INVOICE 1234");
		
		
		// integrando com oracle
		ORAEcommerceTaxDocument taxDoc = new EmissorNF();
		taxDoc.sendInvoiceToGovernment("INVOICE 9876");
	}
}

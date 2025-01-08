package core;

import oracle.ORAEcommerceTaxDocument;
import sap.SAPInvoiceManager;

public class EmissorNF implements SAPInvoiceManager, ORAEcommerceTaxDocument {
	
	public void emitirNF(String conteudo) {
		System.out.println("DEBUG - "+conteudo);
		System.out.println("Nota Fiscal Emitida...");
	}

	@Override
	public void processInvoice(String invoice) {
		// TODO Auto-generated method stub
		System.out.println("Integrando com SAP");
		emitirNF(invoice);
	}

	@Override
	public void sendInvoiceToGovernment(String xmlDocument) {
		// TODO Auto-generated method stub
		System.out.println("Integrando com Oracle");
		emitirNF(xmlDocument);
	}

}

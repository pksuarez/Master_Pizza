/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impresora;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

/**
 *
 * @author Nertrox
 */
public class PrinterService implements Printable {

    private String impresora;
    private String codePage; // important for umlaut chars CP1252 StandardCharsets.ISO_8859_1
    private byte[] cortePapel;

    public PrinterService(String impresora) {
        codePage = "CP437";
        cortePapel = new byte[]{0x1d, 'V',1}; //0,1,48,49
//new byte[] {0x1D, 0x56, 66, 0x00};
        this.impresora = impresora;
    }
    
    public PrinterService() {
        codePage = "CP437";
        cortePapel = new byte[] {0x1D, 0x56, 66, 0x00};
    }

    public String getImpresora() {
        return impresora;
    }

    public void setImpresora(String impresora) {
        this.impresora = impresora;
    }

    public String getCodePage() {
        return codePage;
    }

    public void setCodePage(String codePage) {
        this.codePage = codePage;
    }

    public byte[] getCortePapel() {
        return cortePapel;
    }

    public void setCortePapel(byte[] cortePapel) {
        this.cortePapel = cortePapel;
    }

    public List<String> obtenerImpresoras() {

        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();

        javax.print.PrintService printServices[] = PrintServiceLookup.lookupPrintServices(
                flavor, pras);

        List<String> printerList = new ArrayList<String>();
        for (javax.print.PrintService printerService : printServices) {
            printerList.add(printerService.getName());
        }

        return printerList;
    }

    @Override
    public int print(Graphics g, PageFormat pf, int page)
            throws PrinterException {
        if (page > 0) {
            /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }

        /*
		 * User (0,0) is typically outside the imageable area, so we must
		 * translate by the X and Y values in the PageFormat to avoid clipping
         */
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        /* Now we perform our rendering 
 
		g.setFont(new Font("Roman", 0, 20));
		g.drawString("Hello world !", 0, 10);*/

        return PAGE_EXISTS;
    }

    private void imprimirString(String text) {

        // find the printService of name printerName
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();

        javax.print.PrintService printService[] = PrintServiceLookup.lookupPrintServices(
                flavor, pras);
        javax.print.PrintService service = buscarServiciosImpresion(impresora, printService);//PrintServiceLookup.lookupDefaultPrintService();

        DocPrintJob job = service.createPrintJob();

        try {

            byte[] bytes;

            //
            bytes = text.getBytes(codePage);

            Doc doc = new SimpleDoc(bytes, flavor, null);

            job.print(doc, null);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void imprimirBytes(byte[] bytes) {

        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();

        javax.print.PrintService printService[] = PrintServiceLookup.lookupPrintServices(
                flavor, pras);
        
        javax.print.PrintService servicio = buscarServiciosImpresion(impresora, printService);

        DocPrintJob job = servicio.createPrintJob();

        try {

            Doc doc = new SimpleDoc(bytes, flavor, null);

            job.print(doc, null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cortarPapel() {
        imprimirBytes(cortePapel);
    }

    private javax.print.PrintService buscarServiciosImpresion(String printerName,
            javax.print.PrintService[] services) {
        for (javax.print.PrintService service : services) {
            if (service.getName().equalsIgnoreCase(printerName)) {
                return service;
            }
        }

        return null;
    }
    
    public void imprimirFactura(String contenido){
        imprimirString(contenido);
        //imprimirString("CORTAR EL PAPEL\n\n\n");
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(PrinterService.class.getName()).log(Level.SEVERE, null, ex);
        }
       //cortarPapel();
    }

}

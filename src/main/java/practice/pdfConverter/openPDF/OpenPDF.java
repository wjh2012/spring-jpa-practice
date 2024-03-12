package practice.pdfConverter.openPDF;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;

public class OpenPDF {

    private static final String HTML_INPUT = "src/main/resources/sample/sample.html";
    private static final String PDF_OUTPUT = "src/main/resources/sample.pdf";

    public static void main(String[] args) {
        try {
            OpenPDF htmlToPdf = new OpenPDF();
            htmlToPdf.generateHtmlToPdf();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateHtmlToPdf() throws Exception {
        File inputHTML = new File(HTML_INPUT);
        Document inputHtml = createWellFormedHtml(inputHTML);
        File outputPdf = new File(PDF_OUTPUT);
        xhtmlToPdf(inputHtml, outputPdf);
    }

    private Document createWellFormedHtml(File inputHTML) throws IOException {
        Document document = Jsoup.parse(inputHTML);
        document.outputSettings()
            .syntax(Document.OutputSettings.Syntax.xml);
        return document;
    }

    private void xhtmlToPdf(Document xhtml, File outputPdf) throws Exception {
        try (OutputStream outputStream = new FileOutputStream(outputPdf)) {
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(xhtml.html());
            renderer.layout();
            renderer.createPDF(outputStream);
        }
    }
}

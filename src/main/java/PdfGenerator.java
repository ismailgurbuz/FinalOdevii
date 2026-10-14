import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.File;
import java.io.IOException;

public class PdfGenerator {

    private String sanitize(String text) {
        if (text == null) return "";
        return text.replace('İ', 'I')
                   .replace('ı', 'i')
                   .replace('Ş', 'S')
                   .replace('ş', 's')
                   .replace('Ğ', 'G')
                   .replace('ğ', 'g')
                   .replace('Ü', 'U')
                   .replace('ü', 'u')
                   .replace('Ö', 'O')
                   .replace('ö', 'o')
                   .replace('Ç', 'C')
                   .replace('ç', 'c');
    }

    public void generateCvPdf(CvModel cv, String outputPath) {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                
                // Ad Soyad Başlık
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 20);
                contentStream.newLineAtOffset(50, 750);
                contentStream.showText(sanitize(cv.getFullName()));
                contentStream.endText();

                // Ünvan
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
                contentStream.newLineAtOffset(50, 730);
                contentStream.showText(sanitize(cv.getTitle()));
                contentStream.endText();

                // İletişim Bilgileri
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA, 10);
                contentStream.newLineAtOffset(50, 710);
                contentStream.showText(sanitize(cv.getEmail() + " | " + cv.getPhone() + " | " + cv.getLocation()));
                contentStream.endText();

                // İş Deneyimleri Başlık
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
                contentStream.newLineAtOffset(50, 660);
                contentStream.showText("Is Deneyimleri:");
                contentStream.endText();

                int startY = 640;
                for (String exp : cv.getExperiences()) {
                    contentStream.beginText();
                    contentStream.setFont(PDType1Font.HELVETICA, 10);
                    contentStream.newLineAtOffset(50, startY);
                    contentStream.showText(sanitize("- " + exp));
                    contentStream.endText();
                    startY -= 18;
                    if (cv.getPhotoPath() != null && !cv.getPhotoPath().isEmpty()) {
    File photoFile = new File(cv.getPhotoPath());
    
    // Dosyanın sistemde tam olarak nereye baktığını konsola yazdıralım
    System.out.println("Aranan fotoğraf yolu: " + photoFile.getAbsolutePath());
    System.out.println("Fotoğraf dosyası var mı?: " + photoFile.exists());

    if (photoFile.exists()) {
        PDImageXObject pdImage = PDImageXObject.createFromFile(cv.getPhotoPath(), document);
        contentStream.drawImage(pdImage, 400, 650, 100, 120);
    } else {
        System.out.println("HATA: Fotoğraf dosyası bulunamadı!");
    }
}
                }

            }

            document.save(outputPath);
            System.out.println("PDF başarıyla oluşturuldu: " + outputPath);

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}

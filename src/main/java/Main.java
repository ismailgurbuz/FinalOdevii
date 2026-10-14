import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        CvModel cv = new CvModel(
            "İsmail Gürbüz",
            "Web Developer",
            "ismailgurbuz2016@gmail.com",
            "+90 541 609 10 14",
            "Tekirdağ, Türkiye",
            "Modern web teknolojileri, frontend mimarileri ve full-stack geliştirme süreçlerinde 5+ yıllık deneyime sahip Web Geliştiricisi. React.js, Next.js, Node.js ve performans optimizasyonu konularında uzman; kullanıcı odaklı, ölçeklenebilir ve yüksek performanslı kurumsal web uygulamaları geliştirme konusunda yetkin.",
            Arrays.asList(
                "Senior Frontend / Web Architect - Innova Tech (2024 - Günümüz)",
                "Full-Stack Web Developer - Nexa Yazılım Çözümleri (2022 - 2024)",
                "Frontend Developer - CodeCraft Ajans (2021 - 2022)"
            ),
            Arrays.asList("Kırklareli Üniversitesi - Yazılım Mühendisliği (2017 - 2021)"),
            Arrays.asList("React", "JavaScript", "TypeScript", "Node.js", "PostgreSQL"),
            "cv.jpg" 
        );

      
        PdfGenerator generator = new PdfGenerator();
        generator.generateCvPdf(cv, "ozgecmis.pdf");
    }
}
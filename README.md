# Java PDF CV Generator & OOP Architecture Project

Bu proje, Java dilinde **Nesne Yönelimli Programlama (Object-Oriented Programming - OOP)** ilkelerini pratik bir uygulama üzerinde göstermek ve Apache PDFBox kütüphanesini kullanarak dinamik bir Özgeçmiş (CV) belgesi üretmek amacıyla geliştirilmiştir.

---

## 🚀 Projenin Amacı ve Kapsamı
Yazılım dünyasında verilerin nesne tabanlı modellenmesi, bellek yönetimi (nesne yaşam döngüsü), erişim kısıtlamaları (encapsulation) ve dış kütüphanelerin entegrasyonu süreçlerini tek bir çatı altında birleştiren uçtan uca bir konsol uygulamasıdır.

---

## 🏗️ Kullanılan Bileşenler, Sınıflar ve Kullanım Gerekçeleri

Proje, sorumlulukların ayrılması (Separation of Concerns) mimari prensibine uygun olarak modüler sınıflara ayrılmıştır. Aşağıdaki tablo ve açıklamalar projede kullanılan temel yapı taşlarını özetlemektedir:

### 1. `Main` Sınıfı (İstemci / Çalıştırma Katmanı)
* **Görevi:** Uygulamanın giriş noktasıdır (`main` metodu).
* **Neden Kullanıldı?:** Program akışını başlatmak, `CvModel` nesnesini somut verilerle örneklemek (`instantiation`) ve `PdfGenerator` servis sınıfını tetikleyerek PDF üretim sürecini yönetmek için kullanılmıştır.

### 2. `CvModel` Sınıfı (Veri Taşıyıcı Katman - DTO)
* **Görevi:** CV içerisinde yer alacak kişisel bilgileri, eğitim ve iş deneyimi listelerini bellekte tutan model sınıfıdır.
* **Neden Kullanıldı?:** 
  * **Kapsülleme (Encapsulation):** Tüm alanlar (`fullName`, `email`, `experiences` vb.) `private` olarak tanımlanarak dış müdahalelere karşı korunmuştur.
  * **Veri Güvenliği:** Verilere yalnızca `public` getter ve setter metotları üzerinden erişilerek nesne bütünlüğü (`state`) güvence altına alınmıştır.

### 3. `PdfGenerator` Sınıfı (Servis / İş Mantığı Katmanı)
* **Görevi:** PDF dosyasının fiziksel yapısını oluşturan, sayfa ekleyen, metin konumlandıran ve görsel entegrasyonunu sağlayan ana mantık sınıfıdır.
* **Neden Kullanıldı?:** İş mantığı ile veri modelini birbirinden ayırarak kodun okunabilirliğini, bakımını ve yeniden kullanılabilirliğini (`reusability`) artırmak için tasarlanmıştır.

### 4. Apache PDFBox Kütüphane Bileşenleri ve Nesneleri
Projede harici olarak kullanılan bu nesneler, PDF belgesinin düşük seviyeli manipülasyonunu sağlar:
* **`PDDocument`:** Bellekte temsil edilen PDF belgesinin kök nesnesidir. Belge oluşturma ve diske kaydetme işlemlerini yönetir.
* **`PDPage`:** Belgeye eklenen her bir fiziksel A4 sayfasını temsil eden nesnedir.
* **`PDPageContentStream`:** Sayfa üzerine X-Y koordinat matrisine göre metin yazma, çizgi çizme ve resim konumlandırma akışlarını yöneten kritik akış nesnesidir.
* **`PDImageXObject`:** Disk üzerindeki vesikalık fotoğrafı (`cv.jpg`) bellek akışına okuyup PDF sayfasına çizebilmek için kullanılan görsel nesnesidir.

---

## ♻️ Java Nesne Yaşam Döngüsü (Object Lifecycle) ve Bellek Yönetimi
Projede nesnelerin bellekteki seyri şu aşamalardan geçer:
1. **Oluşturma (Instantiation):** `new` anahtar kelimesi ile nesneler Heap belleğinde alan tahsis edilerek oluşturulur.
2. **Kullanım (Usage):** Nesne metotları aracılığıyla veri okuma ve PDF çizdirme işlemleri yürütülür.
3. **Kaynak Yönetimi (Resource Management):** Dosya ve akış tüketen nesnelerin bellek sızıntısına (`memory leak`) yol açmaması için **`try-with-resources`** bloğu kullanılarak iş bitiminde otomatik olarak (`close()`) kapatılması sağlanmıştır.

---

## 🛠️ Kurulum ve Çalıştırma

1. Projeyi klonlayın veya indirin:
   ```bash
   git clone <repo-url>
2. Proje dizinine gidin ve Maven ile derleyin:
  ```bash
   mvn clean compile

  3.Main.java dosyasını çalıştırarak ozgecmis.pdf çıktısını elde edin.
   

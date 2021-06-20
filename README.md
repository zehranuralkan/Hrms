# Hrms
Spring Boot Hrms Projesi-Genel iş pozisyonlarını listeleyen api eklendi 

![1](https://user-images.githubusercontent.com/68777717/120122926-a87d7380-c1b4-11eb-9dba-4df1e5288e47.png)
---------------------------------------------------------------------------------------------------------------------------
Swagger Desteği Getirildi

![swagger11](https://user-images.githubusercontent.com/68777717/120805336-6191d400-c54e-11eb-8829-72a182dcc633.png)
![swagger2](https://user-images.githubusercontent.com/68777717/120805339-62c30100-c54e-11eb-9b5d-7e40ce1106fd.png)
-----------------------------------------------------------------------------------------------------------------------------
İSTER 1 : İş Arayanlar sisteme kayıt olabilmelidir.Kayıt sırasında kullanıcıdan ad, soyad, tcno, doğum yılı, e-Posta, şifre, şifre tekrarı bilgileri istenir.
Tüm alanlar zorunludur. Kullanıcı bilgilendirilir.Mernis doğrulaması yapılarak sisteme kayıt gerçekleştirilir.Doğrulama geçerli değilse kullanıcı bilgilendirilir.
Daha önce kayıtlı bir e-posta veya tcno var ise kayıt gerçekleşmez. Kullanıcı bilgilendirilir.Kayıdın gerçekleşmesi için e-posta doğrulaması gerekir.

İSTER 2 : İş verenler sisteme kayıt olabilmelidir.Kayıt sırasında kullanıcıdan şirket adı, web sitesi, web sitesi ile aynı domaine sahip e-posta, telefon, şifre,
şifre tekrarı bilgileri istenir. Burada amaç sisteme şirket olmayanların katılmasını engellemektir.Tüm alanlar zorunludur. Kullanıcı bilgilendirilir.
Şirket kayıtları iki şekilde doğrulanır. Kayıdın gerçekleşmesi için e-posta doğrulaması gerekir. HRMS personelinin (bizim :)) onayı gerekmektedir.
Daha önce kayıtlı bir e-posta var ise kayıt gerçekleşmez. Kullanıcı bilgilendirilir.

İSTER 3 : Sisteme genel iş pozisyonu isimleri eklenebilmelidir. Örneğin Software Developer, Software Architect.Bu pozisyonlar tekrar edemez. Kullanıcı uyarılır.

İSTER 4 : İş verenler listelenebilmelidir. (Sadece tüm liste)

İSTER 5 : İş arayanlar listelenebilmelidir. (Sadece tüm liste)

İSTER 6 : İş pozisyonları listelenebilmelidir. (Sadece tüm liste)

![1](https://user-images.githubusercontent.com/68777717/121607536-e1410680-ca58-11eb-9c44-c2ab24baf2ef.png)

İSTER 7 : İş verenler sisteme iş ilanı ekleyebilmelidir.İş ilanı formunda; Seçilebilir listeden (dropdown) genel iş pozisyonu seçilebilmelidir.
(Örneğin Java Developer)(Zorunlu).İş tanımı girişi yapılabilmelidir. (Örneğin; firmamız için JAVA, C# vb. dillere hakim....)(Zorunlu)
Şehir bilgisi açılır listeden seçilebilmelidir. (Zorunlu).Maaş skalası için min-max girişi yapılabilmelidir. (Opsiyonel) Açık pozisyon adedi girişi yapılabilmelidir. (Zorunlu) Son başvuru tarihi girişi yapılabilmelidir.

İSTER 8 : Sistemdeki tüm aktif iş ilanları listelenebilmelidir.Liste, tablo formunda gelmelidir.Listede firmadı, genel iş pozisyonu adı, açık pozisyon adedi, yayın tarihi, son başvuru tarihi bilgileri olmalıdır.

İSTER 9 : Sistemdeki tüm aktif iş ilanları tarihe göre listelenebilmelidir.Liste, tablo formunda gelmelidir.Listede firmadı, genel iş pozisyonu adı, açık pozisyon adedi, yayın tarihi, son başvuru tarihi bilgileri olmalıdır.

İSTER 10 : Sistemde bir firmaya ait tüm aktif iş ilanları listelenebilmelidir.Liste, tablo formunda gelmelidir.Listede firmadı, genel iş pozisyonu adı, açık pozisyon adedi, yayın tarihi, son başvuru tarihi bilgileri olmalıdır.

İSTER 11 : İş verenler sistemdeki bir ilanı kapatabilmelidir. (Pasif ilan)


![1](https://user-images.githubusercontent.com/68777717/122307563-43937e80-cf13-11eb-8e56-df362c31fac9.png)

![2](https://user-images.githubusercontent.com/68777717/122307575-468e6f00-cf13-11eb-93f4-b11d273eabec.png)


İSTER 12: Adaylar sisteme CV girişi yapabilmelidir.
Adaylar okudukları okulları sisteme ekleyebilmelidir. (Okul adı, bölüm). Bu okullarda hangi yıllarda okuduklarını sisteme girebilmelidir.
Eğer mezun değilse mezuniyet yılı boş geçilebilmelidir. Adayların okudukları okullar mezuniyet yılına göre tersten sıralanabilmelidir. Mezun olunmamışsa yine bu okul en üstte ve "devam ediyor" olarak görüntülenmelidir. Adaylar iş tecübelerini girebilmelidir. (İş yeri adı, pozisyon). Bu tecrübelerini hangi yıllarda yaptıklarını sisteme girebilmelidir. Eğer hala çalışıyorsa işten ayrılma yılı boş geçilebilmelidir.
Adayların tecrübeleri yıla göre tersten sıralanabilmelidir. Hala çalışıyorsa yine bu tecrübesi en üstte ve "devam ediyor" olarak görüntülenmelidir.
Adaylar bildikleri yabancı dilleri sisteme girebilmelidir. ( Dil, Seviye -> 1-5)
Adaylar sisteme fotoğraf girebilmelidir. Adaya ait fotoğraf https://cloudinary.com/pricing sisteminde tutulacaktır. (Dış servis entegrasyonu) Ücretsiz hesabı kullanınız.
Adaylar sisteme github adreslerini girebilmelidir.
Adaylar sisteme linkedin adreslerini girebilmelidir.
Adaylar bildikleri programlama dillerini veya teknolojilerini sisteme girebilmelidir. (Programlama/Teknoloji adı) Örneğin; React
Adaylar sisteme ön yazı ekleyebilmelidir. (Örneğin: Çalışmayı çok severim....)


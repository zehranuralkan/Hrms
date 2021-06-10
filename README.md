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

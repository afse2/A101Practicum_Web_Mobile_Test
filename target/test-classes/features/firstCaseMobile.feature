Feature: As a user, I should be able to buy a object without login page on mobile app

@wip
  Scenario: User can buy a object without login on mobile app
    Given user open mobile app
    When user click "GİYİM & AKSESUAR", "Kadın İç Giyim" and "Dizaltı Çorap" tab on mobile app
    And user click object display "Siyah" one on mobile app
    And user click "SEPETE EKLE" button, "SEPETE GİT" button , "SEPETİ ONAYLA" button , "ÜYE OLMADAN DEVAM ET" button on mobile app
    And user displayed mail section on the page and enter a mail address on mobile app
    And user click "Yeni adres oluştur" button on mobile app
    And user enter "Home" as Adres Başlığı, "Ad" , "Soyad" , "Cep Telefonu", "Adres" and select "ADANA" city, "FEKE" township and "KONAKKURAN MAH" district and click KAYDET button on mobile app
    And user select 1 cargo firm and click Kaydet Ve Devam Et button on mobile app
    Then user select 2 payment tab, click "Garanti Pay ile Öde" and complete order and display payment web page on mobile app
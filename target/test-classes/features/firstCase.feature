Feature: As a user, I should be able to buy a object without login page

@wip
  Scenario: User can buy a object without login
    Given user navigate base page
    When user click "Giyim & aksesuar", "Kadın İç Giyim" and "Dizaltı Çorap" tab
    And user click 1 object display "siyah" one
    And user click Sepete Ekle button, "Sepeti Görüntüle" button , "Sepeti Onayla" button , "ÜYE OLMADAN DEVAM ET" button
    And user displayed mail section on the page and enter a mail address
    And user click Yeni adres oluştur button and displayed "Adres Güncelleme" pop-up on the page
    And user enter "Home" as Adres Başlığı, "Ad" , "Soyad" , "Cep Telefonu", "Adres" and select city, township and district and click KAYDET button
    And user select 1 cargo firm and click Kaydet Ve Devam Et button
    Then user select 2 payment tab and complete order and display payment web page
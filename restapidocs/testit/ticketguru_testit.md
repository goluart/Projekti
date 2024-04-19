# Ticketguru-lipunmyyntijärjestelmän testidokumentti
Tämän dokumentti kuvaa Ticketguru-lipunmyyntijärjestelmän testausvaiheita. 
Dokumentista käy ilmi eri testausvaiheet, testikokonaisuuksien suunnitelmat, yksittäisten testien suunitelmat sekä testitulosten analyysit.

## Testeihin käytetyt ohjelmistot
Komponenttitesteihin käytetään Junitia, jolla tehdään back-endin testit. Integraatiotesteihin ja End-to-End-testeihin käytetään sekä Junitia ja  Robot Frameworkia.

## Komponenttitestit
Komponenttitestien tarkoitus on testata yhden yksittäisen komponentin toimintaa. Testeillä halutaan selvittää toimiiko komponentti tai komponentin osa kuten halutaan. Komponentin läpäistessä vaaditut testit, voidaan todeta, että ohjelman osa toimii. Tämän jälkeen voidaan siirtyä ohjelmoinnissa ja testauksessa seuraavaan vaiheeseen.

### Back-End -testit
Back-End -testeissä halutaan selvittää eritysesti toimintoja, jotka liittyvät tapahtumiin ja myyntitapahtumiin. Nämä ovat järjestelmän toiminnan sekä lipunmyynnin kannalta kaksi tärkeintä komponenttia. Jos nämä komponentit toimivat halutulla tavalla, niin järjestelmän perustoiminnot onnistuvat ja projektissa voidaan siirtyä eteenpäin.

Ensimmäisissä testeissä halutaan varmistaa, että tapahtumien lisäys-, poisto-, ja muokkausominaisuudet toimivat. Myyntitapahtumista halutaan pystyä hakemaan ja lisäämään myyntitapahtumia tässä vaiheessa.

#### Tapahtumien hakeminen

> Testin id | Toimenpide | Oletettu lopputulos 
> -------- | ---------- | ------------------- 
> 1 | Tyhjennä tapahtumalista | Tapahtumalista on tyhjä
> 2 | Lisää listalle yksi tapahtuma | Listalla on yksi tapahtuma
> 3 | Hae kaikki tapahtumat | Listalla on enemmän kuin 0 tapahtumaa



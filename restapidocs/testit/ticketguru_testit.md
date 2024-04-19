# Ticketguru-lipunmyyntijärjestelmän testidokumentti
Tämän dokumentti kuvaa Ticketguru-lipunmyyntijärjestelmän testausvaiheita. 
Dokumentista käy ilmi eri testausvaiheet, testikokonaisuuksien suunnitelmat, yksittäisten testien suunitelmat sekä testitulosten analyysit.

## Testeihin käytetyt ohjelmistot
Komponenttitesteihin käytetään Junitia, jolla tehdään back-endin testit. Integraatiotesteihin ja End-to-End-testeihin käytetään sekä Junitia ja  Robot Frameworkia.

## Komponenttitestit
Komponenttitestien tarkoitus on testata yhden yksittäisen komponentin toimintaa. Testeillä halutaan selvittää toimiiko komponentti tai komponentin osa kuten halutaan. Komponentin läpäistessä vaaditut testit, voidaan todeta, että ohjelman osa toimii. Tämän jälkeen voidaan siirtyä ohjelmoinnissa ja testauksessa seuraavaan vaiheeseen.

### Back-End -testit
Back-End -testeissä halutaan selvittää eritysesti toimintoja, jotka liittyvät tapahtumiin ja myyntitapahtumiin. Nämä ovat järjestelmän toiminnan sekä lipunmyynnin kannalta kaksi tärkeintä komponenttia. Jos nämä komponentit toimivat halutulla tavalla, niin järjestelmän perustoiminnot onnistuvat ja projektissa voidaan siirtyä eteenpäin. Kaikissa komponenttitason Back-End -testeissä lähtökohta on, että käyttäjä on kirjautunut järjestelmään. Tätä ei erikseen mainita testikuvauksissa.

Ensimmäisissä testeissä halutaan varmistaa, että tapahtumien lisäys-, poisto-, ja muokkausominaisuudet toimivat. Myyntitapahtumista halutaan pystyä hakemaan ja lisäämään myyntitapahtumia tässä vaiheessa.

#### Tapahtumat-luokan testit

> Testin id | Kuvaus | Lähtötilanne | Toimenpiteet | Oletettu lopputulos 
> --------- | ------ | ------------ | ------------ | ------------------
> 1 | Hae kaikki tapahtumat | Listalla on kolme tapahtumaa | Testi hakee listan. Listalla on  oltava yli 0 tapahtumaa. | Testi löytää listan, jossa on yli 0 tapahtumaa.
> 2 | Hae yksi tietty tapahtuma | Listalla on kolme tapahtumaa | Testi etsii listalta tapahtuman, jonka id on 1. Tapahtuman nimen on oltava "Rock Fetivaali" | Testi löytää ko. tapahtuman
> 3 | Lisää tapahtuma | Listalla on kolme tapahtumaa | Listaan lisätään yksi tapahtuma. | Lista sisältää 4 tapahtumaa.
> 4 | Muokkaa tapahtumaa | Listalla on yksi "Rock Festivaali" -niminen tapahtuma. | Testi muokkaa tapahtuman nimeksi "Humppafest". | Testi löytää listalta "Humppafest"-nimisen tapahtuman.

#### Myyntiapahtumat-luokan testit

> Testin id | Kuvaus | Lähtötilanne | Toimenpiteet | Oletettu lopputulos 
> --------- | ------ | ------------ | ------------ | ------------------
> 5 | Etsi kaikki myyntitapahtumat | Listalla on kolme tapahtumaa | Testi hakee lista. Listalla on oltavaa yli 0 ja alle 4 tapahtumaa. | Testi löytää listan, jolla on yli 0 ja alle 4 tapahtumaa.
> 6 | Lisää yksi myyntitapahtuma | Myyntitapahtuma-lista on tyhjä | Listaan lisätään yksi myyntitapahtumatapahtuma. | Lista sisältää yhden myyntitapahtuman.


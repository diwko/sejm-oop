# Sejm - OOP

Program przedstawiający wybrane dane dotyczące posłów określonej kadencji sejmu.

### Argumenty programu:

* `NR_KADENCJI`  `wydatki`   `suma`        `IMIĘ`         `NAZWISKO`
* `NR_KADENCJI`  `wydatki`   `remont`     `IMIĘ`         `NAZWISKO`
* `NR_KADENCJI`  `wydatki`   `średnia`
* `NR_KADENCJI`  `wyjazdy` `najwięcej`
* `NR_KADENCJI`  `wyjazdy` `najdłużej`
* `NR_KADENCJI`  `wyjazdy`  `najdrożej`
* `NR_KADENCJI`  `wyjazdy`   `kraj`       `NAZWA_KRAJU`

przykład: `8 wyjazdy kraj Grecja`

## Treść zadania:

Korzystanie z danych udostępnianych w webowym API.

1. Zapoznaj się z API serwisu sejmometr https://mojepanstwo.pl/api/sejmometr
2. Opracuj system, który na podstawie argumentów linii poleceń wyświetla następujące informacje (dla określonej kadencji sejmu):
  * suma wydatków posła/posłanki o określonym imieniu i nazwisku
  * wysokości wydatków na 'drobne naprawy i remonty biura poselskiego' określonego posła/posłanki
  * średniej wartości sumy wydatków wszystkich posłów
  * posła/posłanki, który wykonał najwięcej podróży zagranicznych
  * posła/posłanki, który najdłużej przebywał za granicą
  * posła/posłanki, który odbył najdroższą podróż zagraniczną
  * listę wszystkich posłów, którzy odwiedzili Włochy
3. Program powinien obsługiwać błędy oraz zawierać testy weryfikujące poprawność jego działania.

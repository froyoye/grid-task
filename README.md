# Grid-produkt oppgave

## Oppgavebeskrivelse

Gitt en 20x20 matrise (`grid.txt`) med heltall, er målet å finne **det største produktet av fire påfølgende tall**. Tallene kan ligge i én av følgende retninger:

- Horisontalt
- Vertikalt
- Diagonalt høyre
- Diagonalt venstre

## Fremgangsmåte og løsning

### 1. Parsing av data

Jeg startet med å lese inn `grid.txt` linje for linje. Hver linje ble splittet på mellomrom og konvertert til heltall, og tallene ble lagret i en 2D-matrise (`int[20][20]`).

### 2. Fire separate metoder for produktberegning

For å gjøre løsningen tydelig og lett å feilsøke, valgte jeg å lage én metode per retning:

- `horisontaltProdukt(int[][] grid)`
- `vertikaltProdukt(int[][] grid)`
- `diagonaltHProdukt(int[][] grid)`
- `diagonaltVProdukt(int[][] grid)`

Hver metode returnerer:
- Det største produktet som ble funnet i den retningen
- Startposisjonen til produktet (rad og kolonne)

For hver metode jeg lagde, så ble metoden testet på `grid.txt` filen for å sikre at metoden fungerte som ønsket. 

### 3. Sammenligning av resultater

I `main()` kalles alle fire metodene, og resultatene sammenlignes. For hver metode ble det laget en utskrift slik at jeg fikk sett produktet i alle retningene. Da alle metodene var implementert endret jeg utskriften slik at kun det største produktet av de fire ble skrevet ut sammen med retningen produktet ble funnet i, og indeksene til de fire tallene i matrisen. 

### 4. Reversering og bevisst valg

Jeg gjorde litt research i hvordan koden kunne forenkles og kortes ned, men etter å ha forsøkt å refaktorere alle retninger inn i én generell metode, valgte jeg å gå tilbake til den første versjonen. Grunnen til dette var at jeg følte jeg fikk en bedre forståelse av hva koden gjorde, og det var lettere å feilsøke i koden med fire metoder. 

## Eksempel på output

Det største produktet er: 93168306

Retning: Diagonalt Venstre

Indeks i grid: [18, 15], [17, 16], [16, 17], [15, 18]

## Hvordan kjøre koden

1. Sørg for at `grid.txt` ligger under `src/main/resources` 
2. Kjør `FinnProdukt.main()` fra IDE eller terminal
3. Resultatet vises i konsollen



# Ferdaplan 2.0 🧳

Ferðaáætlunarforrit skrifað í JavaFX. Notandi getur búið til ferðir, stjörnumerkt þær, merkt sem lokið, og raðað eftir dagsetningu.

## Kröfur (Requirements)

- **Java JDK 25** eða nýrra
- **Maven** (innbyggt með Maven Wrapper)

## Byggja forritið (Build)

1. Opnaðu terminal/skipanalínu
2. Farðu í möppuna þar sem forritið er:
   ```
   cd Ferdaplan2.0
   ```
3. Byggðu forritið með Maven:
   ```
   ./mvnw clean compile
   ```
   (Á Windows: `mvnw.cmd clean compile`)

## Keyra forritið (Run)

Keyrðu eftirfarandi skipun:
```
./mvnw javafx:run
```
(Á Windows: `mvnw.cmd javafx:run`)

Forritið opnast og sýnir lista af ferðum þar sem hægt er að:
- ⭐ Stjörnumerkja (Favorite) ferðir
- ✅ Merkja ferðir sem lokið (Completed)
- 📅 Raða ferðum eftir dagsetningu eða nafni
- Bæta við, skoða og eyða ferðum

## Höfundur

Jón Þorri Jónsson (JuanTorres94)
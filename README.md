# spravaHracuFinal
řešení celého úkolu, bez stylování
Aplikace pro správu hráčů 
________________________________________
Aplikace bude obsahovat seznam hráčů. Hráče bude možné přidávat, mazat a editovat. O každém hráči uchováváme login, herní level, herní roli, email a datum registrace.
________________________________________
Požadované funkce aplikace:
1.	Seznam hráčů:
o	V aplikaci bude zobrazen seznam hráčů pomocí ListView.
o	Každý hráč bude mít následující atributy:
	Uživatelské jméno (např. „ShadowHunter99“).
	Herní level (číselná hodnota 1 až 100).
	Role ve hře (např. bojovnik, mag, strelec).
	E-mailová adresa pro komunikaci s hráčem.
	Datum registrace do hry.
2.	Zobrazení hráčů a jejich barevné označení podle levelu:
o	V levé části okna bude listView s loginy hráčů
	věrní hráči (= registrováni před rokem a více) budou označení hvězdičkou
	žádné další parametry u hráčů zobrazeny nebudou
o	V pravé části okna půjde zobrazit detail hráče
	Hráči s vysokým levelem (50 a více) budou zobrazeni červeně.
	Středně pokročilí hráči (20–49) budou zobrazeni modře.
	Začátečníci (1–19) budou zobrazeni zeleně.
3.	Přidávání nového hráče:
o	Uživatelé mohou přidávat nové hráče prostřednictvím formuláře:
	Textové pole pro zadání uživatelského jména.
	Číselné pole pro level – (s kontrolou rozsahu 1 až 100).
	Výběr role (použij Radio Button).
	Textové pole pro e-mail.
	Výběr data registrace pomocí DatePicker.
4.	Zobrazení detailů hráče:
o	Po kliknutí na hráče v seznamu se zobrazí detailní informace o hráči v pravé části aplikace.
o	Hráče půjde najít a zobrazit také podle loginu.
5.	Mazání hráče:
o	Vybraného hráče lze ze seznamu odstranit pomocí tlačítka "Smazat hráče".
6.	Úprava informací o hráči:
o	Vybraného hráče lze upravit (např. změnit jeho roli nebo level).
7.	Počáteční data:
o	Aplikace se spustí s několika přednastavenými hráči, např.:
	Uživatelské jméno: ShadowHunter99, Level: 75, Role: bojovnik, Email: shadow.hunter@email.com, Registrace: 1. 1. 2020.
________________________________________
Rozvržení GUI:
1.	Hlavní okno aplikace:
o	Použijte BorderPane pro rozdělení aplikace:
	Horní část: Menu aplikaci
	Levá část: Seznam hráčů (ListView).
	Pravá/prostřední část: 
	Komponenty pro hledání hráče podle loginu
	Detaily vybraného hráče (zobrazení informací nebo formulář pro úpravy):
	Tlačítka:
1.	"Přidat hráče".
2.	"Smazat hráče".
3.	"Upravit hráče".
	Spodní část: Coppyright
2.	Formulář pro přidávání/úpravy hráčů:
o	Použijte GridPane:
	Textové pole pro uživatelské jméno.
	Číselné pole pro zadání levelu.
	Radio Buttony pro výběr role hráče.
	Textové pole pro e-mail.
	DatePicker pro datum registrace.
________________________________________
Možné rozšíření: 
•	Zobrazte počet hráčů podle levelu (např. počet hráčů začátečníků, pokročilých atd.).
•	Přidejte stylování

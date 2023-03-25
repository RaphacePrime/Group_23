# Group_23

Gioco

- List<Tessera> tessere[122]
- int numerogiocatore
- Giocatore giocatori[]
- Giocatore giocatoreattivo
- ObiettiviComuni obiettivicomuni[2]
- Soggiorno s

* Gioco(Giocatori g1, Giocatore g2)
* void turno()
* scegliTessera(int x,int y)
* generaTessere()
* controlloObiettiviComuni(Giocatore giocatoreattivo)
* controlloObiettiviPersonali(Giocatore giocatoreattivo)
* setObiettivoPersonale()
* Tessera getTessera()

Giocatore

- string nome
- int id
- bool sedia
- Libreria libreria
- ObiettivoPersonale op
- int punti
- bool ObiettiviComuni={false,false}

* Giocatore(nome)
* calcolaPunti()
* seObiettiviComuni(num)
* inserisciinLibreria(Tessera t)

Soggiorno

- Tessera matrice[9][9]
- bool tesseraFine

* contaGiocatori()
* ripristino()

ObiettiviComuni

- int id
- int num
- List<Integer> punteggi={8,6,4}

* ObiettiviComuni(id)
* string getTesto()
* bool getImmagine()
* bool controlloObiettivo(Libreria lib)
* riempiPunteggi()

ObiettivoPersonale

- int id
- int punteggi[]={1,2,4,6,9,12}
- int casellecompletate

* ObiettivoPersonale(id)
* string getTesto()
* bool getImmagine()
* bool controlloObiettivo(Libreria lib)
* controllocasella()

Tessera

- string colore
- static int id[122]
- bool used

* Tessera(string colore, int id)
* getImmagine()
* getColore()

string colori={giallo,blu,...}
int j=0; int id=0;
while(j<6)
{
for(int i=0; i<22; i++)
{
Tessera t= new Tessera(colori[j], id);
id++;
}
j++
}

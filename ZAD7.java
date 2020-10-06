import java.util.*;


public class ZAD7{
public static void main(String[] args){

NrTelefoniczny numer1 = new NrTelefoniczny(48,123456789);
NrTelefoniczny numer2 = new NrTelefoniczny(48,134565759);
NrTelefoniczny numer3 = new NrTelefoniczny(48,122565787);

Osoba osoba1 = new Osoba("Ania","Malik","Łódź","Piotrkowska",62,numer1);
Osoba osoba2 = new Osoba("Igor","Siller","Warszawa","Kosynierów",5,numer2);
Firma sportex = new Firma("Sportex","Poznań","Kosynierów",4,numer3);
TreeMap<NrTelefoniczny,Wpis> tmap = new TreeMap<>();
tmap.put(numer1,osoba1);
tmap.put(numer2,osoba2);
tmap.put(numer3,sportex);

for(Map.Entry<NrTelefoniczny,Wpis> i : tmap.entrySet())
{

	System.out.println(i.getValue().opis());

}


}
}


class NrTelefoniczny implements Comparable<NrTelefoniczny>
{
	public int nrKierunkowy,nrTelefonu;
	NrTelefoniczny(int nrk,int nrt)
	{
		nrKierunkowy = nrk;
		nrTelefonu = nrt;

	}
	@Override
	public int compareTo(NrTelefoniczny nr)
	{
		if(nr.nrKierunkowy != nrKierunkowy)
			return nrKierunkowy - nr.nrKierunkowy;
		return nrTelefonu - nr.nrTelefonu; 


	}


}


abstract class Wpis
{

	public abstract String opis();

}


class Firma extends Wpis
{

	public final String nazwa,miejscowosc,ulica;
	public final int numerUlicy;
	public final NrTelefoniczny nr;
	Firma(String n,String m, String u, int nu,NrTelefoniczny num)
			{
				nr = new NrTelefoniczny(num.nrKierunkowy,num.nrTelefonu);
				nazwa = n;
				miejscowosc = m;
				ulica = u;
				numerUlicy = nu;
				
			}
	@Override
	public String opis()
	{
		StringBuilder description = new StringBuilder();
		description.append("Firma nazywa się ").append(nazwa).append(" znajduję się w ").append(miejscowosc).append(" na ulicy ").append(ulica).append(" ").append(numerUlicy);
		 description.append("numer telefonu to +").append(nr.nrKierunkowy).append(" ").append(nr.nrTelefonu);
			return description.toString();
	}

}


class Osoba extends Wpis
{

	public final String imie,nazwisko,miejscowosc,ulica;
	public final int numerUlicy;
	public final NrTelefoniczny nr;
	Osoba(String name,String lname,String m, String u, int nu,NrTelefoniczny num)
			{
				imie = name;
				nazwisko = lname;
				miejscowosc = m;
				ulica = u;
				numerUlicy = nu;
				nr = new NrTelefoniczny(num.nrKierunkowy,num.nrTelefonu);
			}
	@Override
	public String opis()
	{
	StringBuilder description = new StringBuilder();
		description.append("Pan/i ").append(imie).append(" ").append(nazwisko).append(" mieszkająca/y w ").append(miejscowosc).append(" na ulicy ").append(ulica).append(" ").append(numerUlicy);
		 description.append(" numer telefonu to +").append(nr.nrKierunkowy).append(" ").append(nr.nrTelefonu);
			return description.toString();
	}
}